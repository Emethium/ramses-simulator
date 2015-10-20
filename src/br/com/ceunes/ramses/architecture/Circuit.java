package br.com.ceunes.ramses.architecture;

import java.util.ArrayList;
import java.util.List;

import br.com.ceunes.ramses.model.ALU;
import br.com.ceunes.ramses.model.Decoder;
import br.com.ceunes.ramses.model.Multiplexer;
import br.com.ceunes.ramses.model.ProgramCounter;
import br.com.ceunes.ramses.model.Register;

public class Circuit {

	protected ProgramCounter programCounter;
	protected Register rem;
	protected Register rdm;
	protected Register registerX;
	protected Register registerA;
	protected Register registerB;
	protected Register instructionRegister;
	protected ALU alu;
	protected Decoder decoder;
	protected Multiplexer muxToRem;
	protected Multiplexer muxToAlu;
	protected Multiplexer muxToPC;
	protected List<Byte> memory;

	public Circuit() {
		programCounter = new ProgramCounter();
		rem = new Register();
		rdm = new Register();
		registerX = new Register();
		registerA = new Register();
		registerB = new Register();
		instructionRegister = new Register();
		alu = new ALU();
		decoder = new Decoder();
		muxToRem = new Multiplexer();
		muxToAlu = new Multiplexer();
		muxToPC = new Multiplexer();
		memory = new ArrayList<Byte>();
		/*
		 * Creates a 256 byte memory, full of zeros, so we don't have access
		 * memory violations
		 */
		for (int i = 0; i < 256; i++) {
			memory.add((byte) 0);
		}
	}

	public void chargeRa(byte ra) {
		registerA.setValue(ra);
	}

	public void chargeRb(byte rb) {
		registerB.setValue(rb);
	}

	public void chargeRx(byte rx) {
		registerX.setValue(rx);
	}

	public void chargeFlags(byte n, byte z, byte c) {
		alu.setNegativeFlag(n);
		alu.setZeroFlag(z);
		alu.setCarryFlag(c);
	}

	public void chargeIRegister(byte data) {
		instructionRegister.setValue(rdm.getValue());
	}

	public void chargeRem(byte data) {
		rem.setValue(data);
	}

	public void chargeRdm(byte data) {
		rdm.setValue(data);
	}

	public void write() {
		memory.set(Math.abs((int) rem.getValue()), rdm.getValue());
	}

	public void read() {
		rdm.setValue((byte) memory.get(rem.getValue()));
	}

	public void setMuxToAlu(byte s1, byte s2) {
		muxToAlu.setSelect0(s1);
		muxToAlu.setSelect1(s2);
	}

	public void setMuxToPc(byte s5) {
		muxToPC.setSelect0(s5);
	}

	public void setMuxToRem(byte s3, byte s4) {
		muxToRem.setSelect0(s3);
		muxToRem.setSelect1(s4);
	}

	public byte incrementPC() {
		programCounter.increment();
		return programCounter.getValue();
	}

	public void chargePc(byte address) {
		programCounter.setValue(address);
	}

	public List<Byte> getMemory() {
		return memory;
	}

	public void setMemory(List<Byte> memory) {
		int counter = 0;
		for (Byte b : memory) {
			this.memory.set(counter, b);
			counter++;
		}
	}

	public byte getRemValue() {
		return this.rem.getValue();
	}

	public byte getRdmValue() {
		return this.rdm.getValue();
	}

	public byte getPcValue() {
		return this.programCounter.getValue();
	}

	public byte getS1Value() {
		return this.muxToAlu.getSelect0();
	}

	public byte getS2Value() {
		return this.muxToAlu.getSelect1();
	}

	public byte getAluValue() {
		return this.alu.getValue();
	}

	public byte getRiValue() {
		return this.instructionRegister.getValue();
	}
	
	public byte getRbValue() {
		return this.registerB.getValue();
	}

}
