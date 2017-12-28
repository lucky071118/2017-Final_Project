
public class Enemy extends GameObject{
	
	

    public Enemy(int x, int y){
        super(x, y);
        initEnemy();
    }
    
    private void  initEnemy(){
        
        loadImage("bin\\EnemyA.png");
        getImageDimensions();
        
    }
    
    public void move() {
        x += 1;
    }
}
