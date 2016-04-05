import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DatabaseMenuHandler implements ActionListener{
	JFrame jframe;
	model m;
	public DatabaseMenuHandler(JFrame jf, model md) {
		jframe = jf;
		m=md;
	}
	
	public void actionPerformed(ActionEvent event) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		String menuName = event.getActionCommand();
		if (menuName.equals("Fruit")) {
			try {
				m.DisplayFruit();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "No data file found");
			}

		}
		else if (menuName.equals("Vegetable")) {
			try {
				m.DisplayVegetable();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "No data file found");
			}
			
			
		}
		else if (menuName.equals("Open Database File")) {
			try {
				fc.showOpenDialog(null);
				File f = fc.getSelectedFile();
				m.OpenDatabase(f.getAbsolutePath());
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Please select a data file");
			}

			
		}
		else if (menuName.equals("DisplayAll")) {
			try {
				m.DisplayAll();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "No data file found");
			}
			
		}
	}
}
