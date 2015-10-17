package br.com.ceunes.ramses.model;

public class ProgramCounter extends Register {

	private byte value;

	public ProgramCounter() {
		value = (byte) 0;
	}

	public void increment() {
		System.out.println(this.value);
		value++;
		System.out.println(this.value);
	}
}
