package com.hiring.api.pyyne.hiringdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.api.pyyne.hiringdemo.service.DictService;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/dict")
public class DictController {

  private final DictService dictService;

  public DictController(DictService dictService) {
    this.dictService = dictService;
  }

  @GetMapping("")
  public String getDict() {
    return dictService.getDict();
  }

  @PutMapping("")
  public boolean addToDict(String word) {
    return dictService.addToDict(word);
  }

  @DeleteMapping("")
  public boolean deleteFromDict(String word) {
    return dictService.deleteFromDict(word);
  }
}