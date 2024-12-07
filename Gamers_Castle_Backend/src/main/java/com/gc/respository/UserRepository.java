package com.gc.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gc.entity.Product;
import com.gc.entity.User;

public interface UserRepository extends JpaRepository<Product,Long>{
	
	Optional<User> findByEmail(String email);
	
	boolean existsByEmail(String email);
}
