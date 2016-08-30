package com.newgen.myapp.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VoterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		//EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		//Employee employee1 = new Employee(123, "javacodegeeks", 30);
		//employeeDAO.insert(employee1);
		//Employee employee2 = employeeDAO.findById(123);
		//System.out.println(employee2);
		context.close();

	}

}
