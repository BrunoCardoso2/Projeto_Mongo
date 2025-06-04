package com.example.demo.Model;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "usuarios")
@Data
public class Usuario {
    @Id
    private String id;
    private String nome;
    private String senha;
    private List<String> preferencias;
    private List<String> historico;
}
