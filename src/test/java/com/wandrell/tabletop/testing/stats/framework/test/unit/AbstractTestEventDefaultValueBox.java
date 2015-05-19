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
package com.wandrell.tabletop.testing.stats.framework.test.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.tabletop.stat.event.ValueChangeEvent;
import com.wandrell.tabletop.stat.event.ValueChangeListener;
import com.wandrell.tabletop.stat.valuebox.ValueBox;

/**
 * Abstract unit test for {@link ValueBox}, checking that events are generated
 * correctly.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The event generated after setting the value has the correct context.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public abstract class AbstractTestEventDefaultValueBox {

    /**
     * Argument captor to get the event from the listener.
     */
    private final ArgumentCaptor<ValueChangeEvent> captorEvent     = ArgumentCaptor
                                                                           .forClass(ValueChangeEvent.class);
    /**
     * {@code ValueBox} being tested.
     */
    private final ValueBox                         box;
    /**
     * Listener through which the captured event travels.
     */
    private ValueChangeListener                    listenerHandler = Mockito
                                                                           .mock(ValueChangeListener.class);

    /**
     * Constructs an {@code AbstractTestEventDefaultValueBox} for the received
     * {@code ValueBox}.
     * 
     * @param box
     *            {@code ValueBox} to test
     */
    public AbstractTestEventDefaultValueBox(final ValueBox box) {
        super();

        checkNotNull(box, "Received a null pointer as value box");

        this.box = box;
    }

    /**
     * Sets the captor to get the event class.
     */
    @BeforeClass
    public final void initialize() {
        // Sets the captor to get the listener event
        Mockito.doNothing().when(listenerHandler)
                .valueChanged(captorEvent.capture());

        // Adds the listener to the ValueBox
        box.addValueChangeListener(listenerHandler);
    }

    /**
     * Tests that the event generated after setting the value has the correct
     * context.
     */
    @Test
    public final void testSetValue_EventData() {
        final ValueChangeEvent event; // Generated event
        final Integer newValue = 10;  // Value set to the ValueBox

        box.setValue(newValue);

        // To capture the event
        Mockito.verify(listenerHandler, Mockito.times(1)).valueChanged(
                Matchers.any(ValueChangeEvent.class));

        // Gets the captured event
        event = captorEvent.getValue();

        Assert.assertEquals(event.getSource(), box);
        Assert.assertEquals(event.getOldValue(), (Integer) 0);
        Assert.assertEquals(event.getNewValue(), newValue);
    }

}
