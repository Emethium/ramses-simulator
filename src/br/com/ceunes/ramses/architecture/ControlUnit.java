package br.com.ceunes.ramses.architecture;

import br.com.ceunes.ramses.architecture.Circuit;

public class ControlUnit {
	public Circuit circuit = new Circuit();

	public void decode(String data) {
		String operation;
		char aux, aux2;

		// Check if a RA charge operation was expected, then execute
		if (data.charAt(0) == '1') {
			circuit.chargeRa(circuit.alu.getValue());
		}
		data = nextControlUnit(data, 1);

		// Check if a RB charge operation was expected, then execute
		if (data.charAt(0) == '1') {
			circuit.chargeRb(circuit.alu.getValue());
		}
		data = nextControlUnit(data, 1);

		// Check if a RX charge operation was expected, then execute
		if (data.charAt(0) == '1') {
			circuit.chargeRx(circuit.alu.getValue());
		}
		data = nextControlUnit(data, 1);

		// Set the s1 and s2 attributes
		aux = data.charAt(0);
		data = nextControlUnit(data, 1);
		circuit.setMuxToAlu(charToByte(aux), charToByte(data.charAt(0)));
		data = nextControlUnit(data, 1);

		// Calls the desired operation at the ALU
		operation = data.substring(0, 3);
		data = nextControlUnit(data, 3);
		circuit.alu.operate(operation,
				circuit.muxToAlu.multiplex(circuit.registerA.getValue(),
						circuit.registerB.getValue(),
						circuit.registerX.getValue(),
						circuit.programCounter.getValue()), circuit.rdm
						.getValue());

		// Charge the N, Z and C flags
		aux = data.charAt(0);
		data = nextControlUnit(data, 1);
		aux2 = data.charAt(0);
		data = nextControlUnit(data, 1);
		circuit.chargeFlags(charToByte(aux), charToByte(aux2),
				charToByte(data.charAt(0)));
		data = nextControlUnit(data, 1);

		// Set the s5 attribute
		aux = data.charAt(0);
		circuit.setMuxToPc(charToByte(aux));
		data = nextControlUnit(data, 1);

		// Increment PC check, then execute
		if (data.charAt(0) == '1') {
			System.out.println("INCREMEEEEEEEEENT");
			circuit.incrementPC();
		}
		data = nextControlUnit(data, 1);

		// Charge PC register
		if (data.charAt(0) == '1') {
			circuit.chargePc(circuit.muxToPC.multiplex(circuit.alu.getValue(),
					circuit.rem.getValue()));
		}
		data = nextControlUnit(data, 1);

		// Set the s3 and s4 attributes
		aux = data.charAt(0);
		data = nextControlUnit(data, 1);
		circuit.setMuxToRem(charToByte(aux), charToByte(data.charAt(0)));
		data = nextControlUnit(data, 1);

		// Charge RI register
		if (data.charAt(0) == '1') {
			circuit.chargeIRegister(circuit.rdm.getValue());
		}
		data = nextControlUnit(data, 1);

		// Charge REM register
		if (data.charAt(0) == '1') {
			circuit.chargeRem(circuit.muxToRem.multiplex(
					circuit.alu.getValue(), circuit.muxToAlu.multiplex(
							circuit.registerA.getValue(),
							circuit.registerB.getValue(),
							circuit.registerX.getValue(),
							circuit.programCounter.getValue()), circuit.rdm
							.getValue()));
		}
		data = nextControlUnit(data, 1);

		// Read operation
		if (data.charAt(0) == '1') {
			circuit.read();
		}
		data = nextControlUnit(data, 1);

		// Write operation
		if (data.charAt(0) == '1') {
			circuit.write();
		}
		data = nextControlUnit(data, 1);

		// Charge RDM
		if (data.charAt(0) == '1') {
			circuit.chargeRdm(circuit.muxToAlu.multiplex(
					circuit.registerA.getValue(), circuit.registerB.getValue(),
					circuit.registerX.getValue(),
					circuit.programCounter.getValue()));
		}

	}

	public String nextControlUnit(String data, int units) {
		return data.substring(units);
	}

	public byte charToByte(char c) {
		String s = String.valueOf(c);
		return (byte) Integer.parseInt(s);
	}
}
