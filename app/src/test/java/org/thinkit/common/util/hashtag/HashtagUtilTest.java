/*
 * Copyright 2021 Kato Shinya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.thinkit.common.util.hashtag;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * The class that manages test case of {@link HashtagUtil} .
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
public final class HashtagUtilTest {

    @Nested
    class TestCreateHashtag {

        @ParameterizedTest
        @ValueSource(strings = { "test", "t", " test", "test ", " test " })
        void testWhenTagIsPassed(final String parameter) {

            final String actual = assertDoesNotThrow(() -> HashtagUtil.createHashtag(parameter));

            assertNotNull(actual);
            assertEquals("#" + StringUtils.trim(parameter.trim()), actual);
        }

        @ParameterizedTest
        @ValueSource(strings = { " ", "" })
        void testWhenTagIsEmpty(final String parameter) {

            final String actual = assertDoesNotThrow(() -> HashtagUtil.createHashtag(parameter));

            assertNotNull(actual);
            assertEquals("", actual);
        }

        @Test
        void testWhenTagIsNull() {

            final String actual = assertDoesNotThrow(() -> HashtagUtil.createHashtag(null));

            assertNotNull(actual);
            assertEquals("", actual);
        }

        @Nested
        class TestCreateHashtags {

            @Test
            void testWhenTagsArePassed() {

                final List<String> parameters = new ArrayList<>();
                parameters.add("test");
                parameters.add("t");
                parameters.add(" test");
                parameters.add("test ");
                parameters.add(" test ");

                final List<String> actuals = assertDoesNotThrow(() -> HashtagUtil.createHashtags(parameters));

                assertNotNull(actuals);
                assertTrue(parameters.size() == actuals.size());

                for (int i = 0, size = actuals.size(); i < size; i++) {
                    final String actual = actuals.get(i);

                    assertNotNull(actual);
                    assertEquals("#" + StringUtils.trim(parameters.get(i)), actual);
                }
            }

            @Test
            void testWhenTagsAreEmpty() {

                final List<String> parameters = new ArrayList<>();
                parameters.add(" ");
                parameters.add("");

                final List<String> actuals = assertDoesNotThrow(() -> HashtagUtil.createHashtags(parameters));

                assertNotNull(actuals);
                assertTrue(parameters.size() == actuals.size());

                for (int i = 0, size = actuals.size(); i < size; i++) {
                    final String actual = actuals.get(i);

                    assertNotNull(actual);
                    assertEquals("", actual);
                }
            }

            @Test
            void testWhenTagIsNull() {

                final List<String> parameters = new ArrayList<>();
                parameters.add(null);

                final List<String> actuals = assertDoesNotThrow(() -> HashtagUtil.createHashtags(parameters));

                assertNotNull(actuals);
                assertTrue(parameters.size() == actuals.size());

                for (int i = 0, size = actuals.size(); i < size; i++) {
                    final String actual = actuals.get(i);

                    assertNotNull(actual);
                    assertEquals("", actual);
                }
            }
        }
    }
}
