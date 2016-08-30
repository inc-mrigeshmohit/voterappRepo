/**
 * 
 */
package com.newgen.myapp.pojo;


/**
 * @author Admin
 * 
 */
public class Address {
	private int addressId;
	private String houseNo = null;
	private String addres1 = null;
	private String addres2 = null;
	private String addres3 = null;
	private String city = null;
	private String state = null;
	private int pinCode;
	private String voterId = null;
	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getAddres1() {
		return addres1;
	}

	public void setAddres1(String addres1) {
		this.addres1 = addres1;
	}

	public String getAddres2() {
		return addres2;
	}

	public void setAddres2(String addres2) {
		this.addres2 = addres2;
	}

	public String getAddres3() {
		return addres3;
	}

	public void setAddres3(String addres3) {
		this.addres3 = addres3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	@Override
	public String toString() {
		return "\nAddress [addressId=" + addressId + ", houseNo=" + houseNo
				+ ", addres1=" + addres1 + ", addres2=" + addres2
				+ ", addres3=" + addres3 + ", city=" + city + ", state="
				+ state + ", pinCode=" + pinCode + ", voterId=" + voterId + "]";
	}

}
