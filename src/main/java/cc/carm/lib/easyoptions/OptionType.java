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

public class OptionType<V> {

    @SuppressWarnings("unchecked")
    public static <T> OptionType<T> of(@NotNull T defaultValue) {
        return of((Class<T>) defaultValue.getClass(), defaultValue);
    }

    public static <T> OptionType<T> of(@NotNull Class<T> valueClazz, @NotNull T defaultValue) {
        return new OptionType<>(valueClazz, defaultValue);
    }

    private final @NotNull Class<V> valueClazz;
    private @NotNull V defaultValue;

    public OptionType(@NotNull Class<V> valueClazz, @NotNull V defaultValue) {
        this.valueClazz = valueClazz;
        this.defaultValue = defaultValue;
    }

    @NotNull
    public Class<V> valueClass() {
        return this.valueClazz;
    }

    public @NotNull V defaults() {
        return defaultValue;
    }

    /**
     * Set the default value of option.
     *
     * @param defaultValue Default value
     */
    public void defaults(@NotNull V defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isDefault(@NotNull V value) {
        return value.equals(defaultValue);
    }

}