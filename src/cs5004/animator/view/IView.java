package cs5004.animator.view;

/**
 * The IView interface describes methods common to all views.
 */
public interface IView {

  /**
   * Creates a view of the specified type.
   */
  void createView();

  /**
   * Gets a string representation of the current state of the view.
   *
   * @return a string representing the view state
   */
  String getViewState();
}
