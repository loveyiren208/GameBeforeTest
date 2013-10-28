package OurGame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener{
  Dude p;
  Image img;
  Timer time;
  public Board(){
	  p = new Dude();
	  addKeyListener(new AL());
	  setFocusable(true);
	  //ImageIcon i = new ImageIcon("/Users/xiaonanwang/Documents/workspace/GameBeforeTest/src/OurGame/testp.jpg");
	  ImageIcon i = new ImageIcon(this.getClass().getResource("testp.jpg"));
	  img = i.getImage();
	  time = new Timer(5,this);
	  time.start();
	  
  }
  
  public void actionPerformed(ActionEvent e){
	  p.move();
	  repaint();
  }
  
  public void paint(Graphics g){
	  super.paint(g);
	  Graphics2D g2d = (Graphics2D) g;
	  
	  g2d.drawImage(img,0,0,null);
	  g2d.drawImage(p.getImage(),p.getX(),p.getY(),null);
  }
  
  
  private class AL extends KeyAdapter {
	  public void keyReleased (KeyEvent e) {
		  p.keyReleased(e);
	  }
	  
	  public void keyPressed (KeyEvent e) {
		  p.keyPressed(e);
	  }
  }
}
