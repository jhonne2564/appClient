package com.nuvu.corenuvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nuvu.corenuvu.model.ClientDto;

public interface ClientRepository extends JpaRepository<ClientDto,Integer> {
	
}
