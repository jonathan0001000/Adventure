package com.mycompany.mygame.world;

import java.util.ArrayList;

import com.mycompany.mygame.utils.Color;
import com.mycompany.mygame.gameobjects.LoadableObject;
import com.mycompany.mygame.gameobjects.loadables.Player;
import com.mycompany.mygame.world.screens.Screen;

public interface WorldInterface {
  
  // Getters //
  
  public abstract Player getPlayer();
  public abstract Color getColor();
  public abstract Screen getCurrentScreen();
  public abstract Screen getLastScreen();
  public abstract ArrayList <LoadableObject> getCurrentLoadableObjects();
  public abstract ArrayList <LoadableObject> getLastLoadableObjects();
  
  // Main Methods //
  
  public abstract void beginCreateScreen(Screen nextScreen);
  public abstract void middleCreateScreen();
  public abstract void endCreateScreen();
  public abstract void relocateObjectFromCurrentScreenToAnother(Screen newScreen, LoadableObject object);
  public abstract void relocateObjectFromLastScreenToAnother(Screen newScreen, LoadableObject object);
  
}