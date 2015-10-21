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
		this.value = 0;
	}

	public void operate(String data, byte x, byte y) {
		if (data.equals("000")) {
			add(x, y);
		} else if (data.equals("001")) {
			sub(x, y);
		} else if (data.equals("010")) {
			and(x, y);
		} else if (data.equals("011")) {
			or(x, y);
		} else if (data.equals("100")) {
			not(x);
		} else if (data.equals("101")) {
			negate(x);
		} else if (data.equals("110")) {
			shiftRight(x);
		} else {
			getY(y);
		}
	}

	/* ALU basic operations */
	public void add(byte x, byte y) {
		value = (byte) (x + y);
		checkStatus();
	}

	public void sub(byte x, byte y) {
		value = (byte) (x - y);
		checkStatus();
	}

	public void and(byte x, byte y) {
		value = (byte) (x & y);
		checkStatus();
	}

	public void or(byte x, byte y) {
		if (x != 0) {
			value = x;
		} else {
			value = y;
		}
		checkStatus();
	}

	public void negate(byte x) {
		value = (byte) (-x);
		checkStatus();
	}

	public void not(byte x) {
		value = (byte) (~((int) x));
		checkStatus();
	}

	public void getY(byte y) {
		this.value = y;
		checkStatus();
	}

	public void shiftRight(byte x) {
		value = (byte) (x >> 1);
		checkStatus();
	}

	public void checkStatus() {
		if (this.value == 0) {
			zeroFlag = 1;
		} else {
			zeroFlag = 0;
		}
		if (this.value < 0) {
			negativeFlag = 1;
		} else {
			negativeFlag = 1;
		}
		if (this.value > (byte) 255 || this.value < (byte) -128) {
			carryFlag = 1;
		} else {
			carryFlag = 0;
		}
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
