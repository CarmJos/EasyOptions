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
