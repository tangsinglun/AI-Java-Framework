package learn;

import javax.swing.UIManager;
import java.awt.Font;


/**
 * The <code>LearnApp</code> is an application that demonstrates three learing
 * algorithms: back propagation network, Kohonen map network, and a decision
 * tree.
 *
 * @author Joseph P. Bigus
 * @author Jennifer Bigus
 *
 * @copyright
 * Constructing Intelligent Agents using Java
 * (C) Joseph P. Bigus and Jennifer Bigus 1997, 2001
 *
 */
public class LearnApp extends Object {
  boolean packFrame = false;


  /**
   * Creates the learn application.
   */
  public LearnApp() {
    LearnFrame frame = new LearnFrame();

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
    new LearnApp();
  }
}
