package com.hiring.api.pyyne.hiringdemo.service;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DictService {

  public String getDict() {
    return "hello, get dict!";
  }

  public boolean addToDict(String word) {
    if (word.length() >= 1)
      return true;
    else
      return false;
  }

  public boolean deleteFromDict(String word) {
    if (word.length() >= 1)
      return true;
    else
      return false;
  }

}