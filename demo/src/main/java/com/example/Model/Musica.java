package com.example.Model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "musicas")
public class Musica {
    @Id
    private String id;
    private String titulo;
    private String artista;
    private List<String> genero;
    private int ano;
    private List<String> tags;
    private List<Integer> avaliacoes;
}
