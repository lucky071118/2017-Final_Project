
public class Enemy extends GameObject{
	
	private final int INITIAL_X = 400;

    public Enemy(int x, int y){
        super(x, y);
        initAlien();
    }
    
    private void  initAlien(){
        
        loadImage("com\\moving_sprite\\alien.png");
        getImageDimensions();
        
    }
    
    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;
    }
}
