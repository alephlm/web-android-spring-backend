package com.filmes.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.filmes.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	List<Filme> findByTituloContaining(String titulo);

}
