import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class UpdateButtonListener{
//	
//	private JDialog dialog;
//	private Tower[] towers;
//	
//	private int number;
//	
//	
//	
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(dialog != null) {
//			dialog.dispose();
//		}
//		
//		Tower tower = towers[number];
//		String source = e.getActionCommand();
//		String[] result = source.split("\\s");
//		
//		
//		
//		
//		switch(result[0]) {
//			case "Strengthen":
//				tower.updateMissilePower();
//				break;
//				
//			case "Accelerate":
//				tower.updateMissileSpeed();
//				break;
//			
//			case "Reduce":
//				tower.updateReloadTime();
//				break;
//				
//			case "Switch":
//				if(2 < result.length) {
//					tower.updateShootStrategy(result[2]);
//				}
//				break;
//				
//			case "Change":
//				
//				if(2 < result.length) {
//					if(result[2].equals( "TowerA")) {
//						towers[number] = new TowerA(tower.getX(),tower.getY());
//					}else if(result[2].equals("TowerB")) {
//						towers[number] = new TowerB(tower.getX(),tower.getY());
//					}
//					
//				
//				}
//				break;
//				
//			default:
//				System.out.println("error");
//		}
//		
//		
//	}
//	
//	public void setDialog(JDialog dialog) {
//		
//		
//		this.dialog = dialog;
//	}
//	
//	public void setTower(Tower[] towers) {
//		this.towers = towers;
//	}
//	
//	public void setNumber(int number) {
//		this.number =number;
//	}
//	

}
