import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.Border;

public class TowerButton extends JButton{
	
	private ImageIcon imageIcon;
	
	
	private int number;

//	private ActionListener towerButtonListener;
	
	public TowerButton(int number, Image image) {
		
		this.number = number;
		
		setMaximumSize(new Dimension(100, 100));
		setPreferredSize(new Dimension(100, 100));
		
		
		Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		setBorder(emptyBorder);
		
		imageIcon = new ImageIcon(image);
		setIcon(imageIcon);
		setBackground(Color.GRAY);
		
		
		
		

			
	
		setVerticalAlignment(0);
		
		
	}
	
	
	
	
	
	
	
	
	
	public int getNumber() {
		return number;
	}
	
	
	
	
	
	
	
	
	
	
	
}
