package com.frontend;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.CartDAO;
import com.dao.ProductDAO;
import com.model.Cart;

@Controller
public class OrderController
{
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/Checkout")
	public String orderConfirmation(HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> list = cartDAO.getCartItems(username);
		float grandtotal = 0;
		
		for(Cart cart:list)
		{
			grandtotal=grandtotal+(cart.getQuantity()*cart.getPrice());
		}
		m.addAttribute("grandtotal",grandtotal);
		session.setAttribute("gtotal", grandtotal);
		m.addAttribute("cartitems",list);
		
		return "OrderConfirm";
	}

}


