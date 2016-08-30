/**
 * 
 */
package com.newgen.myapp.dao;

import java.util.List;
import java.util.Set;

/**
 * @author Admin
 * 
 */
public interface AddressDao {

	public Set<String> getStateList();

	public List<String> getCityList(String stateName);

	public String getCity(int cityId);

}
