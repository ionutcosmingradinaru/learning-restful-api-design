package com.ionutgradinaru.learning.restfulapidesign.controllers;

import com.ionutgradinaru.learning.restfulapidesign.models.DoorStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DoorDto {

  private final DoorStatus status;
}
