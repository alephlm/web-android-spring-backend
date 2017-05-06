package com.filmes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmes.model.Filme;
import com.filmes.repository.FilmeRepository;

@Service
public class FilmeServiceImpl implements FilmeService{
	@Autowired
	private FilmeRepository filmeRepository;

	@Override
	public void save(Filme filme) {
		filmeRepository.save(filme);
	}

	@Override
	public Filme findByTitulo(String titulo) {
		return filmeRepository.findByTitulo(titulo);
	}

	@Override
	public List<Filme> listAll() {
		return filmeRepository.findAll();
	}
	

}
