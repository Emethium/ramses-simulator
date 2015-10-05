package com.ceunes.ramses.model;

public class ALU {

	
	// TODO criar o tipo BIT
	
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
	
	public byte getY(byte y) {
		return y;
	}
	
	public byte shiftRight(byte x) {
		return (byte)(x >> 1);
	}
	
	// TODO fazer operação NOT
}
