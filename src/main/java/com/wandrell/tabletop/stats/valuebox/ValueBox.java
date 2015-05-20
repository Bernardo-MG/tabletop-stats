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

import com.wandrell.tabletop.stats.event.ValueChangeListener;

/**
 * Interface wrapping a value to allow listening to changes on it. This serves
 * to link the value to other classes, to implement logic such as that of
 * derived attributes.
 * <p>
 * A less abstract way of understanding the objective of this interface is that
 * it represents those values which are noted inside boxes on a character sheet.
 * That's the reason actually for the class' name.
 * <p>
 * It should be noted that if it is used for handling derived attributes then
 * the {@link #setValue(Integer) setValue} method should be disabled, or just
 * empty.
 * <p>
 * The recommended way of handling this is actually hiding implementations of
 * {@code ValueBox} inside a class, so they can't be accessed directly, even
 * when they are meant to be editable.
 * <p>
 * For example, if implementations of this interface are used to represent the
 * attributes of a character, then the class representing that character will
 * have a setter and getter for each attribute, and those method will call the
 * instances of {@code ValueBox}.
 * 
 * @author Bernardo Martínez Garrido
 */
public interface ValueBox {

    /**
     * Adds a value box listener.
     * <p>
     * When the value is modified an event should be thrown, and this listener
     * is expected to catch it.
     * 
     * @param listener
     *            the listener to add
     */
    public void addValueChangeListener(final ValueChangeListener listener);

    /**
     * Returns the current value.
     * 
     * @return the value
     */
    public Integer getValue();

    /**
     * Removes a value box listener.
     * 
     * @param listener
     *            the listener to remove
     */
    public void removeValueChangeListener(final ValueChangeListener listener);

    /**
     * Sets the value stored.
     * <p>
     * If the value is not editable, as for example is the case with derived
     * values, this should be disabled.
     * 
     * @param value
     *            the value to store
     */
    public void setValue(final Integer value);

}
