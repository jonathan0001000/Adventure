package com.mycompany.mygame.world.screens;

import java.util.ArrayList;

import com.mycompany.mygame.utils.Color;
import com.mycompany.mygame.gameobjects.NonLoadableObject;
import com.mycompany.mygame.gameobjects.LoadableObject;
import com.mycompany.mygame.world.WorldInterface;

public abstract class Screen {
  
  protected final int BLOCK = 1;
  protected final int BORDER = 2;
  protected final int TOP_ENTRANCE = 3;
  protected final int BOTTOM_ENTRANCE = 4;
  protected final int RIGHT_ENTRANCE = 5;
  protected final int LEFT_ENTRANCE = 6;
  protected final int CASTLE = 7;
  
  protected Color color;
  
  protected ArrayList <LoadableObject> loadableObjects;
  
  // Getters //
  
  public Color getColor() {
    
    return this.color;
  }
  
  public ArrayList <LoadableObject> getLoadableObjects() {
    
    return this.loadableObjects;
  }
  
  // Main Methods //
  
  public abstract void createLoadableObjects(WorldInterface worldInterface);
  public abstract ArrayList <NonLoadableObject> createNonLoadableObjects();
  
}