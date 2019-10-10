package vn.topica.itlab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.model.UserModel;
import vn.topica.itlab4.util.Utils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController
{
	@Autowired
	private UserModel model;
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = {"/", "/index", "/index.jsp"})
	public String home(Model model, HttpServletRequest request)
	{
		System.out.println("Home");
		getModel(model, request, "Pet shop by ManhHD");
		
		return "index";
	}
	
	@RequestMapping(value = {"/cart"})
	public String cart(Model model, HttpServletRequest request)
	{
		System.out.println("Cart");
		getModel(model, request, "Your cart detail");
		
		return "cart";
	}
	
	@RequestMapping(value = {"/account"})
	public String account(Model model, HttpServletRequest request)
	{
		System.out.println("Account");
		String username = Utils.checkToken(request.getCookies());
		User user = authService.findUser(username);
		if (user == null)
		{
			return "redirect:/";
		}
		else
		{
			getModel(model, request, "Account information");
			return "account";
		}
	}
	
	@RequestMapping(value = {"/account/{path}"})
	public String accountAction(Model model, HttpServletRequest request,
			@PathVariable String path)
	{
		System.out.println("Account action");
		String username = Utils.checkToken(request.getCookies());
		User user = authService.findUser(username);
		if (user == null)
		{
			return "redirect:/";
		}
		else
		{
			getModel(model, request, "Account information");
			model.addAttribute("path", path);
			return "account";
		}
	}
	
	@RequestMapping(value = {"/contact"})
	public String contact(Model model, HttpServletRequest request)
	{
		System.out.println("Contact");
		getModel(model, request, "Contact me!");
		
		return "contact";
	}
	
	private void getModel(Model model, HttpServletRequest request, String title)
	{
		String username = Utils.checkToken(request.getCookies());
		User user = authService.findUser(username);
		if (user != null)
		{
			model.addAttribute("user", user);
		}
		
		model.addAttribute("title", title);
		model.addAttribute("cartNumber", 0);
	}
}
