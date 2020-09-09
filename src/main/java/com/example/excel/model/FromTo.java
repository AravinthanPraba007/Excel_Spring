package com.example.excel.model;

public class FromTo {

	Long from;
	Long to;
	
	public Long getFrom() {
		return from;
	}
	public void setFrom(Long from) {
		this.from = from;
	}
	
	public Long getTo() {
		return to;
	}
	public void setTo(Long to) {
		this.to = to;
	}
	
	public FromTo(Long from, Long to) {
		super();
		this.from = from;
		this.to = to;
	}
	
	public FromTo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "FromTo [from=" + from + ", to=" + to + "]";
	}
	
	
	
	
}
