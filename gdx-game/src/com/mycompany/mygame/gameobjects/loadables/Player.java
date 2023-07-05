package com.mycompany.mygame.gameobjects.loadables;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.mycompany.mygame.Constants;
import com.mycompany.mygame.utils.Color;
import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;
import com.mycompany.mygame.world.WorldInterface;
import com.mycompany.mygame.gameobjects.LoadableObject;
import com.mycompany.mygame.gameobjects.nonloadables.Entrance;
import com.mycompany.mygame.gameobjects.loadables.items.Item;

public final class Player extends LoadableObject {
  
  private Color color;
  
  private float x;
  private float y;
  
  private Rectangle rect;
  
  private float speed;
  
  private String direction;
  
  private Item currentItem;
  
  private boolean isOnBridge;
  private boolean isAlive;
  
  private WorldInterface worldInterface;
  
  public Player(WorldInterface worldInterface) {
    
    this.id = "Player";
    
    this.color = Constants.YELLOW;
    
    this.x = Constants.HALF_THE_WIDTH - 4;
    this.y = Constants.WORLDY - 152;
    
    this.collisors = new ArrayList <Collisor>();
    
    this.rect = new Rectangle(x, y, 8, 8);
    collisors.add(new Collisor("Player", rect, this));
    
    this.speed = 2;
    
    this.direction = "None";
    
    this.currentItem = null;
    
    this.isOnBridge = false;
    this.isAlive = true;
    
    this.worldInterface = worldInterface;
    
  }
  
  // Setters //
  
  public void setDirection(String direction) {
    
    this.direction = direction;
    
  }
  
  // Getters //
  
  public float getX() {
    
    return this.x;
  }
  
  public float getY() {
    
    return this.y;
  }
  
  public Rectangle getRect() {
    
    return this.rect;
  }
  
  public String getDirection() {
    
    return this.direction;
  }
  
  // Main Methods //
  
  @Override
  public void load() {
    
    color = worldInterface.getColor();
    
  }
  
  @Override
  public void update(float deltaTime) {
    
    getRect().setPosition(getX(), getY());
    
    if(currentItem != null) {
      
      currentItem.follow(getX(), getY());
      
    }
    
  }
  
  @Override
  public void render(ShapeRenderer shapeRenderer) {
    
    shapeRenderer.setColor(color.getR(), color.getG(), color.getB(), color.getA());
    shapeRenderer.rect(getRect().getX(), getRect().getY(), getRect().getWidth(), getRect().getHeight());
    
  }
  
  public void walkUp() {
    
    setDirection("Up");
    y = y + speed;
    
  }
  
  public void walkDown() {
    
    setDirection("Down");
    y = y - speed;
    
  }
  
  public void walkRight() {
    
    setDirection("Right");
    x = x + speed;
    
  }
  
  public void walkLeft() {
    
    setDirection("Left");
    x = x - speed;
    
  }
  
  @Override
  public void checkCollision(Collisor collisor) {
    
    if(collisor.getId().equals("Rect_1") == true) {
      
      if(getRect().overlaps(collisor.getRect()) == true) {
        
        collisionWithRect_1(collisor.getRect());
        
      }
      
    }
    
    else if(collisor.getId().equals("Rect_2") == true) {
      
      if(getRect().overlaps(collisor.getRect()) == true) {
        
        collisionWithRect_2(collisor.getRect());
        
      }
      
    }
    
    else if(collisor.getId().equals("Entrance") == true) {
      
      if(getRect().overlaps(collisor.getRect()) == true) {
        
        collisionWithEntrance((Entrance)collisor.getOwner());
        
      }
      
    }
    
    else if(collisor.getId().equals("Collecter") == true) {
       
      if(getRect().overlaps(collisor.getRect()) == true) {
        
        requestToPickItemUp((Item)collisor.getOwner());
        
      }
      
    }
    
    else if(collisor.getId().equals("Crossing") == true) {
      
      checkCollisionWithCrossing(collisor.getRect());
      
    }
    
  }
  
  public void collisionWithRect_1(Rectangle rect2) {
    
    if(isAlive == true) {
      
      String collisionSide = checkCollisionSide(rect2);
      
      if(collisionSide.equals("Top") == true && isOnBridge == false) {
      
        y = rect2.getY() - getRect().getHeight();
        
      }
    
      else if(collisionSide.equals("Bottom") == true && isOnBridge == false) {
      
        y = rect2.getY() + rect2.getHeight();
        
      }
    
      else if(collisionSide.equals("Right") == true) {
      
        x = rect2.getX() - getRect().getWidth();
        
      }
    
      else if(collisionSide.equals("Left") == true) {
      
        x = rect2.getX() + rect2.getWidth();
        
      }
      
    }
    
  }
  
  public String checkCollisionSide(Rectangle rect2) {
    
    if(getRect().getTop() - rect2.getBottom() <= speed) {
     
      return "Top";
    }
    
    if(rect2.getTop() - getRect().getBottom() <= speed) {
      
      return "Bottom";
    }
    
    if(getRect().getRight() - rect2.getLeft() <= speed) {
      
      return "Right";
    }
    
    if(rect2.getRight() - getRect().getLeft() <= speed) {
      
      return "Left";
    }
    
    return "None";
  }
  
  public void collisionWithRect_2(Rectangle rect2) {
    
    if(getDirection().equals("Up") == true) {
      
      y = rect2.getY() - getRect().getHeight();
      
    }
    
    else if(getDirection().equals("Down") == true) {
      
      y = rect2.getY() + rect2.getHeight();
      
    }
    
    else if(getDirection().equals("Right") == true) {
      
      x = rect2.getX() - getRect().getWidth();
      
    }
    
    else if(getDirection().equals("Left") == true) {
    
      x = rect2.getX() + rect2.getWidth();
      
    }
    
  }
  
  public void collisionWithEntrance(Entrance entrance) {
    
    if(isAlive == true) {
      
      if(entrance.getPlayerX() != 0) {
      
       x = entrance.getPlayerX();
      
      }
    
      if(entrance.getPlayerY() != 0) {
      
        y = entrance.getPlayerY();
      
      }
    
      worldInterface.beginCreateScreen(entrance.getNextScreen());
      worldInterface.middleCreateScreen();
      worldInterface.endCreateScreen();
    
    }
    
  }
  
  public void requestToPickItemUp(Item item) {
    
    if(currentItem == null) {
      
      pickItemUp(item);
      
    } else {
      
      dropItem();
      pickItemUp(item);
      
    }
    
  }
  
  public void pickItemUp(Item item) {
    
    currentItem = item;
    currentItem.pickedUp(this);
    
  }
  
  public void requestToDropItem() {
    
    if(currentItem != null) {
      
      dropItem();
      
    }
    
  }
  
  public void dropItem() {
    
    currentItem.dropped();
    currentItem = null;
    
  }
  
  public void checkCollisionWithCrossing(Rectangle rect2) {
    
    if(getRect().overlaps(rect2) == true) {
      
      isOnBridge = true;
      
      if(currentItem != null) {
        
        if(currentItem.getId().equals("Bridge") == true) {
          
          isOnBridge = false;
          
        }
        
      }
      
    } else {
      
      isOnBridge = false;
      
    }
    
  }
  
  public void die(Rectangle dragonRect) {
    
    isAlive = false;
    
    x = dragonRect.getX() + 4;
    y = dragonRect.getY() + 12;
    
  }
  
  @Override
  public void unload() {
    
    if(currentItem != null) {
      
      worldInterface.relocateObjectFromLastScreenToAnother(worldInterface.getCurrentScreen(), currentItem);
      
    }
    
    isOnBridge = false;
    
  }
  
}