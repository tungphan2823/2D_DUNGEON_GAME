package main;
import java.awt.image.BufferedImage;

import ui.menuButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
public class menu extends state implements statemethod{
    private menuButton[] buttons = new menuButton[2];
    private BufferedImage backgroundImg;
    private int menuX,menuY,menuWidth,menuHeight;
    public menu(main.game game) {
        loadButtons();
        loadBackgroundImg();
    }

    private void loadBackgroundImg() {
        backgroundImg = gameSave.getCo(gameSave.MENU_BACKGROUND);
        // menuWidth = (int)(backgroundImg.getWidth()*game.SCALE);
        // menuHeight=(int)(backgroundImg.getHeight()*game.SCALE);
        
    }

    private void loadButtons() {
        buttons[0] = new menuButton(game.GAME_WIDTH/2,(int)(150*game.SCALE),0,gamestate.PLAYING);
        buttons[1] = new menuButton(game.GAME_WIDTH/2,(int)(220*game.SCALE),1,gamestate.OPTIONS);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        for(menuButton mb: buttons)
            mb.update();
    }

    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        // g.setColor(Color.BLACK);
        // g.drawString("MENU", game.GAME_WIDTH/2, 200);
        g.drawImage(backgroundImg, 0,0,game.GAME_WIDTH, game.GAME_HEIGHT, null);
        for(menuButton mb: buttons)
            mb.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        if (arg0.getKeyCode() == 27)
            gamestate.state=gamestate.QUIT;
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        if (arg0.getKeyCode() == 10)
            gamestate.state=gamestate.PLAYING;
       
        }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
}
