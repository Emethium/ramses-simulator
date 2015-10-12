package br.com.ceunes.ramses.architecture;

import java.util.ArrayList;
import java.util.List;

import br.com.ceunes.ramses.model.ALU;
import br.com.ceunes.ramses.model.Decoder;
import br.com.ceunes.ramses.model.Multiplexer;
import br.com.ceunes.ramses.model.ProgramCounter;
import br.com.ceunes.ramses.model.Register;

public class Circuit {

	protected ProgramCounter programCounter = new ProgramCounter();
	protected Register rem = new Register();
	protected Register rdm = new Register();
	protected Register registerX = new Register();
	protected Register registerA = new Register();
	protected Register registerB = new Register();
	protected Register instructionRegister = new Register();
	protected ALU alu = new ALU();
	protected Decoder decoder = new Decoder();
	protected Multiplexer muxToRem = new Multiplexer();
	protected Multiplexer muxToAlu = new Multiplexer();
	protected Multiplexer muxToPC = new Multiplexer();
	protected List<Byte> memory = new ArrayList<Byte>();

	public Circuit() {
		for(int i = 0; i < 256; i++) {
			memory.add((byte)0);
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
		instructionRegister.setValue(data);
	}

	public void chargeRem(byte data) {
		rem.setValue(data);
	}

	public void chargeRdm(byte data) {
		rdm.setValue(data);
	}

	public void write() {
		memory.set(rem.getValue(), rdm.getValue());
	}

	public void read() {
		rdm.setValue(memory.get(rem.getValue()));
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

	public List<Byte> getMemory() {
		return memory;
	}

	public void setMemory(List<Byte> memory) {
		this.memory = memory;
	}


}
