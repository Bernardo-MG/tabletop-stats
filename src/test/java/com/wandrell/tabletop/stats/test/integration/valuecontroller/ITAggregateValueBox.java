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
package com.wandrell.tabletop.stats.test.integration.valuecontroller;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.stats.controller.DefaultValueController;
import com.wandrell.tabletop.stats.controller.ValueController;
import com.wandrell.tabletop.stats.valuebox.DefaultValueBox;
import com.wandrell.tabletop.stats.valuebox.ValueBox;

/**
 * Integration test for {@link DefaultValueController}, checking that the
 * contained {@code ValueBox} is updated correctly.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The {@link ValueBox} is increased by the {@code increaseValue()} method
 * when it is possible to increase.</li>
 * <li>The {@link ValueBox} is not modified by the {@code increaseValue()}
 * method when the value is at the upper limit.</li>
 * <li>The {@link ValueBox} is not modified by the {@code increaseValue()}
 * method when the value is over the upper limit.</li>
 * <li>The {@link ValueBox} is decreased by the {@code decreaseValue()} method
 * when it is possible to decrease.</li>
 * <li>The {@link ValueBox} is not modified by the {@code decreaseValue()}
 * method when the value is at the lower limit.</li>
 * <li>The {@link ValueBox} is not modified by the {@code decreaseValue()}
 * method when the value is under the lower limit.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class ITAggregateValueBox {

    /**
     * Constructs an {@code ITAggregateValueBox}.
     */
    public ITAggregateValueBox() {
        super();
    }

    /**
     * Tests that the {@link ValueBox} is decreased by the
     * {@code decreaseValue()} method when it is possible to decrease.
     */
    @Test
    public final void testDecrease_Able() {
        final ValueController handler; // The tested ValueController
        final ValueBox value;          // The contained ValueBox

        value = new DefaultValueBox(1);

        handler = new DefaultValueController(value);
        handler.setInterval(-10, Integer.MAX_VALUE);

        handler.decreaseValue();
        Assert.assertEquals((Integer) 0, value.getValue());
    }

    /**
     * Tests that the {@link ValueBox} is not modified by the
     * {@code decreaseValue()} method when the value is at the lower limit.
     */
    @Test
    public final void testDecrease_Unable_AtLimit() {
        final ValueController handler; // The tested ValueController
        final ValueBox value;          // The contained ValueBox

        value = new DefaultValueBox(1);

        handler = new DefaultValueController(value);
        handler.setInterval(1, Integer.MAX_VALUE);

        handler.decreaseValue();
        Assert.assertEquals((Integer) 1, value.getValue());
    }

    /**
     * Tests that the {@link ValueBox} is not modified by the
     * {@code decreaseValue()} method when the value is under the lower limit.
     */
    @Test
    public final void testDecrease_Unable_UnderLimit() {
        final ValueController handler; // The tested ValueController
        final ValueBox value;          // The contained ValueBox

        value = new DefaultValueBox(1);

        handler = new DefaultValueController(value);
        handler.setInterval(5, Integer.MAX_VALUE);

        handler.decreaseValue();
        Assert.assertEquals((Integer) 1, value.getValue());
    }

    /**
     * Tests that the {@link ValueBox} is increased by the
     * {@code increaseValue()} method when it is possible to increase.
     */
    @Test
    public final void testIncrease_Able() {
        final ValueController handler; // The tested ValueController
        final ValueBox value;          // The contained ValueBox

        value = new DefaultValueBox(1);

        handler = new DefaultValueController(value);
        handler.setInterval(Integer.MIN_VALUE, 10);

        handler.increaseValue();
        Assert.assertEquals((Integer) 2, value.getValue());
    }

    /**
     * Tests that the {@link ValueBox} is not modified by the
     * {@code increaseValue()} method when the value is at the upper limit.
     */
    @Test
    public final void testIncrease_Unable_AtLimit() {
        final ValueController handler; // The tested ValueController
        final ValueBox value;          // The contained ValueBox

        value = new DefaultValueBox(1);

        handler = new DefaultValueController(value);
        handler.setInterval(Integer.MIN_VALUE, 1);

        handler.increaseValue();
        Assert.assertEquals((Integer) 1, value.getValue());
    }

    /**
     * Tests that the {@link ValueBox} is not modified by the
     * {@code increaseValue()} method when the value is over the upper limit.
     */
    @Test
    public final void testIncrease_Unable_OverLimit() {
        final ValueController handler; // The tested ValueController
        final ValueBox value;          // The contained ValueBox

        value = new DefaultValueBox(1);

        handler = new DefaultValueController(value);
        handler.setInterval(Integer.MIN_VALUE, 1);

        handler.increaseValue();
        Assert.assertEquals((Integer) 1, value.getValue());
    }

}
