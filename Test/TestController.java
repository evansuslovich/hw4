import org.junit.Test;

import java.io.InputStreamReader;
import java.io.StringReader;

import controller.ControllerImpl;
import model.ImageModel;
import view.SimpleView;

import static org.junit.Assert.assertEquals;

/**
 * Class to test the controller.
 */
public class TestController {

  @Test
  public void testQuit1() {

    ImageModel model = new ImageModel();

    StringBuilder reader = new StringBuilder();

    SimpleView view = new SimpleView(reader);

    ControllerImpl controller = new ControllerImpl(new StringReader("q"), model, view);

    controller.processImage();


    assertEquals("Process Image Quit!", reader.toString());
  }

  @Test
  public void testQuit2() {

    ImageModel model = new ImageModel();

    StringBuilder reader = new StringBuilder();

    SimpleView view = new SimpleView(reader);

    ControllerImpl controller = new ControllerImpl(new StringReader("quit"), model, view);

    controller.processImage();


    assertEquals("Process Image Quit!", reader.toString());
  }

  @Test
  public void testQuit3() {

    ImageModel model = new ImageModel();

    StringBuilder reader = new StringBuilder();

    SimpleView view = new SimpleView(reader);

    ControllerImpl controller = new ControllerImpl(new StringReader("qUIT"), model, view);

    controller.processImage();


    assertEquals("Process Image Quit!", reader.toString());
  }


  @Test
  public void testLoad() {

    ImageModel model = new ImageModel();

    StringBuilder reader = new StringBuilder();

    SimpleView view = new SimpleView(reader);

    ControllerImpl controller = new ControllerImpl(new StringReader("load ./res/art.ppm art"), model, view);

    controller.processImage();


  }
}
