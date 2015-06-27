# Value events

Events are fundamental on the library, as it's classes are designed with an event oriented design. But it's also very simple, only two classes exist.

## Event

[![ValueChangeEvent event sequence][value_change_event-class_tree]][value\_change\_event-class\_tree]

The [ValueChangeEvent][value_change_event] is an extension of EventObject which additionally contains two Integers, both are related to the value which caused the event, and one stores the value before the event, and the other stores the value after the event.

This way, it is possible to know how has the value changed during the event.

## Listener

[![ValueChangeEvent event sequence][value_change_listener-class_tree]][value_change_listener-class_tree]

The [ValueChangeListener][value_change_listener] contains just a single method, valueChanged, used to be notified when the value has changed.

[value_change_event]: ./apidocs/com/wandrell/tabletop/stat/event/ValueChangeEvent.html
[value_change_event-class_tree]: ./images/valuechangeevent_class_tree.png
[value_change_listener]: ./apidocs/com/wandrell/tabletop/stat/event/ValueChangeListener.html
[value_change_listener-class_tree]: ./images/valuechangelistener_class_tree.png