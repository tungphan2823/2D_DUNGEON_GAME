package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static utilz.movingStep.directions.*;
public class gameInput implements KeyListener{
    private gamePanel gamePanel;
    public gameInput(gamePanel gamePanel){
    this.gamePanel = gamePanel;
    };

    @Override
    public void keyPressed(KeyEvent arg0) {
        switch(gamestate.state){
            case MENU:
            gamePanel.getGame().getMenu().keyPressed(arg0);
                break;
            case PLAYING:
            gamePanel.getGame().getPlaying().keyPressed(arg0);
                break;
            default:
                break;}
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        switch(gamestate.state){
            case MENU:
            gamePanel.getGame().getMenu().keyReleased(arg0);
                break;
            case PLAYING:
            gamePanel.getGame().getPlaying().keyReleased(arg0);
                break;
            default:
                break;}
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }
    
}
