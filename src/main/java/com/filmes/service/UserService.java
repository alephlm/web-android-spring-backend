package com.filmes.service;

import com.filmes.model.User;

public interface UserService {
    User save(User user);

    User findByUsername(String username);
    
    public void favoritar(Long id);
}
