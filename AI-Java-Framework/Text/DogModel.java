package Text;

// import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.lang.Math;
import java.io.*;


/**
 * The <code>TextApp</code> is an application that demonstrates the dog model
 * algorithms.
 *
 * @author Tang Sing Lun Alan
 *
 *
 * @copyright
 * 
 * (C) Tang Sing Lun Alan  2026
 *
 */
public class DogModel extends Object implements Serializable {
  // private String name;

  // data parameters
  protected Vector<String> labels = new Vector<>();
  protected Vector<String> words = new Vector<>();
  List<Integer> index = new ArrayList<>();
  transient public JTextArea textArea1 = new JTextArea();
  protected String fileName = "";
  protected int numOfLabels = 0;
  protected double mean = 0;
  protected double passageMean = 0;
  protected double proposedMean = 0;
  protected int wordsPerPassage = 0;
  protected double thresHold = 0.07;

    /**
   * Creates a dog Model Object with the given file name.
   * 
   *
   * 
   * @param fileName the text file from which the dataset is populated
   */
  public DogModel(String fileName) {
    if (fileName.endsWith(".dfn") || fileName.endsWith(".dat")) {
      int inx = fileName.indexOf('.');

      this.fileName = fileName.substring(0, inx);  // strip off the extension
    } else {
      this.fileName = fileName;  // text file name only 
    }
    numOfLabels = 0;                // start with no variables defined
  }

    /**
   * Reads the data from the passage defined by the data file.
   */
  public void loadPassageFile() {
    int numOfLines = 0;
    String word = "";
    StringTokenizer input = null;
    String line = null;
    BufferedReader in = null;
    int labelIndex = 0; 
    double sumOfWordsMatch = 0;

    try {
      in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName+".dat")));
    } catch (FileNotFoundException exc) {
      trace("Error: Can't find file " + fileName + ".dat");
    }


    try {
        while ((line = in.readLine()) != null) {
              if (line != null) {
                input = new StringTokenizer(line);
                while (input.hasMoreTokens()) {
                    word = input.nextToken();
                    words.add(word.toUpperCase());
                    wordsPerPassage++;
                    labelIndex = labels.indexOf(word.toUpperCase());
                    if (labelIndex != -1) {
                      sumOfWordsMatch = sumOfWordsMatch + index.get(labelIndex);
                    }
                    trace(word + " ");
                }
              } else {
                break;
              }
            trace("\n");
            numOfLines++;
          }
          trace("\nReading file " + fileName + ".dat with " + wordsPerPassage + " words per passage\n ");
          trace("\nLoaded " + numOfLines + " lines into memory.\n");
          calculateProposedNormalDistribution();
          calculatePassageNormalDistribution(sumOfWordsMatch); 
          predictPassage();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

    /**
   * Reads the data from the file defined by the label file.
   */
  public void loadDataFile() {
    String line = null;
    BufferedReader in = null;
    int numOfLines = 0;
    String word = "";
    StringTokenizer input = null;

    try {
      in = new BufferedReader(new InputStreamReader(new FileInputStream("/mnt/c/development/ai/AI-Java-Framework/" + "dog_" + "label.dat")));
    } catch (FileNotFoundException exc) {
      trace("Error: Can't find file " + fileName + ".dat");
    }

    try {
        while ((line = in.readLine()) != null) {
              if (line != null) {
                input = new StringTokenizer(line);
                while (input.hasMoreTokens()) {
                    word = input.nextToken();
                    labels.add(word.toUpperCase());                     
                }
              } else {
                break;
              }
            trace("\n");
            numOfLines++;
          }

          
          int position = labels.size();

          position = createIndex(position);

          Collections.shuffle(index.subList(0, index.size()));   
          
          position = createIndex(position); 

          Collections.shuffle(index.subList((int)Math.round(labels.size() * 0.35), index.size()));    
          
          position = createIndex(position); 

          Collections.shuffle(index.subList((int)Math.round(labels.size() * 0.7), index.size()));           
          
          for (int i = 0; i < labels.size(); i++) {
              trace(String.valueOf(index.get(i)) + " - " + labels.get(i) + "\n ");
          } 
          trace("\nReading file " + fileName + ".dat with " + numOfLabels + " labels per datafile\n ");
          trace("\nLoaded " + numOfLines + " lines into memory.\n");
          calculateNormalDistribution();  
    } catch (IOException e) {
        e.printStackTrace();
    }
  }


   /**
   * Generate the Index for the labels.
   */

  public int createIndex(int position) {

          for (int i = (int)Math.round(labels.size() * 0.35); i > 0; i--) {
              if (position == 0){
                break;
              }
              index.add(position--); 
          }  
          return position;
  }

   /**
   * Calculate the propose normal distribution on poportion base on the passage.
   */

  public void calculateProposedNormalDistribution() {
    proposedMean = ((double)wordsPerPassage * (double)mean) / (double)labels.size();
    trace("Proposed Mean is "+ String.valueOf(proposedMean) + "\n ");
  }

   /**
   * Calculate the normal distribution base on the label data file.
   */

  public void calculateNormalDistribution() {

    mean = (1 + (double)labels.size()) / 2;
    trace("Mean is "+ String.valueOf(mean) + "\n ");

  }

   /**
   * Calculate the normal distribution base on the passage file.
   */
  public void calculatePassageNormalDistribution(double sumOfWordsMatch) {

    passageMean = (double)sumOfWordsMatch / (double)labels.size();
    trace("Passage mean is "+ String.valueOf(passageMean) + "\n ");

  }

  /**
   * predict the passage subject.
   */
  public void predictPassage() {
          if (passageMean >= (proposedMean * thresHold)) {
            trace("It is a dog. \n");
          } 
          else {
            trace("It is not a dog. \n");            
          } 
  }

    /**
   * Adds text to the text area for display.
   *
   * @param text the String to be displayed
   */
  public void trace(String text) {
    if (textArea1 != null) {
      textArea1.append(text);
    } else {
      System.out.println(text);
    }
  }

    /**
   * Sets the text area to be displayed for the dataset information.
   *
   * @param textArea the JTextArea text area to be displayed
   */
  public void setDisplay(JTextArea textArea) {
    textArea1 = textArea;
  }

  /**
   * Sets the file name for loading the dataset.
   *
   * @param fileName the file name for loading the data
   */

}
