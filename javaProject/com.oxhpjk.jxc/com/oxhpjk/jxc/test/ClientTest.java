package com.oxhpjk.jxc.test;

import java.util.List;

import org.junit.Test;

import com.oxhpjk.jxc.common.Factory;
import com.oxhpjk.jxc.modle.Client;
import com.oxhpjk.jxc.service.ClientService;

public class ClientTest {
	
	@Test
	public void _clientTest() {
		ClientService clientService = Factory.getClientService();
//		List list = clientService.getAllClients();
//		Client client = (Client)list.get(0);
//		System.out.println(client.getName());
		String id = "C1";
		Client client = new Client("C");
		List list = clientService.findClients(client);
		System.out.println(((Client)list.get(0)).getBank());
	}
}
