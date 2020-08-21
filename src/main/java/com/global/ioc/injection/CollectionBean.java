package com.global.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {

	/*  리스트 타입
	 * private List<String> addressList;
	 * 
	 * public List<String> getAddressList() { 
	 *           return addressList; 
	 * }
	 * 
	 * public void setAddressList(List<String> addressList) { 
	 * this.addressList = addressList;
	 * 
	 *  }
	 */
	
	/*
	  set 타입
	
	
	private Set<String> addressList;

	public Set<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<String> addressList) {
		this.addressList = addressList;
	}
*/
	/*
	Map 타입
	private Map<String, String> addressList;

	public Map<String, String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Map<String, String> addressList) {
		this.addressList = addressList;
	}
	*/
	
	private Properties addressList;

	public Properties getAddressList() {
		return addressList;
	}

	public void setAddressList(Properties addressList) {
		this.addressList = addressList;
	}
	
	
	
		
	
	
}
