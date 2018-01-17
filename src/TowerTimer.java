import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class TowerTimer implements ActionListener{
	
	//The timer
	private Timer timer;
	private final int DELAY = 200;
	private Tower[] towers;
	private ArrayList<Missile> missiles;
	private ArrayList<Enemy> enemies;
	
	private static TowerTimer towerATimer;
	
	private TowerTimer() {
		timer = new Timer(DELAY, this);
	}
	
	public static TowerTimer getActionListener() {
		if(towerATimer == null) {
			towerATimer = new TowerTimer();
		}
		
		return towerATimer;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Missile> newMissiles = new ArrayList<Missile>();
		for(Tower tower : towers) {
			if(MissilePath(tower)) {
				ArrayList<Missile> result = tower.fire();
				if(result != null) {
					newMissiles.addAll(result); 
				}
			}
		}
		missiles.addAll(newMissiles);
	}
	
	
	public boolean MissilePath(Tower tower) {
		boolean canFire = false;
		
		Missile missile= tower.getMissile();
		Rectangle r1 = new Rectangle(0, missile.getY(), 720, missile.getHeight());
		for(Enemy enemy : enemies) {
			Rectangle r2 = enemy.getBounds();
			if (r1.intersects(r2)) {
				canFire = true;
			}
		}
			
		
		return canFire;
    }
	
	
	
	
	
	public void  setTowers(Tower[] towers){
		this.towers = towers;
	}
	
	public void setMissiles(ArrayList<Missile> missiles) {
		this.missiles = missiles;
	}
	
	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}
	
	
	public void startTime() {
		timer.start();
	}
	
	
	public void stopTime() {
		timer.stop();
	}
	
	
	
}
