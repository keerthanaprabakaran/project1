package com.niit.cartbackend.testcase;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.ProductDAO;
import com.model.Product;


public class ProductTestCase 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.*");
		
		context.refresh();
		
		// Inserting a Product Object.
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		
		//Insertion TestCase
		
		Product product=new Product();
		
		product.setProdname("Mobile phone");
		product.setCatid(1);
		product.setSuppid(123);
		product.setQuantity(5);
		product.setPrice(500);
		product.setProdDesc("This Mobile has 3gb ram");

		productDAO.insertUpdateProduct(product);		
		System.out.println("Product Inserted");
		
		//Retrieval TestCase
		
		/*Product product=productDAO.getProduct(1);
		System.out.println("Product Name:"+product.getProdname());
		System.out.println("Product Price:"+product.getPrice());*/
		
		//Deletion TestCase
		/*Product product=productDAO.getProduct(2);
		productDAO.deleteProduct(product);
		System.out.println("The Product Deleted");*/
		
		//Retrieving the Data
		
		/*List<Product> list=productDAO.getProductDetails();
		
		for(Product product:list)
		{
			System.out.println(product.getProdid()+":"+product.getProdname()+":"+product.getPrice());
		}*/
		
		//Update the Product
	/*	Product product=productDAO.getProduct(3);
		product.setCatname("WifiEnMobile");
		productDAO.insertUpdateProduct(product);
		System.out.println("The Product Updated");*/
	}
		



}
