package com.example.demo.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.*;
import com.example.demo.Repository.MusicaRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/musicas")
@CrossOrigin(origins = "*") // permite requisições do frontend
public class MusicaController {

    private final MusicaRepository repository;

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
}
