package com.nuvu.corenuvu.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvu.corenuvu.model.ClientDto;
import com.nuvu.corenuvu.repository.ClientRepository;
import com.nuvu.corenuvu.repository.PaymentcardRepository;

@Component
public class ProcessRegister {

	@Autowired
    private ClientRepository clientRepository;
	
	 @Autowired
	private PaymentcardRepository PaymentcardRepository;
	 
	public void register(ClientDto client) {
		try {
			clientRepository.save(client);
		}catch (Exception e) {
			
		}		
	}	
}
