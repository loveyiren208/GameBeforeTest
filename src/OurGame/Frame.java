package OurGame;

import javax.swing.JFrame;

public class Frame {
	public static void main (String[] args) {
	    
	    JFrame frame = new JFrame ("gameloft before test");
	    frame.add(new Board());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(1200,365);
	    frame.setVisible(true);
	  }
}
