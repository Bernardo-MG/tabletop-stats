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
 * Provides an API and default implementations for handling statistics and
 * attributes on tabletop games.
 * <p>
 * These are the kind of value which is annotated on a paper, to indicate for
 * example a character's strength.
 * <p>
 * There are many cases where these values appear, such as for example when
 * handling skills, for which the {@link com.wandrell.tabletop.stats.Skill
 * Skill} interface is useful, or when modifying them through an UI, where the
 * {@link com.wandrell.tabletop.stats.controller.ValueController
 * ValueController} is very helpful.
 * <p>
 * But the classes in these packages are mostly meant to be used on the most
 * complex cases, when there is an interdependency between said values.
 * <p>
 * For example, if the hitpoints derive from the strength and constitution of a
 * character, then it should be stored in a container which updates the
 * hitpoints value when one of those two attributes changes.
 * <p>
 * This is done with the classes in the
 * {@link com.wandrell.tabletop.stats.valuebox valuebox} package, with a bit of
 * help from the more generic {@link com.wandrell.tabletop.stats.event event}
 * package.
 */

package com.wandrell.tabletop.stats;
