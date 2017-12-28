import java.awt.Image;
import java.util.ArrayList;

public class Tower extends GameObject{
	private int dx;
    private int dy;
    private ArrayList<Missile> missiles;
    
    public Tower(int x, int y){
        super(x, y);
        initTower();
    }
    
    private void initTower(){
        missiles = new ArrayList<Missile>();
        loadImage("com\\moving_sprite\\craft.png");
        getImageDimensions();
    }
    
    
    
    public ArrayList getMissiles() {
        return missiles;
    }
    
    
  
    
    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }
}
