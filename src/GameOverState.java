import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameOverState implements StateInterface{
	
	
	
	public void paint(Graphics g, Board board) {
		String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = board.getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (board.getWidth() - fm.stringWidth(msg)) / 2, board.getHeight() / 2);
	}
}
