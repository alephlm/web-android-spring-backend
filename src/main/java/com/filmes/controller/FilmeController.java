package com.filmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmes.model.Filme;
import com.filmes.service.FilmeService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/filme")
@CrossOrigin(origins = "*")
public class FilmeController {
	@Autowired
	private FilmeService filmeservice;
	
    @RequestMapping(value = "/inserir", method = RequestMethod.POST)
    public Filme registration(@RequestBody Filme filme) {
        return filmeservice.save(filme);
    }
    
    @RequestMapping(value = "/list")
    public List<Filme> listaFilmes() {
        return filmeservice.listAll();
    }

    @RequestMapping(value = "/favoritos", method = RequestMethod.GET)
    public List<Filme> favoritos() {
        return filmeservice.listFavoritos();
    }

    @RequestMapping(value = "/favoritos/delete/{id}", method = RequestMethod.POST)
    public List<Filme> deleteFavoritos(@PathVariable Long id) {
        return filmeservice.deleteFavorito(id);
    }

    @RequestMapping(value = "/procura", method = RequestMethod.GET)
    public List<Filme> favoritos(@RequestParam(value = "titulo") String titulo) {
        return filmeservice.procuraFilme(titulo);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        filmeservice.delete(id);
    }

}
