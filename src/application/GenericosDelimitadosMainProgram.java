package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.text.html.parser.ParserDelegator;

import model.entities.Produto;
import model.service.CalculoService;

public class GenericosDelimitadosMainProgram {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		String path = "/tmp/produto.csv";
		List<Produto> lista = new ArrayList<Produto>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String linha = br.readLine();
			String[] campo = null;
			while (linha != null) {
				campo = linha.split(",");
				lista.add(new Produto(campo[0], Double.parseDouble(campo[1])));
				linha = br.readLine();
			}
			Produto x = CalculoService.max(lista);
			System.out.println("O maior preço é do produto:");
			System.out.println(x);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
