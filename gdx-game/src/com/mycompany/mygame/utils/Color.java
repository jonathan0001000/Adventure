package com.mycompany.mygame.utils;

public final class Color {
  
  private float r;
  private float g;
  private float b;
  private float a;
  
  public Color(float r, float g, float b, float a) {
    
    this.r = r;
    this.g = g;
    this.b = b;
    this.a = a;
    
  }
  
  // Getters //
  
  public float getR() {
    
    return this.r;
  }
  
  public float getG() {
    
    return this.g;
  }
  
  public float getB() {
    
    return this.b;
  }
  
  public float getA() {
    
    return this.a;
  }
  
}