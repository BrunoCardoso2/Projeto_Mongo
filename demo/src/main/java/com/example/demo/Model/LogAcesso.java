package com.example.demo.Model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "logs_acesso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogAcesso {
    @Id
    private String id;
    private String nome;
    private String tipo; // "usuario" ou "artista"
    private LocalDateTime dataHora;
    private String acao; // Ex: "LOGIN_SUCESSO", "LOGIN_FALHA"
}
