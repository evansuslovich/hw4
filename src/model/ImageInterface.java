package model;

/**
 * ImageInterface class that holds all the methods needed to manipulate images.
 */
public interface ImageInterface {

  /**
   * Flips the image horizontally.
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  public Pixel[][] flipHorizontally();

  /**
   * Flips the image vertically.
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  public Pixel[][] flipVertically();

  /**
   * Converts grey scale using the red component.
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  public Pixel[][] turnRedGreyScale();

  /**
   * Converts grey scale using the green component.
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  public Pixel[][] turnGreenGreyScale();

  /**
   * Converts grey scale using the blue component.
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  public Pixel[][] turnBlueGreyScale();

  /**
   * Converts grey scale using the value component.
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  public Pixel[][] turnValueGreyScale();

  /**
   * Converts grey scale using the luma component.
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  public Pixel[][] turnLumaGreyScale();

  /**
   * Converts grey scale using the intensity component
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  public Pixel[][] turnIntensityGreyScale();

  /**
   * Changes brightness of an image with a value representing how much to brighten (+ or -) amount
   * @return Pixel[][]: a 2D array of pixels that represent the image.
   */
  public Pixel[][] changeBrightness(int value);
}
