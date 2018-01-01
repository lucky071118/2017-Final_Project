import java.util.ArrayList;

public class DoubleShoot implements ShootStrategy{
	public ArrayList<Missile> shoot(Missile missile){
		ArrayList<Missile> missiles = new ArrayList<Missile>();
		
		Missile newMissile1= missile.copyMissile();
		Missile newMissile2= missile.copyMissile();
		
		
		newMissile1.setDirection(-1, 0);
		newMissile2.setDirection(-1, 0);
		newMissile2.shiftMissile(-10, 0);
		
		missiles.add(newMissile1);
		missiles.add(newMissile2);
		
		
		return missiles;
	}
	
	
	public String getType() {
		return "DoubleShoot";
	}
}
