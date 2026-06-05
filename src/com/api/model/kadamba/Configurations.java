package com.api.model.kadamba;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Configurations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Configurations {
	
	@XmlElement(name="broadcaster")
	private String broadcaster;
	
	@XmlElement(name="apiMatchName")
	private String apiMatchName;
	
	@XmlElement(name="source")
	private String source;
	
	@XmlElement(name="destination")
	private String destination;
	
	@XmlElement(name="updateTime")
	private String updateTime;
	
	@XmlElement(name="ipAddress")
	private String ipAddress;
	
	@XmlElement(name="portNumber")
	private int portNumber;
	
	@XmlElement(name="update_time")
	private String update_time;
	
	@XmlElement(name="fixture_id")
	private String fixture_id;
	
	public Configurations() {
		super();
	}

	

	public Configurations(String broadcaster, String apiMatchName, String source, String destination,String updateTime, String ipAddress,
			int portNumber) {
		super();
		this.broadcaster = broadcaster;
		this.apiMatchName = apiMatchName;
		this.source = source;
		this.destination = destination;
		this.updateTime = updateTime;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
	}
	
	public Configurations(String broadcaster, String apiMatchName, String source, String destination,String updateTime) {
		super();
		this.broadcaster = broadcaster;
		this.apiMatchName = apiMatchName;
		this.source = source;
		this.destination = destination;
		this.updateTime = updateTime;
	}

	public Configurations(String broadcaster, String apiMatchName, String source, String destination,String updateTime, String fixture_id) {
		super();
		this.broadcaster = broadcaster;
		this.apiMatchName = apiMatchName;
		this.source = source;
		this.destination = destination;
		this.updateTime = updateTime;
		this.fixture_id = fixture_id;
	}

	public String getBroadcaster() {
		return broadcaster;
	}

	public void setBroadcaster(String broadcaster) {
		this.broadcaster = broadcaster;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getApiMatchName() {
		return apiMatchName;
	}

	public void setApiMatchName(String apiMatchName) {
		this.apiMatchName = apiMatchName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getFixture_id() {
		return fixture_id;
	}
	public void setFixture_id(String fixture_id) {
		this.fixture_id = fixture_id;
	}

}
