import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDialog;

public class Controller {
	
	//A timer for tower shooting the missile
	private TowerTimer towerTimer;
	
	//A timer for update the paint of JPanel
	private AnimationTimer animationTimer;
	
	//use the state pattern to change the way of updating the paint of JPanel
	private StateInterface state;
	
	//Model contain Tower information
	private Model model;
	
	//Board contain the JPanel and information about missile and enemy
	private Board board;
	
	//towerPanel contain the JPanel about Tower
	private TowerPanel towerPanel;
	
	//a dialog for update the ability of a tower
	private JDialog dialog;
	
	//the 
	private int number;
	
	//the round number of game 
	private int round = 1;
	
	 
	public Controller(Model model,Board board, TowerPanel towerPanel) {
		this.model = model;
		this.board = board;
		this.towerPanel = towerPanel;
		
		initTowerTimer();
		initAnimationTimer();
		
		
		//Set startGmaeListener
		board.addMouseListener(startGmaeListener);
		
	}
	
	private void initTowerTimer() {
		towerTimer = TowerTimer.getActionListener();
        towerTimer.setTowers( model.getTowers());
        towerTimer.setMissiles( board.getMissiles());
        towerTimer.setEnemies( board. getEnemies());
       
	}
	
	private void initAnimationTimer() {
		animationTimer = AnimationTimer.getTimer(animationListener);
	}
	
	
	
	//a ActionListener for dialog when player update the ability of a tower
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
	
	// a ActionListener  when user click the the button of tower
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
	
	
	

	
	
	
	// a ActionListener for animationTimer to update the paint of JPanel
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
			    board.addMouseListener(nextRoundListener);
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
	
	// a MouseListener when the paint is "start game" and it will change state of "start game " to the state of "update towers"
	private MouseListener startGmaeListener = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
	       
	       state = new UpdateTowerState();
	       board.paint(state);
	       board.addMouseListener(nextRoundListener);
	       
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
	
	// a MouseListener when the paint is "update towers" and it will change state of "update towers" to the state of "In Game" 
	private MouseListener nextRoundListener = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
			
			board.setPlayerBlood(5);
			
			
			if(round ==1) {
				board.newRound(new EnemyRound1());
			}else if(round ==2) {
				board.newRound(new EnemyRound2());
			}
			
			state = new InGameState();
			towerPanel.removeAllActionListener(towerButtonListener);
			
			animationTimer.startTime();
			towerTimer.startTime();
			board.removeMouseListener(this);
			
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
