package com.ionutgradinaru.learning.restfulapidesign.models;

import lombok.Data;

@Data
public class Door {

  private DoorStatus status;
  private GamePrize prize;

  public Door(GamePrize prize) {
    this.status = DoorStatus.CLOSED;
    this.prize = prize;
  }
}
