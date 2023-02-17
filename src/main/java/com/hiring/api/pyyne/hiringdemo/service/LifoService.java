package com.hiring.api.pyyne.hiringdemo.service;

import org.springframework.stereotype.Service;

import com.hiring.api.pyyne.hiringdemo.models.Node;

@Service
public class LifoService {

  private Node topOfStack = null;

  public String getLifo() {
    if (topOfStack != null) {
      String answer = topOfStack.getContent();
      topOfStack = topOfStack.getPrev();
      return answer;
    } else {
      return "empty stack";
    }
  }

  public String addToLifo(String word) {
    try {
      Node newNode = new Node(word, topOfStack);
      topOfStack = newNode;
      return newNode.getContent();
    } catch (Exception e) {
      return "fail to add new node";
    }
  }
}