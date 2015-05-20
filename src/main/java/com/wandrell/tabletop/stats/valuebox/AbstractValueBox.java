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

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.google.common.base.MoreObjects;
import com.wandrell.tabletop.stats.event.ValueChangeEvent;

/**
 * Abstract implementation of
 * {@link com.wandrell.tabletop.stats.valuebox.ValueBox ValueBox} offering events
 * and a stored value.
 * <p>
 * This is to be used when implementing a custom extension of {@code ValueBox}.
 * 
 * @author Bernardo Martínez Garrido
 */
public abstract class AbstractValueBox extends AbstractValueBoxEventFirer {

    /**
     * The stored value.
     */
    private Integer storedValue;

    /**
     * Constructs a {@code DefaultValueBox}.
     */
    public AbstractValueBox() {
        this(0);
    }

    /**
     * Copy constructor for {@code DefaultValueBox}.
     * 
     * @param box
     *            the {@code DefaultValueBox} to copy
     */
    public AbstractValueBox(final AbstractValueBox box) {
        super();

        checkNotNull(box, "Received a null pointer as value handler");

        // Copies the stored value
        storedValue = box.storedValue;
    }

    /**
     * Constructs a {@code DefaultValueBox} the specified value.
     * 
     * @param value
     *            the stored value
     */
    public AbstractValueBox(final Integer value) {
        super();

        checkNotNull(value, "Received a null pointer as value");

        // Value store
        storedValue = value;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final AbstractValueBox other;
        other = (AbstractValueBox) obj;

        return Objects.equals(storedValue, other.storedValue);
    }

    @Override
    public final Integer getValue() {
        return storedValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(storedValue);
    }

    /**
     * Sets the value stored.
     * 
     * @param value
     *            the value to store
     */
    @Override
    public final void setValue(final Integer value) {
        final Integer old;

        old = storedValue;

        storedValue = value;

        fireValueChangedEvent(new ValueChangeEvent(this, old, storedValue));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("storedValue", storedValue)
                .toString();
    }

}
