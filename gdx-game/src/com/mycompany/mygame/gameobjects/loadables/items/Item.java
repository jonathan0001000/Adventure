package com.mycompany.mygame.gameobjects.loadables.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;
import com.mycompany.mygame.gameobjects.LoadableObject;
import com.mycompany.mygame.gameobjects.loadables.Player;

public abstract class Item extends LoadableObject {
  
  protected Texture texture;
  
  protected Rectangle collecterRect;
  
  protected float xOffset;
  protected float yOffset;
  
  protected String state;
  
  // Setters //
  
  public void setCollecterRect(Rectangle collecterRect) {
    
    this.collecterRect = collecterRect;
    
  }
  
  public void setXOffset(float xOffset) {
    
    this.xOffset = xOffset;
    
  }
  
  public void setYOffset(float yOffset) {
    
    this.yOffset = yOffset;
    
  }
  
  public void setState(String state) {
    
    this.state = state;
    
  }
  
  // Getters //
  
  public Texture getTexture() {
    
    return this.texture;
  }
  
  public Rectangle getCollecterRect() {
    
    return this.collecterRect;
  }
  
  public float getXOffset() {
    
    return this.xOffset;
  }
  
  public float getYOffset() {
    
    return this.yOffset;
  }
  
  public String getState() {
    
    return this.state;
  }
  
  // Main Methods //
  
  public void render(SpriteBatch spriteBatch) {
    
    spriteBatch.draw(getTexture(), getCollecterRect().getX(), getCollecterRect().getY());
    
  }
   
  public void pickedUp(Player player) {
    
    setState("PickedUp");
    
    defineOffsets(player.getDirection(), player.getRect());
    
  }
  
  public void defineOffsets(String playerDirection, Rectangle playerRect) {
    
    if(playerDirection.equals("Up") == true) {
      
      setXOffset(getCollecterRect().getX() - playerRect.getX());
      setYOffset(playerRect.getHeight() + playerRect.getHeight());
      
      return;
    }
    
    if(playerDirection.equals("Down") == true) {
      
      setXOffset(getCollecterRect().getX() - playerRect.getX());
      setYOffset(-(getCollecterRect().getHeight() + playerRect.getHeight()));
      
      return;
    }
    
    if(playerDirection.equals("Right") == true) {
      
      setXOffset(playerRect.getWidth() + playerRect.getWidth());
      setYOffset(getCollecterRect().getY() - playerRect.getY());
      
      return;
    }
    
    if(playerDirection.equals("Left") == true) {
      
      setXOffset(-(getCollecterRect().getWidth() + playerRect.getWidth()));
      setYOffset(getCollecterRect().getY() - playerRect.getY());
      
      return;
    }
    
  }
  
  public void follow(float x, float y) {
  
    getCollecterRect().setPosition(x + getXOffset(), y + getYOffset());
    
  }
  
  public void dropped() {
    
    setState("Dropped");
    
    setXOffset(0);
    setYOffset(0);
    
  }
  
  public void begginAttracted(Rectangle magnetRect) {
    
    if(getCollecterRect().getTop() < magnetRect.getBottom()) {
      
      getCollecterRect().setY(getCollecterRect().getY() + 1);
      
    }
    
    else if(getCollecterRect().getTop() > magnetRect.getBottom()) {
      
      getCollecterRect().setY(getCollecterRect().getY() - 1);
      
    }
    
    if(getCollecterRect().getLeft() < magnetRect.getLeft()) {
      
      getCollecterRect().setX(getCollecterRect().getX() + 1);
      
    }
    
    else if(getCollecterRect().getLeft() > magnetRect.getLeft()) {
      
      getCollecterRect().setX(getCollecterRect().getX() - 1);
      
    }
    
  }
  
}