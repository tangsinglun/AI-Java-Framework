package Text;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;


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
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu FileMenu = new JMenu();
  JMenu DataMenu = new JMenu();
  JMenu AlgorithmMenu = new JMenu();
  ButtonGroup buttonGroup = new ButtonGroup();
  JMenu HelpMenu = new JMenu();
  JMenuItem ExitMenuItem = new JMenuItem();
  JPanel jPanel = new JPanel();
  JPanel jPanel2 = new JPanel();
  BorderLayout borderLayout = new BorderLayout();
  JScrollPane jScrollPane = new JScrollPane();
  JTextArea dataTextArea = new JTextArea();
  JTextArea traceTextArea = new JTextArea();
  JRadioButtonMenuItem DogModelRadioButtonMenuItem = new JRadioButtonMenuItem();
  JMenuItem LoadDataMenuItem = new JMenuItem();
  JMenuItem AboutMenuItem = new JMenuItem();
  JButton button = new JButton("Passage of Dog");
  JButton button2 = new JButton("Passage of Dog and Vet");
  double mean = 0;
  double passageMean = 0;
  double proposedMean = 0;


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
     
    jPanel.setLayout(null);
    jPanel.setPreferredSize(new Dimension(1000, 300));  
    jPanel2.setLayout(borderLayout);
    jPanel2.setPreferredSize(new Dimension(1000, 700));
    jScrollPane.setViewportView(dataTextArea);
    button.setBounds(0, 200, 250, 30); 
    button2.setBounds(300, 200, 350, 30); 
    jPanel.add(button);
    jPanel.add(button2);
    jPanel2.add(jScrollPane);
    this.setSize(new Dimension(1000, 1000));
    this.setTitle("Text Application - Dog Model");
    this.getContentPane().add(jPanel, BorderLayout.SOUTH);
    this.getContentPane().add(jPanel2, BorderLayout.NORTH);

    FileMenu.setText("File");
    DataMenu.setText("Data");
    AlgorithmMenu.setText("Algorithm");
    DogModelRadioButtonMenuItem.setText("Dog Model");
    DogModelRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DogModelRadioButtonMenuItem_actionPerformed(e);
      }
    });
    buttonGroup.add(DogModelRadioButtonMenuItem);

    DogModelRadioButtonMenuItem.setSelected(true);
    HelpMenu.setText("Help");
    ExitMenuItem.setText("Exit");


    LoadDataMenuItem.setText("Load...");
    LoadDataMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        LoadData_actionPerformed(e);
      }
    });
    button.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        LoadData_actionPerformed(e);
      }
    });
    button2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        LoadMultiData_actionPerformed(e);
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
  void LoadData_actionPerformed(ActionEvent e) {
    FileDialog dlg = new FileDialog(this, "Load Data Set", FileDialog.LOAD);

    dlg.setFile("*.dfn");
    dlg.setVisible(true);;
    String dirName = null;
    String fileName = null;
    dirName = dlg.getDirectory() ;
    fileName = dlg.getFile();
    boolean passageCheck = false;
    String baseFileName = fileName.contains(".") ? fileName.substring(0, fileName.lastIndexOf('.')) : fileName;

    if (fileName != null) {
      dataTextArea.setText("");      
      DogModel dogModel = new DogModel(dirName+fileName);
      dogModel.setDisplay(dataTextArea);
      dogModel.loadLabelDataFile("dog_label"); 
      mean = dogModel.getNormalDistribution();
      dogModel.loadPassageFile(baseFileName);          // load the data set
      passageMean = dogModel.getPassageNormalDistribution();
      proposedMean = dogModel.getProposedNormalDistribution();
      passageCheck =  dogModel.predictPassage(passageMean, proposedMean, 0.05);

      if (passageCheck) {
        dataTextArea.append("This passage is related.\n");
      } 
      else {
         dataTextArea.append("This passage is not related.\n");           
      } 
      this.repaint();
    }

  }


    /**
   * Gets the dataset filename and loads the dataset.
   *
   * @param e the ActionEvent that was generated
   */
  void LoadMultiData_actionPerformed(ActionEvent e) {
    FileDialog dlg = new FileDialog(this, "Load Data Set", FileDialog.LOAD);
    boolean passageCheck = false;
    boolean passageCheck1 = false;

    dlg.setFile("*.dfn");
    dlg.setVisible(true);;
    String dirName = null;
    String fileName = null;
    dirName = dlg.getDirectory() ;
    fileName = dlg.getFile();
    String baseFileName = fileName.contains(".") ? fileName.substring(0, fileName.lastIndexOf('.')) : fileName;

    if (fileName != null) {
      dataTextArea.setText("");      
      DogModel dogModel = new DogModel(dirName+fileName);
      dogModel.setDisplay(dataTextArea);
      dogModel.loadLabelDataFile("dog_label"); 
      mean = dogModel.getNormalDistribution();
      dogModel.loadPassageFile(baseFileName);          // load the data set
      passageMean = dogModel.getPassageNormalDistribution();
      proposedMean = dogModel.getProposedNormalDistribution();
      passageCheck =  dogModel.predictPassage(passageMean, proposedMean, 0.05);

      dogModel.labels.clear();
      dogModel.words.clear();
      dogModel.index.clear();

      dogModel.loadLabelDataFile("vet_label"); 
      mean = dogModel.getNormalDistribution();
      dogModel.loadPassageFile(baseFileName);          // load the data set
      passageMean = dogModel.getPassageNormalDistribution();
      proposedMean = dogModel.getProposedNormalDistribution();
      passageCheck1 =  dogModel.predictPassage(passageMean, proposedMean, 0.02);

      dataTextArea.append("First - "+ passageCheck + ".\n");
      dataTextArea.append("Second - "+ passageCheck1 + ".\n");

      if (passageCheck && passageCheck1) {
        dataTextArea.append("This passage is related.\n");
      } 
      else {
         dataTextArea.append("This passage is not related.\n");           
      } 

      // dogModel.loadLabelDataFile("vet_label"); 
      // DataSetFileNameLabel.setText(dirName+fileName);
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
