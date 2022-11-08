import org.junit.Test;

import model.PPMImage;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Testing PPMImage class.
 */
public class PPMImageTestInterface {

    @Test
    public void testFlipVertically1()  {
      Pixel pixel1 = new Pixel(1, 1, 1);
      Pixel pixel2 = new Pixel(2, 2, 2);
      Pixel pixel3 = new Pixel(3, 3, 3);
      Pixel pixel4 = new Pixel(4, 4, 4);
      Pixel pixel5 = new Pixel(5, 5, 5);
      Pixel pixel6 = new Pixel(6, 6, 6);
      Pixel pixel7 = new Pixel(7, 7, 7);
      Pixel pixel8 = new Pixel(8, 8, 8);
      Pixel pixel9 = new Pixel(9, 9, 9);

      Pixel[][] picture = {{pixel1, pixel2, pixel3},
              {pixel4, pixel5, pixel6},
              {pixel7, pixel8, pixel9}};

      Pixel[][] test = {{pixel7, pixel8, pixel9},
              {pixel4, pixel5, pixel6},
              {pixel1, pixel2, pixel3}};

      PPMImage image = new PPMImage(picture);

      Pixel[][] answer = image.flipVertically();

      assertEquals(test[0][0], answer[0][0]);
      assertEquals(test[0][1], answer[0][1]);
      assertEquals(test[0][2], answer[0][2]);
      assertEquals(test[1][0], answer[1][0]);
      assertEquals(test[1][1], answer[1][1]);
      assertEquals(test[1][2], answer[1][2]);
      assertEquals(test[2][0], answer[2][0]);
      assertEquals(test[2][1], answer[2][1]);
      assertEquals(test[2][2], answer[2][2]);

      assertEquals(test, answer);
    }

    @Test
    public void testFlipVertically2() {
      Pixel pixel1 = new Pixel(1, 1, 1);
      Pixel pixel2 = new Pixel(2, 2, 2);
      Pixel pixel3 = new Pixel(3, 3, 3);
      Pixel pixel4 = new Pixel(4, 4, 4);
      Pixel pixel5 = new Pixel(5, 5, 5);
      Pixel pixel6 = new Pixel(6, 6, 6);
      Pixel pixel7 = new Pixel(7, 7, 7);
      Pixel pixel8 = new Pixel(8, 8, 8);

      Pixel[][] picture =
              {{pixel1, pixel2, pixel3,pixel4},
                      {pixel5, pixel6, pixel7, pixel8}};

      Pixel[][] test =
              {{pixel5, pixel6, pixel7,pixel8},
                      {pixel1, pixel2, pixel3, pixel4}};

      PPMImage image = new PPMImage(picture);

      Pixel[][] answer = image.flipVertically();

      assertEquals(test[0][0], answer[0][0]);
      assertEquals(test[0][1], answer[0][1]);
      assertEquals(test[0][2], answer[0][2]);
      assertEquals(test[1][3], answer[1][3]);
      assertEquals(test[1][0], answer[1][0]);
      assertEquals(test[1][1], answer[1][1]);
      assertEquals(test[1][2], answer[1][2]);
      assertEquals(test[1][3], answer[1][3]);

    }

    @Test
    public void testFlipVertically3() {
      Pixel pixel1 = new Pixel(1, 1, 1);
      Pixel pixel2 = new Pixel(2, 2, 2);
      Pixel pixel3 = new Pixel(3, 3, 3);
      Pixel pixel4 = new Pixel(4, 4, 4);
      Pixel pixel5 = new Pixel(5, 5, 5);
      Pixel pixel6 = new Pixel(6, 6, 6);
      Pixel pixel7 = new Pixel(7, 7, 7);
      Pixel pixel8 = new Pixel(8, 8, 8);

      Pixel[][] picture =
              {
                      {pixel1, pixel2},
                      {pixel3, pixel4},
                      {pixel5, pixel6},
                      {pixel7, pixel8}};

      Pixel[][] test =
              {
                      {pixel7, pixel8},
                      {pixel5,pixel6},
                      {pixel3, pixel4},
                      {pixel1, pixel2}};

      PPMImage image = new PPMImage(picture);

      Pixel[][] answer = image.flipVertically();

      assertEquals(test[0][0], answer[0][0]);
      assertEquals(test[0][1], answer[0][1]);
      assertEquals(test[1][0], answer[1][0]);
      assertEquals(test[1][1], answer[1][1]);
      assertEquals(test[2][0], answer[2][0]);
      assertEquals(test[2][1], answer[2][1]);
      assertEquals(test[3][0], answer[3][0]);
      assertEquals(test[3][1], answer[3][1]);

    }

    @Test
    public void testFlipHorizontally1() {
      Pixel pixel1 = new Pixel(1, 1, 1);
      Pixel pixel2 = new Pixel(2, 2, 2);
      Pixel pixel3 = new Pixel(3, 3, 3);
      Pixel pixel4 = new Pixel(4, 4, 4);
      Pixel pixel5 = new Pixel(5, 5, 5);
      Pixel pixel6 = new Pixel(6, 6, 6);
      Pixel pixel7 = new Pixel(7, 7, 7);
      Pixel pixel8 = new Pixel(8, 8, 8);

      Pixel[][] picture =
              {
                      {pixel1, pixel2},
                      {pixel3, pixel4},
                      {pixel5, pixel6},
                      {pixel7, pixel8}};

      Pixel[][] test =
              {
                      {pixel2, pixel1},
                      {pixel4, pixel3},
                      {pixel6, pixel5},
                      {pixel8, pixel7}};

      PPMImage image = new PPMImage(picture);

      Pixel[][] answer = image.flipHorizontally();

      assertEquals(test[0][0], answer[0][0]);
      assertEquals(test[0][1], answer[0][1]);
      assertEquals(test[1][0], answer[1][0]);
      assertEquals(test[1][1], answer[1][1]);
      assertEquals(test[2][0], answer[2][0]);
      assertEquals(test[2][1], answer[2][1]);
      assertEquals(test[3][0], answer[3][0]);
      assertEquals(test[3][1], answer[3][1]);

    }

    @Test
    public void testFlipHorizontally2() {
      Pixel pixel1 = new Pixel(1, 1, 1);
      Pixel pixel2 = new Pixel(2, 2, 2);
      Pixel pixel3 = new Pixel(3, 3, 3);
      Pixel pixel4 = new Pixel(4, 4, 4);
      Pixel pixel5 = new Pixel(5, 5, 5);
      Pixel pixel6 = new Pixel(6, 6, 6);
      Pixel pixel7 = new Pixel(7, 7, 7);
      Pixel pixel8 = new Pixel(8, 8, 8);
      Pixel pixel9 = new Pixel(9, 9, 9);

      Pixel[][] picture = {{pixel1, pixel2, pixel3},
              {pixel4, pixel5, pixel6},
              {pixel7, pixel8, pixel9}};

      Pixel[][] test = {{pixel3, pixel2, pixel1},
              {pixel6, pixel5, pixel4},
              {pixel9, pixel8, pixel7}};

      PPMImage image = new PPMImage(picture);

      Pixel[][] answer = image.flipHorizontally();

      assertEquals(test[0][0], answer[0][0]);
      assertEquals(test[0][1], answer[0][1]);
      assertEquals(test[0][2], answer[0][2]);
      assertEquals(test[1][0], answer[1][0]);
      assertEquals(test[1][1], answer[1][1]);
      assertEquals(test[1][2], answer[1][2]);
      assertEquals(test[2][0], answer[2][0]);
      assertEquals(test[2][1], answer[2][1]);
      assertEquals(test[2][2], answer[2][2]);

      assertEquals(test, answer);
    }

    @Test
    public void testFlipHorizontally3() {
      Pixel pixel1 = new Pixel(1, 1, 1);
      Pixel pixel2 = new Pixel(2, 2, 2);
      Pixel pixel3 = new Pixel(3, 3, 3);
      Pixel pixel4 = new Pixel(4, 4, 4);
      Pixel pixel5 = new Pixel(5, 5, 5);
      Pixel pixel6 = new Pixel(6, 6, 6);
      Pixel pixel7 = new Pixel(7, 7, 7);
      Pixel pixel8 = new Pixel(8, 8, 8);

      Pixel[][] picture = {{pixel1, pixel2, pixel3, pixel4},
              {pixel5,pixel6,pixel7, pixel8}};

      Pixel[][] test = {{pixel4, pixel3, pixel2, pixel1},
              {pixel8,pixel7,pixel6, pixel5}};


      PPMImage image = new PPMImage(picture);

      Pixel[][] answer = image.flipHorizontally();

      assertEquals(test[0][0], answer[0][0]);
      assertEquals(test[0][1], answer[0][1]);
      assertEquals(test[0][2], answer[0][2]);
      assertEquals(test[0][3], answer[0][3]);
      assertEquals(test[1][0], answer[1][0]);
      assertEquals(test[1][1], answer[1][1]);
      assertEquals(test[1][2], answer[1][2]);
      assertEquals(test[1][3], answer[1][3]);

      assertEquals(test, answer);
    }


    @Test
  public void testConvertToString() {
      Pixel pixel1 = new Pixel(1, 1, 1);
      Pixel pixel2 = new Pixel(2, 2, 2);
      Pixel pixel3 = new Pixel(3, 3, 3);
      Pixel pixel4 = new Pixel(4, 4, 4);

      Pixel[][] picture = {{pixel1, pixel2, pixel3, pixel4}};

      PPMImage image = new PPMImage(picture);

      StringBuilder builder = new StringBuilder();

      builder.append("P3\n"
              +"4 1\n" + "4\n" + "1\n"  + "1\n"
              + "1\n" + "2\n" + "2\n" + "2\n" + "3\n"
              + "3\n" + "3\n" + "4\n" + "4\n" + "4\n");

      assertEquals(builder.toString(), image.convertToString().toString());
    }

    @Test
    public void testTurnGreyScale() {
      Pixel pixel1 = new Pixel(1, 2, 3);
      Pixel pixel2 = new Pixel(2, 3, 4);
      Pixel pixel3 = new Pixel(3, 4, 5);
      Pixel pixel4 = new Pixel(4, 5, 6);

      Pixel[][] picture = {{pixel1, pixel2, pixel3, pixel4}};

      PPMImage image = new PPMImage(picture);

      Pixel[][] test = image.turnRedGreyScale();
      PPMImage officialTest = new PPMImage(test);

      StringBuilder builder = new StringBuilder();

      builder.append("P3\n" +
              "4 1\n" +
              "4\n" +
              "1\n" +
              "1\n" +
              "1\n" +
              "2\n" +
              "2\n" +
              "2\n" +
              "3\n" +
              "3\n" +
              "3\n" +
              "4\n" +
              "4\n" +
              "4\n");

      assertEquals(builder.toString(), officialTest.convertToString().toString());
    }

  @Test
  public void testTurnGreenScale() {
    Pixel pixel1 = new Pixel(1, 2, 3);
    Pixel pixel2 = new Pixel(1, 3, 3);
    Pixel pixel3 = new Pixel(1, 4, 3);
    Pixel pixel4 = new Pixel(1, 5, 3);

    Pixel[][] picture = {{pixel1, pixel2, pixel3, pixel4}};

    PPMImage image = new PPMImage(picture);

    Pixel[][] test = image.turnGreenGreyScale();
    PPMImage officialTest = new PPMImage(test);

    StringBuilder builder = new StringBuilder();

    builder.append("P3\n" +
            "4 1\n" +
            "5\n" +
            "2\n" +
            "2\n" +
            "2\n" +
            "3\n" +
            "3\n" +
            "3\n" +
            "4\n" +
            "4\n" +
            "4\n" +
            "5\n" +
            "5\n" +
            "5\n");

    assertEquals(builder.toString(), officialTest.convertToString().toString());
  }
  @Test
  public void testTurnBlueScale() {
    Pixel pixel1 = new Pixel(1, 2, 3);
    Pixel pixel2 = new Pixel(1, 2, 3);
    Pixel pixel3 = new Pixel(1, 2, 3);
    Pixel pixel4 = new Pixel(1, 2, 3);

    Pixel[][] picture = {{pixel1, pixel2, pixel3, pixel4}};

    PPMImage image = new PPMImage(picture);

    Pixel[][] test = image.turnBlueGreyScale();
    PPMImage officialTest = new PPMImage(test);

    StringBuilder builder = new StringBuilder();

    builder.append("P3\n" +"4 1\n" + "3\n" + "3\n" + "3\n" + "3\n" + "3\n"
            + "3\n" + "3\n" + "3\n" + "3\n" +"3\n" + "3\n" + "3\n" + "3\n");

    assertEquals(builder.toString(), officialTest.convertToString().toString());
  }

  @Test
  public void testTurnValue() {
    Pixel pixel1 = new Pixel(1, 2, 3);
    Pixel pixel2 = new Pixel(1, 2, 3);
    Pixel pixel3 = new Pixel(1, 2, 3);
    Pixel pixel4 = new Pixel(1, 2, 3);

    Pixel[][] picture = {{pixel1, pixel2, pixel3, pixel4}};

    PPMImage image = new PPMImage(picture);

    Pixel[][] test = image.turnValueGreyScale();
    PPMImage officialTest = new PPMImage(test);

    StringBuilder builder = new StringBuilder();

    builder.append("P3\n"
            + "4 1\n" + "3\n" + "3\n" + "3\n" + "3\n" + "3\n" + "3\n"
            + "3\n" + "3\n" + "3\n" + "3\n" + "3\n" + "3\n" + "3\n");

    assertEquals(builder.toString(), officialTest.convertToString().toString());
  }

  @Test
  public void turnLumaGreyScale() {
    Pixel pixel1 = new Pixel(1, 2, 3);
    Pixel pixel2 = new Pixel(1, 2, 3);
    Pixel pixel3 = new Pixel(1, 2, 3);
    Pixel pixel4 = new Pixel(1, 2, 3);

    Pixel[][] picture = {{pixel1, pixel2, pixel3, pixel4}};

    PPMImage image = new PPMImage(picture);

    Pixel[][] test = image.turnLumaGreyScale();
    PPMImage officialTest = new PPMImage(test);

    StringBuilder builder = new StringBuilder();

    builder.append("P3\n" +
            "4 1\n" +"0\n" + "0\n" + "0\n" + "0\n" +
            "0\n" + "0\n" + "0\n" + "0\n" + "0\n" + "0\n"
            + "0\n" + "0\n" + "0\n" );


    assertEquals(builder.toString(), officialTest.convertToString().toString());
  }

  @Test
  public void turnIntensityGreyScale() {
    Pixel pixel1 = new Pixel(0, 2, 4);
    Pixel pixel2 = new Pixel(1, 2, 5);
    Pixel pixel3 = new Pixel(1, 2, 6);
    Pixel pixel4 = new Pixel(1, 2, 7);

    Pixel[][] picture = {{pixel1, pixel2, pixel3, pixel4}};

    PPMImage image = new PPMImage(picture);
    Pixel[][] test = image.turnIntensityGreyScale();
    PPMImage officialTest = new PPMImage(test);

    StringBuilder builder = new StringBuilder();

    builder.append("P3\n" +"4 1\n" + "3\n" + "2\n"
            +"2\n" + "2\n"+ "2\n" + "2\n"
            + "2\n" + "3\n" + "3\n" + "3\n"
            + "3\n"+ "3\n" + "3\n");


    assertEquals(builder.toString(), officialTest.convertToString().toString());
  }

  @Test
  public void testChangeBrightness() {
    Pixel pixel1 = new Pixel(0, 2, 4);
    Pixel pixel2 = new Pixel(1, 2, 5);
    Pixel pixel3 = new Pixel(1, 2, 6);
    Pixel pixel4 = new Pixel(1, 2, 7);

    Pixel[][] picture = {{pixel1, pixel2, pixel3, pixel4}};

    PPMImage image = new PPMImage(picture);
    Pixel[][] test = image.changeBrightness(100);
    PPMImage officialTest = new PPMImage(test);

    StringBuilder builder = new StringBuilder();

    builder.append("P3\n" + "4 1\n" + "107\n" + "100\n" + "102\n" + "104\n" + "101\n"
            + "102\n" + "105\n" + "101\n" + "102\n" + "106\n" + "101\n" + "102\n" + "107\n");


    assertEquals(builder.toString(), officialTest.convertToString().toString());


  }
}
