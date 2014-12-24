package com.jfinal.aceadmin.vo;

import java.util.List;

import com.jfinal.plugin.activerecord.Record;

public class JqGridResponseVo {

	private int totalpages;
	private int currpage;
	private int totalrecords;
	private List<Record> data;
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	public int getTotalrecords() {
		return totalrecords;
	}
	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}
	public List<Record> getData() {
		return data;
	}
	public void setData(List<Record> data) {
		this.data = data;
	}
	
	
	
	
}
