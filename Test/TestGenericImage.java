import org.junit.Test;

import java.io.IOException;

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

}
