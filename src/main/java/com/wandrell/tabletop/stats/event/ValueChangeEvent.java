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
package com.wandrell.tabletop.stats.event;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.EventObject;

/**
 * {@code EventObject} storing the status of a value related event.
 * <p>
 * This is sent when a, {@code Integer} field has been modified, and will store
 * both the old and the new values of such field.
 * <p>
 * Note that the old value is the one the field has before the event happens,
 * while the new is the one that same field has after the event has happened.
 * The values on this event should be consistent with that.
 * <p>
 * Also, keeping these two values means the event can represent any change, no
 * matter if the value increased or decreased, that can be found out by checking
 * the values.
 * <p>
 * The main use of this event is handling changes made to a
 * {@link com.wandrell.tabletop.stats.valuebox.ValueBox ValueBox}, so any other
 * {@code ValueBox} which derives from it can update it's own value.
 * 
 * @author Bernardo Martínez Garrido
 * @see com.wandrell.tabletop.stats.valuebox.ValueBox ValueBox
 */
public final class ValueChangeEvent extends EventObject {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = -4908049306092542940L;
    /**
     * The value after the event has happened.
     */
    private final Integer     newValue;
    /**
     * The value before the event has happened.
     */
    private final Integer     oldValue;

    /**
     * Constructs an instance of the event with the specified source and values.
     * 
     * @param source
     *            the source which generated the event
     * @param before
     *            the value before the event
     * @param after
     *            the value after the event
     */
    public ValueChangeEvent(final Object source, final Integer before,
            final Integer after) {
        super(source);

        checkNotNull(before, "Received a null pointer as the old value");
        checkNotNull(after, "Received a null pointer as the new value");

        this.oldValue = before;
        this.newValue = after;
    }

    /**
     * Returns the value after the event.
     * 
     * @return the value after the event
     */
    public final Integer getNewValue() {
        return newValue;
    }

    /**
     * Returns the value before the event.
     * 
     * @return the value before the event
     */
    public final Integer getOldValue() {
        return oldValue;
    }

}
