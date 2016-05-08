/**
 * Copyright 2015 the original author or authors
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

package com.wandrell.tabletop.stats.test.util.test.unit.valuebox;

import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.stats.event.ValueChangeEvent;
import com.wandrell.tabletop.stats.event.ValueChangeListener;
import com.wandrell.tabletop.stats.valuebox.ValueBox;

/**
 * Abstract unit test for {@link ValueBox}, checking that events data is handled
 * in the correct order.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The value change event receives the new value set to the value box.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public abstract class AbstractTestEventValueBox {

    /**
     * Listener for the tests.
     * <p>
     * It captures the value sent by the value change event.
     * 
     * @author Bernardo Martínez Garrido
     */
    private final class TestValueChangeListener implements ValueChangeListener {

        /**
         * Value sent by the value change event.
         */
        private Integer value;

        /**
         * Default constructor.
         */
        public TestValueChangeListener() {
            super();
        }

        /**
         * Returns the value sent by the value change event.
         * 
         * @return the value sent by the value change event
         */
        public final Integer getValue() {
            return value;
        }

        @Override
        public void valueChanged(final ValueChangeEvent evt) {
            value = ((ValueBox) evt.getSource()).getValue();
        }
    }

    /**
     * Default constructor.
     */
    public AbstractTestEventValueBox() {
        super();
    }

    /**
     * Tests that the value change event has the correct context.
     */
    @Test
    public final void testSetValue_EventContext_Valid() {
        final ValueBox box;           // Tested value box
        final ValueChangeEvent event; // Generated event
        final Integer newValue;       // Value set to the ValueBox
        final ValueChangeListener listenerHandler; // Test listener
        final ArgumentCaptor<ValueChangeEvent> captorEvent;

        listenerHandler = Mockito.mock(ValueChangeListener.class);
        captorEvent = ArgumentCaptor.forClass(ValueChangeEvent.class);

        box = getValueBox();

        // Sets the captor to get the listener event
        Mockito.doNothing().when(listenerHandler)
                .valueChanged(captorEvent.capture());

        // Adds the listener to the ValueBox
        box.addValueChangeListener(listenerHandler);

        newValue = 10;
        box.setValue(newValue);

        // To capture the event
        Mockito.verify(listenerHandler, Mockito.times(1))
                .valueChanged(Matchers.any(ValueChangeEvent.class));

        // Gets the captured event
        event = captorEvent.getValue();

        Assert.assertEquals(event.getSource(), box);
        Assert.assertEquals(event.getOldValue(), (Integer) 0);
        Assert.assertEquals(event.getNewValue(), newValue);
    }

    /**
     * Tests that the value change event receives the new value set to the value
     * box.
     */
    @Test
    public final void testSetValue_EventValue_NewValue() {
        final ValueBox box; // Tested value box
        final Integer v;    // Value set on the ValueBox
        final TestValueChangeListener listener; // Test listener

        box = getValueBox();

        // Sets the listener
        listener = new TestValueChangeListener();
        box.addValueChangeListener(listener);

        // Sets the value
        v = 10;
        box.setValue(v);

        Assert.assertEquals(listener.getValue(), v);
    }

    /**
     * Generates an instance of the {@code ValueBox} to test.
     * 
     * @return the {@code ValueBox} to test
     */
    protected abstract ValueBox getValueBox();

}
