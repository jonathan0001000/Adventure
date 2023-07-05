package com.mycompany.mygame.gameobjects.loadables.items;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import com.mycompany.mygame.gameobjects.LoadableObject;
import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;
import com.mycompany.mygame.world.WorldInterface;

public final class Magnet extends Item {
  
  private WorldInterface worldInterface;
  
  private Item item;
  
  public Magnet(float x, float y, WorldInterface worldInterface) {
    
    this.id = "Magnet";
    
    this.texture = new Texture(Gdx.files.internal("images/Magnet.png"));
    
    this.collisors = new ArrayList <Collisor>();
    
    this.collecterRect = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    collisors.add(new Collisor("Collecter", collecterRect, this));
    
    this.xOffset = 0f;
    this.yOffset = 0f;
    
    this.state = "Dropped";
    
    this.worldInterface = worldInterface;
    
    this.item = null;
    
  }
  
  // Main Methods //
  
  @Override
  public void load() {
    
    item = getItemToAttract();
    
  }
  
  @Override
  public void update(float deltaTime) {
    
    if(item != null && item.getState().equals("Dropped") == true) {
      
      item.begginAttracted(getCollecterRect());
      
    }
    
  }
  
  @Override
  public void unload() {
    
    item = null;
    
  }
  
  public Item getItemToAttract() {
    
    ArrayList <LoadableObject> list = worldInterface.getCurrentLoadableObjects();
    String[] compatibleIDs = {"YellowKey","BlackKey", "Sword", "Bridge", "Chalice"};
    Item tmpItem = null;
    
    xx:
    for(int index_1 = 0; index_1 < list.size(); index_1++) {
      
      for(int index_2 = 0; index_2 < compatibleIDs.length; index_2++) {
        
        if(list.get(index_1).getId().equals(compatibleIDs[index_2]) == true) {
          
          tmpItem = (Item)list.get(index_1);
          break xx;
          
        }
        
      }
      
    }
    
    return tmpItem;
  }
  
}