import java.awt.event.ActionListener;

public class Controller {
	private TowerTimer towerTimer;
	private TowerButtonListener towerButtonListener;
	private Model model;
	private Board board;
	private TowerPanel towerPanel;
	
	
	public Controller(Model model,Board board, TowerPanel towerPanel) {
		this.model = model;
		this.board = board;
		this.towerPanel = towerPanel;
		
		initTowerTimer();
		initTowerButtonListener();
		setTowerButtonListener();
	}
	
	private void initTowerTimer() {
		towerTimer = TowerTimer.getActionListener();
        towerTimer.setTowers( model.getTowers());
        towerTimer.setMissiles( board.getMissiles());
        towerTimer.startTime();
	}
	
	public void initTowerButtonListener() {
		towerButtonListener = new TowerButtonListener();
		towerButtonListener.setTowers(model.getTowers());
	}
	
	public void setTowerButtonListener() {
		towerPanel.setActionListener(towerButtonListener);
	}
	
	
		
//		updateDialogFactory = new DialogFactoryA(model.getTower(number));
	
}
