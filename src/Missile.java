
public class Missile extends GameObject{
	
	private final int BOARD_WIDTH = 390;
    private final int MISSILE_SPEED = 2;
    
    public Missile(int x, int y){
        super(x, y);
        
        initMissile();
    }
    
    private void initMissile(){
        loadImage("com\\moving_sprite\\missile.png");  
        getImageDimensions();
    }
    
    public void move() {
        
        x += MISSILE_SPEED;
        
        if (x > BOARD_WIDTH) {
            isVisible = false;
        }
    }
}
