package model;

import java.util.Objects;

/**
 * Pixel class. An object representing all the RGB values for the image.
 */
public class Pixel {
  private int red;
  private int green;
  private int blue;

  /**
   * Pixel constructor.
   * @param red : Integer, red value
   * @param green : Integer, green value
   * @param blue : Integer, blue value
   * @throws IllegalArgumentException : makes sure values are 0 <= val <= 255.
   */
  public Pixel(int red, int green, int blue) {
    if(red > 255 || green > 255 || blue > 255 || red < 0 || green < 0 || blue < 0) {
      throw new IllegalArgumentException("RGB values must be from 0 - 255");
    }
    Objects.requireNonNull(red);
    Objects.requireNonNull(green);
    Objects.requireNonNull(blue);

    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Sets pixel to the red component.
   * @return Pixel: returns a new Pixel Object
   */
  public Pixel redComponent() {
    return new Pixel(this.red, this.red, this.red);
  }

  /**
   * Sets pixel to the green component.
   * @return Pixel: returns a new Pixel Object
   */
  public Pixel greenComponent() {
    return new Pixel(this.green, this.green, this.green);
  }

  /**
   * Sets pixel to the blue component.
   * @return Pixel: returns a new Pixel Object
   */
  public Pixel blueComponent() {
    return new Pixel(this.blue, this.blue, this.blue);
  }

  /**
   * Sets pixel to the intesity component.
   * @return Pixel: returns a new Pixel Object
   */
  public Pixel intensity() {
    int intensity = (this.red + this.green + this.blue)/3;
    return new Pixel(intensity, intensity, intensity);
  }

  /**
   * Sets pixel to the luma component.
   * @return Pixel: returns a new Pixel Object
   */
  public Pixel luma() {
    int luma = (int)(this.red*0.2126 + this.green*0.7152 + this.blue*0.0722)/3;
    return new Pixel(luma, luma, luma);
  }

  /**
   * Sets pixel to the value component.
   * @return Pixel: returns a new Pixel Object
   */
  public Pixel value() {
    int value = this.maxRGBValue();
    return new Pixel(value, value, value);
  }

  /**
   * Brightens the pixel with a specific amount.
   * @param change, int : the integer representing the change amount
   * @return Pixel: returns a new Pixel Object
   */
  public Pixel brightenPixel(int change) {
    int changedRed = this.brightenPixelHelper(change, this.red);
    int changedGreen = this.brightenPixelHelper(change, this.green);
    int changedBlue = this.brightenPixelHelper(change, this.blue);
    return new Pixel(changedRed, changedGreen, changedBlue);
  }

  /**
   * Helps brightenPixel to see if the amount of change is in the limits of O <= val <= 255
   * @param change Integer, the amount of change
   * @param value Integer, the value of the R, G, or B
   * @return int, the actual amount the pixel should be
   */
  private int brightenPixelHelper(int change, int value) {
    if (change + value > 255) {
      return 255;
    } else if (change + value < 0) {
      return 0;
    } else {
      return value + change;
    }
  }

  /**
   * The maximum RGB value
   * @return int: the int of max val
   */
  public int maxRGBValue() {
    return Math.max(this.blue, Math.max(this.red, this.green));
  }

  /**
   * A getter to get the class object.
   * @return int[] : an array holding the red, green, blue value in order
   */
  public int[] getPixel() {
    int[] pixels = new int[3];

    pixels[0] = this.red;
    pixels[1] = this.green;
    pixels[2] = this.blue;

    return pixels;
  }
}
