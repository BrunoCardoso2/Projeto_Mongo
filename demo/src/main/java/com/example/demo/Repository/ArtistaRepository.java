package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Model.Artista;

public interface ArtistaRepository extends MongoRepository<Artista, String> {
    Optional<Artista> findByNome(String nome);
}