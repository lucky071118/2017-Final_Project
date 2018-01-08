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
   
    
    private ArrayList<Missile> missiles;
    private ArrayList<Enemy> enemies;
    
    private final int boardWidth;
	private final int boardHeight;
    
    
    private StateInterface state = new GameStartState();
    private int playerBlood;
 

    private final int[][] enemyPositions = {
        {0, 0}, {0, 0}, {0, 180},
        {-78, 180}, {-6, 180}, {0, 0},
        {-79, 0}, {-21, 180}, {0, 180},
        {-98, 180}, {-560, 0}, {-510, 0},
        {-93, 0}, {-590, 180}, {-530, 180},
        {-940, 180}, {-990, 0}, {-920, 0},
        {-900, 0}, {-660, 180}, {-540, 180},
        {-810, 180}, {-860, 0}, {-740, 180},
        {-820, 0}, {-490, 180}, {-700, 0}
    };
    
   
    
    
    public Board(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        initBoard();
        
    }
    
    private void initBoard(){
        
       
        setFocusable(true);
        setBackground(Color.GRAY);
        
       
       
        
        
        initEnemies();
        
       
        
        missiles = new ArrayList<Missile>();
        System.out.println("initial board");
    }
   
    
    private void initEnemies(){
        enemies = new ArrayList<Enemy> ();
        
        for(int[] position : enemyPositions){
            
            enemies.add(new EnemyA(position[0], position[1]));
        }
        enemies.add(new EnemyB(0, 360));
    }
    
    
    
    public void paint(StateInterface state) {
    	this.state = state;
    	repaint();
    	
    }
    
    

    
    @Override
    public void paintComponent(Graphics g){
    	
        super.paintComponent(g);
        state.paint(g, this);
        Toolkit.getDefaultToolkit().sync();
    }
    
   
    
   
    public void update() {
    	
    	
    	updateMissiles();
    	updateEnemies();
       
    	checkCollisions();
    	checkBoundary();
    	repaint();
    }
    
  
  
    
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
    
    
    //Set player blood
    public void setPlayerBlood(int playerBlood) {
    	this.playerBlood = playerBlood;
    }
    
    //Get player blood
    public int getPlayerBlood() {
    	return playerBlood;
    }
    
    
    public int getHeight() {
    	return boardHeight;
    }
    
    public int getWidth() {
    	return boardWidth;
    }
    
    
    
    public boolean checkRound() {
    	boolean result = true;
    	if(enemies.isEmpty()){
    		result = false;
    	}
    	return result;
    }
    
    public boolean checkGame() {
    	boolean result = false;
    	if(playerBlood == 0){
    		result = true;
    	}
    	return result;
    }
    
   
    public void setPanelListener(MouseListener startGmaeListener) {
    	addMouseListener(startGmaeListener);
    }
    
    
    
    
}
