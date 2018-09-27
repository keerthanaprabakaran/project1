package com.frontend;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.CartDAO;
import com.dao.PaymentDAO;
import com.dao.ProductDAO;
import com.dao.UserDetailDAO;
import com.model.Cart;
import com.model.Payment;
import com.model.Product;
import com.model.UserDetail;

@Controller
public class PageController  
{
	
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	PaymentDAO paymentDAO;
	
	
	
	
	@RequestMapping("/")
	public String showIndex(HttpServletRequest req)
	{
		req.getSession().setAttribute("loggedIn",false);
		//System.out.println(req.getUserPrincipal().getName());
		return "Header";
	}
	
	@RequestMapping("/Home")
	public String showHome()
	{
		return "Home";
	}
	
	
		
	@RequestMapping("/AboutUs")
	public String showAboutUs()
	{
		return "AboutUs";
	}
	
	@RequestMapping("/ContactUs")
	public String showContactUs()
	{
		return "ContactUs";
	}
	
	
	@RequestMapping("/Login")
	public String showLogin(Model m)
	{
		
		
		return "Login";
	}
	
	
	
	@RequestMapping("/ProductPage")
	public String showProducts(Model m,HttpSession s)
	{
		List<Product> prodlist=productDAO.getProductDetails();
		System.out.println("product list getting printed "+prodlist);
		m.addAttribute("prodlist",prodlist);
		boolean status=Boolean.parseBoolean(s.getAttribute("loggedIn").toString());
		if(status)
		{
	      return "ProductPage";		
		}
		else
		{
		return "Login";

		}
	}
	

	@RequestMapping("/Payment/{citemid}")
	public String showPayment(@PathVariable Long citemid,Model m)
	{
		Cart cart=cartDAO.getCartItem(citemid);
		m.addAttribute("cart",cart);
		
		return "Payment";
	}
	
	@RequestMapping(value="/Payment/{citemid}",method=RequestMethod.POST)
	public String showPaymentcard(@PathVariable Long citemid,@RequestParam("mode")  String ptype,Model m,HttpSession session,@RequestParam("cardnumber")int cardnumber)
	{
		Cart cart=cartDAO.getCartItem(citemid);
		m.addAttribute("cart",cart);
		Payment obj=new Payment();
		if(ptype.equals("card"))
		{
			obj.setCardnumber(cardnumber);
			
		}
		else
		{
			obj.setCardnumber(0);
		}
	    obj.setCartid(cart.getCartid());
	    
	    float gtotal=Float.parseFloat(session.getAttribute("gtotal").toString());
  obj.setPrice((int)gtotal);
  paymentDAO.insertPaymentDetails(obj);
	    return "Successful";
	}

}
