package com.generation.lojagames.model;

import java.text.DecimalFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	//retorna o nome do produto em letras maiúsculas
	public String obterNomeEmCaixaAlta() {
		return nome.toUpperCase();
	}
	
	private double preco; 
	//formatar preço para moeda
	public String formatarPreco() {
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		return "R$" + decimalFormat.format(preco);
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
	
	@ManyToOne
	@JsonIgnoreProperties("produto") //ignorar o looping na busca da postagem em relação aquele tema da busca
	private Categoria categoria;
	
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
