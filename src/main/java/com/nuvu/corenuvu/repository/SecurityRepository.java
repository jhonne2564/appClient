package com.nuvu.corenuvu.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nuvu.corenuvu.model.SecurityApp;

public interface SecurityRepository extends CrudRepository<SecurityApp, Integer>{

	@Query("SELECT c FROM SecurityApp c WHERE c.key = :key")
	SecurityApp findByKey(@Param("key") String key);
	
}
