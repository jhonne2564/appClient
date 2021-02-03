package com.nuvu.corenuvu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nuvu.corenuvu.domain.ProcessDelete;
import com.nuvu.corenuvu.domain.ProcessDetail;
import com.nuvu.corenuvu.domain.ProcessGetAll;
import com.nuvu.corenuvu.model.ClientDto;
import com.nuvu.corenuvu.register.ProcessRegister;

@Service
public class ProcessService {
	private ProcessRegister processRegister;
	private ProcessDelete  processDelete;
	private ProcessDetail processDetail;
	private ProcessGetAll processGetAll;
	public ProcessService(ProcessRegister processRegister,ProcessDelete  processDelete,ProcessDetail processDetail,ProcessGetAll processGetAll) {
		this.processRegister=processRegister;
		this.processDelete=processDelete;
		this.processDetail=processDetail;
		this.processGetAll=processGetAll;
	}

	public void registerClient(ClientDto client) {
		processRegister.register(client);
	}

	public  List<ClientDto>  geAllClients() {		
		return processGetAll.getAll();
	}

	public ClientDto detailClient(Integer identifier) {		
		return processDetail.detail(identifier);
	}

	public ClientDto deleteClient(Integer identifier) {		
		return processDelete.delete(identifier);
	}
}
