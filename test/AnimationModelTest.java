import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;

public class AnimationModelTest {
  private AnimationModel testAnimation;

  @Test
  public void TextTest() {
    // create new shapes first
    // give shape a point2D
    Point2D rLocation1 = new Point2D.Double(200.0, 200.0);
    IShape R = new Rectangle(Color.red, rLocation1, 50.0, 100.0);
    Point2D cLocation = new Point2D.Double(500.0, 100.0);
    IShape C = new Oval(Color.blue, cLocation, 60.0, 30.0);
    // make a new movement with to location
    // and ticks when it moves
    Point2D rLocation2 = new Point2D.Double(300.0, 300.0);
    MoveShape move1 = new MoveShape(R, 1, 100, rLocation1, rLocation2);
    Point2D cNewLocation = new Point2D.Double(500.0, 400.0);
    MoveShape move2 = new MoveShape(C,10, 50, cLocation, cNewLocation, );
    // make new shape change
    // and ticks when it changes
    // change color
    ChangeColor change1 = new ChangeColor(C, 50, 75, Color.blue, Color.green);
    //change width and height
    ScaleShape change2 = new ScaleShape(R, 25, 100);
    //another move for R, back to original location
    MoveShape move3 = new MoveShape(R, 110, 150, rLocation2, rLocation1);
    testAnimation = new AnimationModelImpl();
    // add the shapes to a shape list in the animation model
    // decide when they appear and disappear here
    // rectangle appears at 1, disappears at 100
    testAnimation.addShape(R, 1, 100);
    testAnimation.addShape(C, 6, 100);
    // includes timing of changes
    testAnimation.addChange(move1, 10, 50);
    testAnimation.addChange(move2, 20, 70);
    testAnimation.addChange(change1, 50, 80);
    testAnimation.addChange(change2, 51, 70);
    testAnimation.addChange(move3, 70, 100);
    // maybe in the toString method?
    // then get the string of appearance, disappearance, and moves and changes
    assertEquals("\n" +
                    "Shapes:\n" +
                    "Name: R\n" +
                    "Type: rectangle\n" +
                    "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, " +
                    "Color: (1.0,0.0,0.0)\n" +
                    "Appears at t=1\n" +
                    "Disappears at t=100\n" +
                    " \n" +
                    "Name: C\n" +
                    "Type: oval\n" +
                    "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, " +
                    "Color: (0.0,0.0,1.0)\n" +
                    "Appears at t=6\n" +
                    "Disappears at t=100\n" +
                    " \n" +
                    "Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50\n" +
                    "Shape C moves from (500.0,100.0) to (500.0,400.0) from t=20 to t=70\n" +
                    "Shape C changes color from (0.0,0.0,1.0) to (0.0,1.0,0.0) " +
                    "from t=50 to t=80\n" +
                    "Shape R scales from Width: 50.0, Height: 100.0 to Width: 25.0, " +
                    "Height: 100.0 from t=51 to t=70\n" +
                    "Shape R moves from (300.0,300.0) to (200.0,200.0) from t=70 to t=100"
            , testAnimation.toString());
    // something like that
  }
}
