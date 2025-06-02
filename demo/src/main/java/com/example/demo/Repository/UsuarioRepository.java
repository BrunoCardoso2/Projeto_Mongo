package com.example.demo.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.Model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
