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
		byte oi =  circuit.getMemory().get(120);
		assertEquals("256 should be indexed", 200, oi);
	}

}
