package com.mycompany.mygame.animations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public final class GateAnimations {
  
  private Animation opening;
  
  public GateAnimations() {
    
    // Textures //
    
    Texture gate_sheet = new Texture(Gdx.files.internal("images/Gate_Sheet.png"));
    
    // TextureRegions //
    
    TextureRegion[] opening_frames = new TextureRegion[7];
    
    int WIDTH = gate_sheet.getWidth() / 7;
    int HEIGHT = gate_sheet.getHeight();
    
    for(int i = 0; i < 7; i++) {
      
      opening_frames[i] = new TextureRegion(gate_sheet, i * WIDTH, 0, WIDTH, HEIGHT);
      
    }
    
    // Animations //
    
    this.opening = new Animation(0.1f, opening_frames);
    
  }
  
  // Getters //
  
  public Animation getOpening() {
    
    return this.opening;
  }
  
}