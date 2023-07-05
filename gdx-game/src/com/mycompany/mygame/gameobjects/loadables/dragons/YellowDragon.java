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

public final class YellowDragon extends Dragon {
  
  private WorldInterface worldInterface;
  
  private Item item;
  private boolean playerHasEverBeenInScreen_3;
  
  public YellowDragon(float x, float y, WorldInterface worldInterface) {
    
    this.id = "YellowDragon";
    
    Texture dragon_sheet = new Texture(Gdx.files.internal("images/YellowDragon.png"));
    
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
    
    this.playerHasEverBeenInScreen_3 = false;
    
  }
  
  // Main Methods //
  
  @Override
  public void load() {
    
    if(getIsAlive() == true) {
      
      item = getItemInList("YellowKey", worldInterface.getCurrentLoadableObjects());
      boolean thereIsAYellowKey = item != null;
      
      if(thereIsAYellowKey == true) {
        
        if(worldInterface.getCurrentScreen() == Constants.SCREEN_3) { 
          
          worldInterface.relocateObjectFromCurrentScreenToAnother(Constants.SCREEN_11, this);
          
        } else {
          
          worldInterface.relocateObjectFromCurrentScreenToAnother(Constants.SCREEN_3, this);
          
        }
        
      } else {
        
        follow();
        
      }
      
    }
    
  }
  
  @Override
  public void unload() {
    
    if(getIsAlive() == true) {
      
      item = getItemInList("Chalice", worldInterface.getLastLoadableObjects());
      boolean thereIsAItemToGuard = item != null;
      
      if(thereIsAItemToGuard == true) {
        
        guardItem();
        
      } else {
        
        if(playerHasEverBeenInScreen_3 == false) {
          
          requestToGoToScreen_11();
          playerHasEverBeenInScreen_3 = true;
          
        } else {
          
          goToCurrentScreen();
          
        }
        
      }
        
    }
    
  }
  
  public Item getItemInList(String id, ArrayList <LoadableObject> list) {
    
    Item tmpItem = null;
    
    xx:
    for(int index = 0; index < list.size(); index++) {
      
      if(list.get(index).getId().equals(id) == true) {
        
        tmpItem = (Item)list.get(index);
        break xx;
        
      }
      
    }
    
    return tmpItem;
  }
  
  public void guardItem() {
    
    moveRects(item.getCollecterRect().getX(), item.getCollecterRect().getY());
    
  }
  
  public void requestToGoToScreen_11() {
    
    Random ra = new Random();
    
    int number = ra.nextInt((100 - 1) + 1) + 1;
    
    if(number > 69 && number < 101) {
      
      worldInterface.relocateObjectFromLastScreenToAnother(Constants.SCREEN_11, this);
      
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
      
      moveRects(getBodyRect().getX(), Constants.WORLDY - 236);
      
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