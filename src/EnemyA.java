
public class EnemyA extends Enemy{
	
	public EnemyA(int x, int y) {
		super( x, y, 60, 3);
		
	}
	
	
	protected String getImageName() {
		return "bin\\EnemyA.png";
	}
	
}