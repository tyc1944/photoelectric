package com.electric.entity;

/**
 * 新闻类型实体类
 * @author Administrator
 *
 */
public class NewsType {
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
	public NewsType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	
	
	public NewsType(String typeName) {
		super();
		this.typeName = typeName;
	}
	public NewsType() {
		super();
	}
	@Override
	public String toString() {
		return "NewsType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
	

}
