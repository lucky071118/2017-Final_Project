import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateDialog extends JDialog{
	
	public UpdateDialog(ArrayList<String> StringResults,ActionListener buttonListener) {
		setTitle("Update Tower");
		
		setLayout(new GridLayout(StringResults.size(), 1));
//		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
//		ArrayList<JButton> buttonList = new ArrayList<JButton>();
		
		for(String result : StringResults) {
			JButton button = new JButton(result);
			button.addActionListener(buttonListener);
			add(button);
		}
		
		
		
		
		
		
		
	
		
		
		
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		
		pack();
		
	}
	
	
}
