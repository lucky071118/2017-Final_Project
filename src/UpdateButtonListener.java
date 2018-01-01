import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class UpdateButtonListener implements ActionListener{
	
	private JDialog dialog;
	private Tower tower;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(dialog != null) {
			dialog.dispose();
		}
		
		String source = e.getActionCommand();
		String[] result = source.split("\\s");
		
		
		switch(result[0]) {
			case "Strengthen":
				tower.updateMissilePower();
				break;
				
			case "Accelerate":
				tower.updateMissileSpeed();
				break;
			
			case "Reduce":
				tower.updateReloadTime();
				break;
				
			case "Switch":
				if(2 < result.length) {
					tower.updateShootStrategy(result[2]);
				}
				break;
				
			case "Change":
				
				break;
				
			default:
				System.out.println("error");
		}
		
		
	}
	
	public void setDialog(JDialog dialog) {
		
		
		this.dialog = dialog;
	}
	
	public void setTower(Tower tower) {
		this.tower = tower;
	}
	

}
