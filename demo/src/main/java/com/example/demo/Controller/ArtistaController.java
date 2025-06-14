package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Model.Artista;
import com.example.demo.Repository.ArtistaRepository;

@RestController
@RequestMapping("/artistas")
@CrossOrigin(origins = "*")
public class ArtistaController {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/cadastrar")
    public Artista cadastrar(@RequestBody Artista artista) {
        if (artistaRepository.findByNome(artista.getNome()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome de artista já está em uso");
        }

        artista.setSenha(passwordEncoder.encode(artista.getSenha()));
        return artistaRepository.save(artista);
    }

    @PostMapping("/login")
    public Artista login(@RequestBody Artista loginData) {
        Optional<Artista> artistaOpt = artistaRepository.findByNome(loginData.getNome());

        if (artistaOpt.isPresent() && passwordEncoder.matches(loginData.getSenha(), artistaOpt.get().getSenha())) {
            return artistaOpt.get();
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nome ou senha inválidos");
    }
}
