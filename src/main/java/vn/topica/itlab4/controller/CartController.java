package vn.topica.itlab4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController
{
	@RequestMapping(value = {"/add-to-cart"})
	public String addProduct(@RequestParam("id") int id)
	{
		System.out.println("Add to cart: " + id);
		
		return "Add to cart";
	}
}
