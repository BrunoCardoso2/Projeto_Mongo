package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Model.*;
import com.example.demo.Repository.MusicaRepository;
import com.example.demo.Repository.UsuarioRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musicas")
@CrossOrigin(origins = "*") // permite requisições do frontend
public class MusicaController {

    private final MusicaRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public MusicaController(MusicaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Musica> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Musica> buscarPorId(@PathVariable String id) {
        return repository.findById(id);
    }

    @PostMapping
    public Musica criar(@RequestBody Musica musica) {
        return repository.save(musica);
    }

    @PutMapping("/{id}")
    public Musica atualizar(@PathVariable String id, @RequestBody Musica musica) {
        musica.setId(id);
        return repository.save(musica);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        repository.deleteById(id);
    }

    @GetMapping("/recomendadas/{nomeUsuario}")
    public List<Musica> recomendarPorGenero(@PathVariable String nomeUsuario) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNome(nomeUsuario);

        if (usuarioOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }

        List<String> preferencias = usuarioOpt.get().getPreferencias();
        List<Musica> musicas = repository.findByGeneroIn(preferencias);

        Collections.shuffle(musicas); // embaralha a lista
        return musicas.stream().limit(5).toList(); // retorna no máximo 5
    }

    @GetMapping("/por-artista/{nome}")
    public List<Musica> listarPorArtista(@PathVariable String nome) {
        return repository.findByArtista(nome);
    }

}
