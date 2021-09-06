package com.electric.entity;

import java.util.Date;

public class Contact {
	private int proId;
	private String gsmc;
	private String gsdz;
	private String youbian;
	private String kfdh;
	private String chuanzhen;
	private String shouji;
	private String lianxiren;
	private String msn;
	private String qq;
	private String swyx;
	private String kfyx;
	private String gswz;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getGsmc() {
		return gsmc;
	}
	public void setGsmc(String gsmc) {
		this.gsmc = gsmc;
	}
	public String getGsdz() {
		return gsdz;
	}
	public void setGsdz(String gsdz) {
		this.gsdz = gsdz;
	}
	public String getYoubian() {
		return youbian;
	}
	public void setYoubian(String youbian) {
		this.youbian = youbian;
	}
	public String getKfdh() {
		return kfdh;
	}
	public void setKfdh(String kfdh) {
		this.kfdh = kfdh;
	}
	public String getChuanzhen() {
		return chuanzhen;
	}
	public void setChuanzhen(String chuanzhen) {
		this.chuanzhen = chuanzhen;
	}
	public String getShouji() {
		return shouji;
	}
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	public String getLianxiren() {
		return lianxiren;
	}
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getSwyx() {
		return swyx;
	}
	public void setSwyx(String swyx) {
		this.swyx = swyx;
	}
	public String getKfyx() {
		return kfyx;
	}
	public void setKfyx(String kfyx) {
		this.kfyx = kfyx;
	}
	public String getGswz() {
		return gswz;
	}
	public void setGswz(String gswz) {
		this.gswz = gswz;
	}
	public Contact(int proId, String gsmc, String gsdz,String youbian, String kfdh,
			String chuanzhen, String shouji, String lianxiren, String msn, String qq, String swyx, String kfyx,
			String gswz) {
		super();
		this.proId = proId;
		this.gsmc = gsmc;
		this.gsdz = gsdz;
		this.youbian = youbian;
		this.kfdh = kfdh;
		this.chuanzhen = chuanzhen;
		this.shouji = shouji;
		this.lianxiren = lianxiren;
		this.msn = msn;
		this.qq = qq;
		this.swyx = swyx;
		this.kfyx = kfyx;
		this.gswz = gswz;
	}
	public Contact() {
		super();
	}
	@Override
	public String toString() {
		return "Contact [proId=" + proId + ", gsmc=" + gsmc + ", gsdz=" + gsdz + " youbian=" + youbian
				+ ", kfdh=" + kfdh + ", chuanzhen=" + chuanzhen + ", shouji=" + shouji + ", lianxiren=" + lianxiren
				+ ", msn=" + msn + ", qq=" + qq + ", swyx=" + swyx + ", kfyx=" + kfyx + ", gswz=" + gswz + "]";
	}
	
	
	
}
