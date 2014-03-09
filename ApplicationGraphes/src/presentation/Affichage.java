package presentation;

import javax.swing.UIManager;
import javax.swing.UIManager.*;

public class Affichage {

	public static void main(String[] args) {

		Fenetre fen = new Fenetre();
				try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
	}

}
