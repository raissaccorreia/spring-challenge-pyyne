package com.hiring.api.pyyne.hiringdemo.service;

import org.springframework.stereotype.Service;

import com.hiring.api.pyyne.hiringdemo.models.node;

@Service
public class LifoService {

  node TopOfStack = null;

  public String getLifo() {
    if (TopOfStack != null) {
      String answer = TopOfStack.getContent();
      TopOfStack = TopOfStack.getPrev();
      return answer;
    } else {
      return "empty stack";
    }
  }

  public String addToLifo(String word) {
    try {
      node NewNode = new node(word, TopOfStack);
      TopOfStack = NewNode;
      return NewNode.getContent();
    } catch (Exception e) {
      return "fail to add new node";
    }
  }
}