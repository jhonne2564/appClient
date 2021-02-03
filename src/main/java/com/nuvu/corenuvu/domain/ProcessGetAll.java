package com.nuvu.corenuvu.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nuvu.corenuvu.model.ClientDto;
import com.nuvu.corenuvu.repository.ClientRepository;

@Component
public class ProcessGetAll {
	@Autowired
	private ClientRepository clientRepository;

	public List<ClientDto> getAll() {
		List<ClientDto> list=null;
		try {
			list = clientRepository.findAll().stream().filter(p -> p.getActive())
					.collect(Collectors.toList());
		} catch (Exception e) {

		}

		return list;
	}
}
