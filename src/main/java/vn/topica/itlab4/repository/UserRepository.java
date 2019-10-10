package vn.topica.itlab4.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.itlab4.bean.User;

public interface UserRepository extends PagingAndSortingRepository<User
		, Integer>
{
	User findById(int id);
	
	User findByUsername(String username);
	
	@Query("FROM User")
	Page<User> findAll(Pageable pageable);
}
