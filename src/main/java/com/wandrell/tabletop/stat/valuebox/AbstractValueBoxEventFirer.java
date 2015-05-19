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
package com.wandrell.tabletop.stat.valuebox;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.LinkedHashSet;

import com.wandrell.tabletop.stat.event.ValueChangeEvent;
import com.wandrell.tabletop.stat.event.ValueChangeListener;

/**
 * Abstract implementation of {@code ValueBox} taking care of the event handling
 * process.
 * <p>
 * This is just meant to ease creating new implementations of the interface.
 * 
 * @author Bernardo Martínez Garrido
 */
public abstract class AbstractValueBoxEventFirer implements ValueBox {

    /**
     * The collection of listeners keeping watch on this {@code ValueBox}.
     */
    private final Collection<ValueChangeListener> listeners = new LinkedHashSet<ValueChangeListener>();

    /**
     * Constructs a default instance.
     */
    public AbstractValueBoxEventFirer() {
        super();
    }

    @Override
    public final void
            addValueChangeListener(final ValueChangeListener listener) {
        checkNotNull(listener, "Received a null pointer as listener");

        getListeners().add(listener);
    }

    @Override
    public final void removeValueChangeListener(
            final ValueChangeListener listener) {
        getListeners().remove(listener);
    }

    /**
     * Fires the value change event.
     * <p>
     * This is to be fired when the value is modified, and so it's state
     * changes.
     * 
     * @param event
     *            the event to be sent
     */
    protected final void fireValueChangedEvent(final ValueChangeEvent event) {
        checkNotNull(event, "Received a null pointer as event");

        for (final ValueChangeListener l : getListeners()) {
            l.valueChanged(event);
        }
    }

    /**
     * Returns the list of registered listeners.
     * 
     * @return the list of registered listeners
     */
    protected final Collection<ValueChangeListener> getListeners() {
        return listeners;
    }

}
