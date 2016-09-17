/**
 * 
 */
package com.newgen.myapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.newgen.myapp.pojo.Voter;
import com.newgen.myapp.services.VoterService;
import com.newgen.myapp.dao.VoterDao;

/**
 * @author Admin
 * 
 */
public class VoterServiceImpl implements VoterService {

	@Autowired
	private VoterDao voterDao;

	@Override
	public Voter getVoterDetails(String voterId) {
		return voterDao.getVoterDetails(voterId);
	}

	@Override
	public List<Voter> getVoterList() {
		return voterDao.getVoterList();
	}

	@Override
	public String saveVoterDetails(Voter voter) {
		return voterDao.saveVoterDetails(voter);
	}

	@Override
	public List<Voter> deleteVoter(String voterId) {
		return voterDao.deleteVoter(voterId);
	}

	@Override
	public Voter updateVoterDetails(Voter voter) {
		return voterDao.updateVoterDetails(voter);
	}
}
