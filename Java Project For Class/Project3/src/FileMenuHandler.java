import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileMenuHandler implements ActionListener{
	JFrame jframe;
	model m;
	
	public FileMenuHandler(JFrame jf, model md) {
		// TODO Auto-generated constructor stub
		jframe = jf;
		m=md;
	}
	public void actionPerformed(ActionEvent event){
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		String menuName = event.getActionCommand();
		if(menuName.equals("Open Transaction File")){
			try {
				fc.showOpenDialog(null);
				File f = fc.getSelectedFile();
				m.OpenTransaction(f.getAbsolutePath());
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Please Select a transaction file!");
			}

		}
		else if (menuName.equals("Quit")) {
			System.exit(0);
		}
			
	}

}
