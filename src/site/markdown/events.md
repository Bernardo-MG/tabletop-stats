# Value events

Events are fundamental on the library, as it's classes are designed with an event oriented design. But it's also very simple, only two classes exist.

## Event

![ValueChangeEvent event sequence](./images/valuechangeevent_class_tree.png)

The [ValueChangeEvent][valuechangeevent] is an extension of EventObject which additionally contains two Integers, both are related to the value which caused the event, and one stores the value before the event, and the other stores the value after the event.

This way, it is possible to know how has the value changed during the event.

## Listener

![ValueChangeEvent event sequence](./images/valuechangelistener_class_tree.png)

The [ValueChangeListener][valuechangelistener] contains just a single method, valueChanged, used to be notified when the value has changed.

[valuechangeevent]: ./apidocs/com/wandrell/tabletop/stat/event/ValueChangeEvent.html
[valuechangelistener]: ./apidocs/com/wandrell/tabletop/stat/event/ValueChangeListener.html