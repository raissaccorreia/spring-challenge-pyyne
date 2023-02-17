package com.hiring.api.pyyne.hiringdemo.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.hiring.api.pyyne.hiringdemo.models.Kvt;

@Service
public class DictService {

  private ConcurrentHashMap<String, Kvt> dict = new ConcurrentHashMap<String, Kvt>();

  public String getDict(String word) {
    try {
      if (dict.get(word).isExpired()) {
        dict.remove(word);
      }
      return dict.get(word).getContent();
    } catch (Exception e) {
      return "";
    }
  }

  public boolean addToDict(String key, String value, int ttl) {
    try {
      long now = System.currentTimeMillis();
      Kvt newElement = new Kvt(value, ttl, now);
      dict.put(key, newElement);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean deleteFromDict(String word) {
    try {
      dict.remove(word);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}