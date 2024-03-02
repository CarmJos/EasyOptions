/*
 * This file is part of EasyOptions, licensed under the MIT License.
 *
 * Copyright (c) 2024 Carm
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package cc.carm.lib.easyoptions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public interface OptionHolder {

    static OptionHolder createOptionHolder() {
        return createOptionHolder(new ConcurrentHashMap<>());
    }

    static OptionHolder createOptionHolder(@NotNull Map<OptionType<?>, Object> options) {
        return () -> options;
    }

    @NotNull Map<OptionType<?>, Object> options();

    /**
     * Get the value of option.
     *
     * @param type {@link OptionType}
     * @param <V>  Value type
     * @return Value of option
     */
    @SuppressWarnings("unchecked")
    default <V> @NotNull V get(@NotNull OptionType<V> type) {
        return Optional.ofNullable(options().get(type)).map(v -> (V) v).orElseGet(type::defaults);
    }

    /**
     * Set the value of option.
     *
     * @param type  {@link OptionType}
     * @param value Value of option
     * @param <V>   Value type
     * @return Previous value of option
     */
    @SuppressWarnings("unchecked")
    default <V> @Nullable V set(@NotNull OptionType<V> type, @Nullable V value) {
        if (value == null) {
            return (V) options().remove(type);
        } else {
            return (V) options().put(type, value);
        }
    }

    /**
     * Set the value of option to option's {@link OptionType#defaults()}.
     *
     * @param type {@link OptionType}
     * @param <V>  Value type
     * @return Previous value of option
     */
    default <V> @Nullable V clear(@NotNull OptionType<V> type) {
        return set(type, null);
    }

}
