package com.wandrell.tabletop.testing.stats.test.unit.valuebox.exception;

import org.testng.annotations.Test;

import com.wandrell.tabletop.stats.valuebox.AggregatedValueBox;

/**
 * Unit test for {@link AggregatedValueBox}, checking that exceptions are thrown
 * where required.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>An {@code IllegalArgumentException} is thrown when the
 * {@code AggregatedValueBox} tries to add itself.</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestExceptionAggregatedValueBox {

    /**
     * Constructs a {@code TestExceptionAggregatedValueBox}.
     */
    public TestExceptionAggregatedValueBox() {
        super();
    }

    /**
     * Testa than an {@code IllegalArgumentException} is thrown when the
     * {@code AggregatedValueBox} tries to add itself.
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public final void testAddValue_itself() {
        final AggregatedValueBox aggregated; // Tested ValueBox

        aggregated = new AggregatedValueBox();

        aggregated.addValueBox(aggregated);
    }

}
