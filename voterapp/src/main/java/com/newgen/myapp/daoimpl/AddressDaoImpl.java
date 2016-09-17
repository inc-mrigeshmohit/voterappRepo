package com.newgen.myapp.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.newgen.myapp.dao.AddressDao;
import com.newgen.myapp.pojo.Address;

public class AddressDaoImpl implements AddressDao {
	private static final Logger logger = LoggerFactory
			.getLogger(AddressDaoImpl.class);

	@Override
	public Set<String> getStateList() {
		return null;/*

		logger.debug("inside method: getStateList()");
		Set<String> stateSet = new LinkedHashSet<String>();

		DbConnectionManager dbcon = new DbConnectionManager();
		try {
			dbcon.getConnection("userdb", "root", "root");
			if ((dbcon.getConnection("userdb", "root", "root") != null)) {
				logger.debug("Connection Created Successfully !");

				Statement stmt = dbcon.createStatement();
				ResultSet rs = stmt
						.executeQuery("select state from tblcitylist");
				if (rs.next()) {
					while (rs.next()) {
						stateSet.add(rs.getString("state").toString());
					}
				}
				// System.out.println("Size of stale list is: " +
				// stateSet.size());
				// System.out.println("State list are: " + stateSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbcon.closeConnection();
			dbcon.closeStatement();
			dbcon.closeResultSet();
		}
		logger.debug("outside method: getStateList()");
		return stateSet;
	*/}

	@Override
	public List<String> getCityList(String stateName) {
		return null;/*
		// TODO Auto-generated method stub
		logger.debug("inside method: getCityList()");
		List<String> cityList = new ArrayList<String>();
		DbConnectionManager dbcon = new DbConnectionManager();
		try {
			dbcon.getConnection("userdb", "root", "root");
			if ((dbcon.getConnection("userdb", "root", "root") != null)) {
				logger.debug("Connection Created Successfully !");
				System.out.println("inside daoimpl stateName:=   " + stateName);
				Statement stmt = dbcon.createStatement();
				ResultSet rs = stmt
						.executeQuery("select city_name from tblcitylist where state= '"
								+ stateName + "'");
				System.out.println("query: " + rs.toString());
				while (rs.next()) {
					cityList.add(rs.getString("city_name").toString());
				}
			}
			// System.out.println("Size of city list is: " + cityList.size());
			// System.out.println("City list are: " + cityList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbcon.closeConnection();
			dbcon.closeResultSet();
			dbcon.closeStatement();
		}
		logger.debug("outside method: getCityList()");
		return cityList;
	*/}

	@Override
	public String getCity(int cityId) {
		return null;/*
		// TODO Auto-generated method stub
		logger.debug("inside method: getVoterDetails()");
		Address address = new Address();
		DbConnectionManager dbcon = new DbConnectionManager();
		try {
			dbcon.getConnection("userdb", "root", "root");
			if ((dbcon.getConnection("userdb", "root", "root") != null)) {
				logger.debug("Connection Created Successfully !");

				Statement stmt = dbcon.createStatement();
				ResultSet rs = stmt
						.executeQuery("select city_name from tblcitylist where state="
								+ cityId);
				while (rs.next()) {
					
					 * voter.setVoterId(rs.getString("voter_id"));
					 * voter.setVoterFirstName
					 * (rs.getString("voter_first_name"));
					 * voter.setVoterMiddleName
					 * (rs.getString("voter_middle_name"));
					 * voter.setVoterLaststName
					 * (rs.getString("voter_last_name"));
					 * voter.setVoterFathersName
					 * (rs.getString("voter_father_name"));
					 * voter.setVoterGender(rs.getString("voter_gender"));
					 * voter.setVoterDob(rs.getString("voter_dob"));
					 * voter.setVoterStatus(rs.getString("voter_status"));
					 * voter.setVoterPhoneNo(rs.getInt("voter_phone_no"));
					 * voter.setVoterEmailId(rs.getString("voter_emailid"));
					 
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbcon.closeConnection();
			dbcon.closeResultSet();
			dbcon.closeStatement();
		}
		logger.debug("outside method: getVoterDetails()");
		return null;
	*/}
}
