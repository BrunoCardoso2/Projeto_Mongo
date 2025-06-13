package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "artistas")
@Data
public class Artista {
    @Id
    private String id;
    private String nome;
    private String senha;
}