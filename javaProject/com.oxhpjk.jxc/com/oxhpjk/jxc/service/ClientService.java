package com.oxhpjk.jxc.service;

import java.util.List;

import com.oxhpjk.jxc.modle.Client;

public interface ClientService {
	
	/**
	 * ȡ�����пͻ�
	 * @return
	 */
	public List<Client> getAllClients();
		
	public List<Client> findClients(Client client);
	
	public boolean updateClient(Client client);
	
	public boolean addClient(Client client);
	
}
