package com.newgen.myapp.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.newgen.myapp.dao.AddressDao;
import com.newgen.myapp.dao.VoterDao;

public class DaoImpTest {
	
	@Autowired
	VoterDao voterDao;

	@Autowired
	AddressDao addressDao;

	public static void main(String[] args) {

		ApplicationContext context1 = new FileSystemXmlApplicationContext(
				"src/main/webapp/WEB-INF/spring/appServlet/test.xml");
		
		AddressDao addressDao = (AddressDao) context1.getBean("addressDao");
		
		
		Set<String> stateList = addressDao.getStateList();
		System.out.println("State List: " + stateList.toString());
		
		
		
	}

}
