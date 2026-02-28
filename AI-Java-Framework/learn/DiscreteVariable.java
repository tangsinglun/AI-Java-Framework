package learn;

import java.util.*;
// import java.io.*;


/**
 * The <code>DiscreteVariable</code> class provides the support necessary
 * for variables that can take on a predefined set of numeric or symbolic
 * values.
 *
 * @author Joseph P. Bigus
 * @author Jennifer Bigus
 *
 * @copyright
 * Constructing Intelligent Agents using Java
 * (C) Joseph P. Bigus and Jennifer Bigus 1997, 2001
 *
 */
class DiscreteVariable extends Variable  {
  protected int min = 0;
  protected int max = 0;
  //protected Vector<String> labels;
  protected Vector<String> labels = new Vector<String>();


  /**
   * Creates a <code>DiscreteVariable</code> with the given name.
   *
   * @param name the String name given to the variable
   */
  public DiscreteVariable(String name) {
    super(name);
  }


  /**
   * Set the minimum value for the variable.
   *
   * @param min the int minimum value for the variable
   */
  public void setMin(int min) {
    this.min = min;
  }


  /**
   * Set the maximum value for the variable.
   *
   * @param max the int maximum value for the variable
   */
  public void setMax(int max) {
    this.max = max;
  }


  /**
   * Used within a <code>DataSet</code> to compute the minimum and maximum value
   * for the variable.
   *
   * @param inValue the String that contains the value used to determine minimum
   *                or maximum value for the variable.
   */
  public void computeStatistics(String inValue) {
    if (labels.contains(inValue)) {
      return;
    } else {
      labels.addElement(inValue);
    }
  }


  /**
   * Converts a symbol to a one-of-N code.
   *
   * @param inValue   the String symbol to be converted
   * @param outArray  the double array where the one-of-N code one-of-N code
   *                  will be stored
   * @param inx       the int starting index where the one-of-N code should be
   *                  stored the output array
   *
   * @return the index of the next available position in the output array
   */
  public int normalize(String inValue, double[] outArray, int inx) {

    int index = 0;

    if (inValue == null || inValue.trim().isEmpty()) {
      inValue = "";
    }

    index = getIndex(inValue);  // look up symbol index
    
    double code[] = new double[labels.size()];

    if (index < code.length) {
      code[index] = 1.0;
    }

    // copy one of N code to outArray, increment inx
    for (int i = 0; i < code.length; i++) {
      outArray[inx++] = code[i];
    }
    return inx;  // return output index
  }


  /**
   * Retrieves the number of discrete values the varible can take.
   *
   * @return the size of the one-of-N code when the variable is normalized
   */
  public int getNormalizedSize() {
    return labels.size();
  }


  /**
   * Retrieves the value of the given activation in a format that can be
   * displayed.
   *
   * @param act   the double array that contains the activation
   * @param start the int starting index for the activation within the array
   *
   * @return the value of the activation in a format that can be displayed
   */
  public String getDecodedValue(double[] act, int start) {
    int len = labels.size();
    String value;
    double max = -1.0;

    value = String.valueOf(0);
    for (int i = 0; i < len; i++) {
      if (act[start + i] > max) {
        max = act[start + i];
        value = getLabel(i);
      }
    }
    return value;
  }

  /**
   * Retrieves the label with the specified index.
   *
   * @param index the integer index of the desired label
   *
   * @return the label at the given index
   */
  public String getLabel(int index) {

      return (String) labels.elementAt(index);
  }


  /**
   * Retrieves all the labels from a categorical variable.
   *
   * @return a string that contains all the labels, separated by spaces
   */
  public String getLabels() {
    String labelList = new String();
    Enumeration<String> Enum = labels.elements();

    while (Enum.hasMoreElements()) {
      labelList += Enum.nextElement() + " ";
    }
    return labelList;
  }


    /**
   * Retrieves the index for the given label.
   *
   * @param label the String for which the index is retrieved
   *
   * @return the index of the given label, -1 if label was not found
   */
  public int getIndex(String label) {
    int i = 0, index = -1;
    Enumeration<String> Enum = labels.elements();

    while (Enum.hasMoreElements()) {
      if (label.equals(Enum.nextElement())) {
        index = i;
        break;
      }
      i++;
    }
    return index;
  }


}
