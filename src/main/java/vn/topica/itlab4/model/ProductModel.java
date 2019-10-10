package vn.topica.itlab4.model;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.topica.itlab4.bean.Product;

import java.util.List;

public interface ProductModel
{
	@Transactional
	Product save(Product category);
	
	@Transactional
	Product update(Product category);
	
	@Transactional
	Product find(int id);
	
	@Transactional
	List<Product> findAll(int pageIndex);
}
