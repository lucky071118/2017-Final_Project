import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDialog;

public class TowerButtonListener implements ActionListener{
		
		private Tower[] towers;
		
		public TowerButtonListener() {
			
		}
		
		public void setTowers(Tower[] towers) {
			this.towers = towers;
		}
		
		
		@Override
		
		public void actionPerformed(ActionEvent e) {
			TowerButton  towerButton = (TowerButton )e.getSource();
			
			int number = towerButton.getNumber();
			Tower target = towers[number];
			
			
			
			ArrayList<String> result = target.updateDoalogInformation();
			
			
			
			JDialog dialog = new UpdateDialog(result,towerButton);
		}

}
