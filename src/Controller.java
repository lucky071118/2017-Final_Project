import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;

public class Controller {
	private TowerTimer towerTimer;
	

	
	private Model model;
	private Board board;
	private TowerPanel towerPanel;
	
	private JDialog dialog;
	private int number;
	
	public Controller(Model model,Board board, TowerPanel towerPanel) {
		this.model = model;
		this.board = board;
		this.towerPanel = towerPanel;
		
		initTowerTimer();
		
		
		towerPanel.setActionListener(towerButtonListener);
	}
	
	private void initTowerTimer() {
		towerTimer = TowerTimer.getActionListener();
        towerTimer.setTowers( model.getTowers());
        towerTimer.setMissiles( board.getMissiles());
        towerTimer.startTime();
	}
	
	
	
	
	private  ActionListener updateButtonListener = new  ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(dialog != null) {
				dialog.dispose();
				dialog = null;
			}
			
			Tower tower = model.getTower(number);
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
					Tower[] towers = model.getTowers();
					
					if(2 < result.length) {
						String targetTower = result[2];
						if(targetTower.equals( "TowerA")) {
							
							towers[number] = new TowerA(tower.getX(),tower.getY());
						}else if(targetTower.equals("TowerB")) {
							
							towers[number] = new TowerB(tower.getX(),tower.getY());
							
							
						}
						
						towerPanel.update(number, model.getTowers());
						towerPanel.setActionListener(towerButtonListener, number);
						
					}
					
					break;
					
				default:
					System.out.println("error");
			}
			
			number = -1;
		}
	};
	
	
	private ActionListener towerButtonListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			TowerButton  towerButton = (TowerButton )e.getSource();
			
			number = towerButton.getNumber();
			Tower target = model.getTower(number);
			
			ArrayList<String> result = target.updateDoalogInformation();
			
			
			
			dialog = new UpdateDialog(result, updateButtonListener);
			
			dialog.setLocation(target.getX()-50,target.getY()+180);
			dialog.setVisible(true);
		}
	};
	
	
	
	
	
	
		

	
}
