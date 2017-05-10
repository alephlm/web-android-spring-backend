package com.filmes.service;

import java.util.List;

import com.filmes.model.Filme;

public interface FilmeService {
	
	void save(Filme filme);
	
	List<Filme> listAll();

	List<Filme> listFavoritos();

	List<Filme> deleteFavorito(Long id);

	List<Filme> procuraFilme(String titulo);

}
