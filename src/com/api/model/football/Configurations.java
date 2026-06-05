package com.api.model.football;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Configurations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Configurations {
	
	@XmlElement(name="broadcaster")
	private String broadcaster;
	
	@XmlElement(name="source")
	private String source;
	
	@XmlElement(name="destination")
	private String destination;
	
	@XmlElement(name="fixture_id")
	private String fixture_id;
	
	public Configurations() {
		super();
	}
	
	public Configurations(String broadcaster, String source, String destination) {
		super();
		this.broadcaster = broadcaster;
		this.source = source;
		this.destination = destination;
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

	public String getFixture_id() {
		return fixture_id;
	}

	public void setFixture_id(String fixture_id) {
		this.fixture_id = fixture_id;
	}
	
}
