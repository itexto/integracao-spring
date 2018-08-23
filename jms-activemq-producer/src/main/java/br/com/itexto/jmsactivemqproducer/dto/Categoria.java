package br.com.itexto.jmsactivemqproducer.dto;

public class Categoria {
	
	private long id;
	
	private String nome;
	
	public String toString() {
		return "[" + getId() + "," + getNome() + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
