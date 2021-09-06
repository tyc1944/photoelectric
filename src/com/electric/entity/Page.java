package com.electric.entity;

public class Page {
	private int pageNo;//当前页码
	private int pageCount;//总页数
	private int rowCount;//总记录数
	private int pageSize;//每页记录数
	
	/**
	 * 注意一下当前页码范围的处理
	 * @return
	 */
	public int getPageNo() {
		if(pageNo>getPageCount()) {
			pageNo=pageCount;
		}
		if(pageNo<1)
			pageNo=1;
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 * 计算出总页数
	 * @return
	 */
	public int getPageCount() {
		pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0) {
			pageCount++;
		}
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Page(int pageNo, int pageCount, int rowCount, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageCount = pageCount;
		this.rowCount = rowCount;
		this.pageSize = pageSize;
	}
	public Page() {
		super();
		this.pageNo=1;
		this.pageSize=5;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageCount=" + pageCount + ", rowCount=" + rowCount + ", pageSize="
				+ pageSize + "]";
	}
	
	
	
}
