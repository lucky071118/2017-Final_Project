import java.awt.Graphics;

import javax.swing.JPanel;

public interface StateInterface {
	
	//update the paint of board JPanel according to the state
	void paint(Graphics g,Board board);

}
