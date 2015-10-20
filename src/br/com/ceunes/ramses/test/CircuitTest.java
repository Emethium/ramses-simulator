package br.com.ceunes.ramses.test;

import static org.junit.Assert.*;


import org.junit.Test;

import br.com.ceunes.ramses.architecture.Circuit;

public class CircuitTest {

	public Circuit circuit = new Circuit();

	@Test
	public void testWriteOperation() {
		circuit.chargeRem((byte) 120);
		circuit.chargeRdm((byte) 200);
		circuit.write();
		byte oi = (byte) circuit.getMemory().get(120);
		assertEquals("256 should be indexed", (byte) 200, oi);
	}

	@Test
	public void testReadOperation() {
		/*
		 * Same as above, charge the memory 120 with the 200 value
		 */
		circuit.chargeRem((byte) 120);
		circuit.chargeRdm((byte) 200);
		circuit.write();
		/*
		 * Now we clear the Rdm register in order to see if the read operation
		 * truly works
		 */
		circuit.chargeRdm((byte) 0);
		circuit.read();
		byte oi = (byte) circuit.getMemory().get(120);
		assertEquals("We should have 200 in the RDM again", (byte) 200, oi);
	}
	
	@Test
	public void incrementTest() {
		circuit.chargePc((byte) 31);
		circuit.incrementPC();
		assertEquals("pc equals 32", (byte) 32, circuit.getPcValue());
	}
}
