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
 * Provides an API for value related events.
 * <p>
 * The package is composed in first place of the
 * {@link com.wandrell.tabletop.stat.event.ValueChangeEvent ValueChangeEvent},
 * which stores the status of a value before and after the related event has
 * happened.
 * <p>
 * But also offers a basic listener,
 * {@link com.wandrell.tabletop.stat.event.ValueChangeListener
 * ValueChangeListener}, to keep watch on those events.
 * <p>
 * These are meant to be used on those cases where there exists a dependency to
 * a value, and such a good example of how they meant to be applied are the
 * implementations of {@link com.wandrell.tabletop.stat.valuebox.ValueBox
 * ValueBox}, mainly the
 * {@link com.wandrell.tabletop.stat.valuebox.AbstractValueBoxEventFirer AbstractValueBox}.
 */
package com.wandrell.tabletop.stat.event;

