package vn.topica.itlab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.model.UserModel;
import vn.topica.itlab4.util.Utils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BackendController
{
	@Autowired
	private UserModel model;
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = {"/backend", "/backend/index"})
	public String home(Model model, HttpServletRequest request)
	{
		System.out.println("Backend");
		
		User user = getModel(model, request, "Admin site");
		
		return forward(user, "/backend/index");
	}
	
	@RequestMapping(value = {"/backend/login"})
	public String login(Model model, HttpServletRequest request)
	{
		System.out.println("Backend login");
		
		User user = getModel(model, request, "Admin site");
		System.out.println("User: " + user);
		if (user != null)
		{
			return "redirect:/backend";
		}
		return "/backend/login";
	}
	
	@RequestMapping(value = {"/backend/register"})
	public String register(Model model, HttpServletRequest request)
	{
		System.out.println("Backend register");
		
		User user = getModel(model, request, "Admin site - Register");
		System.out.println(user);
		if (user != null)
		{
			return "redirect:/backend";
		}
		
		return "/backend/register";
	}
	
	@RequestMapping(value = {"/backend/products"})
	public String products(Model model, HttpServletRequest request)
	{
		System.out.println("Backend products");
		
		User user = getModel(model, request, "Admin site - List product");
		
		return forward(user, "/backend/products");
	}
	
	@RequestMapping(value = {"/backend/add-product"})
	public String addProduct(Model model, HttpServletRequest request)
	{
		System.out.println("Backend Add product");
		
		User user = getModel(model, request, "Admin site - Add product");
		
		return forward(user, "/backend/add-product");
	}
	
	@RequestMapping(value = {"/backend/update-product"})
	public String updateProduct(Model model, HttpServletRequest request)
	{
		System.out.println("Backend Update product");
		
		User user = getModel(model, request, "Admin site - Update product");
		
		return forward(user, "/backend/add-product");
	}
	
	private String forward(User user, String path)
	{
		System.out.println(user);
		if (user == null)
		{
			return "redirect:/backend/login";
		}
		if (user.getRole() == 0)
		{
			return "/error/403";
		}
		return path;
	}
	
	private User getModel(Model model, HttpServletRequest request, String title)
	{
		String username = Utils.checkToken(request.getCookies());
		User user = authService.findUser(username);
		if (user != null)
		{
			model.addAttribute("user", user);
		}
		
		model.addAttribute("title", title);
		
		return user;
	}
}
