package com.newgen.myapp.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.newgen.myapp.dao.VoterDao;
import com.newgen.myapp.pojo.Address;
import com.newgen.myapp.pojo.Voter;

@Component
public class JdbcVoterDaoImpl implements VoterDao {
	private static final Logger logger = LoggerFactory
			.getLogger(JdbcVoterDaoImpl.class);
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		//this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Voter> getVoterList(){
		logger.debug("inside method: getVoterList()");
		String sqlStr = "select * from voter";
		List<Voter> voterList = new ArrayList<Voter>();
		voterList = this.getJdbcTemplate().query(sqlStr, new ResultSetExtractor<List<Voter>>(){
			@Override
			public List<Voter> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				List<Voter> listOfVoter = new ArrayList<Voter>();
				while(rs.next()){
					Voter voter = new Voter();
					voter.setVoterId(rs.getString("voter_id"));
					voter.setVoterFirstName(rs.getString("voter_first_name"));
					voter.setVoterMiddleName(rs.getString("voter_middle_name"));
					voter.setVoterLastName(rs.getString("voter_last_name"));
					voter.setVoterGender(rs.getString("voter_gender"));
					voter.setVoterStatus(rs.getString("voter_status"));
					listOfVoter.add(voter);
				}
				return listOfVoter;
			}
		});
		logger.debug("Completed method: getVoterList()");
		return voterList;
	}
	public Voter getVoterDetails(String voterId) {
		logger.debug("inside method: getVoterDetails()");
		Voter voter = new Voter();
		String sqlStr = "select voter_id, voter_first_name, voter_middle_name, voter_last_name, voter_father_name, voter_gender, " +
				"voter_dob, voter_status, voter_phone_no, voter_emailid, house_no, address_1, address_2, address_3, city, state, " +
				"pincode from voter right outer join address using (voter_id) where voter_id= ?";

		voter  = this.getJdbcTemplate().queryForObject(sqlStr, new Object[]{voterId}, new RowMapper<Voter>(){
			@Override
			public Voter mapRow(ResultSet rs, int rowNum) throws SQLException {
				Voter voter = new Voter();
				Address address = new Address();
				do{
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
					return voter;
				}
				while(rs.next());
			}
		});
		logger.debug("completed method: getVoterDetails()");
		return voter;
	}
	
	public String saveVoterDetails(final Voter voter){
		logger.debug("inside method: saveVoterDetails()");
		String insertVoterStoreProc = "{call insertVoter(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		//	List<Voter> listVoter= new ArrayList<Voter>();
		//	String listVoter = null;
		this.getJdbcTemplate().update(insertVoterStoreProc, new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, voter.getVoterId());
				ps.setString(2, voter.getVoterFirstName());
				ps.setString(3, voter.getVoterMiddleName());
				ps.setString(4, voter.getVoterLastName());
				ps.setString(5, voter.getVoterFathersName());
				ps.setString(6, voter.getVoterGender());
				ps.setDate(7, voter.getVoterDob());
				ps.setString(8, voter.getVoterStatus());
				ps.setString(9, voter.getVoterPhoneNo());
				ps.setString(10, voter.getVoterEmailId());
				ps.setString(11, voter.getVoterAddress().getHouseNo());
				ps.setString(12, voter.getVoterAddress().getAddres1());
				ps.setString(13, voter.getVoterAddress().getAddres2());
				ps.setString(14, voter.getVoterAddress().getAddres3());
				ps.setString(15, voter.getVoterAddress().getCity());
				ps.setString(16, voter.getVoterAddress().getState());
				ps.setInt(17, voter.getVoterAddress().getPinCode());
				ps.setString(18, voter.getVoterId());
			}});
		logger.debug("Completed method: saveVoterDetails()");
		String voterId =  voter.getVoterId();
		return voterId;
	}
	
	public Voter updateVoterDetails(final Voter voter) {
		logger.debug("inside method: updateVoterDetails()");
		Voter voterDet = new Voter();
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
				+ "WHERE v.voter_id= ?";
		this.getJdbcTemplate().update(updateVoter, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, voter.getVoterFirstName());
				ps.setString(2, voter.getVoterMiddleName());
				ps.setString(3, voter.getVoterLastName());
				ps.setString(4, voter.getVoterFathersName());
				ps.setString(5, voter.getVoterGender());
				ps.setDate(6, voter.getVoterDob());
				ps.setString(7, voter.getVoterStatus());
				ps.setString(8, voter.getVoterPhoneNo());
				ps.setString(9, voter.getVoterEmailId());
				ps.setString(10, voter.getVoterAddress().getHouseNo());
				ps.setString(11, voter.getVoterAddress().getAddres1());
				ps.setString(12, voter.getVoterAddress().getAddres2());
				ps.setString(13, voter.getVoterAddress().getAddres3());
				ps.setString(14, voter.getVoterAddress().getCity());
				ps.setString(15, voter.getVoterAddress().getState());
				ps.setInt(16, voter.getVoterAddress().getPinCode());
				ps.setString(17, voter.getVoterId());
			}
		});
		logger.debug("Completed method: updateVoterDetails()");
		voterDet = this.getVoterDetails(voter.getVoterId());
		return voterDet;
	}
	
	@SuppressWarnings({ })
	public List<Voter> deleteVoter(final String voterId) {
		logger.debug("inside method: deleteVoter()");
		List<Voter> voter = new ArrayList<Voter>();
		String deleteVoterSql = "delete address, voter from address inner join voter on (voter.voter_id = address.voter_id) "
				+ "where voter.voter_id= ?";
		
		this.getJdbcTemplate().update(deleteVoterSql, new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, voterId);
			}
		});
		voter = this.getVoterList();
		logger.debug("Completed method: deleteVoter()");
		return voter;	
	}
}
