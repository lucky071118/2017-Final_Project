import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class AnimationTimer{
	private Timer timer;
	private final int DELAY = 15;
	private static AnimationTimer animationATimer;
	
	
	
	private AnimationTimer(ActionListener actionListener) {
		timer = new Timer(DELAY, actionListener);
	}
	
	
	
	
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
