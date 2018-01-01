
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Tower extends GameObject{
	
    
    protected int reloadTime;
    private boolean canFire;
    private int reloadCounter;
    protected Missile missile;
    protected String missileImageName;
    protected ShootStrategy shootStrategy;
    private int number;
    
    public Tower(int x, int y, int reloadTime, Missile missile,ShootStrategy shootStrategy, String imageName){
        super(x, y);
        this.reloadTime = reloadTime;
        this.missile = missile;
		this.shootStrategy = shootStrategy;
		this.number = y/100;
		
        initTower(imageName);
        
      
    }
    
   
    
    private void initTower(String imageName){
        loadImage(imageName);
        getImageDimensions();
    }
    
    
    public ArrayList<Missile> fire() {
    	
    	ArrayList<Missile> result = null;
    	if(canFire) {
    		result = shootStrategy.shoot(missile);
    		
    		reloadCounter = 1;
    		canFire = false;
    	}else {
    		reloadCounter++;
    	}
    	
        if(reloadCounter == reloadTime ) {
        	canFire = true;
        }
        return result;
    }
    
    
    public int getNumber() {
    	return number;
    }
    
   
    
   
   
    
    public ArrayList<String> updateDoalogInformation(){
    	
		ArrayList<String> result = new ArrayList<String>();
		dialogMissilePower(result);
		dialogMissileSpeed(result);
		dialogReloadTime(result);
		dialogShootStrategy( result);
		
	
		return result;
	}
    
    
    protected abstract void dialogMissilePower(ArrayList<String> result);
    protected abstract void dialogMissileSpeed(ArrayList<String> result);
    protected abstract void dialogReloadTime(ArrayList<String> result);
    protected abstract void dialogShootStrategy(ArrayList<String> result);
    
}
