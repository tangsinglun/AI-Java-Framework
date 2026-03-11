package Text;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.io.*;
import java.util.*;


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
public class TextFrame extends JFrame {
  BorderLayout borderLayout1 = new BorderLayout();
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu FileMenu = new JMenu();
  JMenu DataMenu = new JMenu();
  JMenu AlgorithmMenu = new JMenu();
  ButtonGroup buttonGroup = new ButtonGroup();
  JMenu HelpMenu = new JMenu();
  JMenuItem ExitMenuItem = new JMenuItem();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea dataTextArea = new JTextArea();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextArea traceTextArea = new JTextArea();
  JLabel jLabel1 = new JLabel();
  BorderLayout borderLayout3 = new BorderLayout();
  BorderLayout borderLayout4 = new BorderLayout();
  JRadioButtonMenuItem DogModelRadioButtonMenuItem = new JRadioButtonMenuItem();
  JMenuItem LoadDataMenuItem = new JMenuItem();
  JMenuItem AboutMenuItem = new JMenuItem();
  JLabel DataSetFileNameLabel = new JLabel();


  /**
   * Constructs the frame for the Text Application.
   */
  public TextFrame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  /**
   * Initializes the UI components.
   *
   * @throws Exception if any errors occur
   */
  private void jbInit() throws Exception {
    this.getContentPane().setLayout(borderLayout1);
    this.setSize(new Dimension(600, 479));
    this.setTitle("Text Application - Dog Model");
    FileMenu.setText("File");
    DataMenu.setText("Data");
    AlgorithmMenu.setText("Algorithm");
    DogModelRadioButtonMenuItem.setText("Dog Model");
    DogModelRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DogModelRadioButtonMenuItem_actionPerformed(e);
      }
    });
    DataSetFileNameLabel.setBounds(new Rectangle(78, 10, 312, 25));
    buttonGroup.add(DogModelRadioButtonMenuItem);

    DogModelRadioButtonMenuItem.setSelected(true);
    HelpMenu.setText("Help");
    ExitMenuItem.setText("Exit");
    jPanel2.setLayout(borderLayout2);
    jPanel4.setMinimumSize(new Dimension(600, 200));
    jPanel4.setPreferredSize(new Dimension(600, 200));
    jPanel4.setLayout(borderLayout3);
    jPanel1.setMinimumSize(new Dimension(600, 50));
    jPanel1.setPreferredSize(new Dimension(600, 50));
    jPanel1.setLayout(null);
    jLabel1.setText("Data Set:");
    jLabel1.setBounds(new Rectangle(15, 14, 69, 17));
    jPanel5.setLayout(borderLayout4);
    LoadDataMenuItem.setText("Load...");
    LoadDataMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        LoadDataMenuItem_actionPerformed(e);
      }
    });
    AboutMenuItem.setText("About");
    AboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        AboutMenuItem_actionPerformed(e);
      }
    });
    jMenuBar1.add(FileMenu);
    jMenuBar1.add(DataMenu);
    jMenuBar1.add(AlgorithmMenu);
    jMenuBar1.add(HelpMenu);
    AlgorithmMenu.add(DogModelRadioButtonMenuItem);
    FileMenu.add(ExitMenuItem);
    this.getContentPane().add(jPanel1, BorderLayout.NORTH);
    jPanel1.add(jLabel1, null);
    jPanel1.add(DataSetFileNameLabel, null);
    this.getContentPane().add(jPanel2, BorderLayout.CENTER);
    jPanel2.add(jPanel4, BorderLayout.NORTH);
    jPanel4.add(jScrollPane2, BorderLayout.CENTER);
    jScrollPane2.getViewport().add(dataTextArea, null);
    jPanel2.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(traceTextArea, null);
    this.getContentPane().add(jPanel3, BorderLayout.SOUTH);
    DataMenu.add(LoadDataMenuItem);
    HelpMenu.add(AboutMenuItem);
    setJMenuBar(jMenuBar1);
  }


  /**
   * Processes window events and is overridden to exit when window closes.
   *
   * @param e the WindowEvent to be processed
   */
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    } else if (e.getID() == WindowEvent.WINDOW_ACTIVATED) {
      e.getWindow().repaint();
    }
  }

  /**
   * Sets the title on the frame when the back prop radio button is clicked.
   *
   * @param e the ActionEvent that was generated
   */
  void DogModelRadioButtonMenuItem_actionPerformed(ActionEvent e) {
    setTitle("Text Application - Dog Model");
  }



  /**
   * Gets the dataset filename and loads the dataset.
   *
   * @param e the ActionEvent that was generated
   */
  void LoadDataMenuItem_actionPerformed(ActionEvent e) {
    FileDialog dlg = new FileDialog(this, "Load Data Set", FileDialog.LOAD);

    dlg.setFile("*.dfn");
    dlg.setVisible(true);;
    String dirName = null;
    String fileName = null;
    dirName = dlg.getDirectory() ;
    fileName = dlg.getFile();

    if (fileName != null) {
      dataTextArea.setText("");      
      DogModel dogModel = new DogModel(dirName+fileName);
      dogModel.setDisplay(dataTextArea);
      dogModel.loadDataFile(); 
      dogModel.loadPassageFile();          // load the data set
      DataSetFileNameLabel.setText(dirName+fileName);
      this.repaint();
    }

  }


  /**
   * Displays the About dialog.
   *
   * @param e the ActionEvent generated when About was selected
   *
   */
  void AboutMenuItem_actionPerformed(ActionEvent e) {
    AboutDialog dlg = new AboutDialog(this, "About Text Application", true);
    Point loc = this.getLocation();
    dlg.setLocation(loc.x + 50, loc.y + 50);
    dlg.setVisible(true);;
  }

}
