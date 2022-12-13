package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class playing extends state implements statemethod{
    private player player;
  private handler handler;

  public playing(game game) {
		initClasses();
}
private void initClasses(){ 
    handler = new handler(game);
    player = new player(200,200,(int) (52 * game.SCALE), (int) (35 * game.SCALE));
    player.loadLvlData(handler.getCurrLevel().getData());
  }
 
@Override
public void update() {
    // TODO Auto-generated method stub
    handler.update();
    player.update();
    
}
@Override
public void draw(Graphics g) {
    // TODO Auto-generated method stub
    handler.draw(g);
    player.render(g);
}
@Override
public void keyPressed(KeyEvent arg0) {
    // TODO Auto-generated method stub
    switch(arg0.getKeyCode()){
        case 65:player.setLeft(true);
        break;//A
        case 87:player.setUp(true);
        break;//W   
        case 83: player.setDown(true);
        break;//s
        case 68://D
        player.setRight(true);
            break;
        case 32://space
        player.setJump(true);
            break; 
        case 27://space
            gamestate.state = gamestate.MENU;
                break;  
    }
    
}
@Override
public void keyReleased(KeyEvent arg0) {
    // TODO Auto-generated method stub
    switch(arg0.getKeyCode()){
        case 65:player.setLeft(false);
        break;//A
        case 87:player.setUp(false);
        break;//W   
        case 83: player.setDown(false);
        break;//s
        case 68://D
        player.setRight(false);
            break;
        case 32://space
        player.setJump(false);
                break;  
        
    }
    
}
@Override
public void keyTyped(KeyEvent arg0) {
    // TODO Auto-generated method stub
    
}
public player getPlayer(){
    return player;
  }
}
