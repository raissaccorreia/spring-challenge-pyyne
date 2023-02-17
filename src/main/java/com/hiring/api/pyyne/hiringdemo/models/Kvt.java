package com.hiring.api.pyyne.hiringdemo.models;

public class Kvt {
  private String key;
  private String value;
  private int ttl;
  private long stamp;

  public Kvt(String key, String value, int ttl, long stamp) {
    this.key = key;
    this.value = value;
    this.ttl = ttl;
    this.stamp = stamp;
  }

  public boolean isMe(String key) {
    return this.key == key;
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

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
