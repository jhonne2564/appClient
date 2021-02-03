package com.nuvu.corenuvu.service;

import org.springframework.stereotype.Service;

import com.nuvu.corenuvu.model.SecurityApp;
import com.nuvu.corenuvu.repository.SecurityRepository;

@Service
public class UtilsService {

	SecurityRepository securityRepository;  
	
	public UtilsService(SecurityRepository securityRepository) {
		this.securityRepository =securityRepository;
	}
	public SecurityApp getClient(String header) {
		return securityRepository.findByKey(header);		
	}	

}
