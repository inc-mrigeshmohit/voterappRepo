/**
 * 
 */
package com.newgen.myapp.pojo;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Admin
 * 
 */
public class Voter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1518942564814440987L;

	private int id;
	private String voterId = null;
	private String voterFirstName = null;
	private String voterMiddleName = null;
	private String voterLastName = null;
	private String voterGender = null;
	private String voterStatus = null;
	private Date voterDob = null;
	private String voterFathersName = null;
	private String voterEmailId = null;
	private String voterPhoneNo = null;

	private Address voterAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getVoterFirstName() {
		return voterFirstName;
	}

	public void setVoterFirstName(String voterFirstName) {
		this.voterFirstName = voterFirstName;
	}

	public String getVoterMiddleName() {
		return voterMiddleName;
	}

	public void setVoterMiddleName(String voterMiddleName) {
		this.voterMiddleName = voterMiddleName;
	}

	public String getVoterLastName() {
		return voterLastName;
	}

	public void setVoterLastName(String voterLastName) {
		this.voterLastName = voterLastName;
	}

	public String getVoterGender() {
		return voterGender;
	}

	public void setVoterGender(String voterGender) {
		this.voterGender = voterGender;
	}

	public String getVoterStatus() {
		return voterStatus;
	}

	public void setVoterStatus(String voterStatus) {
		this.voterStatus = voterStatus;
	}

	public Date getVoterDob() {
		return voterDob;
	}

	public void setVoterDob(Date voterDob) {
		this.voterDob = voterDob;
	}

	public String getVoterFathersName() {
		return voterFathersName;
	}

	public void setVoterFathersName(String voterFathersName) {
		this.voterFathersName = voterFathersName;
	}

	public String getVoterEmailId() {
		return voterEmailId;
	}

	public void setVoterEmailId(String voterEmailId) {
		this.voterEmailId = voterEmailId;
	}

	public String getVoterPhoneNo() {
		return voterPhoneNo;
	}

	public void setVoterPhoneNo(String voterPhoneNo) {
		this.voterPhoneNo = voterPhoneNo;
	}

	public Address getVoterAddress() {
		return voterAddress;
	}

	public void setVoterAddress(Address voterAddress) {
		this.voterAddress = voterAddress;
	}

	@Override
	public String toString() {
		return "\nVoter [id=" + id + ", voterId=" + voterId
				+ ", voterFirstName=" + voterFirstName + ", voterMiddleName="
				+ voterMiddleName + ", voterLastName=" + voterLastName
				+ ", voterGender=" + voterGender + ", voterStatus="
				+ voterStatus + ", voterDob=" + voterDob
				+ ", voterFathersName=" + voterFathersName + ", voterEmailId="
				+ voterEmailId + ", voterPhoneNo=" + voterPhoneNo
				+ ", voterAddress=" + voterAddress + "]";
	}

}
