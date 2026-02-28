package marketplace;

import javax.swing.UIManager;
import java.awt.*;
import java.awt.Font;


/**
 * The <code>MarketplaceApp</code> class implements the marketplace
 * application which allows buyer and seller agents to negotiate when buying
 * and selling items.
 *
 * @author Joseph P. Bigus
 * @author Jennifer Bigus
 *
 * @copyright
 * Constructing Intelligent Agents using Java
 * (C) Joseph P. Bigus and Jennifer Bigus 2001
 *
 */
public class MarketplaceApp {
  boolean packFrame = false;

  /**
   * Creates a <code>MarketplaceApp</code> object.
   *
   */
  public MarketplaceApp() {
    MarketplaceFrame frame = new MarketplaceFrame();

    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from their layout
    if (packFrame) {
      frame.pack();
    } else {
      frame.validate();
    }

    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();

    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
  }


  /**
   * Runs the marketplace applicaiton
   *
   * @param args the String[] object (not used)
   *
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
      UIManager.put("CheckBoxMenuItem.font", new Font("SansSerif", Font.PLAIN, 18));
      UIManager.put("JFrame.font", new Font("SansSerif", Font.PLAIN, 18));
    } catch (Exception e) {}
    new MarketplaceApp();
  }
}
