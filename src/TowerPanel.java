import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TowerPanel extends JPanel {
	/*
	 * The class is JPanel that contain the buttons of towers
	 * 
	 */
	
	
	//a list of buttons of Towers
	private TowerButton[] buttonList = new TowerButton[7];
	
	
	public TowerPanel(Tower[] towers) {
		drawTowerButton(towers);
	}
	
	
	public void setActionListener(ActionListener buttonListener) {
		for(JButton button : buttonList ) {
			button.addActionListener(buttonListener);
		}
	}
	
	public void setActionListener(ActionListener buttonListener, int number) {
	
		buttonList[number].addActionListener(buttonListener);
		
	}
	
	//create buttons of the towers
	private void drawTowerButton(Tower[] towers) {
		for(int i=0; i< buttonList.length; i++) {
			if(buttonList[i] == null) {
				TowerButton towerButton = new TowerButton(i, towers[i].getImage());
				buttonList[i] = towerButton;
			}
			add(buttonList[i]);	
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	
	//update the button of the tower when player change the type of the tower
	public void update(int number, Tower[] towers) {
		removeAll();
		revalidate();
		
		buttonList[number] = null;
		drawTowerButton(towers);
		repaint();
	}
	
	
	public void removeAllActionListener(ActionListener buttonListener) {
		for(JButton button : buttonList ) {
			button.removeActionListener(buttonListener);
		}
	}
	
}
