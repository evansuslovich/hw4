package controller;

import java.io.IOException;

/**
 * ControllerInterface is the interface for the Controller.
 */
public interface ControllerInterface {

  /**
   * processImage handles all the control functionality.
   * @throws IOException : throws I/O exception for the appendable.
   */
  void processImage() throws IOException;

}
