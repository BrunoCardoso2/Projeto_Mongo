package com.example.demo.Repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.Model.Musica;
public interface MusicaRepository extends MongoRepository<Musica, String> {
   List<Musica> findByGenero(String genero);
}
