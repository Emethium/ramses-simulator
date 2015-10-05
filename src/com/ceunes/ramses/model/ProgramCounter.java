package com.ceunes.ramses.model;

public class ProgramCounter extends Register {
	@SuppressWarnings("unused")
	private byte value;

	public void increment() {
		value++;
	}
}
