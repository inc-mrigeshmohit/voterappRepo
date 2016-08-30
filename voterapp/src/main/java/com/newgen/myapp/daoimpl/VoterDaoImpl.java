package com.newgen.myapp.daoimpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.newgen.myapp.connections.DbConnectionManager;
import com.newgen.myapp.dao.VoterDao;
import com.newgen.myapp.pojo.Address;
import com.newgen.myapp.pojo.Voter;

public class VoterDaoImpl implements VoterDao {
	private static final Logger logger = LoggerFactory
			.getLogger(VoterDaoImpl.class);

	@Override
	public Voter getVoterDetails(String voterId) {
		logger.debug("inside method: getVoterDetails()");
		Voter voter = new Voter();
		Address address = new Address();
		DbConnectionManager dbcon = new DbConnectionManager();
		try {
			dbcon.getConnection("voterdb", "root", "root");
			if ((dbcon.getConnection("voterdb", "root", "root") != null)) {
				logger.debug("Connection Created Successfully !");
				Statement stmt = dbcon.createStatement();

				ResultSet rs = stmt
						.executeQuery("select voter.voter_id, voter_first_name, voter_middle_name, voter_last_name, "
								+ "voter_father_name, voter_gender, voter_dob, voter_status, voter_phone_no, voter_emailid, house_no, address_1, address_2, "
								+ "address_3, city, state, pincode from voter right outer join address using (voter_id) where voter_id="
								+ "'" + voterId + "'");

				while (rs.next()) {
					voter.setVoterId(rs.getString("voter_id"));
					voter.setVoterFirstName(rs.getString("voter_first_name"));
					voter.setVoterMiddleName(rs.getString("voter_middle_name"));
					voter.setVoterLastName(rs.getString("voter_last_name"));
					voter.setVoterFathersName(rs.getString("voter_father_name"));
					voter.setVoterGender(rs.getString("voter_gender"));
					voter.setVoterDob(rs.getDate("voter_dob"));
					voter.setVoterStatus(rs.getString("voter_status"));
					voter.setVoterPhoneNo(rs.getString("voter_phone_no"));
					voter.setVoterEmailId(rs.getString("voter_emailid"));

					address.setHouseNo(rs.getString("house_no"));
					address.setAddres1(rs.getString("address_1"));
					address.setAddres2(rs.getString("address_2"));
					address.setAddres3(rs.getString("address_3"));
					address.setCity(rs.getString("city"));
					address.setState(rs.getString("state"));
					address.setPinCode(rs.getInt("pincode"));
					voter.setVoterAddress(address);
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
		return voter;
	}

	@Override
	public String saveVoterDetails(Voter voter) {
		logger.debug("inside method: saveVoterDetails()");
		DbConnectionManager dbcon = new DbConnectionManager();
		try {
			dbcon.getConnection("voterdb", "root", "root");

			if ((dbcon.getConnection("voterdb", "root", "root") != null)) {
				logger.debug("Connection Created Successfully !");
				String insertVoterStoreProc = "{call insertVoter(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				CallableStatement callStmt = dbcon
						.callableStatement(insertVoterStoreProc);
				callStmt.setString(1, voter.getVoterId());
				callStmt.setString(2, voter.getVoterFirstName());
				callStmt.setString(3, voter.getVoterMiddleName());
				callStmt.setString(4, voter.getVoterLastName());
				callStmt.setString(5, voter.getVoterFathersName());
				callStmt.setString(6, voter.getVoterGender());
				callStmt.setDate(7, voter.getVoterDob());
				callStmt.setString(8, voter.getVoterStatus());
				callStmt.setString(9, voter.getVoterPhoneNo());
				callStmt.setString(10, voter.getVoterEmailId());

				callStmt.setString(11, voter.getVoterAddress().getHouseNo());
				callStmt.setString(12, voter.getVoterAddress().getAddres1());
				callStmt.setString(13, voter.getVoterAddress().getAddres2());
				callStmt.setString(14, voter.getVoterAddress().getAddres3());
				callStmt.setString(15, voter.getVoterAddress().getCity());
				callStmt.setString(16, voter.getVoterAddress().getState());
				callStmt.setInt(17, voter.getVoterAddress().getPinCode());
				callStmt.setString(18, voter.getVoterId());

				callStmt.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbcon.closeConnection();
			dbcon.closeCallableStatemant();
		}
		logger.debug("outside method: saveVoterDetails()");
		return voter.getVoterId();
	}

	@Override
	public List<Voter> getVoterList() {
		// TODO Auto-generated method stub
		logger.debug("inside method: getVoterList()");
		List<Voter> voterList = new ArrayList<Voter>();

		DbConnectionManager dbcon = new DbConnectionManager();
		try {
			dbcon.getConnection("voterdb", "root", "root");
			if ((dbcon.getConnection("voterdb", "root", "root") != null)) {
				logger.debug("Connection Created Successfully !");

				Statement stmt = dbcon.createStatement();
				ResultSet rs = stmt.executeQuery("select * from voter");

				while (rs.next()) {
					Voter voter = new Voter();
					voter.setVoterId(rs.getString("voter_id"));
					voter.setVoterFirstName(rs.getString("voter_first_name"));
					voter.setVoterMiddleName(rs.getString("voter_middle_name"));
					voter.setVoterLastName(rs.getString("voter_last_name"));
					voter.setVoterGender(rs.getString("voter_gender"));
					voter.setVoterStatus(rs.getString("voter_status"));
					voterList.add(voter);
				}

				logger.debug("voter details are: " + voterList);
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
		logger.debug("outside method: getVoterList()");
		return voterList;
	}

	@Override
	public Voter deleteVoter(String voterId) {
		logger.debug("inside method: deleteVoter()");
		DbConnectionManager dbcon = new DbConnectionManager();
		try {
			dbcon.getConnection("voterdb", "root", "root");
			if ((dbcon.getConnection("voterdb", "root", "root") != null)) {
				logger.debug("Connection Created Successfully !");
				Statement stmt = dbcon.createStatement();
				stmt.executeUpdate("delete address, voter from address inner join voter on (voter.voter_id = address.voter_id) "
						+ "where voter.voter_id=" + "'" + voterId + "'");
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
		logger.debug("outside method: deleteVoter()");
		return null;
	}

	@Override
	public Voter updateVoterDetails(Voter voter) {
		logger.debug("inside method: updateVoterDetails()");
		DbConnectionManager dbcon = new DbConnectionManager();
		try {
			dbcon.getConnection("voterdb", "root", "root");
			if ((dbcon.getConnection("voterdb", "root", "root") != null)) {
				logger.debug("Connection Created Successfully !");
				String updateVoter = "update (address a, voter v) inner join voter on (v.voter_id = a.voter_id) set "
						+ "v.voter_first_name = ?, "
						+ "v.voter_middle_name = ?, "
						+ "v.voter_last_name = ?, "
						+ "v.voter_father_name = ?, "
						+ "v.voter_gender = ?, "
						+ "v.voter_dob = ?, "
						+ "v.voter_status = ?, "
						+ "v.voter_phone_no = ?, "
						+ "v.voter_emailid = ?, "
						+ "a.house_no = ?, "
						+ "a.address_1 = ?, "
						+ "a.address_2 = ?, "
						+ "a.address_3 = ?, "
						+ "a.city = ?, "
						+ "a.state = ?, "
						+ "a.pincode = ? "
						+ "WHERE v.voter_id=" + "'" + voter.getVoterId() + "'";

				PreparedStatement prepStmt = dbcon
						.preparedStatement(updateVoter);

				prepStmt.setString(1, voter.getVoterFirstName());
				prepStmt.setString(2, voter.getVoterMiddleName());
				prepStmt.setString(3, voter.getVoterLastName());
				prepStmt.setString(4, voter.getVoterFathersName());
				prepStmt.setString(5, voter.getVoterGender());
				prepStmt.setDate(6, voter.getVoterDob());
				prepStmt.setString(7, voter.getVoterStatus());
				prepStmt.setString(8, voter.getVoterPhoneNo());
				prepStmt.setString(9, voter.getVoterEmailId());

				prepStmt.setString(10, voter.getVoterAddress().getHouseNo());
				prepStmt.setString(11, voter.getVoterAddress().getAddres1());
				prepStmt.setString(12, voter.getVoterAddress().getAddres2());
				prepStmt.setString(13, voter.getVoterAddress().getAddres3());
				prepStmt.setString(14, voter.getVoterAddress().getCity());
				prepStmt.setString(15, voter.getVoterAddress().getState());
				prepStmt.setInt(16, voter.getVoterAddress().getPinCode());

				prepStmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbcon.closeConnection();
			dbcon.closePreparedStatement();
			dbcon.closeResultSet();
		}
		logger.debug("outside method: updateVoterDetails()");
		return null;
	}

}
