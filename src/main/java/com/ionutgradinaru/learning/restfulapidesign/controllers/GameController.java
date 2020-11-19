package com.ionutgradinaru.learning.restfulapidesign.controllers;

import com.ionutgradinaru.learning.restfulapidesign.models.Game;
import com.ionutgradinaru.learning.restfulapidesign.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping(path = "/api/v1/games")
public class GameController {

  private final GameRepository repository;

  @Autowired
  public GameController(final GameRepository gameRepository) {
    this.repository = gameRepository;
  }

  @PostMapping
  public Mono<ResponseEntity<Void>> create() {
    return repository
        .save(new Game())
        .flatMap(game -> {
          URI location = URI
              .create("api/v1/games/" + game.getId());
          return Mono.just(ResponseEntity
              .created(location)
              .build());
        });
  }
}
