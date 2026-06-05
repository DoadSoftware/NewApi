package com.api.model.kadamba;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Statistics")
public class Statistics
{
  @Id
  @Column(name="StatisticsId")
  private Integer statistics_id;
  
  @Column(name="PlayerID")
  private Integer player_id;
  
  @Column(name="Info1")
  private String info1;
  
  @Column(name="Info2")
  private String info2;
  
  @Column(name="Info3")
  private String info3;
  
  @Column(name="Info4")
  private String info4;

public Statistics() {
	super();
	// TODO Auto-generated constructor stub
}

public Integer getStatistics_id() {
	return statistics_id;
}

public void setStatistics_id(Integer statistics_id) {
	this.statistics_id = statistics_id;
}

public Integer getPlayer_id() {
	return player_id;
}

public void setPlayer_id(Integer player_id) {
	this.player_id = player_id;
}

public String getInfo1() {
	return info1;
}

public void setInfo1(String info1) {
	this.info1 = info1;
}

public String getInfo2() {
	return info2;
}

public void setInfo2(String info2) {
	this.info2 = info2;
}

public String getInfo3() {
	return info3;
}

public void setInfo3(String info3) {
	this.info3 = info3;
}

public String getInfo4() {
	return info4;
}

public void setInfo4(String info4) {
	this.info4 = info4;
}

}