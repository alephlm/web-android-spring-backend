package com.filmes.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Filme extends AbstractEntity{
	
	private String titulo;
	private String categoria;
	private String diretor;
	@ElementCollection
	private Set<String> atores = new HashSet<>();
	private String sinopse;
	private Date dataLancamento;
	private Integer Nota;

	@ManyToMany(mappedBy="filmes")
	@JsonIgnore
    private Set<User> users;
	
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public Set<String> getAtores() {
		return atores;
	}
	public void setAtores(Set<String> atores) {
		this.atores = atores;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public Integer getNota() {
		return Nota;
	}
	public void setNota(Integer nota) {
		Nota = nota;
	}

}
