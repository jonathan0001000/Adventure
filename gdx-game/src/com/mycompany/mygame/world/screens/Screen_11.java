package com.mycompany.mygame.world.screens;

import java.util.ArrayList;

import com.mycompany.mygame.Constants;
import com.mycompany.mygame.utils.Color;
import com.mycompany.mygame.world.WorldInterface;
import com.mycompany.mygame.gameobjects.NonLoadableObject;
import com.mycompany.mygame.gameobjects.LoadableObject;
import com.mycompany.mygame.gameobjects.nonloadables.Block;
import com.mycompany.mygame.gameobjects.nonloadables.Border;
import com.mycompany.mygame.gameobjects.nonloadables.BottomEntrance;
import com.mycompany.mygame.gameobjects.loadables.items.Chalice;

public final class Screen_11 extends Screen {
  
  private final int[][] objectsInScreen = {
      
    {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},//1
    {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},//2
    {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},//3
    {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},//4
    {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},//5
    {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},//6
    {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},//7
    {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},//8
    {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},//9
    {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},//10
    {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},//11
    {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2},//12
    {2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2},//13
    {0, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 0}//14
    
  };
  
  public Screen_11() {
    
    this.color = Constants.PURPLE;
    
  }
  
  // Main Methods //
  
  @Override
  public void createLoadableObjects(WorldInterface worldInterface) {
    
    this.loadableObjects = new ArrayList <LoadableObject>();
    
    loadableObjects.add(worldInterface.getPlayer());
    loadableObjects.add(new Chalice(Constants.WORLDX + 112, Constants.WORLDY - 160));
    
  }
  
  @Override
  public ArrayList <NonLoadableObject> createNonLoadableObjects() {
    
    ArrayList <NonLoadableObject> nonLoadableObjects = new ArrayList <NonLoadableObject>();
    
    for(int listY = 0; listY < Constants.NUMBER_OF_BLOCKS_VERTICALLY; listY++) {
      
      for(int listX = 0; listX < Constants.NUMBER_OF_BLOCKS_HORIZONTALLY; listX++) {
        
        float x = Constants.WORLDX + (listX * Constants.OFFSET);
        float y = Constants.WORLDY - (listY * Constants.OFFSET);
        
        switch(objectsInScreen[listY][listX]) {
          
          case BLOCK:
            
            nonLoadableObjects.add(new Block(color, x, y));
            break;
            
          case BORDER:
            
            nonLoadableObjects.add(new Border(x, y));
            break;
          
          case BOTTOM_ENTRANCE:
            
            nonLoadableObjects.add(new BottomEntrance(x, y, Constants.SCREEN_10));
            break;
          
        }
        
      }
      
    }
    
    return nonLoadableObjects;
  }
  
}