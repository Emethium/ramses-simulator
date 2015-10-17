package br.com.ceunes.ramses.read;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.ceunes.ramses.architecture.ControlUnit;

public class TextProcessing {

	public ControlUnit unit = new ControlUnit();

	public void read() throws IOException {
		FileInputStream entrada = new FileInputStream("file.txt");
		InputStreamReader entradaFormatada = new InputStreamReader(entrada);
		BufferedReader entradaString = new BufferedReader(entradaFormatada);

		String linha = entradaString.readLine();

		while (linha != null) {
			System.out.println(linha);
			unit.decode(linha);
			linha = entradaString.readLine();
		}
		entrada.close();
	}
}
