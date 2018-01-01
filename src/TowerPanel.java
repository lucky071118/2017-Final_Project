import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TowerPanel extends JPanel {
	
	TowerButton[] buttonList = new TowerButton[7];
	
	public TowerPanel(Tower[] towers) {
		for(int i=0; i< towers.length; i++) {
			TowerButton towerButton = new TowerButton(i, towers[i].getImage());
			buttonList[i] = towerButton;
			add(towerButton);	
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
	}
	
	public void setActionListener(ActionListener buttonListener) {
		for(JButton button : buttonList ) {
			button.addActionListener(buttonListener);
		}
	}
	
//	public void initPanel() {
//		
//	}
	
	
	
	
}
