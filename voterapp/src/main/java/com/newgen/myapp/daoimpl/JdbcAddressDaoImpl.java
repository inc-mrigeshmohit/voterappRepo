package com.newgen.myapp.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.newgen.myapp.dao.AddressDao;

public class JdbcAddressDaoImpl implements AddressDao{
	private static final Logger logger = LoggerFactory
			.getLogger(JdbcAddressDaoImpl.class);
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired(required=true)
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
	
	public List<String> getCityList(String stateName) {
		logger.debug("inside method: getCityList()");
		List<String> cityList = new ArrayList<String>();
		String sqlStr = "select city_name from tblcitylist where state= ?";
		this.getJdbcTemplate().query(sqlStr, new Object[]{stateName}, new ResultSetExtractor<String>(){

			@Override
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				while(rs.next()){
					
				}
				return null;
			}
			
		});		
		
		
		
		
		logger.debug("Completed method: getCityList()");
		return cityList;
		
	}

	@Override
	public Set<String> getStateList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCity(int cityId) {
		// TODO Auto-generated method stub
		return null;
	}
}
