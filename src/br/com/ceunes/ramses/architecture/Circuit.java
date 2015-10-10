package br.com.ceunes.ramses.architecture;

import br.com.ceunes.ramses.model.ALU;
import br.com.ceunes.ramses.model.Decoder;
import br.com.ceunes.ramses.model.Multiplexer;
import br.com.ceunes.ramses.model.ProgramCounter;
import br.com.ceunes.ramses.model.Register;

public class Circuit {

	private ProgramCounter programCounter;
	private Register rem;
	private Register rdm;
	private Register registerX;
	private Register registerA;
	private Register registerB;
	private Register instructionRegister;
	private ALU alu;
	private Decoder decoder;
	private Multiplexer muxToRem;
	private Multiplexer muxToAlu;
	private Multiplexer muxToPC;

	// TODO logic and control methods
	public void chargeCommonRegisters(byte ra, byte rb, byte rx) {
		registerA.setValue(ra);
		registerB.setValue(rb);
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

	public byte write() {
		return rdm.geValue();
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

	/* Getters and Setters */

	public ProgramCounter getProgramCounter() {
		return programCounter;
	}

	public void setProgramCounter(ProgramCounter programCounter) {
		this.programCounter = programCounter;
	}

	public Register getRem() {
		return rem;
	}

	public void setRem(Register rem) {
		this.rem = rem;
	}

	public Register getRdm() {
		return rdm;
	}

	public void setRdm(Register rdm) {
		this.rdm = rdm;
	}

	public Register getRegisterX() {
		return registerX;
	}

	public void setRegisterX(Register registerX) {
		this.registerX = registerX;
	}

	public Register getRegisterA() {
		return registerA;
	}

	public void setRegisterA(Register registerA) {
		this.registerA = registerA;
	}

	public Register getRegisterB() {
		return registerB;
	}

	public void setRegisterB(Register registerB) {
		this.registerB = registerB;
	}

	public Register getInstructionRegister() {
		return instructionRegister;
	}

	public void setInstructionRegister(Register instructionRegister) {
		this.instructionRegister = instructionRegister;
	}

	public ALU getAlu() {
		return alu;
	}

	public void setAlu(ALU alu) {
		this.alu = alu;
	}

	public Decoder getDecoder() {
		return decoder;
	}

	public void setDecoder(Decoder decoder) {
		this.decoder = decoder;
	}

	public Multiplexer getMuxToRem() {
		return muxToRem;
	}

	public void setMuxToRem(Multiplexer muxToRem) {
		this.muxToRem = muxToRem;
	}

	public Multiplexer getMuxToAlu() {
		return muxToAlu;
	}

	public void setMuxToAlu(Multiplexer muxToAlu) {
		this.muxToAlu = muxToAlu;
	}

	public Multiplexer getMuxToPC() {
		return muxToPC;
	}

	public void setMuxToPC(Multiplexer muxToPC) {
		this.muxToPC = muxToPC;
	}

}
