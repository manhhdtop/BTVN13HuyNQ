package vn.topica.itlab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.topica.itlab4.bean.Data;
import vn.topica.itlab4.bean.Product;
import vn.topica.itlab4.model.ProductModel;
import vn.topica.itlab4.util.Constant;
import vn.topica.itlab4.util.Utils;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/product/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController
{
	@Autowired
	private ProductModel model;
	
	@RequestMapping(value = "list-product")
	public String products(@RequestParam(name = "page", defaultValue = "1") String page)
	{
		String method = "List Product";
		String message;
		int code;
		
		System.out.println(method);
		
		message = method + Constant.MESSAGE_ERROR;
		code = Constant.CODE_SUCCESS;
		if (!page.matches("[0-9]+"))
		{
			code = Constant.CODE_FIELD_NOT_VALID;
			message = method + Constant.MESSAGE_ERROR;
			return Utils.packetToJson(Utils.getPacket(method, code, message,
					"Page not valid."));
		}
		int pageIndex = Integer.parseInt(page);
		if (pageIndex <= 0)
		{
			code = Constant.CODE_FIELD_NOT_VALID;
			message = method + Constant.MESSAGE_ERROR;
			return Utils.packetToJson(Utils.getPacket(method, code, message,
					"Page must be granter 0."));
		}
		List<Product> products = model.findAll(pageIndex - 1);
		Data d = new Data();
		d.setProducts(products);
		return Utils.packetToJson(Utils.getPacket(method, code, message, d));
	}
	
	@RequestMapping(value = "add-product")
	public String addProduct(@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "description", defaultValue = "") String description,
			@RequestParam(name = "price", defaultValue = "") String price)
	{
		String method = "Add product";
		String message;
		int code;
		
		System.out.println(method);
		
		boolean checkPrice = true;
		try
		{
			Double.parseDouble(price);
		}
		catch (NumberFormatException e)
		{
			checkPrice = false;
		}
		
		if (name.equals("") || !checkPrice)
		{
			List<String> errors = new ArrayList<>();
			message = method + Constant.MESSAGE_ERROR;
			code = Constant.CODE_FIELD_NOT_VALID;
			if (name.equals(""))
			{
				errors.add("Product name not valid.");
			}
			if (!checkPrice)
			{
				errors.add("Product price not valid.");
			}
			return Utils.packetToJson(Utils.getPacket(method, code, message,
					errors));
		}
		message = method + Constant.MESSAGE_ERROR;
		code = Constant.CODE_SUCCESS;
		Product p = new Product();
		p.setName(name);
		p.setDescription(description);
		p.setPrice(price);
		
		model.save(p);
		
		return Utils.packetToJson(Utils.getPacket(method, code, message, p));
	}
}
