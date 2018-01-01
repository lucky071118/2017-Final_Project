import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class TowerTimer implements ActionListener{
	
	private Timer timer;
	private final int DELAY = 200;
	private Tower[] towers;
	private ArrayList<Missile> missiles;
	
	private static TowerTimer towerATimer;
	
	private TowerTimer() {
		timer = new Timer(DELAY, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Missile> newMissiles = new ArrayList<Missile>();
		for(Tower tower : towers) {
			ArrayList<Missile> result = tower.fire();
			if(result != null) {
				newMissiles.addAll(result); 
			}
		}
		missiles.addAll(newMissiles);
	}
	
	public static TowerTimer getActionListener() {
		if(towerATimer == null) {
			towerATimer = new TowerTimer();
		}
		
		return towerATimer;
	}
	
	public void  setTowers(Tower[] towers){
		this.towers = towers;
	}
	
	public void setMissiles(ArrayList<Missile> missiles) {
		this.missiles = missiles;
	}
	
	
	public void startTime() {
		timer.start();
	}
	
	
	public void stopTime() {
		timer.stop();
	}
	
	
	
}
