package vn.topica.itlab4.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.topica.itlab4.bean.Product;
import vn.topica.itlab4.model.ProductModel;
import vn.topica.itlab4.repository.ProductRepository;
import vn.topica.itlab4.util.Constant;

import java.util.List;

@Service
public class ProductModelImpl implements ProductModel
{
	@Autowired
	private ProductRepository repository;
	
	@Override
	public Product save(Product p)
	{
		return repository.save(p);
	}
	
	@Override
	public Product update(Product p)
	{
		return repository.save(p);
	}
	
	@Override
	public Product find(int id)
	{
		return repository.findById(id);
	}
	
	@Override
	public List<Product> findAll(int pageIndex)
	{
		return repository.findAll(PageRequest.of(pageIndex,
				Constant.PAGE_SIZE)).getContent();
	}
}
