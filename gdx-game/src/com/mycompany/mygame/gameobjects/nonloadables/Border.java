package com.mycompany.mygame.gameobjects.nonloadables;

import java.util.ArrayList;

import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;
import com.mycompany.mygame.gameobjects.NonLoadableObject;

public final class Border extends NonLoadableObject {
  
  private Rectangle rect;
  
  public Border(float x, float y) {
    
    this.id = "Border";
    
    this.collisors = new ArrayList <Collisor>();
    
    this.rect = new Rectangle(x, y, 16, 16);
    collisors.add(new Collisor("Rect_2", rect, this));
    
  }
  
}