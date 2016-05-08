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

import com.wandrell.tabletop.stats.test.util.test.unit.valuebox.AbstractTestEventValueBox;
import com.wandrell.tabletop.stats.valuebox.DefaultSkillBox;
import com.wandrell.tabletop.stats.valuebox.ValueBox;

/**
 * Unit tests for {@link DefaultSkillBox}, checking that events are handled
 * correctly.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestEventDefaultSkillBox extends AbstractTestEventValueBox {

    /**
     * Default constructor.
     */
    public TestEventDefaultSkillBox() {
        super();
    }

    @Override
    protected ValueBox getValueBox() {
        return new DefaultSkillBox("skill", 0);
    }

}
