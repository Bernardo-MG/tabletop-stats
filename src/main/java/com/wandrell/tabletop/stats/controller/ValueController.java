/**
 * Copyright 2014 the original author or authors
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
package com.wandrell.tabletop.stats.controller;

import com.wandrell.tabletop.stats.valuebox.ValueBox;

/**
 * Controller to increase and decrease a
 * {@link com.wandrell.tabletop.stats.valuebox.ValueBox ValueBox} through an UI.
 * <p>
 * This is meant to be used on a desktop application, where the
 * {@link #decreaseValue() decreaseValue} and {@link #increaseValue()
 * increaseValue} methods would be linked to buttons.
 * <p>
 * This way the view layer would receive a {@code ValueController}, which would
 * hide the actual {@code ValueBox} being used, and the code which modifies it.
 * <p>
 * Of course, it's perfectly possible to handle any other value through this
 * controller, but it's meant to use, as said, a {@code ValueBox}.
 * 
 * @author Bernardo Martínez Garrido
 * @see ValueBox
 */
public interface ValueController {

    /**
     * Decreases the value, if it is possible.
     */
    public void decreaseValue();

    /**
     * Returns the minimum allowed value.
     * 
     * @return the minimum allowed value
     */
    public Integer getLowerLimit();

    /**
     * Returns the maximum allowed value.
     * 
     * @return the maximum allowed value
     */
    public Integer getUpperLimit();

    /**
     * Increases the value, if it is possible.
     */
    public void increaseValue();

    /**
     * Checks if it is possible to decrease the value.
     * 
     * @return {@code true} if it is possible to decrease the value,
     *         {@code false} otherwise
     */
    public Boolean isAbleToDecrease();

    /**
     * Checks if it is possible to increase the value.
     * 
     * @return {@code true} if it is possible to increase the value,
     *         {@code false} otherwise
     */
    public Boolean isAbleToIncrease();

    /**
     * Sets the interval in which the value should stay.
     * 
     * @param lowerLimit
     *            the minimum allowed value
     * @param upperLimit
     *            the maximum allowed value
     */
    public void setInterval(final Integer lowerLimit, final Integer upperLimit);

    /**
     * Sets the {@code ValueBox} to be modified.
     * 
     * @param box
     *            the {@code ValueBox} to be modified
     */
    public void setValueBox(final ValueBox box);

}
