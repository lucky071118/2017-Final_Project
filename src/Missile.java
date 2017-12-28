
public abstract class Missile extends GameObject{
	
//	private final int BOARD_WIDTH = 390;
    private int speed;
    private int power;
    
    public Missile(int x, int y, int speed, int power){
        super(x, y);
        this.speed = speed;
        this.power = power;
        initMissile();
    }
    
    private void initMissile(){
        loadImage(getImageName());  
        getImageDimensions();
    }
    
    
    
    public void move() {
        
        x -= speed;
        
        if (x < 0) {
            isVisible = false;
        }
    }
    
    public int getMissilePower() {
    	return power;
    }
}
