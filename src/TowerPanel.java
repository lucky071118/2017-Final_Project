import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class TowerPanel extends JPanel {
	
	public TowerPanel(Tower[] towers) {
		for(int i=0; i< towers.length; i++) {
			add(new TowerButton(i, towers[i].getImage()));	
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
	}
	
//	public void initPanel() {
//		
//	}
	
	
	
	
}
