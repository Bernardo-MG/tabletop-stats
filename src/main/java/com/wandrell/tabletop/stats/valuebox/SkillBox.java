/**
 * Copyright 2014 the original author or authors
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
package com.wandrell.tabletop.stats.valuebox;

import com.wandrell.tabletop.stats.Skill;

/**
 * Extension of {@link ValueBox} for skills.
 * <p>
 * Additionally to what the base interface offers, this one allows indicating a
 * name and a descriptor with the methods inherited from {@link Skill}. Of
 * course, this can also be used for named values, in which case the descriptor
 * can be hidden on the actual implementation, by inheriting this class through
 * composition.
 * <p>
 * Note that most of the times a simple {@code ValueBox} will be enough for any
 * model. If there is only a set number of values use the basic {@code ValueBox}
 * , if the number of values can change, use this interface.
 * <p>
 * Another way to see this is that if the values have to be stored in a
 * collection, then they may be represented by this interface. If you can set a
 * getter for each value on a class, then the basic {@code ValueBox} is enough.
 * <p>
 * Note that for those cases where the value just needs a name this interface
 * may also be used. Just ignore the descriptor.
 * 
 * @author Bernardo Martínez Garrido
 */
public interface SkillBox extends ValueBox, Skill {

}
