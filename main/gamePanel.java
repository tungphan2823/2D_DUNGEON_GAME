package main;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Dimension;
public class gamePanel extends JPanel  {
   private game game;
    public gamePanel(game game){
        this.game =game;
    setPanelSize();
    addKeyListener(new gameInput(this));
    }

    private void setPanelSize(){
        
        Dimension size =    new Dimension(game.GAME_WIDTH,game.GAME_HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    };


    public void gameUpdate(){
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }
    public game getGame(){
        return game;
    }
}
