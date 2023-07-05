package com.mycompany.mygame.world.screens;

import java.util.ArrayList;

import com.mycompany.mygame.Constants;
import com.mycompany.mygame.utils.Color;
import com.mycompany.mygame.world.WorldInterface;
import com.mycompany.mygame.gameobjects.NonLoadableObject;
import com.mycompany.mygame.gameobjects.LoadableObject;
import com.mycompany.mygame.gameobjects.nonloadables.Block;
import com.mycompany.mygame.gameobjects.nonloadables.Border;
import com.mycompany.mygame.gameobjects.nonloadables.TopEntrance;
import com.mycompany.mygame.gameobjects.nonloadables.BottomEntrance;
import com.mycompany.mygame.gameobjects.nonloadables.RightEntrance;
import com.mycompany.mygame.gameobjects.nonloadables.LeftEntrance;

public final class Screen_5 extends Screen {
  
  private final int[][] objectsInScreen = {
      
    {0, 2, 2, 2, 2, 3, 2, 3, 2, 3, 2, 2, 3, 2, 3, 2, 3, 2, 2, 2, 2, 0},//1
    {2, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 2},//2
    {6, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 5},//3
    {6, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 5},//4
    {2, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 2},//5
    {2, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 2},//6
    {6, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 5},//7
    {6, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 5},//8
    {2, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 2},//9
    {2, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 2},//10
    {6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},//11
    {6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},//12
    {2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2},//13
    {0, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 0}//14
      
  };
  
  public Screen_5() {
    
    this.color = Constants.BLUE;
    
  }
    
  // Main Methods //
  
  @Override
  public void createLoadableObjects(WorldInterface worldInterface) {
    
    this.loadableObjects = new ArrayList <LoadableObject>();
    
    loadableObjects.add(worldInterface.getPlayer());
    
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
            
          case TOP_ENTRANCE:
            
            nonLoadableObjects.add(new TopEntrance(x, y, Constants.SCREEN_13));
            break;
            
          case BOTTOM_ENTRANCE:
            
            nonLoadableObjects.add(new BottomEntrance(x, y, Constants.SCREEN_3));
            break;
          
          case RIGHT_ENTRANCE:
            
            nonLoadableObjects.add(new RightEntrance(x, y, Constants.SCREEN_7));
            break;
            
          case LEFT_ENTRANCE:
            
            nonLoadableObjects.add(new LeftEntrance(x, y, Constants.SCREEN_7));
            break;
            
        }
        
      }
      
    }
    
    return nonLoadableObjects;
  }
  
}