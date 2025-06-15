package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Model.LogAcesso;

public interface LogAcessoRepository extends MongoRepository<LogAcesso, String> {
}
