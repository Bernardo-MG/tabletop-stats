/**
 * Copyright 2013-2014 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.wandrell.tabletop.stats.valuebox;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import com.google.common.base.MoreObjects;
import com.google.common.math.IntMath;
import com.wandrell.tabletop.stats.event.ValueChangeEvent;
import com.wandrell.tabletop.stats.event.ValueChangeListener;

/**
 * Implementation of {@link ValueBox} which stores a collection of other
 * {@code ValueBox} instances, and generated a value which is the addition of
 * the values from all those {@code ValueBox} instances.
 * <p>
 * This is a type of derived value, and so the {@link #setValue(Integer)
 * setValue} method is disabled. Trying to use it will cause an
 * {@code UnsupportedOperationException} to be thrown.
 * <p>
 * The logic behind this class is simple: a series of {@code ValueBox} instances
 * are added, and all of them receive a {@link ValueChangeListener} which will
 * update the value contained in the {@code AggregateValueBox}.
 * <p>
 * Which means that the value is not generate when queried, and so acquiring it
 * is always done in linear time.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class AggregatedValueBox extends AbstractValueBoxEventFirer {

    /**
     * The aggregated value.
     * <p>
     * This stored the summation of the values from all the {@code ValueBox}
     * instances added to the {@code AggregatedValueBox}.
     * <p>
     * Each time one of these {@code ValueBox}'s value changes, this aggregated
     * value is updated.
     */
    private Integer                    aggregated = 0;
    /**
     * The listener to be added into any inserted {@code ValueBox}.
     */
    private ValueChangeListener        listenerValues;
    /**
     * Collection with all the {@code ValueBox} classes being aggregated.
     * <p>
     * All of these have received the same {@code ValueChangeListener}, which
     * will be used to react when the value they store changes.
     */
    private final Collection<ValueBox> valueBoxes = new LinkedList<ValueBox>();

    {
        // The ValueChangeListener is initialized
        // It will update the aggregated value with the value change
        listenerValues = new ValueChangeListener() {

            @Override
            public void valueChanged(final ValueChangeEvent evt) {
                updateValue(evt.getNewValue() - evt.getOldValue());
            }

        };
    }

    /**
     * Constructs an {@code AggregatedValueBox}.
     */
    public AggregatedValueBox() {
        super();
    }

    /**
     * Copy constructor for {@code AggregatedValueBox}.
     * <p>
     * The full collection of {@code ValueBox} instances will be copied into the
     * new {@code AggregatedValueBox}, so they will both share the same data,
     * but stored in separated structures.
     * 
     * @param box
     *            the {@code AggregatedValueBox} to copy
     */
    public AggregatedValueBox(final AggregatedValueBox box) {
        super();

        checkNotNull(box, "Received a null pointer as value box");

        valueBoxes.addAll(box.valueBoxes);

        generateValue();
    }

    /**
     * Constructs an {@code AggregatedValueBox} with the specified value boxes.
     * 
     * @param boxes
     *            the boxes to be aggregated
     */
    public AggregatedValueBox(final ValueBox... boxes) {
        super();

        checkNotNull(boxes, "Received a null pointer as value boxes");

        for (final ValueBox box : boxes) {
            checkNotNull(box, "Received a null pointer as one of the values");

            valueBoxes.add(box);

            box.addValueChangeListener(getValueListener());
        }

        generateValue();
    }

    /**
     * Adds a value box to the aggregation collection.
     * <p>
     * If it is already on the collection, then it is not added.
     * 
     * @param box
     *            the {@code ValueBox} to add
     */
    public final void addValueBox(final ValueBox box) {
        checkNotNull(box, "Received a null pointer as value box");

        checkArgument(box != this, "Tried to recursively add the value box");

        final Iterator<ValueBox> itr;
        Boolean found;

        box.addValueChangeListener(getValueListener());

        itr = getValueBoxesModifiable().iterator();
        found = false;
        while ((itr.hasNext()) && (!found)) {
            found = (itr.next() == box);
        }

        if (!found) {
            getValueBoxesModifiable().add(box);
            updateValue(box.getValue());
        }
    }

    @Override
    public final Integer getValue() {
        return aggregated;
    }

    /**
     * Returns all the {@code ValueBox} instances being aggregated.
     * 
     * @return the {@code ValueBox} instances being aggregated
     */
    public final Collection<ValueBox> getValueBoxes() {
        return Collections.unmodifiableCollection(getValueBoxesModifiable());
    }

    /**
     * Removes a value box.
     * 
     * @param box
     *            the {@code ValueBox} to remove
     */
    public final void removeValueBox(final ValueBox box) {
        checkNotNull(box, "Received a null pointer as value");

        final Integer size;

        size = getValueBoxesModifiable().size();

        getValueBoxesModifiable().remove(box);

        box.removeValueChangeListener(getValueListener());

        if (size != getValueBoxesModifiable().size()) {
            updateValue(0 - box.getValue());
        }
    }

    /**
     * Disabled setter.
     * <p>
     * This is a derived value, so the setter will throw an
     * {@link UnsupportedOperationException} if it is called.
     * 
     * @param value
     *            the value to store
     */
    @Override
    public final void setValue(final Integer value) {
        throw new UnsupportedOperationException("Setting the value is disabled");
    }

    /**
     * Sets the {@code ValueBox} instances being aggregated.
     * <p>
     * This will remove all the {@code ValueBox} instances from the class, and
     * then add the ones from the received list.
     * 
     * @param boxes
     *            the {@code ValueBox} instances to aggregate
     */
    public final void setValueBoxes(final Collection<ValueBox> boxes) {
        checkNotNull(boxes, "Received a null pointer as the value boxes");

        getValueBoxesModifiable().clear();
        for (final ValueBox value : boxes) {
            addValueBox(value);
        }

        generateValue();
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("values", valueBoxes)
                .toString();
    }

    /**
     * adds together all the {@code ValueBox} values and stores the resulting
     * value as the aggregated value.
     * <p>
     * This is to be used only when there is no other way to update the value,
     * as it will iterate over all {@code ValueBox} instances being kept on the
     * {@code AggregatedValueBox}.
     */
    private final void generateValue() {
        final Integer old;       // Old value, for the value change event
        ValueBox vhValue = null; // Iterated ValueBox

        old = aggregated;
        aggregated = 0;
        try {
            for (final ValueBox vh : getValueBoxesModifiable()) {
                vhValue = vh;
                // Tries to add the value
                aggregated = IntMath.checkedAdd(aggregated, vh.getValue());
            }
        } catch (final ArithmeticException exception) {
            // Overflow
            if (vhValue == null) {
                aggregated = 0;
            } else if (vhValue.getValue() < 0) {
                // It was a substraction
                // The aggregated value is set to the minimum
                aggregated = Integer.MIN_VALUE;
            } else {
                // It was an addition
                // The aggregated value is set to the maximum
                aggregated = Integer.MAX_VALUE;
            }
        }

        fireValueChangedEvent(new ValueChangeEvent(this, old, aggregated));
    }

    /**
     * Returns a collection with the {@code ValueBox} instances to aggregate.
     * 
     * @return the {@code ValueBox} instances to aggregate
     */
    private final Collection<ValueBox> getValueBoxesModifiable() {
        return valueBoxes;
    }

    /**
     * Returns the listener to apply to the {@code ValueBox} instances.
     * <p>
     * This will react to changed in the {@code ValueBox} instances, updating
     * the aggregated value.
     * 
     * @return the listener to apply to the {@code ValueBox} instances
     */
    private final ValueChangeListener getValueListener() {
        return listenerValues;
    }

    /**
     * Updates the value stored with the value received.
     * <p>
     * The value received will be added to the aggregated value.
     * 
     * @param value
     *            value to add to the aggregated value
     */
    private final void updateValue(final Integer value) {
        final Integer old;      // Old value, for the value change event

        old = aggregated;

        try {
            // Tries to add the value
            aggregated = IntMath.checkedAdd(aggregated, value);
        } catch (final ArithmeticException exception) {
            // Overflow
            if (value < 0) {
                // It was a substraction
                // The aggregated value is set to the minimum
                aggregated = Integer.MIN_VALUE;
            } else {
                // It was an addition
                // The aggregated value is set to the maximum
                aggregated = Integer.MAX_VALUE;
            }
        }

        fireValueChangedEvent(new ValueChangeEvent(this, old, aggregated));
    }

}
