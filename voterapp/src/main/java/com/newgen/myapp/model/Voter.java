package com.newgen.myapp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voter")
public class Voter implements Serializable {

	private static final long serialVersionUID = -1331319210046783901L;

	// @Column(name = "Id")
	// private int id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "voter_id")
	private String voterId = null;

	@Column(name = "voter_first_name")
	private String voterFirstName = null;

	@Column(name = "voter_middle_name")
	private String voterMiddleName = null;

	@Column(name = "voter_last_name")
	private String voterLastName = null;

	@Column(name = "voter_father_name")
	private String voterFathersName = null;

	@Column(name = "voter_gender")
	private String voterGender = null;

	@Column(name = "voter_status")
	private String voterStatus = null;

	@Column(name = "voter_dob")
	private Date voterDob = null;

	@Column(name = "voter_emailid")
	private String voterEmailId = null;

	@Column(name = "voter_phone_no")
	private String voterPhoneNo = null;

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

	public String getVoterFathersName() {
		return voterFathersName;
	}

	public void setVoterFathersName(String voterFathersName) {
		this.voterFathersName = voterFathersName;
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

}
