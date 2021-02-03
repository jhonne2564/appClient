package com.nuvu.corenuvu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.nuvu.corenuvu.model.ClientDto;
import com.nuvu.corenuvu.service.ProcessService;
import com.sun.istack.NotNull;

@RestController
public class ClientController {
	private ProcessService processService;
	public ClientController(ProcessService processService) {
		this.processService=processService;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	@PostMapping("/client/create")
	public ResponseEntity<ClientDto> create(@RequestBody @NotNull  ClientDto clientDto,  @RequestHeader MultiValueMap<String, String> headers){
		logger.debug("Begin create");	
		ResponseEntity<ClientDto> response=null;
		try {	
		 response=new ResponseEntity<>(clientDto,HttpStatus.OK);
		
		processService.registerClient(clientDto);
		logger.debug("End create");
		}catch (Exception e) {
			logger.error("Error General", e);	
			ClientDto client= new ClientDto();
			client.setName("error");
			response=new ResponseEntity<>(client,HttpStatus.OK);
		}
		return response;
		
	}
	
	@GetMapping("/client/all")
	public ResponseEntity<List<ClientDto>> clients(){
		
		logger.debug("Begin create");	
		List<ClientDto> list =processService.geAllClients();
		ResponseEntity<List<ClientDto>> response=new ResponseEntity<List<ClientDto>>(list,HttpStatus.OK);		
		logger.debug("End create");
		return response;
		
	}
	
	@GetMapping("/client/{identifier}")
	public ResponseEntity<ClientDto> detail(@PathVariable(required = true, name = "identifier") final Integer identifier,@RequestHeader MultiValueMap<String, String> headers){
		logger.debug("Begin detail");		
		ResponseEntity<ClientDto> response=new ResponseEntity<>(processService.detailClient(identifier),HttpStatus.OK);
		logger.debug("End detail");
		return response;	
	}
	
	@DeleteMapping(value = "/client/delete/{identifier}")	
	public ResponseEntity<ClientDto> delete(@PathVariable(required = true, name = "identifier") final Integer identifier,@RequestHeader MultiValueMap<String, String> headers){
		logger.debug("Begin delete");
		ResponseEntity<ClientDto> response=new ResponseEntity<>(processService.deleteClient(identifier),HttpStatus.OK);		
		logger.debug("End delete");
		return response;
		
	}
}
