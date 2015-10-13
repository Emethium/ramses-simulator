package br.com.ceunes.ramses.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.ceunes.ramses.architecture.ControlUnit;

public class ControlUnitTest {

	public ControlUnit unit = new ControlUnit();

	@Test
	public void nextControlUnitOneTimeTest() {
		String data = new String("computer");
		data = unit.nextControlUnit(data, 1);
		assertEquals("The strings are equal", "omputer", data);
	}

	@Test
	public void nextControlUnitThreeTest() {
		String data = new String("computer");
		data = unit.nextControlUnit(data, 3);
		assertEquals("The strings are equal", "puter", data);
	}

	@Test
	public void charToByteMethodTest() {
		byte b = unit.charToByte('9');
		assertEquals("The bytes should be equal", (byte) 9, b);
	}

	@Test
	public void charToByteMethodAgainTest() {
		byte b = unit.charToByte('0');
		assertEquals("The bytes should be equal", (byte) 0, b);
	}

	/*
	 * Ok, the serious testing part starts here. The idea is to send the strings
	 * containing the enabling or not of the control operations. We need to see
	 * if all of the variable states are as we need following the Ramses
	 * architecture.
	 */

	/*
	 * carga_RA, carga_RB, carga_RX, s1, s2, sel_ALU (3 bits), carga_N, carga_Z,
	 * carga_C, s5, incrementa_PC, carga_PC, s3, s4, carga_RI, carga_REM, read,
	 * write, carga_RDM
	 */

	@Test
	public void RemChargeFromTheProgramCounter() {
		unit.circuit.chargePc((byte) 10);
		String data = new String("000110000000000001000");
		unit.decode(data);
		assertEquals("s1 should be 1", (byte) 1, unit.circuit.getS1Value());
		assertEquals("s2 should be 1", (byte) 1, unit.circuit.getS2Value());
		assertEquals("alu value must be 10", (byte)10, unit.circuit.getAluValue());
		assertEquals("REM should have the value 10", (byte) 10,
				unit.circuit.getRemValue());
	}
	
	@Test
	public void readingFromMemoryTest() {
		
	}
}
