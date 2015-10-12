package br.com.ceunes.ramses.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.ceunes.ramses.model.Multiplexer;

public class MultiplexerTest {

	public Multiplexer mux = new Multiplexer();

	@Test
	public void testTwoToOneMultiplex() {
		mux.setSelect0((byte) 0);
		assertEquals("Should be the first number", 10,
				mux.multiplex((byte) 10, (byte) 20));
	}

	@Test
	public void testTwoToOneMultiplexAgain() {
		mux.setSelect0((byte) 1);
		assertEquals("Should be the second number", 20,
				mux.multiplex((byte) 10, (byte) 20));
	}

	@Test
	public void testThreeToOneMultiplex() {
		mux.setSelect0((byte) 0);
		mux.setSelect1((byte) 1);
		assertEquals("Should be the third number", 30,
				mux.multiplex((byte) 10, (byte) 20, (byte) 30));
	}

	@Test
	public void testThreeToOneMultiplexAgain() {
		mux.setSelect0((byte) 1);
		mux.setSelect1((byte) 0);
		assertEquals("Should be the second number", 20,
				mux.multiplex((byte) 10, (byte) 20, (byte) 30));
	}

	@Test
	public void testThreeToOneMultiplexElseTestCase() {
		mux.setSelect0((byte) 1);
		mux.setSelect1((byte) 1);
		assertEquals("Should be the third number", 30,
				mux.multiplex((byte) 10, (byte) 20, (byte) 30));
	}

	@Test
	public void testFourToOneMultiplex() {
		mux.setSelect0((byte) 1);
		mux.setSelect1((byte) 1);
		assertEquals("Should be the fourth number", 40,
				mux.multiplex((byte) 10, (byte) 20, (byte) 30, (byte) 40));
	}
}
