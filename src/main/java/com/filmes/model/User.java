package com.filmes.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.JoinColumn;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends AbstractEntity{

    public User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.role = Role.USER;
    }
    
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="favoritos", joinColumns={@JoinColumn(name="user_id")},
    			inverseJoinColumns={@JoinColumn(name="filme_id")})
    private List<Filme> filmes;

    private String username;

    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    
    public void addFilme(Filme filme) {
        this.filmes.add(filme);
    }

    public void removeFilme(Filme filme) {
        this.filmes.remove(filme);
    }
    
    public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
