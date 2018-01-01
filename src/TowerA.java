
import java.util.ArrayList;

import javax.swing.Timer;

public class TowerA extends Tower{
	
	public static final int MaxMissilePower = 90;
	public static final int MaxMissileSpeed = 6;
	public static final int MinReloadTime = 1;
	public static final String[] canShootStrategy= {
			"OneWayShoot", 
			"DoubleShoot",
			"ThreeWayShoot"
			};
	
	public TowerA(int x, int y) {
		
		super(x, y, 4, new Missile(x, y, 3, 30, "bin\\MissileA.png"), new DoubleShoot(), "bin\\TowerA.png");
	}
	
	
	
	
	protected  void dialogMissilePower(ArrayList<String> result) {
		if(missile.getMissilePower()<= TowerA.MaxMissilePower) {
			result.add("Strengthen missile");
		}
	}
	
	protected void dialogMissileSpeed(ArrayList<String> result) {
		if(missile.getMissileSpeed() <= TowerA.MaxMissileSpeed) {
			result.add("Accelerate missile");
		}
	}
	
	protected void dialogReloadTime(ArrayList<String> result) {
		if(reloadTime >= TowerA.MinReloadTime) {
			result.add("Accelerate reload");
		}
	}
	
	protected void dialogShootStrategy(ArrayList<String> result) {
		
		
		
		String strategy = shootStrategy.getType();
		
		for(int i=0; i < canShootStrategy.length; i++) {
			if(!canShootStrategy[i].equals(strategy)){
				result.add(canShootStrategy[i]);
			}
		}
		
		
	}
	
}
