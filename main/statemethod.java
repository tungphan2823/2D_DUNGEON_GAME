package main;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
public interface statemethod {
    public void update();
    public void draw(Graphics g);
    public void keyPressed(KeyEvent arg0);
    public void keyReleased(KeyEvent arg0);
    public void keyTyped(KeyEvent arg0);

}
