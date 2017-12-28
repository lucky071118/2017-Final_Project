
public abstract class Enemy extends GameObject{
	
	private int blood;
	private int speed;

    public Enemy(int x, int y, int blood, int speed){
        super(x, y);
        this.blood = blood;
        this.speed = speed;
        initEnemy();
        
    }
    
    private void  initEnemy(){
        
        loadImage("bin\\EnemyA.png");
        getImageDimensions();
        
    }
    
    
    
    public void move() {
        x += speed;
    }
    
    public void bloodLoss(int missilePower) {
    	blood -= missilePower;
    	
    	if(blood <= 0) {
    		isVisible = false;
    	}
    }
}
