package vn.topica.itlab4.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.model.UserModel;
import vn.topica.itlab4.repository.UserRepository;
import vn.topica.itlab4.util.Constant;

import java.util.List;

@Service
public class UserModelImpl implements UserModel
{
	@Autowired
	private UserRepository repository;
	
	@Override
	public User save(User u)
	{
		return repository.save(u);
	}
	
	@Override
	public User update(User u)
	{
		return repository.save(u);
	}
	
	@Override
	public User findById(int id)
	{
		return null;
	}
	
	@Override
	public User findByUsername(String username)
	{
		System.out.println("username: " + repository);
		return repository.findByUsername(username);
	}
	
	@Override
	public List<User> findAll(int pageIndex)
	{
		return repository.findAll(PageRequest.of(pageIndex,
				Constant.PAGE_SIZE)).getContent();
	}
}
