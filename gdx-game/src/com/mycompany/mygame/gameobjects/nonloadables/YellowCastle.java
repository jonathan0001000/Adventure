package com.mycompany.mygame.gameobjects.nonloadables;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.gameobjects.NonLoadableObject;

public final class YellowCastle extends NonLoadableObject {
  
  private Texture texture;
  
  private float x;
  private float y;
  
  public YellowCastle(float x, float y) {
    
    this.id = "YellowCastle";
    
    this.texture = new Texture(Gdx.files.internal("images/YellowCastle.png"));
    
    this.x = x;
    this.y = y;
    
    this.collisors = new ArrayList <Collisor>();
    
  }
  
  // Main Methods //
  
  @Override
  public void render(SpriteBatch spriteBatch) {
    
    spriteBatch.draw(texture, x, y);
    
  }
  
}