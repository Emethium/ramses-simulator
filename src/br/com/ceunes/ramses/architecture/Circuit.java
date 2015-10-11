package br.com.ceunes.ramses.architecture;

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
	protected byte memory;

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
		instructionRegister.setValue(data);
	}

	public void chargeRem(byte data) {
		rem.setValue(data);
	}

	public void chargeRdm(byte data) {
		rdm.setValue(data);
	}

	public void write() {
		memory = rdm.getValue();
	}
	
	public void read() {
		rdm.setValue(memory);
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

	public void incrementPC() {
		programCounter.increment();
	}

	public void chargePc(byte address) {
		programCounter.setValue(address);
	}

	public byte getMemory() {
		return memory;
	}

	public void setMemory(byte memory) {
		this.memory = memory;
	}

}
