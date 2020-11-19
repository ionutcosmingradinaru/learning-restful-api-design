package com.ionutgradinaru.learning.restfulapidesign.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@TypeAlias("Game")
@Document(value = "games")
public class Game {

  @Id
  private String id;

  @Field(name = "doors")
  List<Door> doors;

  public Game() {
    doors = new ArrayList<>(List.of(
        new Door(GamePrize.CAR),
        new Door(GamePrize.GOAT),
        new Door(GamePrize.GOAT)
    ));
  }
}
