import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	private final int gameWidth = 1280;
	private final int gameHeight = 720;
	
	public Main() { 
        initUI();
    }
    
    private void initUI() {
    	
    	Board board = new Board(gameWidth-100, gameHeight);
    	Model model = new Model();
    	TowerPanel towerPanel = new TowerPanel(model.getTowers());
    	Controller controller = new Controller(model, board, towerPanel);
    	
        add(board,BorderLayout.CENTER);
        add(towerPanel,BorderLayout.EAST);
        pack();
        setSize(gameWidth, gameHeight);
        setResizable(false);
        
        setTitle("Tower Defense Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
            	Main ex = new Main();
                
            }
        });
    }
	

}
