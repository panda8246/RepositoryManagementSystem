package com.oxhpjk.jxc.test;

import java.util.List;

import org.junit.Test;

import com.oxhpjk.jxc.commom.CommonFactory;
import com.oxhpjk.jxc.model.Inport;
import com.oxhpjk.jxc.model.Outport;
import com.oxhpjk.jxc.service.InportService;
import com.oxhpjk.jxc.service.OutportService;

public class OutportTest {

	
	@Test
	public void testoutport() {
		OutportService outportService = CommonFactory.getOutportService();
		Outport outport = new Outport();
		List<Outport> list = outportService.findOutports(outport);
		System.out.println(list.get(0).getPaytype());
	}
}
