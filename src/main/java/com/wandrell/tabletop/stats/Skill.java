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

package com.wandrell.tabletop.stats;

/**
 * Interface for representing a stat with a name and descriptor. These usually
 * are related to RPG skills, which are identified by a unique combination of a
 * name and a descriptor.
 * <p>
 * The name indicates the general domain of the skill, while the descriptor
 * refers to a concrete variant.
 * <p>
 * For example languages in RPGs are usually represented in way similar to
 * "Language (English)", or "Language (Latin)", where "English" and "Latin" are
 * the descriptors and "Language" the name.
 * <p>
 * Another important characteristic of these stats, which is implied by the
 * previous fact, is that the number of them is variable and unpredictable.
 * <p>
 * Going back to the same example, while attributes are usually a set number,
 * there is always the possibility of adding new skills to any model.
 * <p>
 * For those cases where a value should be handled along the identifiers, the
 * {@link com.wandrell.tabletop.stats.valuebox.SkillBox SkillBox} interface
 * should be used.
 * 
 * @author Bernardo Martínez Garrido
 */
public interface Skill {

    /**
     * Returns the skill's descriptor.
     * 
     * If the skill has no descriptor assigned, then it is empty.
     * 
     * @return the skill's descriptor
     */
    public String getDescriptor();

    /**
     * Returns a token representing the name.
     * <p>
     * This can then be localized into the correct name.
     * 
     * @return a token representing the stat's name
     */
    public String getName();

}
