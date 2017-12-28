
import javax.swing.Timer;

public class TowerA extends Tower{
	
	
	
	public TowerA(int x, int y) {
		super(x, y, 1, 30);
	}
	
	protected String getImageFile() {
		return "bin\\TowerA.png";
	}
	
	protected  void shootMissiles() {
		missiles.add(new MissileA(x + width, y + height / 2));
	}
	
	
}
