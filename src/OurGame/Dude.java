package OurGame;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Dude {
	int x, dx, y,nx2,nx;
	Image still;

	public Dude() {
		ImageIcon i = new ImageIcon(this.getClass().getResource("still.png"));
        ImageIcon l = new ImageIcon(this.getClass().getResource("left.png"));
		// ImageIcon i = new
		// ImageIcon("/Users/xiaonanwang/Documents/workspace/GameBeforeTest/src/OurGame/");
		still = i.getImage();
		x = 75;
		nx2 = 685;
		y = 172;
		nx = 0;

	}

	public void move() {
		x = x + dx;
		nx2 = nx2 +dx;
		nx = nx + dx;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return still;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = -1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 1;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
			;
		}
	}

}
