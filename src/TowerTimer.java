import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class TowerTimer implements ActionListener{
	
	private Timer timer;
	private final int DELAY = 200;
	private ArrayList<Tower> towers;
	
	private static TowerTimer towerATimer;
	
	private TowerTimer() {
		timer = new Timer(DELAY, this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(Tower tower : towers) {
			tower.fire(); 
		}
	}
	
	public static TowerTimer getActionListener() {
		if(towerATimer == null) {
			towerATimer = new TowerTimer();
		}
		
		return towerATimer;
	}
	
	public void  setTowers(ArrayList<Tower> towers){
		this.towers = towers;
	}
	
	
	public void startTime() {
		timer.start();
	}
	
	
	public void stopTime() {
		timer.stop();
	}
	
	
	
}
