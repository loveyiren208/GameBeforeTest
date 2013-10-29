package OurGame;

import javax.swing.JFrame;

public class Frame {
	public Frame() {
		JFrame frame = new JFrame ("gameloft before test");
	    frame.add(new Board());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(700,365);
	    frame.setVisible(true);
	}
	
	public static void main (String[] args) {
	    new Frame();
	    
	  }
}
