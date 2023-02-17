package com.hiring.api.pyyne.hiringdemo.service;

import java.util.HashMap;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DictService {

  HashMap<String, String> kvList = new HashMap<>();

  public String getDict(String word) {
    return kvList.get(word);
  }

  public boolean addToDict(String key, String value) {
    try {
      kvList.put(key, value);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean deleteFromDict(String word) {
    try {
      kvList.remove(word);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}