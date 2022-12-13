package ui;
import java.awt.Graphics;
import main.gamestate;
import java.awt.Rectangle;

import java.awt.image.BufferedImage;
import main.gameSave;
import static utilz.movingStep.UI.Buttons.*;
public class menuButton {
    private int xOffCenter=BUTTON_WIDTH/2;
    private int xPos,yPos,rowIndex,index;
    private gamestate state;
    private BufferedImage[] imgs;
    private boolean mouseHover, mousePressed;
    private Rectangle bounds;
    public menuButton(int xPos,int yPos,int rowIndex,gamestate state){
        this.xPos=xPos;
        this.yPos=yPos;
        this.rowIndex=rowIndex;
        this.state = state;
        loadImgs();
        initBound();
    }
    private void initBound() {
        bounds = new Rectangle(xPos-xOffCenter,yPos,BUTTON_WIDTH,BUTTON_HEIGHT);
    }
    private void loadImgs() {
        imgs = new BufferedImage[3];
        BufferedImage temp = gameSave.getCo(gameSave.MENU_BUTTONS);
        for(int i=0;i<imgs.length;i++){
            imgs[i]=temp.getSubimage(i*BUTTON_WIDTH_D, rowIndex*BUTTON_HEIGHT_D, BUTTON_WIDTH_D, BUTTON_HEIGHT_D);
    }
    }
    public void draw(Graphics g){
        g.drawImage(imgs[index],xPos-xOffCenter,yPos,BUTTON_WIDTH,BUTTON_HEIGHT, null);
    }
    public void update(){
        index = 0;
        if(mouseHover)
            index =1;
        if(mousePressed)
            index =2;
    }
    public boolean isMouseHover() {
        return mouseHover;
    }
    public void setMouseHover(boolean mouseHover) {
        this.mouseHover = mouseHover;
    }
    public boolean isMousePressed() {
        return mousePressed;
    }
    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void applyGameState(){
        gamestate.state=state;

    }
    public void resetBools(){
        mouseHover = false;
        mousePressed = false;
    }


}
