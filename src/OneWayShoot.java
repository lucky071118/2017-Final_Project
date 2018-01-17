import java.util.ArrayList;

public class OneWayShoot implements ShootStrategy{
	//the way of shoot is shoot one missile
	//The Tower can change the strategy of shooting to the OneWayShoot
	public ArrayList<Missile> shoot(Missile missile){
		ArrayList<Missile> missiles = new ArrayList<Missile>();
		
		Missile newMissile= missile.copyMissile();
		
		newMissile.setDirection(-1, 0);
		
		missiles.add(newMissile);
		
		return missiles;
	}
	
	
	public String getType() {
		return "OneWayShoot";
	}
}
