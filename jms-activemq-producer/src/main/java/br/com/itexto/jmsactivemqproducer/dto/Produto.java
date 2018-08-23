package br.com.itexto.jmsactivemqproducer.dto;

public class Produto {
	
	private Long id;
	
	private String nome;
	
	private Categoria categoria;
	
	public String toString() {
		return "Produto: " + getId() + " nome = " + getNome() + " categoria: " + getCategoria();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
