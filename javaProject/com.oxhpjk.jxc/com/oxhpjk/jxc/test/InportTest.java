package com.oxhpjk.jxc.test;


import java.util.List;

import org.junit.Test;

import com.oxhpjk.jxc.commom.CommonFactory;
import com.oxhpjk.jxc.model.Inport;
import com.oxhpjk.jxc.service.InportService;


public class InportTest {
	
	@Test
	public void testinport() {
		InportService inportService = CommonFactory.getInportService();
		Inport inport = new Inport();
		List<Inport> list = inportService.findInports(inport);
		System.out.println(list.get(0).getId());
	}
}
