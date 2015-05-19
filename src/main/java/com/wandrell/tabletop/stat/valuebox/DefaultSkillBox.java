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
package com.wandrell.tabletop.stat.valuebox;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Default implementation of the {@link SkillBox} interface.
 * <p>
 * It inherits, by composition, from {@link DefaultValueBox}, just adding a name
 * and a descriptor fields.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DefaultSkillBox extends AbstractValueBox implements SkillBox {

    /**
     * The skill's descriptor.
     */
    private final String skillDescriptor;
    /**
     * The skill's name.
     */
    private final String skillName;

    /**
     * Copy constructor for {@code DefaultSkillBox}.
     * 
     * @param box
     *            the {@code DefaultSkillBox} to copy
     */
    public DefaultSkillBox(final DefaultSkillBox box) {
        super(box);

        skillName = box.skillName;
        skillDescriptor = box.skillDescriptor;
    }

    /**
     * Constructs a {@code DefaultSkillBox} with the specified name.
     * 
     * @param name
     *            the skill's name
     */
    public DefaultSkillBox(final String name) {
        this(name, "", 0);
    }

    /**
     * Constructs a {@code DefaultSkillBox} with the specified name and value.
     * 
     * @param name
     *            the skill's name
     * @param value
     *            the stored value
     */
    public DefaultSkillBox(final String name, final Integer value) {
        this(name, "", value);
    }

    /**
     * Constructs a {@code DefaultSkillBox} with the specified name and
     * descriptor.
     * 
     * @param name
     *            the skill's name
     * @param descriptor
     *            the skill's descriptor
     */
    public DefaultSkillBox(final String name, final String descriptor) {
        this(name, descriptor, 0);
    }

    /**
     * Constructs a {@code DefaultSkillBox} with the specified name, descriptor
     * and value.
     * 
     * @param name
     *            the skill's name
     * @param descriptor
     *            the skill's descriptor
     * @param value
     *            the stored value
     */
    public DefaultSkillBox(final String name, final String descriptor,
            final Integer value) {
        super(value);

        checkNotNull(name, "Received a null pointer as name");
        checkNotNull(descriptor, "Received a null pointer as descriptor");

        skillName = name;
        skillDescriptor = descriptor;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DefaultSkillBox other = (DefaultSkillBox) obj;
        return Objects.equal(skillName, other.skillName)
                && Objects.equal(skillDescriptor, other.skillDescriptor);
    }

    @Override
    public final String getDescriptor() {
        return skillDescriptor;
    }

    @Override
    public final String getName() {
        return skillName;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(skillName, skillDescriptor);
    }

    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this).add("name", skillName)
                .add("descriptor", skillDescriptor).add("value", getValue())
                .toString();
    }

}
