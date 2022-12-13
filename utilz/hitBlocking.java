package utilz;
import java.awt.geom.RectangularShape;
import java.awt.geom.Rectangle2D;

import main.game;

public class hitBlocking {
    public static boolean moveable(float x, float y,float width, float height,int[][] lvlData) {
        if(!checkConner(x, y, lvlData))
            if(!checkConner(x+width, y+height, lvlData))
                if(!checkConner(x+width, y, lvlData))
                    if(!checkConner(x, y+height, lvlData))
                        return true;
        return false;
    }
    public static boolean checkConner(float x, float y,int[][] lvlData){
        if(x < 0 || x>=game.GAME_WIDTH)
            return true;
        if(y<0 || y>= game.GAME_HEIGHT)
            return true;
        float xIndex = x / game.TILES_RESIZE;
        float yIndex = y / game.TILES_RESIZE;

        int value =lvlData[(int) yIndex][(int) xIndex];
        if(value >= 48 || value <0|| value !=11)
            return true;
        return false;
    } 
    public static float getEntityXgoAround(Rectangle2D.Float hitBox, float xSpeed){
        int currentTile=(int)(hitBox.x/game.TILES_RESIZE);
        if(xSpeed>0){
            //right 
            int tilesXgoAround = currentTile *game.TILES_RESIZE;
            int xOffset = (int)(game.TILES_RESIZE - hitBox.width);
            return tilesXgoAround + xOffset -1;
        }else{
            //left
        return currentTile *game.TILES_RESIZE;
        }

    }
    public static float getEntityYgoAround(Rectangle2D.Float hitBox, float airSpeed){
        int currentTile=(int)(hitBox.y/game.TILES_RESIZE);
        if(airSpeed > 0 ){
            //falling
            int tileYgoAround = currentTile *game.TILES_RESIZE;
            int yOffset = (int)(game.TILES_RESIZE - hitBox.height);
            return tileYgoAround + yOffset -1 ;
        }else{
            //jump
            return currentTile *game.TILES_RESIZE;
        }

    }
    public static boolean onFloor(Rectangle2D.Float hitBox,int[][] lvlData ){
        if(!checkConner(hitBox.x, hitBox.y+hitBox.height+1, lvlData))
            if(!checkConner(hitBox.x+hitBox.width, hitBox.y+hitBox.height+1, lvlData))
                return false;
        return true;
    }


}

