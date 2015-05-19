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
package com.wandrell.tabletop.testing.stats.framework.test.unit;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Vector;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.stat.event.ValueChangeEvent;
import com.wandrell.tabletop.stat.event.ValueChangeListener;
import com.wandrell.tabletop.stat.valuebox.ValueBox;

/**
 * Abstract unit test for {@link ValueBox}, checking that event generation
 * procedure is done in the correct order.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>Inside the {@code valueChanged} method of the {@code ValueChangeListener}
 * , the current value of the {@code ValueBox} is the same as the new value on
 * the {@code ValueChangeEvent}.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public abstract class AbstractTestEventOrderDefaultSkillBox {

    /**
     * {@code ValueBox} being tested.
     */
    private final ValueBox box;

    /**
     * Constructs an {@code AbstractTestEventOrderDefaultSkillBox} for the
     * received {@code ValueBox}.
     * 
     * @param box
     *            {@code ValueBox} to test
     */
    public AbstractTestEventOrderDefaultSkillBox(final ValueBox box) {
        super();

        checkNotNull(box, "Received a null pointer as value box");

        this.box = box;
    }

    /**
     * Tests that inside the {@code valueChanged} method of the
     * {@code ValueChangeListener}, the current value of the {@code ValueBox} is
     * the same as the new value on the {@code ValueChangeEvent}.
     */
    @Test
    public final void testSetValue() {
        final List<Integer> listResult; // List storing the tested value
        final Integer v;                // Value set on the ValueBox

        listResult = new Vector<Integer>(1);
        listResult.add(0);

        // The listener sets the value stored in the list
        box.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChanged(final ValueChangeEvent evt) {
                listResult.set(0, ((ValueBox) evt.getSource()).getValue());
            }
        });

        v = 10;
        box.setValue(v);

        Assert.assertEquals(listResult.get(0), v);
    }

}
