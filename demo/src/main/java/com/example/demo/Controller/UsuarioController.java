package com.example.demo.Controller;

import com.example.demo.Model.Usuario;
import com.example.demo.Repository.UsuarioRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        if (usuarioRepository.findByNome(usuario.getNome()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome de usuário já está em uso");
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario loginData) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNome(loginData.getNome());

        if (usuarioOpt.isPresent() && passwordEncoder.matches(loginData.getSenha(), usuarioOpt.get().getSenha())) {
            return usuarioOpt.get();
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Nome ou senha inválidos");
    }
}