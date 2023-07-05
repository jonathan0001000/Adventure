package com.mycompany.mygame.gameobjects.loadables;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;
import com.mycompany.mygame.gameobjects.LoadableObject;
import com.mycompany.mygame.animations.GateAnimations;

public final class Gate extends LoadableObject {
  
  private GateAnimations animations;
  
  private TextureRegion currentFrame;
  
  private float stateTime;
  
  private Rectangle rect;
  
  private String keyForThisGate;
  
  private String state;
  
  public Gate(float x, float y, String keyForThisGate) {
    
    this.id = "Gate";
    
    this.animations = new GateAnimations();
    
    this.currentFrame = animations.getOpening().getKeyFrame(0);
    
    this.stateTime = 0;
    
    this.collisors = new ArrayList <Collisor>();
    
    this.rect = new Rectangle(x, y, currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
    collisors.add(new Collisor("Rect_2", rect, this));
    
    this.keyForThisGate = keyForThisGate;
    
    this.state = "Closed";
    
  }
  
  // Getters //
  
  public Rectangle getRect() {
    
    return this.rect;
  }
  
  // Main Methods //
  
  @Override
  public void update(float deltaTime) {
    
    if(state.equals("Opening") == true) {
      
      stateTime = stateTime + deltaTime;
      
      if(animations.getOpening().isAnimationFinished(stateTime) == false) {
        
        currentFrame = animations.getOpening().getKeyFrame(stateTime, false);
        
      } else {
        
        state = "Opened";
        
      }
      
    }
    
  }
  
  @Override
  public void render(SpriteBatch spriteBatch) {
    
    spriteBatch.draw(currentFrame, getRect().getX(), getRect().getY());
    
  }
  
  @Override
  public void checkCollision(Collisor collisor) {
    
    if(collisor.getOwner().getId().equals(keyForThisGate) == true) {
      
      if(collisor.getRect().overlaps(getRect()) == true) {
        
        if(state.equals("Closed") == true) {
          
          state = "Opening";
          
          getCollisors().remove(0);
          
        }
        
      }
      
    }
    
  }
  
}