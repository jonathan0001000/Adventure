package com.mycompany.mygame.utils;

public class Rectangle {
  
  private float x;
  private float y;
  
  private float width;
  private float height;
  
  public Rectangle(float x, float y, float width, float height) {
    
    this.x = x;
    this.y = y;
    
    this.width = width;
    this.height = height;
    
  }
  
  // Setters //
  
  public void setX(float x) {
    
    this.x = x;
    
  }
  
  public void setY(float y) {
    
    this.y = y;
    
  }
  
  public void setWidth(float width) {
    
    this.width = width;
    
  }
  
  public void setHeight(float height) {
    
    this.height = height;
    
  }
  
  // Getters //
  
  public float getX() {
    
    return this.x;
  }
  
  public float getY() {
    
    return this.y;
  }
  
  public float getWidth() {
    
    return this.width;
  }
  
  public float getHeight() {
    
    return this.height;
  }
  
  public float getTop() {
    
    return getY() + getHeight();
  }
  
  public float getBottom() {
    
    return getY();
  }
  
  public float getRight() {
    
    return getX() + getWidth();
  }
  
  public float getLeft() {
    
    return getX();
  }
  
  // Main Methods //
  
  public void setPosition(float x, float y) {
    
    setX(x);
    setY(y);
    
  }
  
  public boolean overlaps(Rectangle rect) {
    
    return getTop() > rect.getBottom() && getBottom() < rect.getTop() && getRight() > rect.getLeft() && getLeft() < rect.getRight();
  }
  
}