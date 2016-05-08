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

package com.wandrell.tabletop.stats.test.unit.valuebox;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.stats.valuebox.AggregatedValueBox;
import com.wandrell.tabletop.stats.valuebox.ValueBox;

/**
 * Unit test for {@link AggregatedValueBox}, checking that the stored value is
 * updated correctly.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The aggregated value is updated when a {@code ValueBox} is added.</li>
 * <li>The aggregated value is updated when a {@code ValueBox} is removed.</li>
 * <li>The aggregated value is set to the upper limit when adding a
 * {@code ValueBox} would cause overflow.</li>
 * <li>The aggregated value is set to the lower limit when adding a
 * {@code ValueBox} would cause underflow.</li>
 * <li>The aggregated value is set to the upper limit when the initial
 * {@code ValueBox} instances would cause overflow.</li>
 * <li>The aggregated value is set to the lower limit when the initial
 * {@code ValueBox} instances would cause underflow.</li>
 * <li>The aggregated value is 0 by default.</li>
 * <li>The aggregated is set correctly when using a single {@code ValueBox}.
 * </li>
 * <li>The aggregated is set correctly when using two {@code ValueBox}.</li>
 * <li>Removing all the {@code ValueBox} instances sets the aggregate value to
 * 0.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestAggregatedValueBox {

    /**
     * Default constructor.
     */
    public TestAggregatedValueBox() {
        super();
    }

    /**
     * Tests that the aggregated value is updated when a {@code ValueBox} is
     * added
     */
    @Test
    public final void testGetValue_addValue() {
        final ValueBox value1;               // First aggregated value
        final ValueBox value2;               // Second aggregated value
        final AggregatedValueBox aggregated; // Tested ValueBox

        value1 = Mockito.mock(ValueBox.class);
        value2 = Mockito.mock(ValueBox.class);

        Mockito.when(value1.getValue()).thenReturn(1);
        Mockito.when(value2.getValue()).thenReturn(4);

        aggregated = new AggregatedValueBox(value1);

        aggregated.addValueBox(value2);

        Assert.assertEquals(aggregated.getValue(), (Integer) 5);
    }

    /**
     * Tests that the aggregated value is set to the upper limit when adding a
     * {@code ValueBox} would cause overflow.
     */
    @Test
    public final void testGetValue_addValue_overflow_neg() {
        final ValueBox value1;               // First aggregated value
        final ValueBox value2;               // Second aggregated value
        final AggregatedValueBox aggregated; // Tested ValueBox

        value1 = Mockito.mock(ValueBox.class);
        value2 = Mockito.mock(ValueBox.class);

        Mockito.when(value1.getValue()).thenReturn(0 - 1);
        Mockito.when(value2.getValue()).thenReturn(Integer.MIN_VALUE);

        aggregated = new AggregatedValueBox(value1);

        aggregated.addValueBox(value2);

        Assert.assertEquals(aggregated.getValue(), (Integer) Integer.MIN_VALUE);
    }

    /**
     * Tests that the aggregated value is set to the lower limit when adding a
     * {@code ValueBox} would cause underflow.
     */
    @Test
    public final void testGetValue_addValue_overflow_pos() {
        final ValueBox value1;               // First aggregated value
        final ValueBox value2;               // Second aggregated value
        final AggregatedValueBox aggregated; // Tested ValueBox

        value1 = Mockito.mock(ValueBox.class);
        value2 = Mockito.mock(ValueBox.class);

        Mockito.when(value1.getValue()).thenReturn(1);
        Mockito.when(value2.getValue()).thenReturn(Integer.MAX_VALUE);

        aggregated = new AggregatedValueBox(value1);

        aggregated.addValueBox(value2);

        Assert.assertEquals(aggregated.getValue(), (Integer) Integer.MAX_VALUE);
    }

    /**
     * Tests that the aggregated value is 0 by default
     */
    @Test
    public final void testGetValue_Empty() {
        final ValueBox aggregated; // Tested ValueBox

        aggregated = new AggregatedValueBox();

        Assert.assertEquals(aggregated.getValue(), (Integer) 0);
    }

    /**
     * Tests that the aggregated is set correctly when using a single
     * {@code ValueBox}.
     */
    @Test
    public final void testGetValue_OneValue() {
        final ValueBox value1;     // Aggregated value
        final ValueBox aggregated; // Tested ValueBox

        value1 = Mockito.mock(ValueBox.class);

        Mockito.when(value1.getValue()).thenReturn(1);

        aggregated = new AggregatedValueBox(value1);

        Assert.assertEquals(aggregated.getValue(), (Integer) 1);
    }

    /**
     * Tests that the aggregated value is set to the upper limit when the
     * initial {@code ValueBox} instances would cause overflow.
     */
    @Test
    public final void testGetValue_Overflow_Max() {
        final ValueBox value1;     // First aggregated value
        final ValueBox value2;     // Second aggregated value
        final ValueBox aggregated; // Tested ValueBox

        value1 = Mockito.mock(ValueBox.class);
        value2 = Mockito.mock(ValueBox.class);

        Mockito.when(value1.getValue()).thenReturn(1);
        Mockito.when(value2.getValue()).thenReturn(Integer.MAX_VALUE);

        aggregated = new AggregatedValueBox(value1, value2);

        Assert.assertEquals(aggregated.getValue(), (Integer) Integer.MAX_VALUE);
    }

    /**
     * Tests that the aggregated value is set to the lower limit when the
     * initial {@code ValueBox} instances would cause underflow.
     */
    @Test
    public final void testGetValue_Overflow_Min() {
        final ValueBox value1;     // First aggregated value
        final ValueBox value2;     // Second aggregated value
        final ValueBox aggregated; // Tested ValueBox

        value1 = Mockito.mock(ValueBox.class);
        value2 = Mockito.mock(ValueBox.class);

        Mockito.when(value1.getValue()).thenReturn(-1);
        Mockito.when(value2.getValue()).thenReturn(Integer.MIN_VALUE);

        aggregated = new AggregatedValueBox(value1, value2);

        Assert.assertEquals(aggregated.getValue(), (Integer) Integer.MIN_VALUE);
    }

    /**
     * Tests that removing all the {@code ValueBox} instances sets the aggregate
     * value to 0.
     */
    @Test
    public final void testGetValue_RemoveAll() {
        final ValueBox value1;               // First aggregated value
        final ValueBox value2;               // Second aggregated value
        final AggregatedValueBox aggregated; // Tested ValueBox

        value1 = Mockito.mock(ValueBox.class);
        value2 = Mockito.mock(ValueBox.class);

        Mockito.when(value1.getValue()).thenReturn(1);
        Mockito.when(value2.getValue()).thenReturn(4);

        aggregated = new AggregatedValueBox(value1, value2);

        aggregated.removeValueBox(value2);
        aggregated.removeValueBox(value1);

        Assert.assertEquals(aggregated.getValue(), (Integer) 0);
    }

    /**
     * Tests that the aggregated value is updated when a {@code ValueBox} is
     * removed.
     */
    @Test
    public final void testGetValue_RemoveValue() {
        final ValueBox value1;               // First aggregated value
        final ValueBox value2;               // Second aggregated value
        final AggregatedValueBox aggregated; // Tested ValueBox

        value1 = Mockito.mock(ValueBox.class);
        value2 = Mockito.mock(ValueBox.class);

        Mockito.when(value1.getValue()).thenReturn(1);
        Mockito.when(value2.getValue()).thenReturn(4);

        aggregated = new AggregatedValueBox(value1, value2);

        aggregated.removeValueBox(value2);

        Assert.assertEquals(aggregated.getValue(), (Integer) 1);
    }

    /**
     * Tests that the aggregated is set correctly when using two
     * {@code ValueBox}.
     */
    @Test
    public final void testGetValue_TwoValues() {
        final ValueBox value1;     // First aggregated value
        final ValueBox value2;     // Second aggregated value
        final ValueBox aggregated; // Tested ValueBox

        value1 = Mockito.mock(ValueBox.class);
        value2 = Mockito.mock(ValueBox.class);

        Mockito.when(value1.getValue()).thenReturn(1);
        Mockito.when(value2.getValue()).thenReturn(4);

        aggregated = new AggregatedValueBox(value1, value2);

        Assert.assertEquals(aggregated.getValue(), (Integer) 5);
    }

}
