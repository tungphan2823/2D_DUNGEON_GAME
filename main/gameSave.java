package main;

import java.awt.Color;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
public class gameSave {
    public static final String pAtlas = "/res/character2.png";
    public static final String lAtlas = "/res/dungeon.png";
    public static final String LEVEL_ONE_DATA = "/res/test.png";
    public static final String BACK_GROUND = "/res/background2.png";
    public static final String MENU_BUTTONS = "/res/menuButton.png";
    public static final String MENU_BACKGROUND = "/res/menu.jpg";
    public static BufferedImage getCo(String fileName){
        BufferedImage img = null;
        InputStream is = gameSave.class.getResourceAsStream(fileName);
        
        try {
            img = ImageIO.read(is);
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return img;
    }
    public static int[][] getData(){
        int[][] lvlData = new int[game.TILES_HEIGHT][game.TILES_WIDTH];
        BufferedImage img = getCo(LEVEL_ONE_DATA);
        
        for(int j= 0; j< img.getHeight(); j++)
            for (int i = 0; i< img.getWidth();i++){
                Color color = new Color(img.getRGB(i,j));
                int value1  = color.getRed();
                int value2 = color.getGreen();
                int value3 = color.getBlue();
                if(value1 >=48)
                    value1=0;
                lvlData[j][i] = value1;
            }
            
            return lvlData;
    }

}
