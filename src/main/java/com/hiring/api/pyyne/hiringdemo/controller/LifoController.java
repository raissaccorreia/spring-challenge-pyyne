package com.hiring.api.pyyne.hiringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.api.pyyne.hiringdemo.service.LifoService;

@RestController
@RequestMapping("/lifo")
public class LifoController {

  private final LifoService lifoService;

  public LifoController(LifoService lifoService) {
    this.lifoService = lifoService;
  }

  @GetMapping("")
  public String getLifo() {
    try {
      return lifoService.getLifo();
    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
  }

  @PutMapping("")
  public String addToLifo(@RequestParam(value = "word", required = true) String word) {
    try {
      return lifoService.addToLifo(word);
    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
  }
}
