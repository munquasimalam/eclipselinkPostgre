package com.mm.muka;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Collage {
	
	@Id
	private Integer cid;
	private String cname;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Collage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collage(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Collage [cid=" + cid + ", cname=" + cname + "]";
	}
	

}
