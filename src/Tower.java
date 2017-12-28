
import java.util.ArrayList;

public abstract class Tower extends GameObject{
	
    protected ArrayList<Missile> missiles;
    private int reloadTime;
    private boolean canFire;
    private int reloadCounter;
    
    public Tower(int x, int y, int reloadTime){
        super(x, y);
        this.reloadTime = reloadTime;
        initTower();
    }
    
    private void initTower(){
        missiles = new ArrayList<Missile>();
        loadImage(getImageName());
        getImageDimensions();
    }
    
    
    
    
    public ArrayList<Missile> getMissiles() {
        return missiles;
    }
    
    
  
    
    public void fire() {
    	
    	if(canFire) {
    		shootMissiles();
    		
    		
    		reloadCounter = 1;
    		canFire = false;
    	}else {
    		reloadCounter++;
    	}
    	
        if(reloadCounter == reloadTime ) {
        	canFire = true;
        }
    }
    
    protected abstract void shootMissiles();
    
}
