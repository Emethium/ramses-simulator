package com.ceunes.ramses.model;

public class Decoder {
	private boolean[] bits;
	private boolean[] output;
	
	public Decoder() {
		for(@SuppressWarnings("unused") boolean b: output) {
			b = false;
		}
	}
	
	public boolean decode() {
		if (!bits[0] && !bits[1] && !bits[2] && !bits[3]) {
			output[0] = true;
			return output[0];
		} else if (bits[0] && !bits[1] && !bits[2] && !bits[3]) {
			output[1] = true;
			return output[1];
		} else if (!bits[0] && bits[1] && !bits[2] && !bits[3]) {
			output[2] = true;
			return output[2];
		} else if (bits[0] && bits[1] && !bits[2] && !bits[3]) {
			output[3] = true;
			return output[3];
		} else if (!bits[0] && !bits[1] && bits[2] && !bits[3]) {
			output[4] = true;
			return output[4];
		} else if (bits[0] && !bits[1] && bits[2] && !bits[3]) {
			output[5] = true;
			return output[5];
		} else if (!bits[0] && bits[1] && bits[2] && !bits[3]) {
			output[6] = true;
			return output[6];
		} else if (!bits[0] && bits[1] && bits[2] && bits[3]) {
			output[7] = true;
			return output[7];
		} else if (!bits[0] && !bits[1] && !bits[2] && bits[3]) {
			output[8] = true;
			return output[8];
		} else if (bits[0] && !bits[1] && !bits[2] && bits[3]) {
			output[9] = true;
			return output[9];
		} else if (!bits[0] && bits[1] && !bits[2] && bits[3]) {
			output[10] = true;
			return output[10];
		} else if (bits[0] && bits[1] && !bits[2] && bits[3]) {
			output[11] = true;
			return output[11];
		} else if (!bits[0] && !bits[1] && bits[2] && bits[3]) {
			output[12] = true;
			return output[12];
		} else if (bits[0] && !bits[1] && bits[2] && bits[3]) {
			output[13] = true;
			return output[13];
		} else if (!bits[0] && bits[1] && bits[2] && bits[3]) {
			output[14] = true;
			return output[14];
		} else {
			output[15] = true;
			return output[15];
		}
	}
	
	public void set(byte value) {
		if(value << 1 == 0) {
			bits[0] = false;
		} else {
			bits[0] = true;
		}
	
		if(value << 1 == 0) {
			bits[1] = false;
		} else {
			bits[1] = true;
		}
		
		if(value << 1 == 0) {
			bits[2] = false;
		} else {
			bits[2] = true;
		}
		
		if(value << 1 == 0) {
			bits[3] = false;
		} else {
			bits[3] = true;
		}
		
	}
}
