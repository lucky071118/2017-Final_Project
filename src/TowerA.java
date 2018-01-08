
import java.util.ArrayList;

import javax.swing.Timer;

public class TowerA extends Tower{
	
	public static final int MaxMissilePower = 90;
	public static final int MaxMissileSpeed = 5;
	public static final int MinReloadTime = 1;
	private String type = "TowerA";
	public static final String[] canShootStrategy= {
			"OneWayShoot", 
			"DoubleShoot",
			"ThreeWayShoot"
			};
	
	public TowerA(int x, int y) {
		
		super(x, y, 4, new Missile(x, y+5, 3, 30, "bin\\MissileA.png"), new OneWayShoot(), "bin\\TowerA.png");
	}
	
	
	
	
	protected  void dialogMissilePower(ArrayList<String> result) {
		int power = missile.getMissilePower();
		if(power < TowerA.MaxMissilePower) {
			result.add("Strengthen missile ("+ power+"+30"+")");
		}
	}
	
	protected void dialogMissileSpeed(ArrayList<String> result) {
		int speed = missile.getMissileSpeed();
		if( speed < TowerA.MaxMissileSpeed) {
			result.add("Accelerate missile ("+ speed+"+1"+")");
		}
	}
	
	protected void dialogReloadTime(ArrayList<String> result) {
		
		if(reloadTime > TowerA.MinReloadTime) {
			result.add("Reduce reload time ("+ reloadTime+"-1"+")");
		}
	}
	
	protected void dialogShootStrategy(ArrayList<String> result) {
		
		
		
		String strategy = shootStrategy.getType();
		
		for(int i=0; i < canShootStrategy.length; i++) {
			if(!canShootStrategy[i].equals(strategy)){
				result.add("Switch to " + canShootStrategy[i]);
			}
		}
	}
	
	protected void dialogTower(ArrayList<String> result) {
		for(String towerType : TowerCatalog) {
			if( !(towerType.equals(type))) {
				result.add("Change to " + towerType);
			}
		}
		
	}
	
	public void updateMissilePower() {
		int power = missile.getMissilePower();
		if(power < TowerA.MaxMissilePower) {
			missile.setMissilePower(power+30);
		}
	}
	
	public void updateMissileSpeed() {
		int speed = missile.getMissileSpeed();
		if( speed < TowerA.MaxMissileSpeed) {
			missile.setMissileSpeed(speed+1);
		}
	}
	
	public void updateReloadTime() {
		if(reloadTime > TowerA.MinReloadTime) {
			reloadTime -= 1;
		}
		
	}
	
	public void updateShootStrategy(String shootStrategyType) {
		switch (shootStrategyType) {
			case "OneWayShoot":
				shootStrategy = new OneWayShoot();
				break;
				
			case "DoubleShoot":
				shootStrategy = new DoubleShoot();
				break;
				
			case "ThreeWayShoot":
				shootStrategy = new ThreeWayShoot();
				break;
			
				
		}
	}
	
}
