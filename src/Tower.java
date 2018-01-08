
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Tower extends GameObject{
	
    public String test;
    protected int reloadTime;
    private boolean canFire = true;
    private int reloadCounter;
    protected Missile missile;
    protected String missileImageName;
    protected ShootStrategy shootStrategy;
    private int number;
    public static final String[] TowerCatalog = {"TowerA", "TowerB"};
    
    public Tower(int x, int y, int reloadTime, Missile missile,ShootStrategy shootStrategy, String imageName){
        super(x, y);
        this.reloadTime = reloadTime;
        this.missile = missile;
		this.shootStrategy = shootStrategy;
		this.number = y/100;
		
        initTower(imageName);
        test = imageName;
      
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
    
   
    public Missile getMissile() {
    	return missile;
    }
   
   
    
    public ArrayList<String> updateDoalogInformation(){
    	
		ArrayList<String> result = new ArrayList<String>();
		dialogMissilePower(result);
		dialogMissileSpeed(result);
		dialogReloadTime(result);
		dialogShootStrategy( result);
		dialogTower(result);
	
		return result;
	}
    
    
    protected abstract void dialogMissilePower(ArrayList<String> result);
    protected abstract void dialogMissileSpeed(ArrayList<String> result);
    protected abstract void dialogReloadTime(ArrayList<String> result);
    protected abstract void dialogShootStrategy(ArrayList<String> result);
    protected abstract void dialogTower(ArrayList<String> result);
    
    public abstract void updateMissilePower();
    public abstract void updateMissileSpeed();
    public abstract void updateReloadTime();
    public abstract void updateShootStrategy(String shootStrategyType);
    
}
