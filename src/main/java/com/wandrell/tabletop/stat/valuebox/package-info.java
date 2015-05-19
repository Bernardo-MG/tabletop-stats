/**
 * Copyright 2013-2014 the original author or authors
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
/**
 * Provides an API for storing and watching values, and information related to
 * such values.
 * <p>
 * These values are exemplified by attributes on character sheets (and the
 * "value boxes" they usually are noted in), which can have dependencies between
 * them and to derived attributes.
 * <p>
 * Such dependencies can be handled thanks to the event-based containers on this
 * package.
 * <p>
 * {@link ValueBox} is the basic interface from which the other classes come. It
 * can store an {@code Integer}, sending events each time it is changed.
 * <p>
 * A more advanced version, {@link SkillBox} also allows giving a name,
 * and a descriptor, to the value. So a value can be clearly identified.
 * <p>
 * Additionally, an abstract implementation of {@code ValueBox}, called
 * {@link AbstractValueBoxEventFirer}, contains support for the value events, so
 * new implementation of the interface can be created with ease.
 */
package com.wandrell.tabletop.stat.valuebox;

