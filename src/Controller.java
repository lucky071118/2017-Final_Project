import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDialog;

public class Controller {
	private TowerTimer towerTimer;
	private AnimationTimer animationTimer;
	
	private StateInterface state;
	
	private Model model;
	private Board board;
	private TowerPanel towerPanel;
	
	private JDialog dialog;
	private int number;
	private int round = 1;
	
	
	public Controller(Model model,Board board, TowerPanel towerPanel) {
		this.model = model;
		this.board = board;
		this.towerPanel = towerPanel;
		
		initTowerTimer();
		initAnimationTimer();
		
		
		//Set startGmaeListener
		board.setPanelListener(startGmaeListener);
		
	}
	
	private void initTowerTimer() {
		towerTimer = TowerTimer.getActionListener();
        towerTimer.setTowers( model.getTowers());
        towerTimer.setMissiles( board.getMissiles());
	}
	
	private void initAnimationTimer() {
		animationTimer = AnimationTimer.getTimer(animationListener);
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
	
	
	

	
	
	
	
	private ActionListener animationListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			board.update();
			 
			board.paint(state);
			if(board.checkRound()==false) {
				System.out.println("Round over");
				towerTimer.stopTime();
				animationTimer.stopTime();
				state = new UpdateTowerState();
				board.paint(state);
			    board.setPanelListener(nextRoundListener);
			    round++;
			}
			if(board.checkGame()==true) {
				state = new GameOverState();
				towerTimer.stopTime();
				animationTimer.stopTime();
				board.paint(state);
			}
			
			
		}
	};
	
	private MouseListener startGmaeListener = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
	       
	       state = new UpdateTowerState();
	       board.paint(state);
	       board.setPanelListener(nextRoundListener);
	       
	       towerPanel.setActionListener(towerButtonListener);
	    }
		
		public void mouseExited(MouseEvent e) {
	        
	    }
	    
	    public void mousePressed(MouseEvent e) {
	       
	    }
	    
	    public void mouseReleased(MouseEvent e) {
	        
	    }
	    
	    public void mouseEntered(MouseEvent e) {
	       
	    }
	};
	
	
	private MouseListener nextRoundListener = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
			
			board.setPlayerBlood(5);
			
			
			if(round ==1) {
				board.newRound(new EnemyRound1());
			}else if(round ==2) {
				board.newRound(new EnemyRound2());
			}
			
			state = new InGameState();
			towerPanel.removeActionListener(towerButtonListener);
			
			animationTimer.startTime();
			towerTimer.startTime();
			
		}
			
		public void mouseExited(MouseEvent e) {
	        
	    }
	    
	    public void mousePressed(MouseEvent e) {
	       
	    }
	    
	    public void mouseReleased(MouseEvent e) {
	        
	    }
	    
	    public void mouseEntered(MouseEvent e) {
	       
	    }
		
		
	};
		

	
}
