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
		if(missile.getMissilePower()<= TowerB.MaxMissilePower) {
			result.add("Strengthen missile");
		}
	}
	
	protected void dialogMissileSpeed(ArrayList<String> result) {
		if(missile.getMissileSpeed() <= TowerB.MaxMissileSpeed) {
			result.add("Accelerate missile");
		}
	}
	
	protected void dialogReloadTime(ArrayList<String> result) {
		if(reloadTime >= TowerB.MinReloadTime) {
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
