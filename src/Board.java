import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends JPanel{
   
    
	//missiles in the game board
    private ArrayList<Missile> missiles;
    
    //enemies in the game board
    private ArrayList<Enemy> enemies;
    
    //the width of game board 
    private final int boardWidth;
    
    //the height of game board
	private final int boardHeight;
    
    
	//initial state for update paint 
    private StateInterface state = new GameStartState();
    
    //the blood of the player
    private int playerBlood;
 
    
   
    
    
   
    
    
    public Board(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        initBoard();
        
    }
    
   
    private void initBoard(){
        
       
        setFocusable(true);
        setBackground(Color.GRAY);
        
        missiles = new ArrayList<Missile>();
       
        enemies = new ArrayList<Enemy>();
       
       
    }
    
    //When starting the new round, the method will be invoked
    public void newRound(EnemyFactory factory) {
    	
    	missiles.clear();
    	enemies.addAll( factory.createEnemy(boardWidth,boardHeight));
    }
    
    
   
    
    
    //controller invoke the method to update the JPanel
    public void paint(StateInterface state) {
    	this.state = state;
    	repaint();
    	
    }
    
    

    //paint the JPanel with the new information about enemy and missile
    @Override
    public void paintComponent(Graphics g){
    	
        super.paintComponent(g);
        state.paint(g, this);
        Toolkit.getDefaultToolkit().sync();
    }
    
   
    
   //update all information about enemy and missile
    public void update() {
    	
    	
    	updateMissiles();
    	updateEnemies();
       
    	checkCollisions();
    	checkBoundary();
    	repaint();
    }
    
  
  
    //move the enemy position or clear from the arraylist
    private void updateMissiles(){
    	
    		
		for (int i = 0; i < missiles.size(); i++) {
			Missile missile = missiles.get(i);
			if (missile.isVisible()) {
				missile.move();
			} else {
				missiles.remove(i);
			}
		}
    	  
    }
    
    //move the enemy position or clear from arraylist
    private void updateEnemies(){
        if(enemies.isEmpty()){
            
            return;
        }
        
        for(int i = 0; i < enemies.size(); i++){
            Enemy enemy = enemies.get(i);
            if(enemy.isVisible()){
                enemy.move();
            }else{
                enemies.remove(i);
            }

        }
        
    }
    
    //check whether the missile check the enemy
    private void checkCollisions(){
        
    	
    	
		for (Missile missile : missiles) {
			Rectangle r1 = missile.getBounds();

			for (Enemy enemy : enemies) {
				Rectangle r2 = enemy.getBounds();
				if (r1.intersects(r2)) {

					missile.setVisible(false);
					enemy.bloodLoss(missile.getMissilePower());
					
				}
			}
    		
    	}
        
    }
    
    //check whether the enemy touch the tower
    private void checkBoundary() {
    	Rectangle r1 = new Rectangle(boardWidth, 0, 100, boardHeight);
    	for (Enemy enemy : enemies) {
			Rectangle r2 = enemy.getBounds();
			if (r1.intersects(r2)) {
				enemy.setVisible();
				playerBlood -= 1;
			}
		}
    	
    	
    }
    
    
    
    
    public ArrayList<Missile> getMissiles(){
    	return missiles;
    }
    
    
    public ArrayList<Enemy> getEnemies(){
    	return enemies;
    }
    
    public void addMissiles(ArrayList<Missile> newMissiles) {
    	missiles.addAll(newMissiles);
    }
    
    
   
    public void setPlayerBlood(int playerBlood) {
    	this.playerBlood = playerBlood;
    }
    
   
    public int getPlayerBlood() {
    	return playerBlood;
    }
    
    
    public int getHeight() {
    	return boardHeight;
    }
    
    public int getWidth() {
    	return boardWidth;
    }
    
    
    //check whether the round is over
    public boolean checkRound() {
    	boolean result = true;
    	if(enemies.isEmpty()){
    		result = false;
    	}
    	return result;
    }
    
    //check whether the game is over
    public boolean checkGame() {
    	boolean result = false;
    	if(playerBlood == 0){
    		result = true;
    	}
    	return result;
    }
    
   
    
    
    
    
}
