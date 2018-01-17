import java.util.ArrayList;

public interface ShootStrategy {
	
	//Every tower has its own strategy of shooting 
	ArrayList<Missile> shoot(Missile missile);
	
	String getType();
}
