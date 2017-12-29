
public class TowerB extends Tower{

	public TowerB(int x, int y) {
		super(x, y, 3);
	}
	
	protected String getImageName() {
		return "bin\\TowerB.png";
	}
	
	protected  void shootMissiles() {
		missiles.add(new MissileB(x , y + height / 6));
	}
}
