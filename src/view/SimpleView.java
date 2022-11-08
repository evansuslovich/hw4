package view;

import java.io.IOException;

/**
 * SimpleView class. Handles all the printing to the console.
 */
public class SimpleView implements SimpleViewInterface{
  private Appendable appendable;

  /**
   * SimpleView constructor. Takes in an appendable object.
   * @param appendable : Appendable, an appendable object that holds all the logging to the user
   */
  public SimpleView(Appendable appendable) {
    this.appendable = appendable;
  }

  /**
   * appendToView function adds a String message to the appendable
   * @param message : String, the message
   * @throws IOException : If an I/O error occurs
   */
  public void appendToView(String message) throws IOException {
      this.appendable.append(message);
  }

}
