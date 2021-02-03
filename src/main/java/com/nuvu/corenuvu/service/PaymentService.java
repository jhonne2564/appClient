package com.nuvu.corenuvu.service;

import org.springframework.stereotype.Service;

import com.nuvu.corenuvu.model.Paymentcard;
import com.nuvu.corenuvu.model.ResponsePaymentDto;
import com.nuvu.corenuvu.repository.PaymentcardRepository;

@Service
public class PaymentService {
	
	PaymentcardRepository paymentcardRepository;		

	public PaymentService(PaymentcardRepository paymentcardRepository) {
		this.paymentcardRepository=paymentcardRepository;
	}
	
	public ResponsePaymentDto registerPaymentCard(Paymentcard paymentCard) {
		ResponsePaymentDto dto= null;		
		try {
			dto= new ResponsePaymentDto();
			paymentcardRepository.save(paymentCard);
			dto.setResponse("sucessfull");
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return dto;
	}

	
}
