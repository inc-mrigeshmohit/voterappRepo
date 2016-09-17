package com.newgen.myapp.services;

import java.util.List;

import com.newgen.myapp.pojo.Voter;

/**
 * @author Admin
 * 
 */
public interface VoterService {
	public Voter getVoterDetails(String voterId);

	public List<Voter> getVoterList();

	public String saveVoterDetails(Voter voter);

	public List<Voter> deleteVoter(String voterId);

	public Voter updateVoterDetails(Voter voter);
}
