import java.awt.Image;
import java.util.ArrayList;

public class Tower extends GameObject{
	private int dx;
    private int dy;
    private ArrayList<Missile> missiles;
    
    public Tower(int x, int y){
        super(x, y);
        initCraft();
    }
    
    private void initCraft(){
        missiles = new ArrayList<Missile>();
        loadImage("com\\moving_sprite\\craft.png");
        getImageDimensions();
    }
    
    public void move(){
        x += dx;
        y += dy;
        
        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }
    
    public ArrayList getMissiles() {
        return missiles;
    }
    
    
  
    
    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }
}
