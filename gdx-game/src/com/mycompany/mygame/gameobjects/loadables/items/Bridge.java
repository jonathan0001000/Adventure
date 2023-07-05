package com.mycompany.mygame.gameobjects.loadables.items;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;
import com.mycompany.mygame.gameobjects.loadables.Player;

public final class Bridge extends Item {
  
  private Rectangle leftCollecterRect;
  private Rectangle crossingRect;
  private Rectangle rightCollecterRect;
  
  public Bridge(float x, float y) {
    
    this.id = "Bridge";
    
    this.texture = new Texture(Gdx.files.internal("images/Bridge.png"));
    
    this.collisors = new ArrayList <Collisor>();
    
    this.leftCollecterRect = new Rectangle(x, y, 16, 48);
    collisors.add(new Collisor("Collecter", leftCollecterRect, this));
    
    this.crossingRect = new Rectangle(x + 16, y, 32, 48);
    collisors.add(new Collisor("Crossing", crossingRect, this));
    
    this.rightCollecterRect = new Rectangle(x + 48, y, 16, 48);
    collisors.add(new Collisor("Collecter", rightCollecterRect, this));
    
    this.collecterRect = leftCollecterRect;
    
    this.xOffset = 0f;
    this.yOffset = 0f;
    
    this.state = "Dropped";
    
  }
  
  // Main Methods //
  
  @Override
  public void render(SpriteBatch spriteBatch) {
    
    spriteBatch.draw(getTexture(), leftCollecterRect.getX(), leftCollecterRect.getY());
    
  }
  
  @Override
  public void pickedUp(Player player) {
    
    setState("PickedUp");
    
    whichCollecterThePlayerCollided(player.getRect());
    
    defineOffsets(player.getDirection(), player.getRect());
    
  }
  
  public void whichCollecterThePlayerCollided(Rectangle playerRect) {
    
    if(playerRect.overlaps(rightCollecterRect) == true) {
      
      setCollecterRect(rightCollecterRect);
      
      return;
    }
    
    if(playerRect.overlaps(leftCollecterRect) == true) {
      
      setCollecterRect(leftCollecterRect);
      
      return;
    }
    
  }
  
  @Override
  public void follow(float x, float y) {
    
    if(getCollecterRect() == rightCollecterRect) {
      
      moveRectsFromRightOne(x + getXOffset(), y + getYOffset());
      
    }
    
    else if(getCollecterRect() == leftCollecterRect) {
      
      moveRectsFromLeftOne(x + getXOffset(), y + getYOffset());
      
    }
    
  }
  
  @Override
  public void begginAttracted(Rectangle magnetRect) {
    
    if(leftCollecterRect.getTop() < magnetRect.getBottom()) {
      
      moveRectsFromLeftOne(leftCollecterRect.getX(), leftCollecterRect.getY() + 1);
      
    }
    
    else if(leftCollecterRect.getTop() > magnetRect.getBottom()) {
      
      moveRectsFromLeftOne(leftCollecterRect.getX(), leftCollecterRect.getY() - 1);
      
    }
    
    if(leftCollecterRect.getLeft() < magnetRect.getLeft()) {
      
      moveRectsFromLeftOne(leftCollecterRect.getX() + 1, leftCollecterRect.getY());
      
    }
    
    else if(leftCollecterRect.getLeft() > magnetRect.getLeft()) {
      
      moveRectsFromLeftOne(leftCollecterRect.getX() - 1, leftCollecterRect.getY());
      
    }
    
  }
  
  public void moveRectsFromRightOne(float x, float y) {
    
    rightCollecterRect.setPosition(x, y);
    crossingRect.setPosition(rightCollecterRect.getX() - crossingRect.getWidth(), y);
    leftCollecterRect.setPosition(crossingRect.getX() - leftCollecterRect.getWidth(), y);
    
  }
  
  public void moveRectsFromLeftOne(float x, float y) {
    
    leftCollecterRect.setPosition(x, y);
    crossingRect.setPosition(leftCollecterRect.getX() + leftCollecterRect.getWidth(), y);
    rightCollecterRect.setPosition(crossingRect.getX() + crossingRect.getWidth(), y);
    
  }
  
}