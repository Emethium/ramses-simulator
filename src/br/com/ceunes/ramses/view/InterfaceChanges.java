package br.com.ceunes.ramses.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InterfaceChanges {
	
	public Interface interfac = new Interface();
	
	public void RecebeCargaRB(char cargaRb){
		
		if(cargaRb==(byte)0){
			interfac.CargaRB0.setSelected(true);
			interfac.CargaRB1.setSelected(false);
		}
		else{
			interfac.CargaRB1.setSelected(true);
			interfac.CargaRB0.setSelected(false);
		}
			
	}
	public void RecebeCargaRX(char cargaRx){
		
		if(cargaRx==(byte)0){
			interfac.CargaRX0.setSelected(true);
			interfac.CargaRX1.setSelected(false);
		}
		else{
			interfac.CargaRX1.setSelected(true);
			interfac.CargaRX0.setSelected(false);
		}
	}
	
	public void RecebeCargaREM(char cargaREM){
		
		if(cargaREM==(byte)0){
			interfac.CargaREM0.setSelected(true);
			interfac.CargaREM1.setSelected(false);
		}
		else{
			interfac.CargaREM1.setSelected(true);
			interfac.CargaREM0.setSelected(false);
		}
	}
	public void RecebeCargaRDM(char cargaRDM){
		
		if(cargaRDM==(byte)0){
			interfac.CargaRDM0.setSelected(true);
			interfac.CargaRDM1.setSelected(false);
		}
		else{
			interfac.CargaRDM1.setSelected(true);
			interfac.CargaRDM0.setSelected(false);
		}
	}
	public void RecebeCargaRI(char cargaRx){
		
		if(cargaRx==(byte)0){
			interfac.CargaRI0.setSelected(true);
			interfac.CargaRI1.setSelected(false);
		}
		else{
			interfac.CargaRI1.setSelected(true);
			interfac.CargaRI0.setSelected(false);
		}
	}
		
	public void RecebeCargaS1(char cargaRI){
			if(cargaRI==(byte)0){
				interfac.MUXS1.setText("0");
			}
			if(cargaRI==(byte)1){
				interfac.MUXS1.setText("1");
			}
	}
	public void RecebeCargaS2(char cargaS2){
			if(cargaS2==(byte)0){
				interfac.MUXS2.setText("0");
			}
			if(cargaS2==(byte)1){
				interfac.MUXS2.setText("1");
			}
	}
	
	public void RecebeCargaS3(char cargaS3){
		if(cargaS3==(byte)0){
			interfac.MUXS3.setText("0");
		}
		if(cargaS3==(byte)1){
			interfac.MUXS3.setText("1");
		}
	}
	public void RecebeCargaS4(char cargaS4){
		if(cargaS4==(byte)0){
			interfac.MUXS4.setText("0");
		}
		if(cargaS4==(byte)1){
			interfac.MUXS4.setText("1");
		}
	}
	public void RecebeCargaS5(char cargaS5){
		if(cargaS5==(byte)0){
			interfac.MUXS5.setText("0");
		}
		if(cargaS5==(byte)1){
			interfac.MUXS5.setText("1");
		}
	}
	
	public void RecebeCargaAluMSB(char cargaAluMsb){
		if(cargaAluMsb==(byte)0){
			interfac.ALUMSB.setText("0");
		}
		if(cargaAluMsb==(byte)1){
			interfac.ALUMSB.setText("1");
		}
	}
	public void RecebeCargaAlu2MSB(char cargaAlu2Msb){
		if(cargaAlu2Msb==(byte)0){
			interfac.ALU2MSB.setText("0");
		}
		if(cargaAlu2Msb==(byte)1){
			interfac.ALU2MSB.setText("1");
		}
	}
	public void RecebeCargaAluLSB(char cargaAluLSB){
		if(cargaAluLSB==(byte)0){
			interfac.ALULSB.setText("0");
		}
		if(cargaAluLSB==(byte)1){
			interfac.ALULSB.setText("1");
		}
	}
	
	public void RecebeCargaCarry(char cargaCarry){
		if(cargaCarry==(byte)0){
			interfac.Carry.setSelected(false);
		}
		else
			interfac.Carry.setSelected(true);
	}
	
	public void RecebeCargaNegativo(char cargaNegativo){
		if(cargaNegativo==(byte)0){
			interfac.Negativo.setSelected(false);
		}
		else
			interfac.Negativo.setSelected(true);
	}
	
	public void RecebeCargaZero(char cargaZero){
		if(cargaZero==(byte)0){
			interfac.Zero.setSelected(false);
		}
		else
			interfac.Zero.setSelected(true);
	}
	
	public void RecebeCargaRead(char cargaRead){
		if(cargaRead==(byte)0){
			interfac.Read.setSelected(false);
		}
		else
			interfac.Read.setSelected(true);
	}
	public void RecebeCargaWrite(char cargaWrite){
		if(cargaWrite==(byte)0){
			interfac.Write.setSelected(false);
		}
		else
			interfac.Write.setSelected(true);
	}
	
	public void valorPC(byte cargaPC){
		interfac.incrementaPC.setText(String.valueOf(cargaPC));
	}
	
	public void valorRA(byte cargaRA){
		interfac.valorRA.setText(String.valueOf(cargaRA));
	}
	
	public void valorRB(byte cargaRB){
		interfac.valorRB.setText(String.valueOf(cargaRB));
	}
	
	public void valorRX(byte cargaRX){
		interfac.valorRX.setText(String.valueOf(cargaRX));
	}
	
	public void valorREM(byte cargaREM){
		interfac.valorREM.setText(String.valueOf(cargaREM));
	}
	
	public void valorRDM(byte cargaRDM){
		interfac.valorRDM.setText(String.valueOf(cargaRDM));
	}
	
	
	public void proximaInstrucao(){
		interfac.btnproximaInstrucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TODO: EXECUTAR PROXIMA INSTRUÇÃO
			}
		});
	}
}
