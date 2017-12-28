import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{
    private final int DELAY = 15;
    private final int B_WIDTH = 1200;
    private final int B_HEIGHT = 900;
    private Timer timer;
    private ArrayList<Tower> towers;
    private ArrayList<Enemy> enemies;
    private boolean ingame;
    
    private final int[][] enemyPositions = {
        {0, 29}, {0, 59}, {0, 89},
        {-78, 109}, {-6, 139}, {0, 239},
        {-79, 259}, {-21, 50}, {0, 150},
        {-98, 209}, {-560, 45}, {-510, 70},
        {-93, 159}, {-590, 80}, {-530, 60},
        {-940, 59}, {-990, 30}, {-920, 200},
        {-900, 259}, {-660, 50}, {-540, 90},
        {-810, 220}, {-860, 20}, {-740, 180},
        {-820, 128}, {-490, 170}, {-700, 30}
    };
    
    private final int[][] towerPositions = {
            {1000, 29}, {900, 59}
        };
    
    
    public Board(){
        
        initBoard();
    }
    
    private void initBoard(){
        
       
        setFocusable(true);
        setBackground(Color.BLACK);
        
        ingame = true;
        
        initTowers();
        
        
        initEnemies();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    private void initTowers(){
    	towers = new ArrayList<Tower> ();
        
    	for(int[] position : towerPositions) {
    		towers.add(new Tower(position[0], position[1]));
    	}
    }
    
    private void initEnemies(){
        enemies = new ArrayList<Enemy> ();
        
        for(int[] position : enemyPositions){
            
            enemies.add(new Enemy(position[0], position[1]));
        }
        
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
        
        for(Tower tower : towers){
        	if(tower.isVisible()){
                g2d.drawImage(tower.getImage(), tower.getX(), tower.getY(), this);
            }
        }
        
        for(Tower tower : towers){
        	  ArrayList<Missile> missiles = tower.getMissiles();
              for(Missile missile : missiles){
                  if(missile.isVisible()){
                      g2d.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);
                  }
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
        for(Tower tower : towers){
        	tower.fire();
        }
        
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
    	for(Tower tower : towers){
    		ArrayList<Missile> missiles = tower.getMissiles();
    		for(int i = 0; i < missiles.size(); i++){
    			Missile missile = missiles.get(i);
    			if(missile.isVisible()){
    				missile.move();
    			}else{
    				missiles.remove(i);
    			}
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
        
//        Rectangle r3 = craft.getBounds();
//        
//        for(Alien alien :enemies){
//            Rectangle r2 = alien.getBounds();
//            if(r3.intersects(r2)){
//                craft.setVisible(false);
//                alien.setVisible(false);
//                ingame = false;
//            }
//            
//        }
    	for(Tower tower : towers){
    		ArrayList<Missile> missiles = tower.getMissiles();
        
    		for(Missile missile : missiles){
    			Rectangle r1 = missile.getBounds();
            
    			for(Enemy enemy :enemies){
    				Rectangle r2 = enemy.getBounds();
    				if(r1.intersects(r2)){
    					missile.setVisible(false);
    					enemy.setVisible(false);
    				}
    			}
    		}
    	}
        
        
    }
    
    
}
