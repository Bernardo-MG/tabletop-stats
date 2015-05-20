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

/**
 * Default implementation of
 * {@link com.wandrell.tabletop.stats.valuebox.ValueBox ValueBox}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultValueBox extends AbstractValueBox {

    /**
     * Constructs a {@code DefaultValueBox}.
     */
    public DefaultValueBox() {
        super(0);
    }

    /**
     * Copy constructor for {@code DefaultValueBox}.
     * 
     * @param box
     *            the {@code DefaultValueBox} to copy
     */
    public DefaultValueBox(final DefaultValueBox box) {
        super(box);
    }

    /**
     * Constructs a {@code DefaultValueBox} the specified value.
     * 
     * @param value
     *            the stored value
     */
    public DefaultValueBox(final Integer value) {
        super(value);
    }

}
