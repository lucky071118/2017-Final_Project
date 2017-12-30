import java.util.ArrayList;

public class OneWayShoot implements ShootStrategy{
	
	public ArrayList<Missile> shoot(Missile missile){
		ArrayList<Missile> missiles = new ArrayList<Missile>();
		
		Missile newMissile= missile.copyMissile();
		
		newMissile.setDirection(-1, 0);
		
		missiles.add(newMissile);
		
		return missiles;
	}
	
}
