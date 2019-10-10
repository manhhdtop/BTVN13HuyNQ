package vn.topica.itlab4.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import vn.topica.itlab4.bean.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product
		, Integer>
{
	Product findById(int id);
	
	@Query("FROM Product")
	Page<Product> findAll(Pageable pageable);
}
