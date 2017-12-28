
import java.util.ArrayList;

public abstract class Tower extends GameObject{
	
    protected ArrayList<Missile> missiles;
    private int reloadTime;
    private int firePower;
    private boolean canFire;
    private int reloadCounter;
    
    public Tower(int x, int y, int reloadTime,int firePower){
        super(x, y);
        this.reloadTime = reloadTime;
        this.firePower = firePower;
        initTower();
    }
    
    private void initTower(){
        missiles = new ArrayList<Missile>();
        loadImage(getImageFile());
        getImageDimensions();
    }
    
    protected abstract String getImageFile();
    
    
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
