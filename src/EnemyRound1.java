import java.util.ArrayList;
import java.util.Random;

public class EnemyRound1 implements EnemyFactory{

	 
	 private int enemyANumber = 10;
	 
	
	
     
     public ArrayList<Enemy> createEnemy(int width, int height) {
    	 ArrayList<Enemy> enemies = new ArrayList<Enemy> ();
    	 Random ran = new Random();
    	 for(int i=0; i< enemyANumber; i++) {
    		 enemies.add(new EnemyA((-1*ran.nextInt(1000)), ran.nextInt(620)));
    	 }
    	 
    	
    	enemies.add(new EnemyB(-300, ran.nextInt(300)));
    	enemies.add(new EnemyB(-750, ran.nextInt(420)));
    	 
    	 
    	
    	enemies.add(new EnemyC(-1000, height/2));
    	 
   	
		         
    	 return enemies;
    	 
     }
     
     
	 
}
