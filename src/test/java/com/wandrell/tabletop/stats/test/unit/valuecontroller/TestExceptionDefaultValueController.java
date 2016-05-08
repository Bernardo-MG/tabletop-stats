
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
 * <li>Invalid intervals throw an exception.</li>
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
     * Tests that invalid intervals throw an exception.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testSetInterval_Invalid() {
        final ValueController controller; // Controller being tested

        controller = new DefaultValueController();

        controller.setInterval(10, 0);
    }
}
