package com.ceunes.ramses.model;

public class ALU {

	private boolean negativeFlag;
	private boolean zeroFlag;
	private boolean carryFlag;
	
	public ALU() {
		this.negativeFlag = false;
		this.zeroFlag = false;
		this.carryFlag = false;
	}
	
	/* ALU basic operations */
	public byte add(byte x, byte y, byte carry) {
		return (byte)(x+y+carry);
	}
	
	public byte sub(byte x, byte y) {
		return (byte)(x-y);
	}
	
	public byte and(byte x, byte y) {
		return (byte)(x&y);
	}
	
	public byte or(byte x, byte y) {
		return (byte)(x|y);
	}
	
	public byte negate(byte x) {
		return (byte)(-x);
	}
	
	public byte not(byte x) {
		return (byte)~x;
	}
	
	public byte getY(byte y) {
		return y;
	}
	
	public byte shiftRight(byte x) {
		return (byte)(x >> 1);
	}

	
	/* Getters and Setters */
	public boolean getNegativeFlag() {
		return negativeFlag;
	}

	public void setNegativeFlag(boolean negativeFlag) {
		this.negativeFlag = negativeFlag;
	}

	public boolean getZeroFlag() {
		return zeroFlag;
	}

	public void setZeroFlag(boolean zeroFlag) {
		this.zeroFlag = zeroFlag;
	}

	public boolean getCarryFlag() {
		return carryFlag;
	}

	public void setCarryFlag(boolean carryFlag) {
		this.carryFlag = carryFlag;
	}
	
}
