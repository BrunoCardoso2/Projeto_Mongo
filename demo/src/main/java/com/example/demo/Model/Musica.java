package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "musicas")
@Data
public class Musica {
    @Id
    private String id;
    private String titulo;
    private String artista;
    private String genero;

    //private int ano;
    //private List<String> tags;
    //private List<Integer> avaliacoes;
}
 