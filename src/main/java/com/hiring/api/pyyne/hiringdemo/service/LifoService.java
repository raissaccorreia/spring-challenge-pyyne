package com.hiring.api.pyyne.hiringdemo.service;

import java.util.Stack;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LifoService {

  Stack<String> arr = new Stack<String>();

  public String getLifo() {
    if (arr.empty()) {
      System.out.println("STACK EMPTY");
    } else {
      return arr.pop();
    }
    return null;
  }

  public boolean addToLifo(String word) {
    try {
      arr.push(word);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}