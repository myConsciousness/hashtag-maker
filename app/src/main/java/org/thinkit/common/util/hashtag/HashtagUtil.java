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

import java.util.List;
import java.util.stream.Collectors;

import org.thinkit.common.util.hashtag.catalog.TagSymbol;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * This utility class provides functionality for hashtag.
 *
 * <p>
 * For example, this is useful when you want to easily convert a string that is
 * not in hashtag format to hashtag format. It is also possible to convert tag
 * strings stored in list format to hashtag format.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HashtagUtil {

    /**
     * Returns the tag string passed as an argument in the form of a hashtag.
     *
     * @param tag The tag
     * @return The hash tag based on {@code tag}
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static String createHashTag(@NonNull final String tag) {
        return TagSymbol.HASH.getCode() + tag;
    }

    /**
     * Returns the list of tag strings passed as an argument as a list of hashtag
     * strings.
     *
     * @param tags The tags
     * @return The hash tags based on {@code tags}
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static List<String> createHashTags(@NonNull final List<String> tags) {
        return tags.stream().map(HashtagUtil::createHashTag).collect(Collectors.toList());
    }
}
