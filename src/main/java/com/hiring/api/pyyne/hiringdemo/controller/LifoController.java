package com.hiring.api.pyyne.hiringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.api.pyyne.hiringdemo.service.LifoService;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/lifo")
public class LifoController {

  private final LifoService lifoService;

  public LifoController(LifoService lifoService) {
    this.lifoService = lifoService;
  }

  @GetMapping("")
  public String getLifo() {
    return lifoService.getLifo();
  }

  @PutMapping("")
  public boolean addToLifo(@RequestParam(value = "word", required = true) String word) {
    return lifoService.addToLifo(word);
  }
}