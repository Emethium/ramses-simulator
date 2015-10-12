package br.com.ceunes.ramses.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.ceunes.ramses.model.ALU;

public class AluTest {

	public ALU alu = new ALU();

	@Test
	public void addOperationTest() {
		alu.add((byte) 50, (byte) 49);
		assertEquals("Sum must be 99", 99, alu.getValue());
	}

	@Test
	public void subOperationTest() {
		alu.sub((byte) 100, (byte) 33);
		assertEquals("Subtraction must be 67", 67, alu.getValue());
	}

	@Test
	public void andOperationTestThatShouldBeTrue() {
		alu.and((byte) 101, (byte) 101);
		assertEquals("Should be itself", 101, alu.getValue());
	}

	@Test
	public void andOperationTestThatShouldBeFalse() {
		alu.and((byte) 9, (byte) 100);
		assertNotEquals("Should give a zero", 9, alu.getValue());
	}

	@Test
	public void orOperationTestThatShouldBeTrue() {
		alu.or((byte) 1, (byte) 0);
		assertEquals("Should be a 1", 1, alu.getValue());
	}

	@Test
	public void orOperationTestThatShouldAlsoBeTrue() {
		alu.or((byte) 1, (byte) 1);
		assertEquals("Should be a 1", 1, alu.getValue());
	}

	@Test
	public void orOperationTestThatShouldBeFalse() {
		alu.or((byte) 0, (byte) 0);
		assertEquals("Should be a 0", 0, alu.getValue());
	}

	@Test
	public void testNegation() {
		alu.negate((byte) 9);
		assertEquals("Should be a equal to -9", -9, alu.getValue());
	}

	@Test
	public void testNotOperatorWithJustABit() {
		alu.not((byte) 0);
		assertEquals("Should be a -1", -1, alu.getValue());
	}

	@Test
	public void testNotOperatorWithJustALongerUnit() {
		alu.not((byte) 4);
		assertNotEquals("Should be something weird", 3, alu.getValue());
	}

	@Test
	public void testRightShifting() {
		alu.shiftRight((byte) 4);
		assertEquals("Should be 2", 2, alu.getValue());
	}

	@Test
	public void testOperationForSum() {
		alu.operate("000", (byte) 20, (byte) 30);
		assertEquals("Sum must be activated. Value = 50", 50, alu.getValue());
	}

	@Test
	public void testOperationForNegate() {
		alu.operate("101", (byte) 20, (byte) 30);
		assertEquals("Negation must be activated. Value = -20", -20,
				alu.getValue());
	}
	
	@Test
	public void testOperationForGety() {
		alu.operate("111", (byte)1, (byte) 10);
		assertEquals("Gety must be activated. Value = 10", 10, alu.getValue());
	}

}
