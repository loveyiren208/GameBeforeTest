package OurGame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Board extends JPanel implements ActionListener, Runnable {
	Dude p;
	Image img;
	Timer time;

	Thread animator;

	int v = 172;

	Enemy en;
	Enemy en2;
	boolean lose = true;
	static Font font = new Font("SanSerif",Font.BOLD,24);
	public Board() {
		p = new Dude();
		addKeyListener(new AL());
		setFocusable(true);
		// ImageIcon i = new
		// ImageIcon("/Users/xiaonanwang/Documents/workspace/GameBeforeTest/src/OurGame/testp.jpg");
		ImageIcon i = new ImageIcon(this.getClass().getResource("testp.jpg"));
		img = i.getImage();
		time = new Timer(5, this);
		time.start();

		en = new Enemy(p.x+550,200);
		en2 = new Enemy(p.x + 600,200);
		
		
	}
	
	
	public void checkCollisions(){
		Rectangle r1 = en.getBounds();
		Rectangle r2 = en2.getBounds();
		
		ArrayList<Bullet> bullets = Dude.getBullets();
		for (int w = 0; w < bullets.size();w++) {
			Bullet m = bullets.get(w);
			Rectangle m1 = m.getBounds();
			if (r1.intersects(m1) && en.isAlive) {
				en.isAlive = false;
				m.visible = false;
			} else if (r2.intersects(m1) && en2.isAlive) {
				en2.isAlive = false;
				m.visible = false;
			}
			
		}
		
		Rectangle d = p.getBounds();
		
		if (d.intersects(r1) || d.intersects(r2)) {
			lose = true;
		}
		
	}


	// runs every 5 milliseconds
	public void actionPerformed(ActionEvent e) {
		checkCollisions();
		ArrayList<Bullet> bullets = Dude.getBullets();
		for (int w = 0; w < bullets.size();w++) {
			Bullet m = bullets.get(w);
			if (m.visible) {
				m.move();
			} else {
				bullets.remove(m);
			}
		}
		
		p.move();
		
		if (p.x > 400 ) {
			en.move(p.getdx(),p.left);
		}
		
		if (p.x >500 && p.getdx() >0){
			en2.move(p.getdx(),p.left);
		}
		repaint();
	}

	boolean k = false;

	public void paint(Graphics g) {

		if(lose){
			//System.exit(0);
		}
		if (p.dy == 1 && k == false) {
			k = true;
			animator = new Thread(this);
			animator.start();
		}

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		if ((p.getX() - 590) % 2400 == 0) {
			p.nx = 0;
		}

		if ((p.getX() - 1790) % 2400 == 0) {
			p.nx2 = 0;
		}
		g2d.drawImage(img, 685 - p.nx2, 0, null);

		if (p.getX() > 590) {
			g2d.drawImage(img, 685 - p.nx, 0, null);
		}
		g2d.drawImage(p.getImage(), p.left, v, null);
		
		
		
		ArrayList<Bullet> bullets = Dude.getBullets();
		for (int w = 0; w < bullets.size();w++) {
			Bullet m = bullets.get(w);
			
			
			g2d.drawImage(m.getImage(),m.getX(),m.getY(),null);
		}
		
		g2d.setFont(font);
		g2d.setColor(Color.BLUE);
		g2d.drawString("Ammo left"+ p.ammo, 500,20);
		
		if (p.x > 450 ){
			if (en.isAlive == true) {
				g2d.drawImage(en.getImage(),en.getX(),en.getY(),null);
			}
		}
		if (p.x > 550 ){
			if (en2.isAlive == true) {
				g2d.drawImage(en2.getImage(),en2.getX(),en2.getY(),null);
			}
		}
		
	}

	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			p.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			p.keyPressed(e);
		}
	}

	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;
		beforeTime = System.currentTimeMillis();
		cycle();
		while (done == false) {
			cycle();
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = 10 - timeDiff;
			if (sleep < 0) {
				sleep = 2;

			}

			try {
				Thread.sleep(sleep);
			} catch (Exception e) {

			}
			beforeTime = System.currentTimeMillis();

		}
		done = false;
		h = false;
		k = false;
	}

	boolean h = false;
	boolean done = false;

	public void cycle() {
		if (h == false) {
			v--;
		}
		if (v == 125) {
			h = true;
		}

		if (h == true && v <= 200) {
			v++;
			if (v == 172) {
				done = true;
			}
		}

	}
}
