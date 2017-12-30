
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Tower extends GameObject{
	
    protected ArrayList<Missile> missiles;
    private int reloadTime;
    private boolean canFire;
    private int reloadCounter;
    private Missile missile;
    protected String missileImageName;
    protected ShootStrategy shootStrategy;
    
    public Tower(int x, int y, int reloadTime, Missile missile,ShootStrategy shootStrategy, String imageName){
        super(x, y);
        this.reloadTime = reloadTime;
        this.missile = missile;
		this.shootStrategy = shootStrategy;
		
        initTower(imageName);
        
        missiles = new ArrayList<Missile>();
    }
    
   
    
    private void initTower(String imageName){
        loadImage(imageName);
        getImageDimensions();
    }
    
   
   
   
   
  
    
    public ArrayList<Missile> getMissiles() {
        return missiles;
    }
    
    
  
    
    public void fire() {
    	
    	if(canFire) {
    		missiles.addAll(shootStrategy.shoot(missile));
    		
    		
    		reloadCounter = 1;
    		canFire = false;
    	}else {
    		reloadCounter++;
    	}
    	
        if(reloadCounter == reloadTime ) {
        	canFire = true;
        }
    }
    
    
    
//    public Missile CreateMissile() {
//    	return new Missile
//    }
    
//    protected abstract void shootMissiles();
    
   
    
   
    
    
}
