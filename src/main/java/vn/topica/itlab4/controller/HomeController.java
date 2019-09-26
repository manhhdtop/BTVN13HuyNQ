package vn.topica.itlab4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.cryptography.Encrypt;
import vn.topica.itlab4.model.UserModel;
import vn.topica.itlab4.util.Constant;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController
{
	@RequestMapping(value = {"/", "/index", "/index.jsp"})
	public String home(Model model, HttpSession session)
	{
		System.out.println("Home");
		getModel(model, session.getId(), "Pet shop by ManhHD");
		
		String salt = Encrypt.getSalt(Constant.FILE_NAME_LENGTH);
		String password = Encrypt.generateSecurePassword("123456a@", salt);
		System.out.println(salt);
		System.out.println(password);
		
		List<User> users = new UserModel().getUser();
		users.forEach(System.out::println);
		return "index";
	}
	
	@RequestMapping(value = {"/cart"})
	public String cart(Model model, HttpSession session)
	{
		System.out.println("Cart");
		getModel(model, session.getId(), "Your cart detail");
		
		return "cart";
	}
	
	@RequestMapping(value = {"/contact"})
	public String contact(Model model, HttpSession session)
	{
		System.out.println("Contact");
		getModel(model, session.getId(), "Contact me!");
		
		return "contact";
	}
	
	private void getModel(Model model, String sessionId, String title)
	{
		model.addAttribute("title", title);
		model.addAttribute("cartNumber", 0);
	}
}
