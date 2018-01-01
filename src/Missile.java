
public class Missile extends GameObject{
	
//	private final int BOARD_WIDTH = 390;
    private int speed;
    private double dx;
    private double dy;
    private int power;
    private String imageName;
    
    public Missile(int x, int y, int speed, int power,String imageName){
        super(x, y);
        this.speed = speed;
        this.power = power;
        this.imageName = imageName;
        initMissile();
    }
    
    private void initMissile(){
        loadImage(imageName);  
        getImageDimensions();
    }
   
    

    public void setDirection(double dx, double dy) {
    	this.dx = dx;
    	this.dy = dy;
    }
    
    
   
    
    
    public void move() {
        
        x += (speed * dx);
        
        double resultY = speed * dy;
        double sign = Math.signum(resultY);
        if(Math.abs(resultY) < 1.0) {
        	resultY = 1.0;
        }
        
        resultY *= sign ;
        
        
        y += resultY;
       
        
        if (x < 0) {
            isVisible = false;
        }
    }
    
    public int getMissilePower() {
    	return power;
    }
    
    public int getMissileSpeed() {
    	return speed;
    }
    
    public Missile copyMissile() {
    	Missile missile = new Missile(x, y, speed, power, imageName);
    	return missile;
    }
    
    public void shiftMissile(int shiftX, int shiftY) {
    	x += shiftX;
    	y += shiftY;
    }
    
    
}
