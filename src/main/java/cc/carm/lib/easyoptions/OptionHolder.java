
package cc.carm.lib.easyoptions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


/**
 * A data holder for options.
 *
 * @author CarmJos
 * @version 1.0.0
 */
public class OptionHolder {

    protected final Map<OptionType<?>, Object> options;

    public OptionHolder() {
        this(new ConcurrentHashMap<>());
    }

    public OptionHolder(Map<OptionType<?>, Object> options) {
        this.options = options;
    }

    /**
     * Get the value of option.
     *
     * @param type {@link OptionType}
     * @param <V>  Value type
     * @return Value of option
     */
    @SuppressWarnings("unchecked")
    public <V> @NotNull V get(@NotNull OptionType<V> type) {
        return Optional.ofNullable(options.get(type)).map(v -> (V) v).orElseGet(type::defaults);
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
    public <V> @Nullable V set(@NotNull OptionType<V> type, @Nullable V value) {
        if (value == null) {
            return (V) options.remove(type);
        } else {
            return (V) options.put(type, value);
        }
    }

}
