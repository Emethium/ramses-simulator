package br.com.ceunes.ramses.model;

public class Multiplexer {

	private byte select0;
	private byte select1;

	public Multiplexer() {
		this.select0 = 0;
		this.select1 = 0;
	}

	public byte multiplex(byte first, byte second) {
		if (select0 == 0) {
			return first;
		} else {
			return second;
		}
	}

	public byte multiplex(byte first, byte second, byte third, byte fourth) {
		if (select0 == 0 && select1 == 0) {
			return first;
		} else if (select0 == 1 && select1 == 0) {
			return second;
		} else if (select0 == 0 && select1 == 1) {
			return third;
		} else {
			return fourth;
		}
	}

	/* Getters and Setters */

	public byte isSelect0() {
		return select0;
	}

	public void setSelect0(byte select0) {
		this.select0 = select0;
	}

	public byte isSelect1() {
		return select1;
	}

	public void setSelect1(byte select1) {
		this.select1 = select1;
	}

}
