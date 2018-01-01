import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class UpdateButtonListener implements ActionListener{
	
	private JDialog dialog;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(dialog != null) {
			dialog.dispose();
		}
	}
	
	public void setDialog(JDialog dialog) {
		
		if(dialog != null) {
		}
		this.dialog = dialog;
	}
	

}
