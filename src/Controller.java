
public class Controller {
	private TowerTimer towerTimer;
	
	private Model model;
	private Board board;
	
	
	public Controller(Model model,Board board) {
		this.model = model;
		this.board = board;
		
		initTowerTimer();
	}
	
	private void initTowerTimer() {
		towerTimer = TowerTimer.getActionListener();
        towerTimer.setTowers( model.getTowers());
        towerTimer.setMissiles( board.getMissiles());
        towerTimer.startTime();
	}
}
