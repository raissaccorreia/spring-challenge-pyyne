package com.hiring.api.pyyne.hiringdemo.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.hiring.api.pyyne.hiringdemo.models.Kvt;

@Service
public class DictService {

  private ConcurrentHashMap<String, Kvt> dict = new ConcurrentHashMap<String, Kvt>();

  public String getDict(String word) {
    if (dict.get(word) == null || dict.get(word).isExpired()) {
      dict.remove(word);
      return null;
    } else {
      return dict.get(word).getContent();
    }
  }

  public String addToDict(String key, String value, int ttl) {
      long now = Kvt.getCurrentTime();
      Kvt newElement = new Kvt(value, ttl, now);
      dict.put(key, newElement);
      if (ttl != 0) {
        return "Added: " + key + " = " + value + " with ttl " + ttl + " seconds";
      } else {
        return "Added: " + key + " = " + value + " without ttl";
      }
  }

  public String deleteFromDict(String word) {
    if (dict.get(word) == null) {
      return "Fail to Remove: " + word;
    } else {
      dict.remove(word);
      return "Removed: " + word;
    }
  }

}
