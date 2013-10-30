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
	public Rectangle getBounds(){
		return new Rectangle(x,y,73,78);
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
	
	public void move (int dx,int left){
		if (dx == 1 && ! ((left + dx) < 150) ){
			x -= dx;
		}
		
	}
}
