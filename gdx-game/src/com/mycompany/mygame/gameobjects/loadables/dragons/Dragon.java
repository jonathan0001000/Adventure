package com.mycompany.mygame.gameobjects.loadables.dragons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;
import com.mycompany.mygame.gameobjects.LoadableObject;
import com.mycompany.mygame.gameobjects.loadables.Player;

public class Dragon extends LoadableObject {
  
  protected TextureRegion idle;
  protected TextureRegion attacking;
  protected TextureRegion died;
  
  protected TextureRegion currentFrame;
  
  protected Rectangle bodyRect;
  protected Rectangle mouthRect;
  protected Rectangle stomachRect;
  
  protected float speed;
  
  protected String state;
  
  protected boolean isAlive;
  
  protected float timer;
  
  protected Player player;
  
  protected boolean playerIsCollidingWithMouth;
  
  // Getters //
  
  public Rectangle getBodyRect() {
    
    return this.bodyRect;
  }
  
  public boolean getIsAlive() {
    
    return this.isAlive;
  }
  
  public Player getPlayer() {
    
    return this.player;
  }
  
  // Main Methods //
  
  @Override
  public void update(float deltaTime) {
    
    if(state.equals("Following") == true) {
      
      if(walkUntilReachThePlayer() == true) {
        
        attack();
        
      }
      
    }
    
    else if(state.equals("Attacking") == true) {
      
      timer = timer + deltaTime;
      
      if(timer >= 3) {
        
        timer = 0;
        
        if(playerIsCollidingWithMouth == true) {
          
          eat();
          
        } else {
          
          follow();
          
        }
        
      }
      
    }
    
  }
  
  @Override
  public void render(SpriteBatch spriteBatch) {
    
    spriteBatch.draw(currentFrame, bodyRect.getX(), bodyRect.getY());
    
  }
  
  public boolean walkUntilReachThePlayer() {
    
    if(mouthRect.getTop() < player.getRect().getTop()) {
      
      moveRects(bodyRect.getX(), bodyRect.getY() + speed);
      
    }
    
    else if(mouthRect.getTop() > player.getRect().getTop()) {
      
      moveRects(bodyRect.getX(), bodyRect.getY() - speed);
      
    }
    
    if(mouthRect.getLeft() < player.getRect().getLeft()) {
      
      moveRects(bodyRect.getX() + speed, bodyRect.getY());
      
    }
    
    else if(mouthRect.getLeft() > player.getRect().getLeft()) {
      
      moveRects(bodyRect.getX() - speed, bodyRect.getY());
      
    }
    
    return mouthRect.getTop() == player.getRect().getTop() && mouthRect.getLeft() == player.getRect().getLeft();
  }
  
  public void moveRects(float x, float y) {
    
    bodyRect.setPosition(x, y);
    mouthRect.setPosition(x, y + 30);
    stomachRect.setPosition(x, y + 8);
    
  }
  
  public void follow() {
    
    currentFrame = idle;
    
    state = "Following";
  
    collisors.clear();
    
  }
  
  public void attack() {
    
    currentFrame = attacking;
    
    state = "Attacking";
    
    Rectangle blockRect_1 = new Rectangle(bodyRect.getX(), bodyRect.getY() + 8, 16, 20);
    Rectangle blockRect_2 = new Rectangle(bodyRect.getX() + 10, bodyRect.getY() + 30, 6, 8);
    Rectangle blockRect_3 = new Rectangle(bodyRect.getX(), bodyRect.getY() + 40, 8, 4);
    
    collisors.add(new Collisor("Rect_2", blockRect_1, this));
    collisors.add(new Collisor("Rect_2", blockRect_2, this));
    collisors.add(new Collisor("Rect_2", blockRect_3, this));
    
  }
  
  public void eat() {
    
    currentFrame = idle;
    
    state = "Idle";
    
    collisors.clear();
    
    Rectangle blockRect_1 = new Rectangle(bodyRect.getX(), bodyRect.getY() + 20, 16, 4);
    Rectangle blockRect_2 = new Rectangle(bodyRect.getX(), bodyRect.getY() + 8, 16, 4);
    Rectangle blockRect_3 = new Rectangle(bodyRect.getX() + 12, bodyRect.getY() + 8, 4, 16);
    Rectangle blockRect_4 = new Rectangle(bodyRect.getX(), bodyRect.getY() + 8, 4, 16);
    
    collisors.add(new Collisor("Rect_2", blockRect_1, this));
    collisors.add(new Collisor("Rect_2", blockRect_2, this));
    collisors.add(new Collisor("Rect_2", blockRect_3, this));
    collisors.add(new Collisor("Rect_2", blockRect_4, this));
     
    player.die(bodyRect);
    
  }
  
  public void die() {
    
    currentFrame = died;
    
    state = "Died";
    
    isAlive = false;
    
    collisors.clear();
    
    Rectangle blockRect_1 = new Rectangle(bodyRect.getX(), bodyRect.getY(), 14, 18);
    Rectangle blockRect_2 = new Rectangle(bodyRect.getX(), bodyRect.getY() + 18, 8, 8);
    Rectangle blockRect_3 = new Rectangle(bodyRect.getX() + 8, bodyRect.getY() + 18, 8, 10);
    Rectangle blockRect_4 = new Rectangle(bodyRect.getX() + 8, bodyRect.getY() + 28, 4, 6);
    
    
    collisors.add(new Collisor("Rect_2", blockRect_1, this));
    collisors.add(new Collisor("Rect_2", blockRect_2, this));
    collisors.add(new Collisor("Rect_2", blockRect_3, this));
    collisors.add(new Collisor("Rect_2", blockRect_4, this));
    
  }
  
  @Override
  public void checkCollision(Collisor collisor) {
    
    if(collisor.getOwner().getId().equals("Sword") == true) {
      
      if(collisor.getRect().overlaps(stomachRect) == true && state.equals("Following") == true) {
        
        die();
        
      }
      
    }
    
    else if(collisor.getId().equals("Player") == true) {
      
      playerIsCollidingWithMouth = collisor.getRect().overlaps(mouthRect);
      
    }
    
  }
  
}