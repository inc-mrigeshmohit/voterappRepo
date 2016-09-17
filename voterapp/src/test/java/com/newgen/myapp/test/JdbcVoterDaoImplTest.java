package com.newgen.myapp.test;

import java.sql.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.newgen.myapp.daoimpl.JdbcVoterDaoImpl;
import com.newgen.myapp.pojo.Address;
import com.newgen.myapp.pojo.Voter;

@Component
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/test-context.xml" })
@RunWith(value = SpringJUnit4ClassRunner.class)
public class JdbcVoterDaoImplTest {

	@Autowired
	private JdbcVoterDaoImpl jdbcVoterDaoImpl;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetVoterDetails() {
		jdbcVoterDaoImpl.getVoterDetails("BXQ2699221");
	}

	@Test
	public void testGetVoterList() {
		jdbcVoterDaoImpl.getVoterList();
	}
	
	@Test
	public void testSaveVoterDetails() {
		Voter voter = new Voter();
		Address address = new Address();
		voter.setVoterId("BXQ2699251");
		voter.setVoterFirstName("Kumari");
		voter.setVoterMiddleName("Vandana");
		voter.setVoterLastName("Jaiswal");
		voter.setVoterFathersName("Shiv Prakash Jaiswal");
		voter.setVoterGender("female");
		voter.setVoterDob(new Date(1985-11-02));
		voter.setVoterStatus("Active");
		voter.setVoterPhoneNo("8055896387");
		voter.setVoterEmailId("jaiswalkamini02@gmail.com");
		address.setVoterId("BXQ2699251");
		address.setHouseNo("Hno 81");
		address.setAddres1("Matan Tola");
		address.setAddres2("Gosaiganj");
		address.setAddres3("Teh-Mohanlalganj");
		address.setCity("Lucknow");
		address.setState("Uttar-Pradesh");
		address.setPinCode(226012);
		voter.setVoterAddress(address);
		//jdbcVoterDaoImpl.saveVoterDetails(voter);
	}

	@Test
	public void testUpdateVoterDetails() {
		Voter voter = new Voter();
		Address address = new Address();
		voter.setVoterId("BXQ2699221");
		voter.setVoterFirstName("Kumari");
		voter.setVoterMiddleName("Kamini");
		voter.setVoterLastName("Jaiswal");
		voter.setVoterFathersName("Shiv Prakash Jaiswal");
		voter.setVoterGender("female");
		voter.setVoterDob(new Date(1985-11-02));
		voter.setVoterStatus("Active");
		voter.setVoterPhoneNo("8055896387");
		voter.setVoterEmailId("jaiswalkamini02@gmail.com");
		address.setVoterId("BXQ2699221");
		address.setHouseNo("Hno 81");
		address.setAddres1("Matan Tola");
		address.setAddres2("Gosaiganj");
		address.setAddres3("Teh-Mohanlalganj");
		address.setCity("Lucknow");
		address.setState("Uttar-Pradesh");
		address.setPinCode(226012);
		voter.setVoterAddress(address);
		jdbcVoterDaoImpl.updateVoterDetails(voter);
	}
	
	@Test
	public void testDeleteVoter() {
		//jdbcVoterDaoImpl.deleteVoter("BXQ2699253");
	}

}
