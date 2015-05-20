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
 * Controllers for handling a
 * {@link com.wandrell.tabletop.stats.valuebox.ValueBox ValueBox} on UIs.
 * <p>
 * These classes allow direct modification of a {@code ValueBox}, and are meant
 * to be part of the controller layer of a desktop application, where the UI is
 * closely linked to the model.
 * <p>
 * The only class currently contained in the package, the
 * {@link com.wandrell.tabletop.stats.controller.ValueController ValueController}
 * , allows increasing and decreasing a {@code ValueBox} with the use of
 * buttons, and a series of constraints such as the interval in which the value
 * can move.
 */
package com.wandrell.tabletop.stats.controller;

