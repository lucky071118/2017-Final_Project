import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class AnimationTimer{
	/*
	 * AnimationTimer is a timer for JPanel animation 
	 * 
	 * 
	 * 
	 */
	
	
	
	private Timer timer;
	
	//update Jpanel every 15ms
	private final int DELAY = 15;
	
	//use singleton pattern for users only use a timer
	private static AnimationTimer animationATimer;
	
	
	
	//set actionListener from controller
	//invoke the actionListener method every delay
	private AnimationTimer(ActionListener actionListener) {
		timer = new Timer(DELAY, actionListener);
	}
	
	
	
	//use static method to get animationTimer 
	public static AnimationTimer getTimer(ActionListener actionListener) {
		if(animationATimer == null) {
			animationATimer = new AnimationTimer(actionListener);
		}
		
		return animationATimer;
	}
	
	
	
	public void startTime() {
		timer.start();
	}
	
	
	public void stopTime() {
		timer.stop();
	}
	
	
	
	
	
}
