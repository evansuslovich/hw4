import org.junit.Test;

import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Tests pixel class.
 */
public class TestPixel {

  @Test
  public void testBrightenPixel() {
    Pixel test = new Pixel(100,100,100);

    int[] pixel = test.brightenPixel(100).getPixel();

    int red = pixel[0];
    int green = pixel[1];
    int blue = pixel[2];

    assertEquals(red, 200);
    assertEquals(green, 200);
    assertEquals(blue, 200);


  }

  @Test
  public void testBrightenPixelNeg() {
    Pixel test = new Pixel(156,123,255);

    int[] pixel = test.brightenPixel(-200).getPixel();

    int red = pixel[0];
    int green = pixel[1];
    int blue = pixel[2];

    assertEquals(red, 0);
    assertEquals(green, 0);
    assertEquals(blue, 55);


  }

  @Test
  public void testValue() {
    Pixel pixel = new Pixel(100,200,255);

    int[] test = pixel.value().getPixel();

    int red = test[0];
    int green = test[1];
    int blue = test[2];

    assertEquals(red, 255);
    assertEquals(green, 255);
    assertEquals(blue, 255);


    Pixel pixel2 = new Pixel(12,13,16);

    int[] test2 = pixel2.value().getPixel();

    int red2 = test2[0];
    int green2 = test2[1];
    int blue2 = test2[2];

    assertEquals(red2, 16);
    assertEquals(green2, 16);
    assertEquals(blue2, 16);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testPixelConstructor() {
    Pixel pixel = new Pixel(0,0,256);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testPixelConstructor2() {
    Pixel pixel = new Pixel(0,256,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPixelConstructor3() {
    Pixel pixel = new Pixel(256,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPixelConstructor4() {
    Pixel pixel = new Pixel(-1,0,0);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testPixelConstructor5() {
    Pixel pixel = new Pixel(0,-1,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPixelConstructor6() {
    Pixel pixel = new Pixel(0,0,-1);
  }

  @Test
  public void testGetPixel() {
    Pixel pixel = new Pixel(32,123,65);
    int[] test = {32, 123, 65};

    assertEquals(test[0], pixel.getPixel()[0]);
    assertEquals(test[1], pixel.getPixel()[1]);
    assertEquals(test[2], pixel.getPixel()[2]);
  }

  @Test
  public void testGreenComponent() {
    Pixel pixel = new Pixel(12,23,34);

    int[] test= pixel.greenComponent().getPixel();

    int red = test[0];
    int green = test[1];
    int blue = test[2];

    assertEquals(red, 23);
    assertEquals(green, 23);
    assertEquals(blue, 23);
  }

  @Test
  public void testBlueComponent() {
    Pixel pixel = new Pixel(12,23,34);

    int[] test = pixel.blueComponent().getPixel();

    int red = test[0];
    int green = test[1];
    int blue = test[2];

    assertEquals(red, 34);
    assertEquals(green, 34);
    assertEquals(blue, 34);
  }

  @Test
  public void testRedComponent() {
    Pixel pixel = new Pixel(12,23,34);

    int[] test = pixel.redComponent().getPixel();

    int red = test[0];
    int green = test[1];
    int blue = test[2];

    assertEquals(red, 12);
    assertEquals(green, 12);
    assertEquals(blue, 12);
  }

  @Test
  public void testIntensity() {
    Pixel pixel = new Pixel(12,100,34);

    int[] test = pixel.intensity().getPixel();

    int red = test[0];
    int green = test[1];
    int blue = test[2];

    assertEquals(red, 48);
    assertEquals(green, 48);
    assertEquals(blue, 48);


    Pixel pixel2 = new Pixel(123,255,255);

    int[] test2 = pixel2.intensity().getPixel();

    int red2 = test2[0];
    int green2 = test2[1];
    int blue2 = test2[2];

    assertEquals(red2, 211);
    assertEquals(green2, 211);
    assertEquals(blue2, 211);
  }


  @Test
  public void testLuma() {
    Pixel pixel = new Pixel(12,100,34);

    int[] test = pixel.luma().getPixel();

    int red = test[0];
    int green = test[1];
    int blue = test[2];

    assertEquals(red, 25);
    assertEquals(green, 25);
    assertEquals(blue, 25);
  }

}