import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.GenericImage;
import model.Pixel;

import static org.junit.Assert.assertEquals;

public class TestGenericImage {

  @Test
  public void testGenericImageConstructor() throws IOException {
    GenericImage image = new GenericImage("./res/grey.png");

   Pixel pixel = image.getImage()[0][0];

    int red = pixel.getPixel()[0];
    int green = pixel.getPixel()[1];
    int blue = pixel.getPixel()[2];

    assertEquals(red, 123);
    assertEquals(green, 123);
    assertEquals(blue, 123);

  }

  @Test
  public void testGenericImageConstructorPurple() throws IOException {
    GenericImage image = new GenericImage("./res/purple.png");

    Pixel pixel = image.getImage()[0][0];

    int red = pixel.getPixel()[0];
    int green = pixel.getPixel()[1];
    int blue = pixel.getPixel()[2];

    assertEquals(red, 156);
    assertEquals(green, 102);
    assertEquals(blue, 255);
  }

  public static void main(String[] args) throws IOException {




//    GenericImage image = new GenericImage("./res/grey.png");
//    StringBuilder builder = image.convertToString();
//
//
//    BufferedWriter file = new BufferedWriter(new FileWriter("./res/yas.png"));
//
//    file.write(String.valueOf(builder));
//
//    file.close();


//
    BufferedImage img = new BufferedImage(256, 256,
            BufferedImage.TYPE_INT_RGB);
    for(int i = 0; i < 256; i++) {
      for(int j = 0; j < 256; j++) {
        img.setRGB(i,j,-11972815);
      }
    }

    File outputfile = new File("./res/ihopethisworks.png");
    ImageIO.write(img, "png", outputfile);

  }
}
