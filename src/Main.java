import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	public Main() { 
        initUI();
    }
    
    private void initUI() {
    	
    	Board board = new Board();
    	Model model = new Model();
    	TowerPanel towerPanel = new TowerPanel(model.getTowers());
    	Controller controller = new Controller(model, board,towerPanel);
    	
        add(board,BorderLayout.CENTER);
        add(towerPanel,BorderLayout.EAST);
        pack();
        setSize(1600, 720);
        setResizable(false);
        
        setTitle("Tower Defense Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
            	Main ex = new Main();
                ex.setVisible(true);
            }
        });
    }
	

}
