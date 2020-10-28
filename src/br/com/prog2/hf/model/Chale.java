package br.com.prog2.hf.model;

public class Chale {
	private String cod_chale;
	private String localizacao;
	private Integer capacidade;
	private Double valorAltaEstacao;
	private Double valorBaixaEstacao;
	
	public Chale() {}
	
	public String getCod_chale() {
		return cod_chale;
	}
	public void setCod_chale(String cod_chale) {
		this.cod_chale = cod_chale;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Double getValorAltaEstacao() {
		return valorAltaEstacao;
	}
	public void setValorAltaEstacao(Double valorAltaEstacao) {
		this.valorAltaEstacao = valorAltaEstacao;
	}
	public Double getValorBaixaEstacao() {
		return valorBaixaEstacao;
	}
	public void setValorBaixaEstacao(Double valorBaixaEstacao) {
		this.valorBaixaEstacao = valorBaixaEstacao;
	}
	
	
}
