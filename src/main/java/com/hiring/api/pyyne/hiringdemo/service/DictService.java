package com.hiring.api.pyyne.hiringdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hiring.api.pyyne.hiringdemo.models.Kvt;

@Service
public class DictService {

  private List<Kvt> kvtList = new ArrayList<Kvt>();

  public String getDict(String word) {
    for (int i = 0; i < kvtList.size(); i++) {
      Kvt element = kvtList.get(i);
      if (element.getKey().equals(word) && !element.isExpired()) {
        return element.getValue();
      }
    }
    return "";
  }

  public boolean addToDict(String key, String value, int ttl) {
    try {
      long now = System.currentTimeMillis();
      Kvt newElement = new Kvt(key, value, ttl, now);
      kvtList.add(newElement);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean deleteFromDict(String word) {
    try {
      for (int i = 0; i < kvtList.size(); i++) {
        Kvt element = kvtList.get(i);
        if (element.getKey().equals(word)) {
          kvtList.remove(i);
          return true;
        }
      }
      return false;
    } catch (Exception e) {
      return false;
    }
  }

}