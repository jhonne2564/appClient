package com.nuvu.corenuvu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.nuvu.corenuvu.model.ResponsePaymentDto;
import com.nuvu.corenuvu.model.Paymentcard;
import com.nuvu.corenuvu.service.PaymentService;
import com.sun.istack.NotNull;

@RestController
public class PaymentCardController {
	private static final Logger logger = LoggerFactory.getLogger(PaymentCardController.class);
	
	private PaymentService paymentService;
	public PaymentCardController(PaymentService paymentService) {
		this.paymentService=paymentService;
	}
	
	
	@PostMapping("/paymentcard/create")
	public ResponseEntity<ResponsePaymentDto> register(@RequestBody @NotNull  Paymentcard paymentCard,  @RequestHeader MultiValueMap<String, String> headers){
		ResponseEntity<ResponsePaymentDto> response=null;
		logger.debug("Begin register");
		
		try {						
			ResponsePaymentDto responsePayment=paymentService.registerPaymentCard(paymentCard);
			response=new ResponseEntity<>(responsePayment,HttpStatus.OK);
			logger.debug("End register");
		} catch (Exception e) {
			logger.error("Error General", e);
			ResponsePaymentDto responsePayment= new ResponsePaymentDto();
			responsePayment.setError(e.getMessage());
			response=new ResponseEntity<>(responsePayment,HttpStatus.OK);
		}	
		return response;
		
	}
}
