package com.mycompany.mygame.animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public final class ChaliceAnimations {
  
  private Animation shining;
  
  public ChaliceAnimations() {
    
    // Textures //
    
    Texture chalice_sheet = new Texture(Gdx.files.internal("images/Chalice_Sheet.png"));
    
    // TextureRegions //
    
    TextureRegion[] shining_frames = new TextureRegion[2];
    
    int WIDTH = chalice_sheet.getWidth() / 2;
    int HEIGHT = chalice_sheet.getHeight();
    
    for(int i = 0; i < 2; i++) {
      
      shining_frames[i] = new TextureRegion(chalice_sheet, i * WIDTH, 0, WIDTH, HEIGHT);
      
    }
    
    // Animations //
    
    this.shining = new Animation(0.05f, shining_frames);
    
  }
  
  // Getters //
  
  public Animation getShining() {
    
    return this.shining;
  }
  
}