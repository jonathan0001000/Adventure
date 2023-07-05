package com.mycompany.mygame;

import com.badlogic.gdx.Gdx;

import com.mycompany.mygame.utils.Color;
import com.mycompany.mygame.world.screens.Screen;
import com.mycompany.mygame.world.screens.Screen_1;
import com.mycompany.mygame.world.screens.Screen_2;
import com.mycompany.mygame.world.screens.Screen_3;
import com.mycompany.mygame.world.screens.Screen_4;
import com.mycompany.mygame.world.screens.Screen_5;
import com.mycompany.mygame.world.screens.Screen_6;
import com.mycompany.mygame.world.screens.Screen_7;
import com.mycompany.mygame.world.screens.Screen_8;
import com.mycompany.mygame.world.screens.Screen_9;
import com.mycompany.mygame.world.screens.Screen_10;
import com.mycompany.mygame.world.screens.Screen_11;
import com.mycompany.mygame.world.screens.Screen_12;
import com.mycompany.mygame.world.screens.Screen_13;
import com.mycompany.mygame.world.screens.Screen_14;

public abstract class Constants {
  
  public static final Color YELLOW = new Color((211f / 255), (211f / 255), (63f / 255), 1);
  public static final Color GREEN_1 = new Color((95f / 255), (187f / 255), (95f / 255), 1);
  public static final Color GREEN_2 = new Color((136f / 255), (184f / 255), (95f / 255), 1);
  public static final Color GREEN_3 = new Color((161f / 255), (172f / 255), (78f / 255), 1);
  public static final Color BLUE = new Color((64f / 255), (77f / 255), (201f / 255), 1);
  public static final Color BROWN = new Color((199f / 255), (108f / 255), (63f / 255), 1);
  public static final Color BLACK = new Color(0f, 0f, 0f, 1);
  public static final Color PURPLE = new Color((147f / 255), (77f / 255), (193f / 255), 1);
  
  public static final float HALF_THE_WIDTH = (Gdx.graphics.getWidth() / 2);
  public static final float HALF_THE_HEIGHT = (Gdx.graphics.getHeight() / 2);
  
  public static final int NUMBER_OF_BLOCKS_HORIZONTALLY = 22;
  public static final int NUMBER_OF_BLOCKS_VERTICALLY = 14;
  public static final int OFFSET = 16;
  public static final int WORLDWIDTH = NUMBER_OF_BLOCKS_HORIZONTALLY * OFFSET;
  public static final int WORLDHEIGHT = NUMBER_OF_BLOCKS_VERTICALLY * OFFSET;
  public static final float WORLDX = HALF_THE_WIDTH - (WORLDWIDTH / 2);
  public static final float WORLDY = HALF_THE_HEIGHT + (WORLDHEIGHT / 2) - OFFSET;
  
  public static final Screen SCREEN_1 = new Screen_1();
  public static final Screen SCREEN_2 = new Screen_2();
  public static final Screen SCREEN_3 = new Screen_3();
  public static final Screen SCREEN_4 = new Screen_4();
  public static final Screen SCREEN_5 = new Screen_5();
  public static final Screen SCREEN_6 = new Screen_6();
  public static final Screen SCREEN_7 = new Screen_7();
  public static final Screen SCREEN_8 = new Screen_8();
  public static final Screen SCREEN_9 = new Screen_9();
  public static final Screen SCREEN_10 = new Screen_10();
  public static final Screen SCREEN_11 = new Screen_11();
  public static final Screen SCREEN_12 = new Screen_12();
  public static final Screen SCREEN_13 = new Screen_13();
  public static final Screen SCREEN_14 = new Screen_14();
  
}