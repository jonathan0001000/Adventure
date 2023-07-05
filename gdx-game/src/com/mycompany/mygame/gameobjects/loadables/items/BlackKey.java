package com.mycompany.mygame.gameobjects.loadables.items;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import com.mycompany.mygame.utils.Collisor;
import com.mycompany.mygame.utils.Rectangle;

public final class BlackKey extends Item {
  
  public BlackKey(float x, float y) {
    
    this.id = "BlackKey";
    
    this.texture = new Texture(Gdx.files.internal("images/BlackKey.png"));
    
    this.collisors = new ArrayList <Collisor>();
    
    this.collecterRect = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    collisors.add(new Collisor("Collecter", collecterRect, this));
    
    this.xOffset = 0f;
    this.yOffset = 0f;
    
    this.state = "Dropped";
    
  }
  
}