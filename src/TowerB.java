import java.util.ArrayList;

public class TowerB extends Tower{
	

	public static final int MaxMissilePower = 300;
	public static final int MaxMissileSpeed = 4;
	public static final int MinReloadTime = 3;
	public static final String[] canShootStrategy= {
			"OneWayShoot", 
			"DoubleShoot",
			};
	
	public TowerB(int x, int y) {
		super(x, y, 12, new Missile(x, y, 2, 100, "bin\\MissileB.png"), new OneWayShoot(), "bin\\TowerB.png");
	}
	
	
	protected  void dialogMissilePower(ArrayList<String> result) {
		int power = missile.getMissilePower();
		if( power <= TowerB.MaxMissilePower) {
			result.add("Strengthen missile ("+ power+"+100"+")");
		}
	}
	
	protected void dialogMissileSpeed(ArrayList<String> result) {
		int speed = missile.getMissileSpeed();
		if( speed <= TowerB.MaxMissileSpeed) {
			result.add("Accelerate missile ("+ speed+"+1"+")");
		}
	}
	
	protected void dialogReloadTime(ArrayList<String> result) {
		if(reloadTime >= TowerB.MinReloadTime) {
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
