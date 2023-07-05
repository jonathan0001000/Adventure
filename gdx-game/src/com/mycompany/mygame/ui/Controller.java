package com.mycompany.mygame.ui;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.mycompany.mygame.Constants;

public final class Controller {
  
  private final int NO_POINT = -1;
  private final int SIZE = 64;
  private final int OFFSET = SIZE / 4;
  
  private ArrayList <Rectangle> points;
  
  private Button upButton;
  private Button downButton;
  private Button rightButton;
  private Button leftButton;
  private Button actionButton;
  private Button resetButton;
  
  private ShapeRenderer shapeRenderer;
  
  public Controller() {
    
    this.points = new ArrayList <Rectangle>();
    points.add(0, new Rectangle());
    points.add(1, new Rectangle());
    points.add(2, new Rectangle());
    points.add(3, new Rectangle());
    points.add(4, new Rectangle());
    
    float upButtonX = getAOffset(1);
    float upButtonY = getAOffset(2);
    this.upButton = new Button(upButtonX, upButtonY, SIZE);
    
    float downButtonX = getAOffset(1);
    float downButtonY = getAOffset(0);
    this.downButton = new Button(downButtonX, downButtonY, SIZE);
    
    float rightButtonX = getAOffset(2);
    float rightButtonY = getAOffset(1);
    this.rightButton = new Button(rightButtonX, rightButtonY, SIZE);
    
    float leftButtonX = getAOffset(0);
    float leftButtonY = getAOffset(1);
    this.leftButton = new Button(leftButtonX, leftButtonY, SIZE);
    
    float actionButtonX = Gdx.graphics.getWidth() - getAOffset(2);
    float actionButtonY = getAOffset(1);
    this.actionButton = new Button(actionButtonX, actionButtonY, SIZE);
    
    float resetButtonX = Constants.HALF_THE_WIDTH - (SIZE / 2);
    float resetButtonY = getAOffset(0);
    this.resetButton = new Button(resetButtonX, resetButtonY, SIZE);
    
    this.shapeRenderer = new ShapeRenderer();
    
  }
  
  // Getters //
  
  public float getAOffset(int index) {
    
    return OFFSET + ((SIZE + OFFSET) * index);
  }
  
  public Rectangle getPoints(int pointIndex) {
    
    return points.get(pointIndex);
  }
  
  // Main Methods //
  
  public void render() {
    
    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
    
    upButton.render(shapeRenderer);
    downButton.render(shapeRenderer);
    rightButton.render(shapeRenderer);
    leftButton.render(shapeRenderer);
    actionButton.render(shapeRenderer);
    resetButton.render(shapeRenderer);
    
    shapeRenderer.end();
    
  }
  
  public void touchDown(int pointIndex) {
    
    float x = Gdx.input.getX(pointIndex) - (SIZE / 2);
    float y = (Gdx.graphics.getHeight() - Gdx.input.getY(pointIndex)) - (SIZE / 2);
    
    getPoints(pointIndex).set(x, y, SIZE, SIZE);
    
  }
  
  public void touchUp(int pointIndex) {
    
    getPoints(pointIndex).set(0, 0, 0, 0);
    
    if(actionButton.getPoint() == pointIndex) {
      
      actionButton.setPoint(NO_POINT);
      
    }
    
    if(resetButton.getPoint() == pointIndex) {
      
      resetButton.setPoint(NO_POINT);
      
    }
    
  }
  
  public boolean upButtonIsTouched(int pointIndex) {
    
    return buttonIsTouched(pointIndex, upButton);
  }
  
  public boolean downButtonIsTouched(int pointIndex) {
    
    return buttonIsTouched(pointIndex, downButton);
  }
  
  public boolean rightButtonIsTouched(int pointIndex) {
    
    return buttonIsTouched(pointIndex, rightButton);
  }
  
  public boolean leftButtonIsTouched(int pointIndex) {
    
    return buttonIsTouched(pointIndex, leftButton);
  }
  
  public boolean actionButtonJustTouched(int pointIndex) {
    
    return buttonJustTouched(pointIndex, actionButton);
  }
  
  public boolean resetButtonJustTouched(int pointIndex) {
    
    return buttonJustTouched(pointIndex, resetButton);
  }
  
  public boolean buttonIsTouched(int pointIndex, Button button) {
    
    return getPoints(pointIndex).overlaps(button.getRect());
  }
  
  public boolean buttonJustTouched(int pointIndex, Button button) {
    
    if(button.getPoint() == NO_POINT) {
      
      if(getPoints(pointIndex).overlaps(button.getRect()) == true) {
        
        button.setPoint(pointIndex);
        
        return true;
      }
      
    }
    
    return false;
  }
  
  public void dispose() {
    
    shapeRenderer.dispose();
    
  }
  
}