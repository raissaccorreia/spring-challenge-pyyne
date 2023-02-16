package com.hiring.api.pyyne.hiringdemo.service;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LifoService {

  public String getLifo() {
    return "hello, get lifo!";
  }

  public boolean addToLifo(String word) {
    if (word.length() >= 1)
      return true;
    else
      return false;
  }

}