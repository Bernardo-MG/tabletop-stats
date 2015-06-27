# ValueBox

A ValueBox is a variant of the observable pattern, meant to handle dependencies between values, which will be observers, keeping watch on the ValueBox through listeners.

## Interfaces

The [ValueBox][value_box] allows querying and editing the contained value. Additionally, it also allows to register and unregister observers.

This is done with the _addValueChangeListener_ and _removeValueChangeListener_ methods. These won't receive the observers, but an event listener, which will be the actual way for both ends to interact.

There is an additional interface, the [SkillBox][skill_box], which additionally takes care of a name and descriptor. This covers the most usual skills which appear on tabletop games. It also can be used in cases where the value needs to be named, for that just ignore the descriptor.

### Default implementations

[![ValueBox class tree][value_box-class_tree]][value_box-class_tree]

Two default implementations are offered. [DefaultValueBox][default_value_box], and [DefaultSkillBox][default_skill_box]. These are straightforward implementations, which cover most of the use cases.

## Events

To handle the event operations an abstract implementation, [AbstractValueBoxEventFirer][value_box_event], is offered.

It just takes care of the events and nothing else, with a very simple implementation. Listeners are stored in a list, which is iterated each time the _fireValueChangedEvent_ method is invoked.

Note that prior this, the required event should be created.

[![ValueBox event sequence][value_box_event-sequence]][value_box_event-sequence]

Handling events through the listener is very simple and straightforward. The listener will be an adapter, allowing the observer to actually observe the ValueBox, and be warned each time it suffers any modification.

## Derived stats

### Aggregated ValueBox

[![AggregatedValueBox class tree][aggregatedvalueboxclasstree]][aggregatedvalueboxclasstree]

A common type of derived stat, the aggregated stat is composed of the summation of a series of other stats, and is updated when any of them changes.

This is represented by the [AggregatedValueBox][aggregatedvaluebox]. This keeps a collection of ValueBoxes, and an internal value with the summation. Said value will only be updated when needed (thanks to the use of listeners), so querying it will be always a linear operation.

It should be noted that while the setValue exists on this ValueBox, it is disabled, and will throw an UnsupportedOperationException.

[aggregatedvaluebox]: ./apidocs/com/wandrell/tabletop/stat/valuebox/AggregatedValueBox.html
[aggregatedvalueboxclasstree]: ./images/aggregated_valuebox_class_tree.png
[default_skill_box]: ./apidocs/com/wandrell/tabletop/stat/valuebox/DefaultSkillBox.html
[default_value_box]: ./apidocs/com/wandrell/tabletop/stat/valuebox/DefaultValueBox.html
[skill_box]: ./apidocs/com/wandrell/tabletop/stat/valuebox/SkillBox.html
[value_box]: ./apidocs/com/wandrell/tabletop/stat/valuebox/ValueBox.html
[value_box-class_tree]: ./images/valuebox_class_tree.png
[value_box_event]: ./apidocs/com/wandrell/tabletop/stat/valuebox/AbstractValueBoxEventFirer.html
[value_box_event-sequence]: ./images/valuebox_event_sequence.png