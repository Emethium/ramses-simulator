package br.com.ceunes.ramses.model;

public class ProgramCounter extends Register {
	@SuppressWarnings("unused")
	private byte value;

	public ProgramCounter() {
		value = (byte)0;
	}
	public void increment() {
		value++;
	}
}
