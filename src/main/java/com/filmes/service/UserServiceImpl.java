package com.filmes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.filmes.model.CurrentUser;
import com.filmes.model.Filme;
import com.filmes.model.User;
import com.filmes.repository.FilmeRepository;
import com.filmes.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public void favoritar(Long id){
    	CurrentUser currentUser = (CurrentUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	User user = userRepository.getOne(currentUser.getId());
        Filme filme = filmeRepository.findOne(id);
        user.addFilme(filme);
        userRepository.save(user);
    }
    
}
