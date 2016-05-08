
package com.wandrell.tabletop.stats.test.unit.valuecontroller;

import org.testng.annotations.Test;

import com.wandrell.tabletop.stats.controller.DefaultValueController;
import com.wandrell.tabletop.stats.controller.ValueController;

/**
 * Unit test for {@link DefaultValueController}, checking that exceptions are
 * thrown when required.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The {@code setInterval} method throws an {@code IllegalArgumentException}
 * when the interval is invalid.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionDefaultValueController {

    /**
     * Default constructor.
     */
    public TestExceptionDefaultValueController() {
        super();
    }

    /**
     * Tests that the {@code setInterval} method throws an
     * {@code IllegalArgumentException} when the interval is invalid.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testSetInterval_Invalid() {
        final ValueController handler;

        handler = new DefaultValueController();

        handler.setInterval(10, 0);
    }
}
