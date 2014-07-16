package com.zhuani21.pbase.domain;

/**
 * @author wgn
 *
 */
public class Product {
	private long id;
	private String name;
	private long prdTypeId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrdTypeId() {
		return prdTypeId;
	}
	public void setPrdTypeId(long prdTypeId) {
		this.prdTypeId = prdTypeId;
	}
	
}
