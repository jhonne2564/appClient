package com.nuvu.corenuvu.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvu.corenuvu.model.ClientDto;
import com.nuvu.corenuvu.repository.ClientRepository;

@Component
public class ProcessDelete {

	@Autowired
    private ClientRepository clientRepository;
	
	public ClientDto delete(Integer identifier) {
		ClientDto clientDto=null;
		try {
			clientDto=clientRepository.findById(identifier).get();
			clientRepository.deleteById(identifier);
		} catch (Exception e) {
			
		}		
		return clientDto;
	}

}
