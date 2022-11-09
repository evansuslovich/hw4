package model;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents the PPM image.
 */
public class PPMImage extends AbstractImage {
  private int maxValue;


  /**
   * Constructor for the PPM Image.
   *
   * @param fileAddress String: file address used in readPPM
   * @throws FileNotFoundException thrown in the readPPM if the file is not found in directory
   */
  public PPMImage(String fileAddress) throws IOException {
    super(fileAddress);
    this.maxValue = this.maxImageRGBValue();
  }

  /**
   * PPMImage constructor that takes in the 2D array of pixels.
   *
   * @param pixels : the 2D array representing the image
   */
  public PPMImage(Pixel[][] pixels) {
    super(pixels);
    this.maxValue = this.maxImageRGBValue();


  }


  /**
   * Finds the maximum rgb value in the 2D array
   *
   * @return Integer, returns the maximum RGB value
   */
  private int maxImageRGBValue() {
    int max = 0;
    for (int h = 0; h < this.height; h++) {
      for (int w = 0; w < this.width; w++) {
        max = Math.max(this.image[w][h].maxRGBValue(), max);
      }
    }
    return max;
  }


  public void saveImage(String pathName) {

    StringBuilder builder = new StringBuilder();

    builder.append("P3\n");
    builder.append(this.height + " " + this.width + "\n");
    builder.append(this.maxValue + "\n");

    for (int x = 0; x < this.width; x++) {
      for (int y = 0; y < this.height; y++) {
        builder.append(this.image[x][y].getPixel()[0] + "\n"
                + this.image[x][y].getPixel()[1] + "\n"
                + this.image[x][y].getPixel()[2] + "\n");
      }
    }
    try {
      BufferedWriter file = new BufferedWriter(new FileWriter(pathName));

      file.write(String.valueOf(builder));
      System.out.println("File is created successfully with the content.");

      file.close();
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
