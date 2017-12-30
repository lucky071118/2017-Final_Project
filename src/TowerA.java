
import javax.swing.Timer;

public class TowerA extends Tower{
	
	
	
	public TowerA(int x, int y) {
		
		super(x, y, 1, new Missile(x, y, 3, 30, "bin\\MissileA.png"), new DoubleShoot(), "bin\\TowerA.png");
	}
	
	
	
	
//	protected  void shootMissiles() {
//		missiles.add(new MissileA(x , y + height / 8));
//		missiles.add(new MissileA(x , y + height / 8));
//		missiles.add(new MissileA(x , y + height / 8));
//	}
	
	
}
