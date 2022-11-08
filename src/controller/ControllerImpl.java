package controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.ImageInterface;
import model.PPMImage;
import model.ImageModel;
import view.SimpleView;

/**
 * Implements the Controller interface and handles all functionality for controlling the program.
 */
public class ControllerImpl implements ControllerInterface {
  private Readable readable;
  private ImageModel model;
  private SimpleView view;

  /**
   * ControllerImpl constructor.
   * @param readable : Readable, Source for the Characters
   * @param model : ImageModel, the image's functionality
   * @param view : SimpleView, communicating back to the user with an appendable.
   * @throws IllegalArgumentException : if any of the parameters are null
   */
  public ControllerImpl(Readable readable, ImageModel model, SimpleView view)
          throws IllegalArgumentException {
    if (readable == null || model == null || view == null) {
      throw new IllegalArgumentException("Readable or Image are null");
    }
    this.readable = readable;
    this.model = model;
    this.view = view;
  }

  public void processImage() {
    boolean gameOver = false;

    while (!gameOver) {
      Scanner scanner = new Scanner(this.readable);
      ArrayList<String> inputs = new ArrayList<String>();
      inputs.add(scanner.next());
      int limit = 2;
      int count = 0;

      if (inputs.get(0).equals("brighten")) {
        limit = 3;
      }

      if (this.isQuit(inputs.get(0))) {
        return;
      }

      while (count < limit) {
        inputs.add(scanner.next());
        if (this.isQuit(inputs.get(count + 1))) {

          return;
        }
        count++;
      }

      takeCommands(inputs);
    }
  }

  /**
   * Helper function to reduce code in the processImage class. Used when user quits the program.
   * @param s : the string representing the possible quitting command
   * @return Boolean: true --> game is quit, false --> game is not quit
   */
  private boolean isQuit(String s) {
    if(s.equalsIgnoreCase("q") || s.equalsIgnoreCase("quit")) {
      this.renderMessage("Program Quit!");
      return true;
    }
    return false;
  }


  /**
   * Adds the message to the appendable.
   * @param s : String, the string for communicating back with the user.
   */
  private void renderMessage(String s) {
    try {
      this.view.appendToView(s);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * Takes the commands from the user and corresponds with an error or the model's command's method
   * @param inputs : ArrayList<String>, an arraylist of the inputs from the user
   */
  private void takeCommands(ArrayList<String> inputs) {

    // handles the image chosen by the user
    ImageInterface beginningImage;

    // handles brighten command
    if (inputs.get(0).equals("brighten")) {
      int value;
      // checks if input is an integer
      try {
        value = Integer.parseInt(inputs.get(1));
      } catch (NumberFormatException e) {
        // informs user that the input is not a number
        this.renderMessage("Please enter a number after 'brighten'");
        return;
      }

      // second element in the arrayList is the imageName
      String imageName = inputs.get(2);
      // third element in the arrayList is the new imageName
      String saveAsName = inputs.get(3);

      beginningImage = this.model.getImage(imageName);

      // does the image exist in the map?
      if (beginningImage == null) {
        this.renderMessage("Image not found!");
        return;
      }
      // adds the image to the model with the PPM object along with the name given to it
      this.model.addImage(new PPMImage(beginningImage.changeBrightness(value)), saveAsName);
      return;
    }

    // the command wishes to be run
    String command = inputs.get(0);
    // the imageName
    String imageName = inputs.get(1);
    // the new image's name
    String saveAsImage = inputs.get(2);


    // save command
    if (command.equals("save")) {
      // gets the savedImage from the model
      ImageInterface savedImage = this.model.getImage(saveAsImage);
      // checks if the image exists in the model
      if (savedImage == null) {
        this.renderMessage("Image not found!");
        return;
      }

      StringBuilder builder = savedImage.convertToString();


      try {
        BufferedWriter file = new BufferedWriter(new FileWriter(imageName));

        file.write(String.valueOf(builder));
        this.renderMessage("File is created successfully with the content.");

        file.close();
      } catch (IOException e) {
        this.renderMessage(e.getMessage());
      }
      return;
    }

    if (command.equals("load")) {
      if (this.model.getImage(saveAsImage) != null) {
        this.model.removeImage(saveAsImage);
      }

      try {
        this.model.addImage(new PPMImage(imageName), saveAsImage);
        this.renderMessage("Loaded image: '" + saveAsImage + "'\n");

      } catch (FileNotFoundException e) {
        this.renderMessage("File not found");
      }
      return;
    }

    beginningImage = this.model.getImage(imageName);
    if (beginningImage == null) {
      this.renderMessage("Image under " + imageName + " not found. Please try again");
      return;
    }

    switch (command) {
      // command turn-green
      case "turn-green":
        this.model.addImage(new PPMImage(beginningImage.turnGreenGreyScale()), saveAsImage);
        this.renderMessage("Turn '" + imageName + "' green" + "\n");
        break;

      // command turn-red
      case "turn-red":
        this.model.addImage(new PPMImage(beginningImage.turnRedGreyScale()), saveAsImage);
        this.renderMessage("Turn '" + imageName + "' red" + "\n");
        break;

      // command turn-blue
      case "turn-blue":
        this.model.addImage(new PPMImage(beginningImage.turnBlueGreyScale()), saveAsImage);
        this.renderMessage("Turn '" + imageName + "' blue" + "\n");
        break;

      // command value-component
      case "value-component":
        this.model.addImage(new PPMImage(beginningImage.turnValueGreyScale()), saveAsImage);
        this.renderMessage("Value component of '" + imageName + "' \n");
        break;

      // command luma-component
      case "luma-component":
        this.model.addImage(new PPMImage(beginningImage.turnLumaGreyScale()), saveAsImage);
        this.renderMessage("Luma component of '" + imageName + "' \n");
        break;

      // command intensity-component
      case "intensity-component":
        this.model.addImage(new PPMImage(beginningImage.turnIntensityGreyScale()), saveAsImage);
        this.renderMessage("Intensity component of '" + imageName + "' \n");
        break;

      // command horizontal-component
      case "horizontal-flip":
        this.model.addImage(new PPMImage(beginningImage.flipHorizontally()), saveAsImage);
        this.renderMessage("Horizontally flipped '" + imageName + "' \n");
        break;

      // command vertical-flip
      case "vertical-flip":
        this.model.addImage(new PPMImage(beginningImage.flipVertically()), saveAsImage);
        this.renderMessage("Vertically flipped '" + imageName + "' \n");
        break;

      // if the command is not listed already
      default:
        this.renderMessage("Command not found!");

    }
  }
}