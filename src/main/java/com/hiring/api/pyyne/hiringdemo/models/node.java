package com.hiring.api.pyyne.hiringdemo.models;

public class node {
  private String content;
  private node prev;

  public node(String content, node prev) {
    this.content = content;
    this.prev = prev;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public node getPrev() {
    return prev;
  }

  public void setPrev(node prev) {
    this.prev = prev;
  }

}
