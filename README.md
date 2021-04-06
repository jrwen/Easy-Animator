# Easy-Animator

The Easy Animator model accepts IShape objects and IEvent objects. You can add these objects 
to the model to create text output describing a simple animation.

### AnimationModel
The AnimationModel interface describes methods you must use if you implement AnimationModel. 
AnimationModel objects are designed to represent an animation. We created this interface to expose
only the public methods in the animation model for ease of use by the client.

#### AnimationModelImpl
AnimationModelImpl implements the AnimationModel interface. It generates an animation model. 
Animations consist of two types of objects: IShapes, and IEvents that act on those shapes. 
Each shape must have a unique name so that one or more IEvents can be associated with it. 
This implementation includes private helper methods that don't need to be exposed to the client. 
###### Useful methods
* `addShape(IShape shape, int appear, int disappear)` - add an IShape to your animation
* `addEvent(IShape shape, IEvent event, int appear, int disappear)` - add an IEvent to your IShape
* `getEventList(IShape shape)` - returns a list of all events associated with a shape
* `getShapesAtTick(int tick)` - get all shapes and their states at a given tick. Currently a stub. 

### IShape 
The IShape interface describes methods you must use if you implement IShape. IShape objects are 
designed to represent shapes.  We created this interface so that any helper methods stay private 
and don't need to be exposed to the client, and there's no need for the client to look at the 
implementation itself. The interface could be extended with additional shape types later. It allows
a shape to be instantiated without specifying the type of shape.

#### AbstractShape 
The AbstractShape class implements IShape. It includes a comparator that enables comparison by shape 
width. AbstractShape includes setters and getters for all shape attributes so that the 
AnimationModel and IEvent can easily access and change them. We created this abstract class to reuse
code that's common to all shapes. 

#### Rectangle
The Rectangle class extends AbstractShape. It allows you to construct a rectangle shape. We created
this concrete class to enable the client to generate a rectangle shape. The constructor takes
in a unique name, an initial location, R, G, and B values for color, and width/height values.

`IShape example = new Rectangle("name", 1.0, 1.0, 255, 255, 255, 20.0, 25.0);`

#### Oval
The Oval class extends AbstractShape. It allows you to construct an oval shape. We created this 
concrete class to enable the client to generate an oval shape. The constructor takes
in a unique name, an initial location, R, G, and B values for color, and width/height values.

`IShape example = new Oval("name", 1.0, 1.0, 255, 255, 255, 20.0, 25.0);`

### IEvent
The IEvent interface describes methods you must use if you implement IEvent. IEvent objects are
designed to represent events that happen on shapes. We created this interface as a contract for 
the client, so that helper methods aren't exposed and there's no need for the client to look at 
the implementation itself. The interface could be extended with additional events later. It allows
an event to be instantiated without specifying the type of the event. 

#### AbstractEvent
The AbstractEvent class implements IEvent. It includes a change() stub that will be implemented once 
we have more information about how changes will work with a controller. We created this abstract 
class in order to reuse code common to all events. 

#### MoveShape
The MoveShape class extends AbstractEvent. Use the MoveShape class to create a move event on an
IShape. We created this concrete class so that the client can generate a move event. The constructor 
takes in a shape, an initial location, and a new location.

`IEvent example = new MoveShape(example, 1.0, 1.0, 2.0, 2.0);`

#### ChangeColor
The MoveShape class extends AbstractEvent. Use the ChangeColor class to create a color change event
on an IShape. We created this concrete class so that the client can generate a color
change event. The constructor takes in a shape, an initial color, and a new color.

`IEvent example = new ChangeColor(example, 0, 0, 0, 255, 255, 255);`

#### ScaleShape
The MoveShape class extends AbstractEvent. Use the ScaleShape class to create a scale shape event
on an IShape. We created this concrete class so that the client can generate a scale shape event.
The constructor takes in a shape, an initial size, and a new size.

`IEvent example = new ScaleShape(example, 1.0, 1.0, 2.0, 2.0);`

### Helper classes and enums
#### Color
Color is a class used to store RGB colors. Its constructor accepts three ints as parameters: 
**R**, **G**, and **B**. We created this class so that we could more easily store color values. 

#### Point2D
Point2D is a class used to store (x, y) coordinates. Its constructor accepts two doubles as 
parameters: **x** and **y**. We created this class so that we could more easily store location 
values.

#### EventType
EventType is an enum used to store the types of possible events. Currently, it allows events to be
set as **move**, **scale**, or **recolor**. We created this enum so that AnimationModel can easily 
identify an event's type, which helps make sure that the same type of event doesn't overlap for
a given shape. 