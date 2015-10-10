package br.com.ceunes.ramses.model;

public class ALU {

	private byte negativeFlag;
	private byte zeroFlag;
	private byte carryFlag;
	private byte value;
	
	public ALU() {
		this.negativeFlag = 0;
		this.zeroFlag = 0;
		this.carryFlag = 0;
	}
	
	/* ALU basic operations */
	public void add(byte x, byte y, byte carry) {
		value = (byte)(x+y+carry);
	}
	
	public void sub(byte x, byte y) {
		value = (byte)(x-y);
	}
	
	public void and(byte x, byte y) {
		value = (byte)(x&y);
	}
	
	public void or(byte x, byte y) {
		value = (byte)(x|y);
	}
	
	public void negate(byte x) {
		value = (byte)(-x);
	}
	
	public void not(byte x) {
		value = x == 0 ? (byte)1 : 0;
	}
	
	public void getY(byte y) {
		value = y;
	}
	
	public void shiftRight(byte x) {
		value = (byte)(x >> 1);
	}

	
	/* Getters and Setters */
	public byte getNegativeFlag() {
		return negativeFlag;
	}

	public void setNegativeFlag(byte negativeFlag) {
		this.negativeFlag = negativeFlag;
	}

	public byte getZeroFlag() {
		return zeroFlag;
	}

	public void setZeroFlag(byte zeroFlag) {
		this.zeroFlag = zeroFlag;
	}

	public byte getCarryFlag() {
		return carryFlag;
	}

	public void setCarryFlag(byte carryFlag) {
		this.carryFlag = carryFlag;
	}

	public byte getValue() {
		return value;
	}

	public void setValue(byte value) {
		this.value = value;
	}
	
}
