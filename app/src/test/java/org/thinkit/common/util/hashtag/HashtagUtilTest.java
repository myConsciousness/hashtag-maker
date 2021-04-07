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

import org.junit.jupiter.api.Nested;
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
        @ValueSource(strings = { "test", "t" })
        void testWhenTagIsPassed(final String parameter) {

            final String actual = assertDoesNotThrow(() -> HashtagUtil.createHashtag(parameter));

            assertNotNull(actual);
            assertEquals("#" + parameter, actual);
        }
    }
}
