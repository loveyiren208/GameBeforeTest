package OurGame;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Dude {
	int x, dx, y, nx2, nx, left, dy;
	Image still;
	ImageIcon i = new ImageIcon(this.getClass().getResource("still.png"));
	ImageIcon l = new ImageIcon(this.getClass().getResource("left.png"));
	ImageIcon j = new ImageIcon(this.getClass().getResource("jump.png"));
	static ArrayList<Bullet> bullets;

	int ammo = 10;

	public Dude() {

		// ImageIcon i = new
		// ImageIcon("/Users/xiaonanwang/Documents/workspace/GameBeforeTest/src/OurGame/");
		still = i.getImage();

		x = 75;
		nx2 = 685;
		y = 172;
		nx = 0;

		left = 150;
		bullets = new ArrayList<Bullet>();
	}

	public static ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void move() {
		if (dx != -1) {
			if (left + dx <= 150) {
				left += dx;
			} else {
				x = x + dx;
				nx2 = nx2 + dx;
				nx = nx + dx;
			}
		} else {
			if (left + dx <= 0) {
				left = 0;
			} else {
				left += dx;
			}
		}

		// y += y+dy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getdx(){
		return dx;
	}

	public Image getImage() {
		return still;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			still = l.getImage();
			dx = -1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			still = i.getImage();
			dx = 1;
		}

		if (key == KeyEvent.VK_UP) {
			still = j.getImage();
			dy = 1;
		}

		if (key == KeyEvent.VK_SPACE) {
			fire();
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;

		}

		if (key == KeyEvent.VK_UP) {
			dy = 0;
			still = i.getImage();
		}
	}

	public void fire() {

		if (ammo > 0) {
			ammo--;
			Bullet z = new Bullet(left + 60, y + 154 / 2);
			bullets.add(z);
		}
	}
}
