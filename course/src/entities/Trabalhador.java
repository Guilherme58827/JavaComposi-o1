package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador nivel;
	private double salariobase;
	private Departamento departamento;
	private List<ContratoHora> contratos = new ArrayList<>();

	public Trabalhador() {

	}

	public Trabalhador(String nome, NivelTrabalhador nivel, double salariobase, Departamento departamento) {

		this.nome = nome;
		this.nivel = nivel;
		this.salariobase = salariobase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public double getSalariobase() {
		return salariobase;
	}

	public void setSalariobase(double salariobase) {
		this.salariobase = salariobase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContratos() {
		return contratos;
	}

	public void adicionarContratos(ContratoHora contrato) {
		contratos.add(contrato);

	}

	public void RemoverContratos(ContratoHora contrato) {
		contratos.remove(contrato);

	}

	public double ganho(Integer Ano, Integer Mes) {
		double soma = salariobase;
		for (ContratoHora c : contratos) {
			int cano = c.getData().getYear();

			int cmes = c.getData().getMonthValue();
			if (Ano == cano && Mes == cmes) {
				soma += c.valorTotal();
			}

		}
		return soma;
	}

}
