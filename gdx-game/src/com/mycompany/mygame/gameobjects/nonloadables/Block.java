package com.mycompany.mygame.gameobjects.nonloadables;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.mycompany.mygame.utils.Color;
import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;
import com.mycompany.mygame.gameobjects.NonLoadableObject;

public final class Block extends NonLoadableObject {
  
  private Color color;
  
  private Rectangle rect;
  
  public Block(Color color, float x, float y) {
    
    this.id = "Block";
    
    this.color = color;
    
    this.collisors = new ArrayList <Collisor>();
    
    this.rect = new Rectangle(x, y, 16, 16);
    collisors.add(new Collisor("Rect_1", rect, this));
    
  }
  
  // Getters //
  
  public Rectangle getRect() {
    
    return this.rect;
  }
  
  // Main Methods //
  
  @Override
  public void render(ShapeRenderer shapeRenderer) {
    
    shapeRenderer.setColor(color.getR(), color.getG(), color.getB(), color.getA());
    shapeRenderer.rect(getRect().getX(), getRect().getY(), getRect().getWidth(), getRect().getHeight());
    
  }
  
}