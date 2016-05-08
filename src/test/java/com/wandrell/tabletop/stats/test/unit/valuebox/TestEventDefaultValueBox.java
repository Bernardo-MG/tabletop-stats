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

import com.wandrell.tabletop.stats.test.util.test.unit.AbstractTestEventDefaultValueBox;
import com.wandrell.tabletop.stats.valuebox.DefaultValueBox;

/**
 * Unit tests for {@link DefaultValueBox} implementing
 * {@code AbstractTestEventDefaultValueBox}.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestEventDefaultValueBox
        extends AbstractTestEventDefaultValueBox {

    /**
     * Constructs a {@code TestEventDefaultValueBox}.
     */
    public TestEventDefaultValueBox() {
        super(new DefaultValueBox(0));
    }

}
