package br.com.ceunes.ramses.architecture;

import br.com.ceunes.ramses.architecture.Circuit;

public class ControlUnit {
	private Circuit circuit;

	public void decode(String data) {
		char aux;
		
		// Check if a RA charge operation was expected
		if (data.charAt(0) == '1') {
			circuit.chargeRa(circuit.alu.getValue());
		}
		data = nextControlUnit(data, 1);

		// Check if a RB charge operation was expected
		if (data.charAt(0) == '1') {
			circuit.chargeRb(circuit.alu.getValue());
		}
		data = nextControlUnit(data, 1);
		
		// Check if a RX charge operation was expected
		if (data.charAt(0) == '1') {
			circuit.chargeRx(circuit.alu.getValue());
		}
		data = nextControlUnit(data, 1);
		
		// Set the s1 and s2 attributes
		aux = data.charAt(0);
		data = nextControlUnit(data, 1);
		circuit.setMuxToAlu(charToByte(aux), charToByte(data.charAt(0)));
		data = nextControlUnit(data, 1);
		
		
		
	}

	public String nextControlUnit(String data, int units) {
		return data.substring(units);
	}
	
	public byte charToByte(char c) {
		String s = String.valueOf(c);
		return (byte)Integer.parseInt(s);
	}
}
