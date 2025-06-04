package com.example.demo.Repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.Model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByNome(String nome);
    Optional<Usuario> findByNomeAndSenha(String nome, String senha);
}
