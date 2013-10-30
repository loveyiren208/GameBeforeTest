package OurGame;

import java.awt.*;

import javax.swing.ImageIcon;

public class Enemy {
	Image img;
	int x,y;
	
	boolean isAlive = true;
	public Enemy(int startX, int startY) {
	    ImageIcon newEnemy = new ImageIcon(this.getClass().getResource("enemy.png"));

		img = newEnemy.getImage();
		
		x = startX;
		y = startY;
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
	
	public void move (int dx){
		x -= dx;
	}
}
