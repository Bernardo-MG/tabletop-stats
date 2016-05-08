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
package com.wandrell.tabletop.stats.test.integration.valuebox;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.stats.valuebox.AggregatedValueBox;
import com.wandrell.tabletop.stats.valuebox.DefaultValueBox;
import com.wandrell.tabletop.stats.valuebox.ValueBox;

/**
 * Integration test for {@link AggregatedValueBox}, checking that the stored
 * value is updated correctly.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The aggregated value is updated when a {@code ValueBox} is added and then
 * it's value is changed.</li>
 * <li>The aggregated value is updated when a {@code ValueBox} is removed.</li>
 * <li>The aggregated value is updated when the initial {@code ValueBox} is
 * modified.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class ITAggregatedValueBox {

    /**
     * Constructs an {@code ITAggregatedValueBox}.
     */
    public ITAggregatedValueBox() {
        super();
    }

    /**
     * Tests that the aggregated value is updated when a {@code ValueBox} is
     * added and then it's value is changed.
     */
    @Test
    public final void testValueUpdates_added() {
        final ValueBox value1;               // First aggregated value
        final ValueBox value2;               // Second aggregated value
        final AggregatedValueBox aggregated; // Tested ValueBox

        value1 = new DefaultValueBox(1);
        value2 = new DefaultValueBox(1);

        aggregated = new AggregatedValueBox(value1);

        aggregated.addValueBox(value2);

        value2.setValue(5);

        Assert.assertEquals(aggregated.getValue(), (Integer) 6);
    }

    /**
     * Tests that the aggregated value is updated when the initial
     * {@code ValueBox} is modified.
     */
    @Test
    public final void testValueUpdates_Constructor() {
        final ValueBox value1;          // Aggregated value
        final ValueBox aggregated;      // Tested ValueBox

        value1 = new DefaultValueBox(1);

        aggregated = new AggregatedValueBox(value1);

        value1.setValue(5);

        Assert.assertEquals(aggregated.getValue(), (Integer) 5);
    }

    /**
     * Tests that the aggregated value is updated when the initial
     * {@code ValueBox} is modified.
     */
    @Test
    public final void testValueUpdates_removed() {
        final ValueBox value1;               // First aggregated value
        final ValueBox value2;               // Second aggregated value
        final AggregatedValueBox aggregated; // Tested ValueBox

        value1 = new DefaultValueBox(1);
        value2 = new DefaultValueBox(1);

        aggregated = new AggregatedValueBox(value1);

        aggregated.addValueBox(value2);

        aggregated.removeValueBox(value2);

        value2.setValue(5);

        Assert.assertEquals(aggregated.getValue(), (Integer) 1);
    }

}
