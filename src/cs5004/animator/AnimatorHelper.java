package cs5004.animator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.*;

/**
 * The AnimatorHelper class helps construct an animation.
 */
public class AnimatorHelper {

  /**
   * _____________________________ CONSTRUCTOR: AnimatorHelper() __________________________________.
   * Constructs an AnimatorHelper instance. No parameters.
   */
  public AnimatorHelper() {
  }

  /**
   * _____________________________ HELPER METHOD: jframeStart() ___________________________________.
   * Starts a JFrame.
   *
   * @return a JFrame object
   */
  public static JFrame jFrameStart() {
    JFrame frame = new JFrame("Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    return frame;
  }

  /**
   * Generates a StringBuilder with arguments from the command line.
   *
   * @param args arguments passed in from the command line
   * @return a StringBuilder
   */
  public static StringBuilder stringBuilder(String[] args) {
    StringBuilder sb = new StringBuilder();
    for (String arg : args) {
      sb.append(arg);
      sb.append(" ");
    }
    return sb;
  }

  /**
   * Scans arguments for an in file.
   *
   * @param sb the StringBuilder to be scanned
   * @return the name of the in file
   */
  public static String nameScanner(StringBuilder sb) {
    Scanner in = new Scanner(sb.toString());
    in.findInLine("-in");
    return in.next();
  }

  /**
   * Checks for problems with files and throws exceptions if problems exist.
   *
   * @param inputName the name of the out file
   * @param frame the JFrame used for exception-throwing
   * @return a filereader object with the out file specified
   */
  public static Readable fileExceptions(String inputName, JFrame frame) {
    try {
      return new FileReader(inputName);
    } catch (FileNotFoundException e) {
      frame.setVisible(true);
      JOptionPane.showMessageDialog(frame, "Input file not found", "Input file error",
              JOptionPane.ERROR_MESSAGE);
      System.out.println("The input file was not found.");
      e.printStackTrace();
       //System.exit(1);
    }
    return null;
  }

  /**
   * Scans command-line arguments for the view type.
   *
   * @param sb the StringBuilder to scan
   * @return the view type as a string
   */
  public static String viewScanner(StringBuilder sb) {
    Scanner view = new Scanner(sb.toString());
    view.findInLine("-view");
    return view.next();
  }

  /**
   * Checks for problems with the view type and throws exceptions if problems exist.
   *
   * @param outputView the view type, a String
   * @param frame the frame used to throw exceptions
   */
  public static void viewExceptions(String outputView, JFrame frame) {
    if (!outputView.equalsIgnoreCase("text")
            && !outputView.equalsIgnoreCase("svg")
            && !outputView.equalsIgnoreCase("visual")) {
      frame.setVisible(true);
      JOptionPane.showMessageDialog(frame, "The view type must be text, svg, or visual",
              "Invalid view", JOptionPane.ERROR_MESSAGE);
      //System.exit(1);
    }
  }

  /**
   * Scans command-line arguments for the out file.
   *
   * @param sb the StringBuilder to be scanned
   * @return the name of the out file as a string
   */
  public static String outScanner(StringBuilder sb) {
    Scanner out = new Scanner(sb.toString());
    out.findInLine("-out");
    return out.next();
  }

  /**
   * Scans command-line arguments for the requested speed.
   *
   * @param sb sb the StringBuilder to be scanned
   * @return the speed as a String
   */
  public static String speedScanner(StringBuilder sb) {
    Scanner outputSpeed = new Scanner(sb.toString());
    outputSpeed.findInLine("-speed");
    return outputSpeed.next();
  }

  /**
   * Checks for problems with the speed and throws exceptions if problems exist.
   *
   * @param outputSpeed the speed, as a string
   * @param frame the frame used to throw exceptions
   */
  public static void speedExceptions(String outputSpeed, JFrame frame) {
    try {
      int speedInt = Integer.parseInt(outputSpeed);
      if (speedInt < 1) throw new NumberFormatException();
    } catch (NumberFormatException n) {
      frame.setVisible(true);
      JOptionPane.showMessageDialog(frame, "Speed must be a positive integer",
              "Invalid speed", JOptionPane.ERROR_MESSAGE);
      //System.exit(1);
    }
  }

  }
