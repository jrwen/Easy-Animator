package cs5004.animator.model;

/**
 * _____________________________________ CLASS: Oval {} ___________________________________________.
 * The Oval class extends AbstractShape and implements the method declarations that are unique to
 * the Oval class. It creates and stores information about an Oval shape.
 */
public class Ellipse extends AbstractShape {
  // radiusX, from the center point to the outer edge of the circle along the X-axis/width
  private double radiusX = 0;
  // radiusY, from the center point to the outer edge of the circle along the Y-axis/height
  private double radiusY = 0;

  /**
   * __________________________________ CONSTRUCTOR: Oval() _______________________________________.
   * The Oval() constructor creates an oval with the given width, height, color parameters, and
   * location coordinates.
   *
   * @param name   name of the oval
   * @param width  width of the oval (x)
   * @param height height of the oval (y)
   * @param red    red value of oval
   * @param green  green value of oval
   * @param blue   blue value of oval
   * @param x      x coordinate of oval
   * @param y      y coordinate of oval
   */
  public Ellipse(String name, double width, double height,
                 int red, int green, int blue, double x, double y) {
    super(name, width, height, red, green, blue, x, y);
    this.radiusX = width / 2;
    this.radiusY = height / 2;
  }

  /**
   * _________________________SECOND CONSTRUCTOR: Ellipse() _________________________________.
   * Creates a shape with the given name. Further attributes are instantiated with the first event
   * called on the shape.
   *
   * @param name   name of the shape
   * @throws IllegalArgumentException if name is null
   */
  public Ellipse(String name) {
    super(name);
  }

  /**
   * ___________________________________ METHOD: toString() _______________________________________.
   * Returns a String with the name, location, horizontal radius, vertical radius, color, and
   * appear and disappear times of the oval.
   *
   * @return a String displaying the oval's attributes
   */
  @Override
  public String toString() {
    return "Name: " + this.name
            + "\nType: oval"
            + "\nCenter: " + this.location.toString()
            + ", X radius: " + this.radiusX + ", Y radius: "
            + this.radiusY + ", Color: " + this.color.toString()
            + "\nAppears at t=" + this.appear
            + "\nDisappears at t=" + this.disappear + "\n";
  }

  @Override
  public String createString() {
    return "Create " + this.color.toString() + " oval " + this.name
            + " with center at " + this.location.toString() + ", radius " + this.radiusX
            + " and " + this.radiusY;
  }
}
