package com.filmes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filmes.model.Filme;
import com.filmes.service.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController {
	@Autowired
	private FilmeService filmeservice;
	
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String registration(@RequestBody Filme filme) {
        filmeservice.save(filme);
        return "OK";
    }
    
    @RequestMapping(value = "/list")
    public List<Filme> registration() {
        return filmeservice.listAll();
    }

}
