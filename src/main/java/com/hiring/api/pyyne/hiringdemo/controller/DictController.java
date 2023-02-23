package com.hiring.api.pyyne.hiringdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.api.pyyne.hiringdemo.service.DictService;

@RestController
@RequestMapping("/dict")
public class DictController {

  private final DictService dictService;

  public DictController(DictService dictService) {
    this.dictService = dictService;
  }

  @GetMapping("")
  public String getDict(@RequestParam(value = "word", required = true) String word) {
    try {
      if (dictService.getDict(word) == null) {
        return "Word: " + word + "not found";
      } else {
        return dictService.getDict(word);
      }
    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
  }

  @PutMapping("")
  public String addToDict(
      @RequestParam(value = "key", required = true) String key,
      @RequestParam(value = "value", required = true) String value,
      @RequestParam(value = "ttl", defaultValue = "0", required = false) int ttl) {
    try {
      return dictService.addToDict(key, value, ttl);
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }

  @DeleteMapping("")
  public String deleteFromDict(@RequestParam(value = "word", required = true) String word) {
    try {
      return dictService.deleteFromDict(word);
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }
}
