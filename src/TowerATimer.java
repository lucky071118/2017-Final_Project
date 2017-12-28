import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class TowerATimer implements ActionListener, TowerTimer{
	
	private Timer timer;
	private final int DELAY = 500;
	private ArrayList<Tower> towers;
	
	private static TowerTimer towerATimer;
	
	private TowerATimer() {
		timer = new Timer(DELAY, this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("test");
		for(Tower tower : towers) {
			tower.fire();
			 
		}
	}
	
	public static TowerTimer getActionListener() {
		if(towerATimer == null) {
			towerATimer = new TowerATimer();
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
