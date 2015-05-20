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

import java.util.EventListener;

/**
 * Listener for reacting to value change events.
 * <p>
 * A value change event indicates that a value intrinsic to the class throwing
 * it has changed. It may have increased, or it may have decreased, that doesn't
 * matter, as the {@link ValueChangeEvent} can be used to find out any
 * additional information which may be required.
 * <p>
 * The main use of this interface is reacting to changes on the
 * {@link com.wandrell.tabletop.stats.valuebox.ValueBox ValueBox} value.
 * 
 * @author Bernardo Martínez Garrido
 * @see ValueChangeEvent
 */
public interface ValueChangeListener extends EventListener {

    /**
     * The value has changed.
     * 
     * @param event
     *            the event data
     */
    public void valueChanged(final ValueChangeEvent event);

}
