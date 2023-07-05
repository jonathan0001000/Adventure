package com.mycompany.mygame.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.mycompany.mygame.Constants;
import com.mycompany.mygame.MyGdxGame;
import com.mycompany.mygame.utils.Color;
import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.gameobjects.NonLoadableObject;
import com.mycompany.mygame.gameobjects.LoadableObject;
import com.mycompany.mygame.gameobjects.loadables.Player;
import com.mycompany.mygame.world.screens.Screen;

public final class World implements WorldInterface {
  
  private MyGdxGame game;
  
  private Player player;
  
  private Screen currentScreen;
  private Screen lastScreen;
  
  private ArrayList <NonLoadableObject> gameObjects;
  private ArrayList <Collisor> collisors;
  
  public World(MyGdxGame game) {
    
    this.game = game;
    
    this.player = new Player(this);
    
    Constants.SCREEN_1.createLoadableObjects(this);
    Constants.SCREEN_2.createLoadableObjects(this);
    Constants.SCREEN_3.createLoadableObjects(this);
    Constants.SCREEN_4.createLoadableObjects(this);
    Constants.SCREEN_5.createLoadableObjects(this);
    Constants.SCREEN_6.createLoadableObjects(this);
    Constants.SCREEN_7.createLoadableObjects(this);
    Constants.SCREEN_8.createLoadableObjects(this);
    Constants.SCREEN_9.createLoadableObjects(this);
    Constants.SCREEN_10.createLoadableObjects(this);
    Constants.SCREEN_11.createLoadableObjects(this);
    Constants.SCREEN_12.createLoadableObjects(this);
    Constants.SCREEN_13.createLoadableObjects(this);
    Constants.SCREEN_14.createLoadableObjects(this);
    
    this.currentScreen = Constants.SCREEN_1;
    this.lastScreen = null;
    
    this.gameObjects = new ArrayList <NonLoadableObject>();
    this.collisors = new ArrayList <Collisor>();
    
    endCreateScreen();
    
  }
  
  // Getters //
  
  public Player getPlayer() {
    
    return this.player;
  }
  
  @Override
  public Color getColor() {
    
    return this.currentScreen.getColor();
  }
  
  @Override
  public Screen getCurrentScreen() {
    
    return this.currentScreen;
  }
  
  @Override
  public Screen getLastScreen() {
    
    return this.lastScreen;
  }
  
  @Override
  public ArrayList <LoadableObject> getCurrentLoadableObjects() {
    
    return this.currentScreen.getLoadableObjects();
  }
  
  @Override
  public ArrayList <LoadableObject> getLastLoadableObjects() {
    
    return this.lastScreen.getLoadableObjects();
  }
  
  // Main Methods //
  
  @Override
  public void beginCreateScreen(Screen nextScreen) {
    
    lastScreen = currentScreen;
    currentScreen = nextScreen;
    
  }
  
  @Override
  public void middleCreateScreen() {
    
    unload();
    load();
    
    gameObjects.clear();
    collisors.clear();
    
  }
  
  @Override
  public void endCreateScreen() {
    
    gameObjects.addAll(currentScreen.createNonLoadableObjects());
    gameObjects.addAll(currentScreen.getLoadableObjects());
    
  }
  
  public void load() {
    
    for(int index = 0; index < getCurrentLoadableObjects().size(); index++) {
      
      getCurrentLoadableObjects().get(index).load();
      
    }
    
  }
  
  public void unload() {
    
    for(int index = 0; index < getLastLoadableObjects().size(); index++) {
      
      getLastLoadableObjects().get(index).unload();
      
    }
    
  }
  
  @Override
  public void relocateObjectFromCurrentScreenToAnother(Screen newScreen, LoadableObject object) {
    
    newScreen.getLoadableObjects().add(object);
    getCurrentLoadableObjects().remove(object);
    
  }
  
  @Override
  public void relocateObjectFromLastScreenToAnother(Screen newScreen, LoadableObject object) {
    
    newScreen.getLoadableObjects().add(object);
    getLastLoadableObjects().remove(object);
    
  }
  
  public void update(float deltaTime) {
    
    for(int index = 0; index < gameObjects.size(); index++) {
      
      gameObjects.get(index).update(deltaTime);
      
    }
    
    if(getCurrentScreen() == Constants.SCREEN_14) {
      
      checkIfThereIsAChaliceInYellowCastle();
      
    }
    
  }
  
  public void render() {
    
    game.getShapeRenderer().begin(ShapeRenderer.ShapeType.Filled);
    
    for(int index = 0; index < gameObjects.size(); index++) {
      
      gameObjects.get(index).render(game.getShapeRenderer());
      
    }
    
    game.getShapeRenderer().end();
    
    game.getSpriteBatch().begin();
    
    for(int index = 0; index < gameObjects.size(); index++) {
      
      gameObjects.get(index).render(game.getSpriteBatch());
      
    }
    
    game.getSpriteBatch().end();
    
  }
  
  public void checkCollisions() {
    
    for(int index = 0; index < gameObjects.size(); index++) {
      
      collisors.addAll(gameObjects.get(index).getCollisors());
      
    }
    
    for(int index_1 = 0; index_1 < gameObjects.size(); index_1++) {
      
      for(int index_2 = 0; index_2 < collisors.size(); index_2++) {
        
        gameObjects.get(index_1).checkCollision(collisors.get(index_2));
        
      }
      
    }
    
    collisors.clear();
    
  }
  
  public void checkIfThereIsAChaliceInYellowCastle() {
    
    for(int index = 0; index < gameObjects.size(); index++) {
      
      if(gameObjects.get(index).getId().equals("Chalice") == true) {
        
        game.setIsRunning(false);
        
      }
      
    }
    
  }
  
}