import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class UpdateTowerState implements StateInterface{
	
	
	//update the paint of board JPanel when the state is "updateTower"
	public void paint(Graphics g, Board board) {
		String msg = "Start Round";
        Font small = new Font("Helvetica", Font.BOLD, 50);
        FontMetrics fm = board.getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (board.getWidth() - fm.stringWidth(msg)) / 2, board.getHeight() / 2);
		
		
		
	}
	
	
	
	
	
}
