package br.com.ceunes.ramses.architecture;

import java.util.List;

import br.com.ceunes.ramses.architecture.Circuit;
import br.com.ceunes.ramses.view.Interface;

public class ControlUnit {

	public Circuit circuit;
	public Interface interfac2;
	public char aux = 1;
	public List<Byte> memory;
	public int cycleCounter;
	public int memoryAcessCounter;

	public ControlUnit() {
		circuit = new Circuit();
		interfac2 = new Interface();
		cycleCounter = 0;
		memoryAcessCounter = 0;
	}

	public ControlUnit(Interface interfac2, Circuit circuit) {
		this.interfac2 = interfac2;
		this.circuit = circuit;
		cycleCounter = 0;
		memoryAcessCounter = 0;
	}

	public void decode(String data) {
		String operation;
		char aux;
		int position;
		// Check if a RA charge operation was expected, then execute
		if (data.charAt(0) == '1') {
			circuit.chargeRa(circuit.alu.getValue());
			interfac2.valorRA(circuit.alu.getValue());
		}
		interfac2.RecebeCargaRA(data.charAt(0));
		data = nextControlUnit(data, 1);

		// Check if a RB charge operation was expected, then execute
		if (data.charAt(0) == '1') {
			circuit.chargeRb(circuit.alu.getValue());
			interfac2.valorRB(circuit.alu.getValue());
		}
		interfac2.RecebeCargaRB(data.charAt(0));
		data = nextControlUnit(data, 1);

		// Check if a RX charge operation was expected, then execute
		if (data.charAt(0) == '1') {
			circuit.chargeRx(circuit.alu.getValue());
			interfac2.valorRX(circuit.alu.getValue());
		}
		interfac2.RecebeCargaRX(data.charAt(0));
		data = nextControlUnit(data, 1);

		// Set the s1 and s2 attributes
		aux = data.charAt(0);
		interfac2.RecebeCargaS1(data.charAt(0));
		data = nextControlUnit(data, 1);
		interfac2.RecebeCargaS2(data.charAt(0));
		circuit.setMuxToAlu(charToByte(aux), charToByte(data.charAt(0)));
		data = nextControlUnit(data, 1);

		// Calls the desired operation at the ALU
		operation = data.substring(0, 3);
		String values = operation;
		interfac2.RecebeCargaAluMSB(values.charAt(0));
		values = nextControlUnit(values, 1);
		interfac2.RecebeCargaAlu2MSB(values.charAt(0));
		values = nextControlUnit(values, 1);
		interfac2.RecebeCargaAluLSB(values.charAt(0));

		data = nextControlUnit(data, 3);
		circuit.alu.operate(operation,
				circuit.muxToAlu.multiplex(circuit.registerA.getValue(),
						circuit.registerB.getValue(),
						circuit.registerX.getValue(),
						circuit.programCounter.getValue()), circuit.rdm
						.getValue());

		// Charge the N, Z and C flags
		if (data.charAt(0) == '1') {
			interfac2.RecebeCargaNegativo(circuit.getFlagN());
		}
		data = nextControlUnit(data, 1);

		if (data.charAt(0) == '1') {
			interfac2.RecebeCargaZero(circuit.getFlagZ());
		}
		data = nextControlUnit(data, 1);

		if (data.charAt(0) == '1') {
			interfac2.RecebeCargaCarry(circuit.getFlagC());
		}
		data = nextControlUnit(data, 1);

		// Set the s5 attribute
		aux = data.charAt(0);
		interfac2.RecebeCargaS5(data.charAt(0));
		circuit.setMuxToPc(charToByte(aux));
		data = nextControlUnit(data, 1);

		// Increment PC check, then execute
		if (data.charAt(0) == '1') {
			byte value = circuit.incrementPC();
			interfac2.RecebeCargaPC(data.charAt(0), value);
			System.out.println("Incrementou PC! Valor:" + circuit.getPcValue());
		}

		data = nextControlUnit(data, 1);

		// Charge PC register
		if (data.charAt(0) == '1') {
			circuit.chargePc(circuit.muxToPC.multiplex(circuit.alu.getValue(),
					circuit.rem.getValue()));
			interfac2.valorPC(circuit.muxToPC.multiplex(circuit.alu.getValue(),
					circuit.rem.getValue()));

			System.out.println(circuit.muxToPC.multiplex(
					circuit.alu.getValue(), circuit.rem.getValue()));
		}

		data = nextControlUnit(data, 1);

		// Set the s3 and s4 attributes
		aux = data.charAt(0);
		interfac2.RecebeCargaS3(data.charAt(0));
		data = nextControlUnit(data, 1);
		interfac2.RecebeCargaS4(data.charAt(0));
		circuit.setMuxToRem(charToByte(aux), charToByte(data.charAt(0)));
		data = nextControlUnit(data, 1);

		// Charge RI register
		if (data.charAt(0) == '1') {
			circuit.chargeIRegister(circuit.rdm.getValue());
			System.out.println("Carga no RI! Valor:" + circuit.getRiValue());
		}
		interfac2.RecebeCargaRI(data.charAt(0)); // atualiza o bit de carga do
													// RI na interface
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

			// interfac2.valorREM((byte) 57);
			interfac2
					.valorREM(circuit.muxToRem.multiplex(
							circuit.alu.getValue(), circuit.muxToAlu.multiplex(
									circuit.registerA.getValue(),
									circuit.registerB.getValue(),
									circuit.registerX.getValue(),
									circuit.programCounter.getValue()),
							circuit.rdm.getValue()));
			System.out.println("Carga no REM! Valor:" + circuit.getRdmValue());
		}
		interfac2.RecebeCargaREM(data.charAt(0));
		data = nextControlUnit(data, 1);

		// Read operation
		if (data.charAt(0) == '1') {
			circuit.read();
			interfac2.valorRDM(circuit.getRdmValue());
			memoryAcessCounter++;
			System.out.println("Read feito! Valor do RDM:"
					+ circuit.getRdmValue());
		}
		interfac2.RecebeCargaRead(data.charAt(0));
		data = nextControlUnit(data, 1);

		// Write operation
		if (data.charAt(0) == '1') {
			circuit.write();
			position = circuit.getRemValue() >= 0 ? circuit.getRemValue()
					: circuit.getRemValue() & 0xff;
			interfac2.insertTable(circuit.getRdmValue(), position);
			memoryAcessCounter++;
			System.out.println("Write feito!");
		}
		interfac2.RecebeCargaWrite(data.charAt(0));
		data = nextControlUnit(data, 1);

		// Charge RDM
		if (data.charAt(0) == '1') {
			circuit.chargeRdm(circuit.muxToAlu.multiplex(
					circuit.registerA.getValue(), circuit.registerB.getValue(),
					circuit.registerX.getValue(),
					circuit.programCounter.getValue()));

			interfac2.valorRDM(circuit.muxToAlu.multiplex(
					// atualiza o valor de RDM na interface
					circuit.registerA.getValue(), circuit.registerB.getValue(),
					circuit.registerX.getValue(),
					circuit.programCounter.getValue()));
			System.out.println("Carga no RDM! Valor:" + circuit.getRdmValue());
		}
		interfac2.RecebeCargaRDM(data.charAt(0));
		cycleCounter++;
	}

	public void memoryDataValues() {
		memory = circuit.getMemory();

		int counter;
		for (counter = 0; counter < memory.size(); counter++) {
			interfac2.updateMemoryList(memory.get(counter), counter);
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
