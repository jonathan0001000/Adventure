package com.mycompany.mygame.ui;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public final class Button {
  
  private Rectangle rect;
  
  private int point;
  
  public Button(float posX, float posY, float size) {
    
    this.rect = new Rectangle(posX, posY, size, size);
    
    this.point = -1;
    
  }
  
  // Setters //
  
  public void setPoint(int point) {
    
    this.point = point;
    
  }
  
  // Getters //
  
  public Rectangle getRect() {
    
    return this.rect;
  }
  
  public int getPoint() {
    
    return this.point;
  }
  
  // Main Methods //
  
  public void render(ShapeRenderer shapeRenderer) {
    
    shapeRenderer.setColor(1f, 1f, 1f, 1f);
    shapeRenderer.rect(getRect().getX(), getRect().getY(), getRect().getWidth(), getRect().getHeight());
    
  }
  
}