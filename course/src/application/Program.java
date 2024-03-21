package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("MM/yyyy");
		System.out.print("entre com o nome do departamento: ");
		String deptnome = sc.nextLine();
		System.out.print("nome do trabalhador: ");
		String nome = sc.nextLine();
		System.out.print("nivel do trabalhador: ");
		String nivel = sc.nextLine();
		System.out.print("salario base: ");

		double salariobase = sc.nextDouble();

		Trabalhador t = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salariobase, new Departamento(deptnome));

		System.out.print("quantos contratos? ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("entre com o contrato " + i);
			System.out.print("data: ");
			String dd = sc.next();
			LocalDate data = LocalDate.parse(dd, f1);
			System.out.print("valor por hora: ");
			double valorporhora = sc.nextDouble();
			System.out.print("duração: ");
			int hora = sc.nextInt();
			ContratoHora contrato = new ContratoHora(data, valorporhora, hora);
			t.adicionarContratos(contrato);
		}
		System.out.println();
		System.out.print("entre com mes e ano(MM/yyyy): ");
		String meseano = sc.next().trim();
		String mes = meseano.substring(0, 2);
		String ano = meseano.substring(3);

		System.out.println("nome: " + t.getNome());
		System.out.println("departamento: " + t.getDepartamento().getNome());
		System.out.println("quanto ganhou em " + meseano + ": R$ "
				+ String.format("%.2f", t.ganho(Integer.parseInt(ano), Integer.parseInt(mes))));

		sc.close();
	}
}
