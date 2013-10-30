package OurGame;

import java.awt.*;

import javax.swing.ImageIcon;
public class Bullet {
	int x,y;
	Image img;
	boolean visible = true;
	public Bullet (int startX,int startY) {
		x = startX;
		y = startY;
	    ImageIcon newBullet = new ImageIcon(this.getClass().getResource("bullet.png"));
	    img = newBullet.getImage();
	}
	
	public void move() {
		x = x+2;	
		if (x > 700)  {
			visible = false;
		}
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public Image getImage(){
		return img;
	}
}
