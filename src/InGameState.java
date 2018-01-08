import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class InGameState implements StateInterface{
	
//	private AnimationTimer animationTimer;
//	private TowerTimer towerTimer;
//	
//	public InGameState() {
//		initTowerTimer();
//		initAnimationTimer();
//	}
//	
//	private void initTowerTimer() {
//		towerTimer = TowerTimer.getActionListener();
//        towerTimer.setTowers( model.getTowers());
//        towerTimer.setMissiles( board.getMissiles());
//        towerTimer.startTime();
//	}
//	
//	private void initAnimationTimer() {
//		animationTimer = AnimationTimer.getActionListener();
//		animationTimer.setBoard(StateController.board);
//	}
	
	
	
	public void paint(Graphics g, Board board) {
		Graphics2D g2d = (Graphics2D) g;
		
		ArrayList<Enemy> enemies = board.getEnemies();
		ArrayList<Missile> missiles = board.getMissiles();
	        
	       
//       
       
      
       	 
       for(Missile missile : missiles){
			if (missile.isVisible()) {
				g2d.drawImage(missile.getImage(), missile.getX(), missile.getY(), board);
			}
		}
       
     
       
       for(Enemy enemy : enemies){
           if(enemy.isVisible()){
               g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), board);
           }
       }
       
       g.setColor(Color.WHITE);
       g.drawString("Enemies left: " + enemies.size(), 5, 15);
       g.drawString("Player blood: " + board.getPlayerBlood(), 5, 30);
     
	}
	
	
	
	
    
    
   
	
}
