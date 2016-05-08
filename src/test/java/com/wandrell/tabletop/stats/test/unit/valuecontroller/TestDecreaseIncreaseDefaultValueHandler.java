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
package com.wandrell.tabletop.stats.test.unit.valuecontroller;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.stats.controller.DefaultValueController;
import com.wandrell.tabletop.stats.controller.ValueController;
import com.wandrell.tabletop.stats.valuebox.ValueBox;

/**
 * Unit test for {@link DefaultValueController}, checking that the
 * {@code isAbleToIncrease()} and {@code isAbleToDecrease()} methods work
 * correctly.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The {@code isAbleToIncrease()} returns {@code true} when the value is
 * under the upper limit.</li>
 * <li>The {@code isAbleToIncrease()} returns {@code false} when the value is on
 * the upper limit.</li>
 * <li>The {@code isAbleToIncrease()} returns {@code false} by default.</li>
 * <li>The {@code isAbleToDecrease()} returns {@code true} when the value is
 * over the lower limit.</li>
 * <li>The {@code isAbleToDecrease()} returns {@code false} when the value is on
 * the lower limit.</li>
 * <li>The {@code isAbleToDecrease()} returns {@code false} by default.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestDecreaseIncreaseDefaultValueHandler {

    /**
     * Constructs a {@code TestDecreaseIncreaseDefaultValueHandler}.
     */
    public TestDecreaseIncreaseDefaultValueHandler() {
        super();
    }

    /**
     * The {@code isAbleToDecrease()} returns {@code true} when the value is
     * over the lower limit.
     */
    @Test
    public final void testIsAbleDecrease_Able() {
        final ValueController handler;
        final ValueBox value;

        value = Mockito.mock(ValueBox.class);
        Mockito.when(value.getValue()).thenReturn(1);

        handler = new DefaultValueController(value);
        handler.setInterval(-10, Integer.MAX_VALUE);

        Assert.assertTrue(handler.isAbleToDecrease());
    }

    /**
     * The {@code isAbleToDecrease()} returns {@code false} when the value is on
     * the lower limit.
     */
    @Test
    public final void testIsAbleDecrease_Unable() {
        final ValueController handler;
        final ValueBox value;

        value = Mockito.mock(ValueBox.class);
        Mockito.when(value.getValue()).thenReturn(1);

        handler = new DefaultValueController(value);
        handler.setInterval(1, Integer.MAX_VALUE);

        Assert.assertTrue(!handler.isAbleToDecrease());
    }

    /**
     * The {@code isAbleToDecrease()} returns {@code false} by default.
     */
    @Test
    public final void testIsAbleDecrease_Unable_Default() {
        Assert.assertTrue(!new DefaultValueController().isAbleToDecrease());
    }

    /**
     * The {@code isAbleToIncrease()} returns {@code true} when the value is
     * under the upper limit.
     */
    @Test
    public final void testIsAbleIncrease_Able() {
        final ValueController handler;
        final ValueBox value;

        value = Mockito.mock(ValueBox.class);
        Mockito.when(value.getValue()).thenReturn(1);

        handler = new DefaultValueController(value);
        handler.setInterval(Integer.MIN_VALUE, 10);

        Assert.assertTrue(handler.isAbleToIncrease());
    }

    /**
     * The {@code isAbleToIncrease()} returns {@code false} when the value is on
     * the upper limit.
     */
    @Test
    public final void testIsAbleIncrease_Unable() {
        final ValueController handler;
        final ValueBox value;

        value = Mockito.mock(ValueBox.class);
        Mockito.when(value.getValue()).thenReturn(1);

        handler = new DefaultValueController(value);
        handler.setInterval(Integer.MIN_VALUE, 1);

        Assert.assertTrue(!handler.isAbleToIncrease());
    }

    /**
     * The {@code isAbleToIncrease()} returns {@code false} by default.
     */
    @Test
    public final void testIsAbleIncrease_Unable_Default() {
        Assert.assertTrue(!new DefaultValueController().isAbleToIncrease());
    }

}
