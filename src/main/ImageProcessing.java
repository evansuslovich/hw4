package main;

import java.io.IOException;
import java.io.InputStreamReader;

import controller.ControllerImpl;
import model.ImageModel;
import view.SimpleView;


/**
 * ImageProcessing class that holds the main function the run the program.
 */
public class ImageProcessing {


  /**
   * main function that runs everything.
   * @param args : argument to run
   */
  public static void main(String[] args) {
    InputStreamReader reader = new InputStreamReader(System.in);
    ImageModel model = new ImageModel();
    SimpleView view = new SimpleView(System.out);

    ControllerImpl controller = new ControllerImpl(reader, model, view);

    try {
      controller.processImage();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
