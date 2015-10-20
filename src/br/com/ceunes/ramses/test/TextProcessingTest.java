package br.com.ceunes.ramses.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import br.com.ceunes.ramses.read.TextProcessing;

public class TextProcessingTest {

	public TextProcessing read = new TextProcessing();

	@Test
	public void readingStringTest() throws IOException {
		read.unit.circuit.chargePc((byte) 10);
		//read.read();
		assertEquals("s1 should be 1", (byte) 1, read.unit.circuit.getS1Value());
		assertEquals("s2 should be 1", (byte) 1, read.unit.circuit.getS2Value());
		assertEquals("alu value must be 11", (byte) 11, read.unit.circuit.getAluValue());
		assertEquals("REM should have the value 10", (byte) 10, read.unit.circuit.getRemValue());
		//assertEquals("PC should be 11", (byte)11, read.control_unit.circuit.getPcValue());
		assertEquals("RDM should be 0", (byte)0, read.unit.circuit.getRdmValue());
	}
}
