package br.com.ceunes.ramses.model;

public class Decoder {
	private byte[] bits;
	private byte[] output;

	public Decoder() {
		for (@SuppressWarnings("unused")
		byte b : output) {
			b = 0;
		}
	}

	public byte decode() {
		if (bits[0] == 0 && bits[1] == 0 && bits[2] == 0 && bits[3] == 0) {
			output[0] = 1;
			return output[0];
		} else if (bits[0] == 1 && bits[1] == 0 && bits[2] == 0 && bits[3] == 0) {
			output[1] = 1;
			return output[1];
		} else if (bits[0] == 0 && bits[1] == 1 && bits[2] == 0 && bits[3] == 0) {
			output[2] = 1;
			return output[2];
		} else if (bits[0] == 1 && bits[1] == 1 && bits[2] == 0 && bits[3] == 0) {
			output[3] = 1;
			return output[3];
		} else if (bits[0] == 0 && bits[1] == 0 && bits[2] == 1 && bits[3] == 0) {
			output[4] = 1;
			return output[4];
		} else if (bits[0] == 1 && bits[1] == 0 && bits[2] == 1 && bits[3] == 0) {
			output[5] = 1;
			return output[5];
		} else if (bits[0] == 0 && bits[1] == 1 && bits[2] == 1 && bits[3] == 0) {
			output[6] = 1;
			return output[6];
		} else if (bits[0] == 0 && bits[1] == 1 && bits[2] == 1 && bits[3] == 1) {
			output[7] = 1;
			return output[7];
		} else if (bits[0] == 0 && bits[1] == 0 && bits[2] == 0 && bits[3] == 1) {
			output[8] = 1;
			return output[8];
		} else if (bits[0] == 1 && bits[1] == 0 && bits[2] == 0 && bits[3] == 1) {
			output[9] = 1;
			return output[9];
		} else if (bits[0] == 0 && bits[1] == 1 && bits[2] == 0 && bits[3] == 1) {
			output[10] = 1;
			return output[10];
		} else if (bits[0] == 1 && bits[1] == 1 && bits[2] == 0 && bits[3] == 1) {
			output[11] = 1;
			return output[11];
		} else if (bits[0] == 0 && bits[1] == 0 && bits[2] == 1 && bits[3] == 1) {
			output[12] = 1;
			return output[12];
		} else if (bits[0] == 1 && bits[1] == 0 && bits[2] == 1 && bits[3] == 1) {
			output[13] = 1;
			return output[13];
		} else if (bits[0] == 0 && bits[1] == 1 && bits[2] == 1 && bits[3] == 1) {
			output[14] = 1;
			return output[14];
		} else {
			output[15] = 1;
			return output[15];
		}
	}

	public byte[] getBits() {
		return bits;
	}

	public void setBits(byte[] bits) {
		this.bits = bits;
	}

	public byte[] getOutput() {
		return output;
	}

	public void setOutput(byte[] output) {
		this.output = output;
	}

	
}
