import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class TowerPanel extends JPanel {
	
	public TowerPanel(Tower[] towers) {
		for(Tower tower : towers) {
			add(new TowerButton(tower.getX(), tower.getY(), tower.getImage()));
			
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
	}
	
	
	
	
}
