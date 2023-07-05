package com.mycompany.mygame.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mycompany.mygame.utils.Collisor;

public abstract class NonLoadableObject {
  
  protected String id;
  
  protected ArrayList <Collisor> collisors;
  
  // Getters //
  
  public String getId() {
    
    return this.id;
  }
  
  public ArrayList <Collisor> getCollisors() {
    
    return this.collisors;
  }
  
  // Main Methods //
  
  public void update(float deltaTime) {
  }
  
  public void render(ShapeRenderer shapeRenderer) {
  }
  
  public void render(SpriteBatch spriteBatch) {
  }
  
  public void checkCollision(Collisor collisor) {
  }
  
}