package com.oxhpjk.jxc.service.imp;

import java.util.List;

import com.oxhpjk.jxc.dao.ClientDao;
import com.oxhpjk.jxc.modle.Client;
import com.oxhpjk.jxc.service.ClientService;

public class ClientImp implements ClientService{

	@Override
	public List<Client> getAllClients() {
		ClientDao clientdao = new ClientDao();
		return clientdao.getAllClient();
	}

	@Override
	public List findClients(Client client) {
		ClientDao clientdao = new ClientDao();
		return clientdao.findClients(client);
	}

	@Override
	public boolean updateClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}


}
