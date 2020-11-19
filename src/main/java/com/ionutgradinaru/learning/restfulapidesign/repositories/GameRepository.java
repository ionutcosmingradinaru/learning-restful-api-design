package com.ionutgradinaru.learning.restfulapidesign.repositories;

import com.ionutgradinaru.learning.restfulapidesign.models.Game;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface GameRepository extends ReactiveMongoRepository<Game, String> {
}
