package com.filmes.service;

import com.filmes.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    
    public void favoritar(Long id);
}
