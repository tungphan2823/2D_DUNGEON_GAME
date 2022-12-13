package main;
import static utilz.movingStep.playerMovingStep.*;
import static utilz.hitBlocking.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.lang.reflect.WildcardType;
public class player extends entity{
    private BufferedImage[][] allAnimations;
    private int animaSpeed=25, animaTick, animaIndex;
    private int action = STAND;
    private boolean left, up,right,down,jump;
    private float speed = 2.0f;
    private int[][] lvlData;
    private boolean moving=false;
    private float xDraw = 21 * game.SCALE;
    private float yDraw = 4 * game.SCALE;

    private float airSpeed = 0.0f;
    private float gravity = 0.04f * game.SCALE;
    private float jumpSpeed = -2.25f * game.SCALE;
    private float fallSpeed= 0.5f * game.SCALE;
    private boolean inAir = false;

    public player(float x, float y,int width, int height) {
        
        super(x, y,width,height);
        loadAnimation();
        initHitbox(x, y,20* game.SCALE,27* game.SCALE);
        //TODO Auto-generated constructor stub
    }
    public void update(){
        animationLoop();
        animationTick();
        goAround();
    };
    public void render(Graphics g){
        g.drawImage(allAnimations[action][animaIndex],(int)(hitBox.x-xDraw),(int)(hitBox.y-yDraw),width,height,null);//draw
        //drawHitBox(g);
    };
    
    private void animationTick(){
        if(moving)
            action = RUNNING;
        else 
            action = STAND;
            
    }

    private void animationLoop(){
        animaTick++;
        if(animaTick >= animaSpeed){
            animaTick=0;//reset
            animaIndex++;
            if(animaIndex >=  getNumbers(action))
                animaIndex = 0;// change by the number of image =v 
        }
    }
    private void goAround(){
        moving = false;
        if(jump)
            jump();
        if(!left && !right && !inAir)
            return;

        float xSpeed = 0;

        if(left ){
        xSpeed-=speed;
        
       } if(right ){
        xSpeed+=speed;
        
       }
       if (!inAir){
        if(!onFloor(hitBox,lvlData)){
            inAir = true;
        }
       }
       if(inAir){
        if(moveable(hitBox.x, hitBox.y+ airSpeed, hitBox.width, hitBox.height, lvlData)){
            hitBox.y+=airSpeed;
            airSpeed+=gravity;
            updateXgoAround(xSpeed);
        }else{
            hitBox.y= getEntityYgoAround(hitBox, airSpeed);
            if(airSpeed > 0){
                resetInAir();
            }else 
                airSpeed = fallSpeed;
            updateXgoAround(xSpeed);
            
        }
       }else 
            updateXgoAround(xSpeed);
        moving = true;

    }
    private void jump() {
        if(inAir)
            return;
        inAir = true;
        airSpeed = jumpSpeed;
    }
    private void resetInAir() {
        inAir = false;
        airSpeed = 0;
    }
    private void updateXgoAround(float xSpeed) {
        if(moveable(hitBox.x+xSpeed, hitBox.y,hitBox.width, hitBox.height,lvlData)){
                   hitBox.x += xSpeed;
            }else{
              hitBox.x= getEntityXgoAround(hitBox,xSpeed) ;
            }
    }
    private void loadAnimation(){  
            BufferedImage img = gameSave.getCo(gameSave.pAtlas);
            allAnimations = new BufferedImage[4][6];
            for(int j= 0; j< allAnimations.length; j++)
                for(int i = 0; i<allAnimations.length;i++)allAnimations[j][i] = img.getSubimage(i*65, j*52, 65, 52);
    }
    public void loadLvlData(int[][] lvlData){
        this.lvlData = lvlData;
    }
    public boolean isLeft() {
        return left;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
    public boolean isUp() {
        return up;
    }
    public void setUp(boolean up) {
        this.up = up;
    }
    public boolean isRight() {
        return right;
    }
    public void setRight(boolean right) {
        this.right = right;
    }
    public boolean isDown() {
        return down;
    }
    public void setDown(boolean down) {
        this.down = down;
    };
    public void setJump(boolean jump) {
        this.jump = jump;
    }
    
}
