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
	public Filme save(Filme filme) {
		return filmeRepository.save(filme);
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

	@Override
	public List<Filme> deleteFavorito(Long id) {
		CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = userRepository.getOne(currentUser.getId());
        Filme filme = filmeRepository.findOne(id);
        user.removeFilme(filme);
        userRepository.save(user);
        return user.getFilmes();
	}

	@Override
	public List<Filme> procuraFilme(String titulo) {
		return filmeRepository.findByTituloContaining(titulo);
	}

	@Override
	public void delete(Long id) {
		Filme filme = filmeRepository.getOne(id);
		List<User> users = filme.getUsers();
		for (User u : users) {
			u.removeFilme(filme);
			userRepository.save(u);
		}
		filmeRepository.delete(id);
	}

}
