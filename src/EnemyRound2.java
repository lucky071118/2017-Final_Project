

import java.util.ArrayList;
import java.util.Random;

public class EnemyRound2 implements EnemyFactory{
	
	//The class will create the enemies for round 1
	 private int enemyANumber = 20;
	 private int enemyBNumber = 10;
	
	
     
     public ArrayList<Enemy> createEnemy(int width, int height) {
    	 ArrayList<Enemy> enemies = new ArrayList<Enemy> ();
    	 Random ran = new Random();
    	 for(int i=0; i< enemyANumber; i++) {
    		 enemies.add(new EnemyA((-1*ran.nextInt(1000)), ran.nextInt(620)));
    	 }
    	 
    	 for(int i=0; i< enemyBNumber; i++) {
    		 enemies.add(new EnemyB((-1*ran.nextInt(2000)), ran.nextInt(540)));
    	 }
    	
    	
    	 
    	 
    	enemies.add(new EnemyC(-1000, height/3));
    	 
    	enemies.add(new EnemyC(-2000, height/2));
    	enemies.add(new EnemyC(-500, height-260));
    	 
    	
   	
		         
    	 return enemies;
    	 
     }
}
