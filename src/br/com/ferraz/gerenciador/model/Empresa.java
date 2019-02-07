package br.com.ferraz.gerenciador.model;

import java.util.Date;

public class Empresa {

	private int id;
	private String nome;
	private Date dataAbertura = new Date();
	
	
	public Empresa(int id, String nome, Date dataAbertura) {
		this.id = id;
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", dataAbertura=" + dataAbertura + "]";
	}
	
}
