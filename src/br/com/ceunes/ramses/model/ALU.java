package br.com.ceunes.ramses.model;

public class ALU {

	private byte negativeFlag;
	private byte zeroFlag;
	private byte carryFlag;
	
	public ALU() {
		this.negativeFlag = 0;
		this.zeroFlag = 0;
		this.carryFlag = 0;
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
		return x == 0 ? (byte)1 : 0;
	}
	
	public byte getY(byte y) {
		return y;
	}
	
	public byte shiftRight(byte x) {
		return (byte)(x >> 1);
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
	
}
