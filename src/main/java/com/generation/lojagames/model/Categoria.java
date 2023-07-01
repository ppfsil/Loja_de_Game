package com.generation.lojagames.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;

//import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O Nome do Game é Obrigatório")
	private String nome;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Categoria> categoria;

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
	//public boolean equals(Object obj) {  //equals(Object obj) é usado para comparar se duas instâncias de Categoria são iguais
      //  if (this == obj) {
        //    return true;
       // }
        //if (obj == null || getClass() != obj.getClass()) {
          //  return false;
       // }
       // Categoria outraCategoria = (Categoria) obj;
       // return Objects.equals(id, outraCategoria.id);
   // }
	
//	public int hashCode() {  //esse completa o método de cima - testar
  //      return Objects.hash(id);
  //  }
	//método toString() retorna uma representação em forma de string do objeto Categoria, exibindo os valores dos atributos id e nome
  //  public String toString() {
    //    return "Categoria{" +
      //          "id=" + id +
        //        ", nome='" + nome + '\'' +
          //      '}';
   // }
    
  //  public boolean isNomeIgual(String nome) {  //ignorar Maiusculas e Minusculas ao inserir dados pelo usuário
   // return this.nome.equalsIgnoreCase(nome);
 		}
//	}
