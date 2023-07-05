package com.mycompany.mygame.gameobjects.loadables.dragons;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.mycompany.mygame.Constants;
import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;
import com.mycompany.mygame.world.WorldInterface;
import com.mycompany.mygame.gameobjects.LoadableObject;
import com.mycompany.mygame.gameobjects.loadables.items.Item;

public final class GreenDragon extends Dragon {
  
  private WorldInterface worldInterface;
  
  private Item item;
  private boolean blackKeyWasStolen;
  
  public GreenDragon(float x, float y, WorldInterface worldInterface) {
    
    this.id = "GreenDragon";
    
    Texture dragon_sheet = new Texture(Gdx.files.internal("images/GreenDragon.png"));
    
    int WIDTH = dragon_sheet.getWidth() / 3;
    int HEIGHT = dragon_sheet.getHeight();
    
    this.idle = new TextureRegion(dragon_sheet, 0, 0, WIDTH, HEIGHT);
    this.attacking = new TextureRegion(dragon_sheet, WIDTH, 0, WIDTH, HEIGHT);
    this.died = new TextureRegion(dragon_sheet, WIDTH * 2, 0, WIDTH, HEIGHT);
    
    this.currentFrame = idle;
    
    this.collisors = new ArrayList <Collisor>();
    
    this.bodyRect = new Rectangle(x, y, WIDTH, HEIGHT);
    this.mouthRect = new Rectangle(x, y + 30, 8, 8);
    this.stomachRect = new Rectangle(x, y + 8, 16, 18);
    
    this.speed = 1;
    
    this.state = "Idle";
    
    this.isAlive = true;
    
    this.timer = 0;
    
    this.worldInterface = worldInterface;
    
    this.player = worldInterface.getPlayer();
    this.item = null;
    
    this.blackKeyWasStolen = false;
    
  }
  
  // Main Methods //
  
  @Override
  public void load() {
    
    if(getIsAlive() == true) {
      
      follow();
      
    }
    
  }
  
  @Override
  public void unload() {
    
    if(getIsAlive() == true) {
      
      item = getItemToGuard();
      boolean thereIsAItemToGuard = item != null;
      
      if(thereIsAItemToGuard == true) {
        
        guardItem();
        
      } else {
        
        if(blackKeyWasStolen == false) {
          
          blackKeyWasStolen = true;
          requestToGoToScreen_8();
          
        } else {
          
          goToCurrentScreen();
          
        }
        
      }
      
    }
    
  }
  
  public Item getItemToGuard() {
    
    ArrayList <LoadableObject> list = worldInterface.getLastLoadableObjects();
    String[] compatibleIDs = {"BlackKey", "Bridge", "Magnet", "Chalice"};
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
  
  public void guardItem() {
    
    moveRects(item.getCollecterRect().getX(), item.getCollecterRect().getY());
    
  }
  
  public void requestToGoToScreen_8() {
    
    Random ra = new Random();
    
    int number = ra.nextInt((100 - 1) + 1) + 1;
    
    if(number > 49 && number < 101) {
      
      worldInterface.relocateObjectFromLastScreenToAnother(Constants.SCREEN_8, this);
      
    } else {
      
      goToCurrentScreen();
      
    }
    
  }
  
  public void goToCurrentScreen() {
    
    worldInterface.relocateObjectFromLastScreenToAnother(worldInterface.getCurrentScreen(), this);
    position();
    
  }
  
  public void position() {
    
    if(getPlayer().getDirection().equals("Up") == true) {
      
      moveRects(bodyRect.getX(), Constants.WORLDY - 236);
      
    }
    
    else if(getPlayer().getDirection().equals("Down") == true) {
      
      moveRects(getBodyRect().getX(), Constants.WORLDY);
      
    }
    
    else if(getPlayer().getDirection().equals("Right") == true) {
      
      moveRects(Constants.WORLDX, getBodyRect().getY());
      
    }
    
    else if(getPlayer().getDirection().equals("Left") == true) {
      
      moveRects(Constants.WORLDX + 336, getBodyRect().getY());
      
    }
    
  }
  
}