package com.mycompany.mygame.gameobjects.nonloadables;

import java.util.ArrayList;

import com.mycompany.mygame.Constants;
import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;
import com.mycompany.mygame.world.screens.Screen;

public final class TopEntrance extends Entrance {
  
  public TopEntrance(float x, float y, Screen nextScreen) {
    
    this.id = "Entrance";
    
    this.collisors = new ArrayList <Collisor>();
    
    this.rect = new Rectangle(x, y, 16, 16);
    collisors.add(new Collisor("Entrance", rect, this));
    
    this.nextScreen = nextScreen;
    
    this.playerX = 0;
    this.playerY = Constants.WORLDY - 192;
    
  }
  
}