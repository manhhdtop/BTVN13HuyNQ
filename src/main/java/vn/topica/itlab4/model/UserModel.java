package vn.topica.itlab4.model;

import org.springframework.transaction.annotation.Transactional;
import vn.topica.itlab4.bean.User;

import java.util.List;

public interface UserModel
{
	@Transactional
	User save(User user);
	
	@Transactional
	User update(User user);
	
	@Transactional
	User findById(int id);
	
	@Transactional
	User findByUsername(String username);
	
	@Transactional
	List<User> findAll(int pageIndex);
	
	
}
