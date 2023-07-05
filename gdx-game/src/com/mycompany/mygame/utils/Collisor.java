package com.mycompany.mygame.utils;

import com.mycompany.mygame.gameobjects.NonLoadableObject;

public final class Collisor {
  
  private String id;
  
  private Rectangle rect;
  
  private NonLoadableObject owner;
  
  public Collisor(String id, Rectangle rect, NonLoadableObject owner) {
    
    this.id = id;
    
    this.rect = rect;
    
    this.owner = owner;
    
  }
  
  // Getters //
  
  public String getId() {
    
    return this.id;
  }
  
  public Rectangle getRect() {
    
    return this.rect;
  }
  
  public NonLoadableObject getOwner() {
    
    return this.owner;
  }
  
}