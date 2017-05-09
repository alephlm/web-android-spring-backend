package com.filmes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.filmes.model.CurrentUser;
import com.filmes.model.Filme;
import com.filmes.model.User;
import com.filmes.repository.FilmeRepository;
import com.filmes.repository.UserRepository;

@Service
public class FilmeServiceImpl implements FilmeService{
	@Autowired
	private FilmeRepository filmeRepository;
	@Autowired
    private UserRepository userRepository;

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
	
	@Override
	public List<Filme> listFavoritos() {
    	CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = userRepository.getOne(currentUser.getId());
    	return user.getFilmes();
	}

	public List<Filme> deleteFavorito(Long id){
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = userRepository.getOne(currentUser.getId());
        Filme filme = filmeRepository.findOne(id);
        user.removeFilme(filme);
        userRepository.save(user);
        return user.getFilmes();
	}

}
