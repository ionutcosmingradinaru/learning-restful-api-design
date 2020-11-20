package com.ionutgradinaru.learning.restfulapidesign.controllers;

import com.ionutgradinaru.learning.restfulapidesign.models.Game;
import com.ionutgradinaru.learning.restfulapidesign.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

  @GetMapping(path = "/{id}/doors", produces = APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<List<DoorDto>>> getDoors(@PathVariable String id) {
    return repository
        .findById(id)
        .flatMap(game -> {
          var doors = game
              .getDoors()
              .stream()
              .map(door -> new DoorDto(door.getStatus()))
              .collect(Collectors.toList());

          return Mono.just(ResponseEntity
              .ok(doors));
        });
  }
}
