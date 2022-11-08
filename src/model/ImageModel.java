package model;

import java.util.HashMap;
import java.util.Map;

/**
 * The ImageModel class holds the listOfImages and the methods to manipulate the list.
 */
public class ImageModel {
  private Map<String, ImageInterface> listOfImages;

  /**
   * Constructor for the ImageModel class, takes in no parameters and creates a hashmap for the map.
   */
  public ImageModel() {
    this.listOfImages = new HashMap<String, ImageInterface>();
  }

  /**
   * Gets the image with the imageName
   * @param imageName : the String representing the image name
   * @return ImageInterface: the object of the image
   */
  public ImageInterface getImage(String imageName) {
    return this.listOfImages.get(imageName);
  }

  /**
   * Adds the image to the list.
   * @param image ImageInterface: the object holding the image
   * @param imageName String: the name of the image
   */
  public void addImage(ImageInterface image, String imageName) {
    this.listOfImages.put(imageName, image);
  }

  /**
   * Removes the image from the list.
   * @param overWrittenImageName String : the imageName replacing the old image name
   */
  public void removeImage(String overWrittenImageName) {
    this.listOfImages.remove(overWrittenImageName);
  }


}