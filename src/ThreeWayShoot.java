import java.util.ArrayList;

public class ThreeWayShoot implements ShootStrategy{
	public ArrayList<Missile> shoot(Missile missile){
		ArrayList<Missile> missiles = new ArrayList<Missile>();
		
		Missile newMissile1= missile.copyMissile();
		Missile newMissile2= missile.copyMissile();
		Missile newMissile3= missile.copyMissile();
		
		newMissile1.setDirection(-1, 0);
		newMissile2.setDirection(-0.96, -0.26);
		newMissile3.setDirection(-0.96, 0.26);
		
		missiles.add(newMissile1);
		missiles.add(newMissile2);
		missiles.add(newMissile3);
		
		return missiles;
	}
	
	public String getType() {
		return "ThreeWayShoot";
	}
}
