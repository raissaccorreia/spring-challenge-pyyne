package com.hiring.api.pyyne.hiringdemo.models;

public class Kvt {
  private String content;
  private int ttl;
  private long stamp;

  public Kvt(String content, int ttl, long stamp) {
    this.content = content;
    this.ttl = ttl;
    this.stamp = stamp;
  }

  public boolean isExpired() {
    if (ttl == 0)
      return false;
    long now = System.currentTimeMillis();
    if (now >= (stamp + ttl * 1000)) {
      return true;
    }
    return false;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String Content) {
    this.content = Content;
  }

  public int getttl() {
    return ttl;
  }

  public void setttl(int ttl) {
    this.ttl = ttl;
  }

  public long getStamp() {
    return stamp;
  }

  public void setStamp(long stamp) {
    this.stamp = stamp;
  }

}
