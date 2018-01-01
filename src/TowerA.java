
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
		int power = missile.getMissilePower();
		if(power <= TowerA.MaxMissilePower) {
			result.add("Strengthen missile ("+ power+"+30"+")");
		}
	}
	
	protected void dialogMissileSpeed(ArrayList<String> result) {
		int speed = missile.getMissileSpeed();
		if( speed <= TowerA.MaxMissileSpeed) {
			result.add("Accelerate missile ("+ speed+"+1"+")");
		}
	}
	
	protected void dialogReloadTime(ArrayList<String> result) {
		
		if(reloadTime >= TowerA.MinReloadTime) {
			result.add("Reduce reload time ("+ reloadTime+"-1"+")");
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
