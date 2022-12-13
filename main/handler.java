package main;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class handler {
    private game game;
    private BufferedImage backgroundImg;
    private level dungeonLevel;
    private BufferedImage[] levelSprites;
    public handler(game game){
       this.game = game;
        backgroundImg= gameSave.getCo(gameSave.BACK_GROUND);
        //levelSprites = gameSave.getCo(gameSave.lAtlas);
        importDungeon();
        dungeonLevel = new level(gameSave.getData());
    }
    private void importDungeon() {
        BufferedImage img =gameSave.getCo(gameSave.lAtlas);
        levelSprites = new BufferedImage[48];
        for (int j= 0; j<4;j++)
            for(int i = 0; i< 12; i++){
                int index = j*12+i;
                levelSprites[index] = img.getSubimage(i*32, j*32, 32, 32);
            }
    }
    public void draw(Graphics g){
        g.drawImage(backgroundImg, 0, 0,game.GAME_WIDTH, game.GAME_HEIGHT,null);

        for(int j = 0; j<game.TILES_HEIGHT; j++)
            for(int i =0;i<game.TILES_WIDTH;i++){
                int index = dungeonLevel.getIndex(i,j);
                g.drawImage(levelSprites[index], game.TILES_RESIZE*i,game.TILES_RESIZE*j, game.TILES_RESIZE,game.TILES_RESIZE, null);
            }


        
    }
    public void update() {
    }
    public level getCurrLevel(){
        return dungeonLevel;
    }
}
