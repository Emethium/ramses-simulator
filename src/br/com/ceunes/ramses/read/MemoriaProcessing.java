	package br.com.ceunes.ramses.read;



	import java.io.BufferedReader;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.ceunes.ramses.architecture.*;
	import br.com.ceunes.ramses.view.*;
	
	public class MemoriaProcessing {
		
		public Interface interfac2;
		public ControlUnit unit;
		public Circuit circuit;
		public BufferedReader entradaString;
		public List<Byte> memory = new ArrayList<Byte>();
		public Byte value;
		
		
		public void memoryRead(Interface interfac2, Circuit circuit) throws IOException {
			this.interfac2= interfac2;
			this.circuit = circuit;
			unit = new ControlUnit(interfac2,circuit);
			FileInputStream entrada = new FileInputStream("memoria.txt");
			InputStreamReader entradaFormatada = new InputStreamReader(entrada);
			entradaString = new BufferedReader(entradaFormatada);
			loop();
		}
		public void loop() throws IOException{
			String linha = entradaString.readLine();
			
			while (linha != null) {
						value = Byte.valueOf(linha);
						linha = entradaString.readLine();
						memory.add(value);

			}
			circuit.setMemory(memory);
			entradaString.close();
		
		}

}
	

