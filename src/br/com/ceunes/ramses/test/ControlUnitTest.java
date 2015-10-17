package br.com.ceunes.ramses.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

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
	public void orOperationTest() {
		unit.circuit.chargeRdm((byte) 102);
		unit.circuit.chargeRx((byte) 101);
		String data = new String("000010110000000000000");
		unit.decode(data);
		assertEquals("ALU must have 101 value", (byte) 101,
				unit.circuit.getAluValue());
	}

	@Test
	public void RdmChargedFromRegisterTest() {
		unit.circuit.chargePc((byte) 160);
		String data = new String("000110000000000000001");
		unit.decode(data);
		assertEquals("s1 and s2 must be 1", (byte) 1, unit.circuit.getS1Value());
		assertEquals("s1 and s2 must be 1", (byte) 1, unit.circuit.getS2Value());
		assertEquals("Rdm charged with 160 from the PC", (byte) 160,
				unit.circuit.getRdmValue());
		;
	}

	@Test
	public void RiChargeTest() {
		unit.circuit.chargeRdm((byte) 89);
		String data = new String("000000000000000010000");
		unit.decode(data);
		assertEquals("The RI should have been charged with 89", (byte) 89,
				unit.circuit.getRiValue());
	}

	@Test
	public void writingToMemoryTest() {
		/*
		 * The idea is to put the value '100' on the '128' memory position,
		 * indexed by the value inside the REM.
		 */
		unit.circuit.chargeRem((byte) 128);
		unit.circuit.chargeRdm((byte) 100);
		String data = new String("000000000000000000010");
		unit.decode(data);
		byte aux = unit.circuit.getMemory().get(128);
		assertEquals("Memory position 128 should contain 100", (byte) 100, aux);
	}

	@Test
	public void RemChargeFromTheProgramCounterTest() {
		unit.circuit.chargePc((byte) 10);
		String data = new String("000110000000000001000");
		unit.decode(data);
		assertEquals("s1 should be 1", (byte) 1, unit.circuit.getS1Value());
		assertEquals("s2 should be 1", (byte) 1, unit.circuit.getS2Value());
		assertEquals("alu value must be 10", (byte) 10,
				unit.circuit.getAluValue());
		assertEquals("REM should have the value 10", (byte) 10,
				unit.circuit.getRemValue());
	}

	@Test
	public void RemChargedFromRdmTest() {
		unit.circuit.chargeRdm((byte) 180);
		unit.circuit.chargeRem((byte) 0);
		String data = new String("000000000000000101000");
		unit.decode(data);
		assertEquals("Rem charged with 180", (byte) 180,
				unit.circuit.getRemValue());
	}

	@Test
	public void incrementingProgramCounterTest() {
		unit.circuit.chargePc((byte) 90);
		String data = new String("000000000000100000000");
		unit.decode(data);
		assertEquals("pc should be 91", (byte) 91, unit.circuit.getPcValue());
	}

	@Test
	public void readingFromMemoryTest() {
		// First of all, we define a memory and set it's content.
		List<Byte> memory = new ArrayList<Byte>();
		memory.add((byte) 10);
		memory.add((byte) 33);
		unit.circuit.setMemory(memory);
		/*
		 * Now we're going to charge the REM so it points somewhere inside the
		 * memory. Position zero, in this case.
		 */
		unit.circuit.chargeRem((byte) 0);
		String data = new String("000000000000000000100");
		unit.decode(data);
		assertEquals("Rdm should have been charged with 10", (byte) 10,
				unit.circuit.getRdmValue());
		/*
		 * We're going to do it again, changing the REM so it points to the
		 * second value inside the memory, which is a 33.
		 */
		unit.circuit.chargeRem((byte) 1);
		unit.decode(data);
		assertEquals("Now RDM should have been charged with 33", (byte) 33,
				unit.circuit.getRdmValue());

	}
}
