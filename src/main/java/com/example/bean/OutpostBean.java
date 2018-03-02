package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OutpostBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cmds;
	private String showCmds;
	@Column(unique = true)
	private int theOrder;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCmds() {
		return cmds;
	}
	public void setCmds(String cmds) {
		this.cmds = cmds;
	}
	public int getTheOrder() {
		return theOrder;
	}
	public void setTheOrder(int theOrder) {
		this.theOrder = theOrder;
	}
	public String getShowCmds() {
		return showCmds;
	}
	public void setShowCmds(String showCmds) {
		this.showCmds = showCmds;
	}
	
	
}
