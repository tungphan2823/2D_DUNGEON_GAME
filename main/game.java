package main;
import java.awt.Graphics;
public class game implements Runnable {
  private gameWindow gameWindow;
  private playing playing;
  private menu menu;
  private gamePanel gamePanel;
  private Thread gameThread;
  private final int FPS = 180;
  private final int UPS = 180;
  public final static int TILES_SIZE = 32;  
  public final static float SCALE = 2f;
  public final static int TILES_HEIGHT = 14;
  public final static int TILES_WIDTH = 26;
  public final static int TILES_RESIZE = (int) (TILES_SIZE*SCALE);
  public final static int GAME_WIDTH = TILES_RESIZE * TILES_WIDTH;
  public final static int GAME_HEIGHT = TILES_RESIZE * TILES_HEIGHT;
  
  
  private double deltaUpdate = 0;
  private double deltaFrame = 0;
  private int frames = 0;
  private long lastCheck = 0;
  public game(){
    initClasses();
    gamePanel = new gamePanel(this);//go first 
    gameWindow = new gameWindow(gamePanel);
    gamePanel.requestFocus();
    
    
    gameStart();
  }
  private void initClasses(){ 
    menu = new menu(this);
    playing = new playing(this);
  }
  private void gameStart(){
    gameThread = new Thread(this);
    gameThread.start();
  }
  public void update(){
   
    switch(gamestate.state){
      case MENU:
      menu.update();
        break;
      case PLAYING:
       playing.update();
        break;
      case QUIT:
      default:
        System.exit(0);
        break;

    }
  }

  public void render(Graphics g){
    switch(gamestate.state){
      case MENU:
      menu.draw(g);
        break;
      case PLAYING:
      playing.draw(g);
        break;
      default:
        break;

    }
  }

@Override
public void run() {
    // TODO Auto-generated method stub
    
    double timePerFrame = 1000000000 /FPS;
    double timePerUpdate = 1000000000 /UPS;
    long lastTime = System.nanoTime();
    
    while(true){
        long currentTime = System.nanoTime();
        deltaUpdate +=(currentTime - lastTime)/timePerUpdate;
        deltaFrame +=(currentTime - lastTime)/timePerFrame;
        lastTime = currentTime;
        if(deltaUpdate >=1){
          update();
          deltaUpdate--;

        }
        if (deltaFrame  >=1){
          gamePanel.repaint();
          deltaFrame--;
          frames++;
        }

        if(System.currentTimeMillis()- lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("fps: " + frames);
            frames  = 0;
        }
    }
  }
 public menu getMenu(){
  return menu;

 }
 public playing getPlaying(){
  return playing;
 }
}
