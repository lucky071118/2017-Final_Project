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
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{
    private final int DELAY = 15;
    private final int B_WIDTH = 1740;
    private final int B_HEIGHT = 720;
    private Timer timer;
    private ArrayList<Missile> missiles;
    private ArrayList<Enemy> enemies;
    private boolean ingame;
    private TowerTimer towerTimer;
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
    
   
    
    
    public Board(){
        
        initBoard();
        
    }
    
    private void initBoard(){
        
       
        setFocusable(true);
        setBackground(Color.GRAY);
        
        ingame = true;
        
       
        
        
        initEnemies();
        
        timer = new Timer(DELAY, this);
        timer.start();
        
        missiles = new ArrayList<Missile>();
        
    }
   
    
    private void initEnemies(){
        enemies = new ArrayList<Enemy> ();
        
        for(int[] position : enemyPositions){
            
            enemies.add(new EnemyA(position[0], position[1]));
        }
        enemies.add(new EnemyB(0, 360));
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if (ingame){
            drawObjects(g);
        }else{
            drawGameOver(g);
        }
        
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawObjects(Graphics g){
    	
    	
    	
        Graphics2D g2d = (Graphics2D) g;
        
        
       
//        for(Tower tower : towers){
//        	if(tower.isVisible()){
//                g2d.drawImage(tower.getImage(), tower.getX(), tower.getY(), this);
//            }
//        }
        
       
        	 
        for(Missile missile : missiles){
			if (missile.isVisible()) {
				g2d.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);
			}
		}
        
      
        
        for(Enemy enemy : enemies){
            if(enemy.isVisible()){
                g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
            }
        }
        
        g.setColor(Color.WHITE);
        g.drawString("Enemies left: " + enemies.size(), 5, 15);
        
      
        
    }
    
    private void drawGameOver(Graphics g){
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        inGame();
//        updateCraft();
        
        
        updateMissiles();
        updateEnemies();
        
        checkCollisions();
        
        repaint();
        
    }
    
    
    private void inGame(){
        if (!ingame) {
            timer.stop();
        }
    }
    
//    private void updateCraft(){
//        
//        craft.move();
//    }
    
    
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
            ingame = false;
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
    
    
    
    public ArrayList<Missile> getMissiles(){
    	return missiles;
    }
    
    public void addMissiles(ArrayList<Missile> newMissiles) {
    	missiles.addAll(newMissiles);
    }
    
    
}
