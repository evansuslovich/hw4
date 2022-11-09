
package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GenericImage extends AbstractImage {


  public GenericImage(String fileAddress) throws IOException {
    super(fileAddress);
  }

  public GenericImage(Pixel[][] image) {
    super(image);
  }


  public void saveImage(String pathName) {
    BufferedImage img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);

    for (int x = 0; x < this.width; x++) {
      for (int y = 0; y < this.height; y++) {
        int red = this.image[x][y].getPixel()[0];
        int green = this.image[x][y].getPixel()[1];
        int blue = this.image[x][y].getPixel()[2];

        Color color = new Color(red, green, blue);

        img.setRGB(x, y, color.getRGB());
      }
    }
    File outputFile = new File(pathName);
    String formatName = getFileFormat(pathName);
    try {
      ImageIO.write(img, formatName, outputFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  public Pixel[][] getImage() {
    return image;
  }

}

