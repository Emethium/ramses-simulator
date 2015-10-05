package com.ceunes.ramses.model;

public class Multiplexer {

	private boolean select0;
	private boolean select1;
	
	public Multiplexer() {
		this.select0 = false;
		this.select1 = false;
	}
	
	public byte multiplex(byte first, byte second) {
		if(!select0) {
			return first;
		} else {
			return second;
		}
	}

	public byte multiplex(byte first, byte second, byte third, byte fourth) {
		if(!select0 && !select1) {
			return first;
		} else if (select0 && !select1) {
			return second;
		} else if (!select0 && select1) {
			return third;
		} else {
			return fourth;
		}
	}
	
	
	/*Getters and Setters */
	
	public boolean isSelect0() {
		return select0;
	}
	public void setSelect0(boolean select0) {
		this.select0 = select0;
	}
	public boolean isSelect1() {
		return select1;
	}
	public void setSelect1(boolean select1) {
		this.select1 = select1;
	}
	
	
	
	
	
}
