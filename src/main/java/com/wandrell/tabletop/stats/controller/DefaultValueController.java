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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.math.IntMath;
import com.wandrell.tabletop.stats.valuebox.ValueBox;

/**
 * Default implementation of the {@code ValueHandler} interface.
 * <p>
 * If the default constructor is used, all the boolean query methods will return
 * false, and the modifier methods will do nothing.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultValueController implements ValueController {

    /**
     * The step marking the change to be applied on the value.
     */
    private final Integer changeStep = 1;

    /**
     * The {@code ValueBox} to be handled.
     */
    private ValueBox      handledValue;

    /**
     * Minimum allowed value.
     */
    private Integer       limitLower = Integer.MIN_VALUE;

    /**
     * Maximum allowed value.
     */
    private Integer       limitUpper = Integer.MAX_VALUE;

    /**
     * Constructs a {@code DefaultValueController} with no {@code ValueBox}.
     */
    public DefaultValueController() {
        super();
    }

    /**
     * Constructs a {@code DefaultValueController} with the specified
     * {@code ValueBox}.
     * 
     * @param value
     *            the {@code ValueBox} to control
     */
    public DefaultValueController(final ValueBox value) {
        this();

        handledValue = value;
    }

    @Override
    public final void decreaseValue() {
        Integer value;

        if (getValue() != null) {
            try {
                value = IntMath.checkedSubtract(getValue().getValue(),
                        getStep());
            } catch (final ArithmeticException exception) {
                value = Integer.MIN_VALUE;
            }

            if (value >= getLowerLimit()) {
                getValue().setValue(value);
            }
        }
    }

    @Override
    public final Integer getLowerLimit() {
        return limitLower;
    }

    @Override
    public final Integer getUpperLimit() {
        return limitUpper;
    }

    @Override
    public final void increaseValue() {
        Integer value;

        if (getValue() != null) {
            try {
                value = IntMath.checkedAdd(getValue().getValue(), getStep());
            } catch (final ArithmeticException exception) {
                value = Integer.MAX_VALUE;
            }

            if (value <= getUpperLimit()) {
                getValue().setValue(value);
            }
        }
    }

    @Override
    public final Boolean isAbleToDecrease() {
        final Boolean result;
        Integer value;

        if (getValue() == null) {
            result = false;
        } else {
            try {
                value = IntMath.checkedSubtract(getValue().getValue(),
                        getStep());
            } catch (final ArithmeticException exception) {
                value = Integer.MIN_VALUE;
            }
            result = (value >= getLowerLimit());
        }

        return result;
    }

    @Override
    public final Boolean isAbleToIncrease() {
        final Boolean result;
        Integer value;

        if (getValue() == null) {
            result = false;
        } else {
            try {
                value = IntMath.checkedAdd(getValue().getValue(), getStep());
            } catch (final ArithmeticException exception) {
                value = Integer.MAX_VALUE;
            }
            result = (value <= getUpperLimit());
        }

        return result;
    }

    @Override
    public final void setInterval(final Integer lowerLimit,
            final Integer upperLimit) {
        checkNotNull(lowerLimit, "Received a null pointer as lower limit");
        checkNotNull(upperLimit, "Received a null pointer as upper limit");

        checkArgument(lowerLimit <= upperLimit,
                "The lower limit should be lower or equal to the upper limit");

        limitLower = lowerLimit;
        limitUpper = upperLimit;
    }

    @Override
    public final void setValueBox(final ValueBox value) {
        checkNotNull(value, "Received a null pointer as value");

        handledValue = value;
    }

    /**
     * Returns the step for the value modifications.
     * 
     * @return the modification step
     */
    private final Integer getStep() {
        return changeStep;
    }

    /**
     * Returns the {@code ValueBox} being handled.
     * 
     * @return the {@code ValueBox} being handled
     */
    private final ValueBox getValue() {
        return handledValue;
    }

}
