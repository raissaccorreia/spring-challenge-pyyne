package com.hiring.api.pyyne.hiringdemo.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.hiring.api.pyyne.hiringdemo.models.Kvt;

@Service
public class DictService {

  private ConcurrentHashMap<String, Kvt> dict = new ConcurrentHashMap<String, Kvt>();

  /*
   * The idea of the try catch on service layer is to provide an error message
   * to an user, instead of the controller which is on the technical side.
   */

  public String getDict(String word) {
      try {
        if (dict.get(word).isExpired()) {
          dict.remove(word);
        }
        return dict.get(word).getContent();
      } catch (Exception e) {
        return "Not found: " + word;
      }
  }

  public String addToDict(String key, String value, int ttl) {
    try {
      long now = System.currentTimeMillis();
      Kvt newElement = new Kvt(value, ttl, now);
      dict.put(key, newElement);
      if (ttl != 0) {
        return "Added: " + key + " = " + value + " with ttl " + ttl + " seconds";
      } else {
        return "Added: " + key + " = " + value + " without ttl";
      }
    } catch (Exception e) {
      return "Fail to Add: " + key + " = " + value + " with ttl " + ttl;
    }
  }

  public String deleteFromDict(String word) {
    try {
      dict.remove(word);
      return "Removed: " + word;
    } catch (Exception e) {
      return "Fail to Remove: " + word;
    }
  }

}
