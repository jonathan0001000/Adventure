package com.mycompany.mygame.gameobjects.loadables.items;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.mycompany.mygame.animations.ChaliceAnimations;
import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;

public final class Chalice extends Item {
  
  private ChaliceAnimations animations;
  
  private TextureRegion currentFrame;
  
  private float stateTime;
  
  public Chalice(float x, float y) {
    
    this.id = "Chalice";
    
    this.animations = new ChaliceAnimations();
    
    this.currentFrame = animations.getShining().getKeyFrame(0f);
    
    this.stateTime = 0;
    
    this.collisors = new ArrayList <Collisor>();
    
    this.collecterRect = new Rectangle(x, y, currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
    collisors.add(new Collisor("Collecter", collecterRect, this));
    
    this.xOffset = 0f;
    this.yOffset = 0f;
    
    this.state = "Dropped";
    
  }
  
  // Main Methods //
  
  @Override
  public void update(float deltaTime) {
    
    stateTime = stateTime + deltaTime;
    currentFrame = animations.getShining().getKeyFrame(stateTime, true);
    
  }
  
  @Override
  public void render(SpriteBatch spriteBatch) {
    
    spriteBatch.draw(currentFrame, getCollecterRect().getX(), getCollecterRect().getY());
    
  }
  
}