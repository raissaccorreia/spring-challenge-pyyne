package com.hiring.api.pyyne.hiringdemo.models;

public class Node {
  private String content;
  private Node prev;

  public Node(String content, Node prev) {
    this.content = content;
    this.prev = prev;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Node getPrev() {
    return prev;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }

}
