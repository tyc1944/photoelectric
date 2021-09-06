package com.electric.entity;

/**
 * 产品类型
 * @author hgf
 * 2020年9月16日
 */
public class ProductType {
	private int typeId;
	private String typeName;
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public ProductType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	
	public ProductType(String typeName) {
		super();
		this.typeName = typeName;
	}
	public ProductType() {
		super();
	}
	
	
}
