
import java.util.ArrayList;

public class Tower extends GameObject{
	
    private ArrayList<Missile> missiles;
    
    public Tower(int x, int y){
        super(x, y);
        initTower();
    }
    
    private void initTower(){
        missiles = new ArrayList<Missile>();
        loadImage("bin\\TowerA.png");
        getImageDimensions();
    }
    
    
    
    public ArrayList<Missile> getMissiles() {
        return missiles;
    }
    
    
  
    
    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }
}
