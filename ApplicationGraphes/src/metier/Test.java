package metier;

import javax.swing.UIManager;
import presentation.Fenetre;

/**
 *
 * @author Hans
 */
public class Test {

    /**
     *
     * @param arg
     */
    public static void main(String[] arg) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        Fenetre fen = new Fenetre();



    }
}
