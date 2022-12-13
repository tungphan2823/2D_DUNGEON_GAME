package main;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import java.awt.Color;
public abstract class entity {
    protected float x,y;
    protected int width, height;
    protected Rectangle2D.Float hitBox;
    public entity(float x, float y ,int width, int height){
        this.x = x;
        this.y = y;
        this.width= width;
        this.height= height;
        
    }
    protected void drawHitBox(Graphics g){
        g.setColor(Color.PINK);
        g.drawRect((int)hitBox.x, (int) hitBox.y, (int) hitBox.width, (int )hitBox.height);
    }
    protected void initHitbox(float x, float y ,float width, float height){
        hitBox = new Rectangle2D.Float (x, y, width, height );

    }
    protected void updateHitbox(){
        hitBox.x=(int) x;
        hitBox.y=(int) y;
    }
    public Rectangle2D.Float getHitbox(){
        return hitBox;
    }
}
