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