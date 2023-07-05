package com.mycompany.mygame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mycompany.mygame.world.World;
import com.mycompany.mygame.ui.Controller;
import com.mycompany.mygame.gameobjects.loadables.Player;

public class MyGdxGame extends ApplicationAdapter {
  
  private ShapeRenderer shapeRenderer;
  private SpriteBatch spriteBatch;
  
  private OrthographicCamera camera;
  
  private World world;
  
  private Player player;
  
  private Controller controller;
  
  private boolean isRunning;
  
  // Setters //
  
  public void setIsRunning(boolean isRunning) {
    
    this.isRunning = isRunning;
    
  }
  
  // Getters //
  
  public ShapeRenderer getShapeRenderer() {
    
    return this.shapeRenderer;
  }
  
  public SpriteBatch getSpriteBatch() {
    
    return this.spriteBatch;
  }
  
  public boolean getIsRunning() {
    
    return this.isRunning;
  }
  
  // Main Methods //
  
  @Override
  public void create() {
    
    this.shapeRenderer = new ShapeRenderer();
    this.spriteBatch = new SpriteBatch();
    
    this.camera = new OrthographicCamera(320, 192);
    camera.position.set(Constants.HALF_THE_WIDTH, Constants.HALF_THE_HEIGHT, 0f);
    
    this.world = new World(this);
    this.player = world.getPlayer();
    
    this.controller = new Controller();
    
    this.isRunning = true;
    
  }
  
  @Override
  public void render() {
    
    Gdx.gl.glClearColor((171f / 255), (171f / 255), (171f / 255), 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    
    camera.update();
    
    getShapeRenderer().setProjectionMatrix(camera.combined);
    getSpriteBatch().setProjectionMatrix(camera.combined);
    
    if(getIsRunning() == true) {
      
      world.update(Gdx.graphics.getDeltaTime());
      world.checkCollisions();
      
    }
    
    world.render();
    controller.render();
    
    events();
    
  }
  
  public void events() {
    
    for(int pointIndex = 0; pointIndex < 5; pointIndex++) {
      
      if(Gdx.input.isTouched(pointIndex) == true) {
        
        controller.touchDown(pointIndex);
        
        if(controller.upButtonIsTouched(pointIndex) == true) {
      
          player.walkUp();
      
        }
    
        else if(controller.downButtonIsTouched(pointIndex) == true) {
      
          player.walkDown();
      
        }
    
        else if(controller.rightButtonIsTouched(pointIndex) == true) {
      
          player.walkRight();
      
        }
    
        else if(controller.leftButtonIsTouched(pointIndex) == true) {
      
          player.walkLeft();
          
        }
        
        else if(controller.actionButtonJustTouched(pointIndex) == true) {
          
          player.requestToDropItem();
          
        }
        
        else if(controller.resetButtonJustTouched(pointIndex) == true) {
          
          dispose();
          create();
          
        }
        
      }
      
      else if(Gdx.input.isTouched(pointIndex) == false) {
        
        controller.touchUp(pointIndex);
        
      }
      
    }
    
  }
  
  @Override
  public void dispose() {
    
    getShapeRenderer().dispose();
    getSpriteBatch().dispose();
    controller.dispose();
    
  }
  
}