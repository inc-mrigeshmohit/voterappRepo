package com.newgen.myapp.test;

import java.util.ArrayList;
import java.util.List;

import com.newgen.myapp.dao.AddressDao;
import com.newgen.myapp.daoimpl.AddressDaoImpl;
import com.newgen.myapp.pojo.Address;

public class AddressTest {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> stateList = new ArrayList<String>();
		AddressDao addressDao = new AddressDaoImpl();
		//stateList = addressDao.getStateList();
		
		System.out.println("States are: " + stateList);
		
	}

}
