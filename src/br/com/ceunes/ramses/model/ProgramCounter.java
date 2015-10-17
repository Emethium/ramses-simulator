package br.com.ceunes.ramses.model;

public class ProgramCounter {

	private byte value;

	public ProgramCounter() {
		this.value = (byte) 0;
	}
	
	public byte getValue() {
		return value;
	}

	public void setValue(byte value) {
		this.value = value;
	}

	public void increment() {
		value++;
	}
}
