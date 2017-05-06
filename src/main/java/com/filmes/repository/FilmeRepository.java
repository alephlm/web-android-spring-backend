package com.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmes.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	Filme findByTitulo(String titulo);

}
