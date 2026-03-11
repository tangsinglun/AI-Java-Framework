package Text;

import javax.swing.UIManager;
import java.awt.Font;


/**
 * The <code>TextApp</code> is an application that demonstrates the dog model
 * algorithms.
 * 
 *
 * @author Tang Sing Lun Alan
 * 
 *
 * @copyright
 * 
 * (C) Tang Sing Lun Alan  2026
 *
 */
public class TextApp extends Object {
  boolean packFrame = false;


  /**
   * Creates the learn application.
   */
  public TextApp() {
    TextFrame frame = new TextFrame();

    // Pack frames that have useful preferred size info. from their layout or
    // validate frames that have preset sizes.
    if (packFrame) {
      frame.pack();
    } else {
      frame.validate();
    }
    frame.setVisible(true);
  }


  /**
   * Runs the learn application.
   *
   * @param args  a String array used to pass arguments into the class. Not used
   *              in this application.
   */
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      UIManager.put("Label.font", new Font("SansSerif", Font.PLAIN, 18));
      UIManager.put("Button.font", new Font("SansSerif", Font.PLAIN, 20));
      UIManager.put("TextField.font", new Font("SansSerif", Font.PLAIN, 18));
      UIManager.put("Menu.font", new Font("SansSerif", Font.PLAIN, 18));
      UIManager.put("MenuItem.font", new Font("SansSerif", Font.PLAIN, 18));
      UIManager.put("TextArea.font", new Font("SansSerif", Font.PLAIN, 18));
      UIManager.put("RadioButtonMenuItem.font", new Font("SansSerif", Font.PLAIN, 18));
      UIManager.put("JFrame.font", new Font("SansSerif", Font.PLAIN, 18));
    } catch (Exception e) {}
    new TextApp();
  }
}
