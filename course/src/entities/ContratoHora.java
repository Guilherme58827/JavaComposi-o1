package entities;

import java.time.LocalDate;

import java.util.Date;

public class ContratoHora {
	private LocalDate data;
	private double valorph;
	private Integer horas;

	public ContratoHora() {

	}

	public ContratoHora(LocalDate data, double valorph, Integer horas) {

		this.data = data;
		this.valorph = valorph;
		this.horas = horas;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValorph() {
		return valorph;
	}

	public void setValorph(double valorph) {
		this.valorph = valorph;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public double valorTotal() {
		return valorph * horas;
	}

}
