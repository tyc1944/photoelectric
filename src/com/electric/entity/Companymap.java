package com.electric.entity;

public class Companymap {
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
	public Companymap(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public Companymap() {
		super();
	}
	@Override
	public String toString() {
		return "companymap [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
}
