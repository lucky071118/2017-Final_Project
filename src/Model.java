
public class Model {
	private Tower[] towers;
	
	 
	public Model() {
		initTowers();
		 
	}
	
	private void initTowers(){
    	towers = new Tower[7];
    	for(int i=0; i<towers.length; i++) {
    		towers[i] = new TowerA(1500, i*100);
    	}
    	
    }
	
	
	
	
	public Tower[] getTowers() {
		return towers;
	}
	
	    
	public Tower getTower(int number) {
		return towers[number];
	}
}
