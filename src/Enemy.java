
public abstract class Enemy extends GameObject{
	
	//the blood of enemy
	private int blood;
	
	//the speed of enemy move
	private int speed;
	
    public Enemy(int x, int y, int blood, int speed){
        super(x, y);
        this.blood = blood;
        this.speed = speed;
        initEnemy();
        
    }
    
    private void  initEnemy(){
        
        loadImage(getImageName());
        getImageDimensions();
        
    }
    
    
    //enemy will move when the animationTimer invoke the paint of JPanel
    public void move() {
        x += speed;
    }
    
    //enemy will loss the blood when missile touch the enemy
    public void bloodLoss(int missilePower) {
    	blood -= missilePower;
    	
    	if(blood <= 0) {
    		isVisible = false;
    	}
    }
    
    
    public void setVisible() {
    	isVisible = false;
    }
    
    protected abstract String getImageName();
}
