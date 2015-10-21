package br.com.ceunes.ramses.read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.ceunes.ramses.architecture.Circuit;
import br.com.ceunes.ramses.architecture.ControlUnit;
import br.com.ceunes.ramses.view.*;



public class TextProcessing {
	public Interface interfac2;
	public ControlUnit unit;
	public BufferedReader entradaString;
	public boolean next=true;
	public boolean one;
	public Circuit circuit;
	public boolean prox=false;

	public void read(boolean all, Interface interfac2,Circuit circuit) throws IOException {
		this.interfac2= interfac2;
		this.circuit = circuit;
		unit = new ControlUnit(interfac2,circuit);
				FileInputStream entrada = new FileInputStream("file.txt");
				InputStreamReader entradaFormatada = new InputStreamReader(entrada);
				entradaString = new BufferedReader(entradaFormatada);
				if(all) loop(true);
				else loop(false);
					
	}
	public void loop(boolean prox) throws IOException{
			String linha = entradaString.readLine();
			if(linha==null){
				interfac2.setFim(false);
				entradaString.close();
			}
			else{
				
				if(prox){
					while (linha != null) {
						unit.decode(linha);
						linha = entradaString.readLine();
					}
					entradaString.close();
					interfac2.setFim(false);
				}
				else unit.decode(linha);
			}
	}
}