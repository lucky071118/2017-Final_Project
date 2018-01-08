import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;


public class GameStartState implements StateInterface{
	
	
	
	
	public void paint(Graphics g, Board board) {
		String msg = "Game Start";
        Font small = new Font("Helvetica", Font.BOLD, 50);
        FontMetrics fm = board.getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (board.getWidth() - fm.stringWidth(msg)) / 2, board.getHeight() / 2);
        
	}
	
	
	
	
}
