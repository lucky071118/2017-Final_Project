
public class TowerB extends Tower{

	public TowerB(int x, int y) {
		super(x, y, 3, 30);
	}
	
	protected String getImageFile() {
		return "bin\\TowerA.png";
	}
	
	protected  void shootMissiles() {
		missiles.add(new MissileB(x + width, y + height / 2));
	}
}
