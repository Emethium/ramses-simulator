package com.ceunes.ramses.architecture;

import com.ceunes.ramses.model.ALU;
import com.ceunes.ramses.model.Decoder;
import com.ceunes.ramses.model.Multiplexer;
import com.ceunes.ramses.model.ProgramCounter;
import com.ceunes.ramses.model.Register;

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
