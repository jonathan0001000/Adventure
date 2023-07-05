package com.mycompany.mygame.gameobjects.nonloadables;

import com.mycompany.mygame.utils.Rectangle;
import com.mycompany.mygame.gameobjects.NonLoadableObject;
import com.mycompany.mygame.world.screens.Screen;

public class Entrance extends NonLoadableObject {
  
  protected Rectangle rect;
  
  protected Screen nextScreen;
  
  protected float playerX;
  protected float playerY;
  
  // Setters //
  
  public void setPlayerX(float playerX) {
    
    this.playerX = playerX;
    
  }
  
  public void setPlayerY(float playerY) {
    
    this.playerY = playerY;
    
  }
  
  // Getters //
  
  public Rectangle getRect() {
    
    return this.rect;
  }
  
  public Screen getNextScreen() {
    
    return this.nextScreen;
  }
  
  public float getPlayerX() {
    
    return this.playerX;
  }
  
  public float getPlayerY() {
    
    return this.playerY;
  }
  
}