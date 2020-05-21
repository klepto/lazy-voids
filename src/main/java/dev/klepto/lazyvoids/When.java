package dev.klepto.lazyvoids;


import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * A key-value pair container object which may or may not contain a non-null value. When enables simplified key-value
 * mapping while preserving some of the compile-time type safety provided by more verbose patterns such as using
 * {@link java.util.Map}.
 *
 * <p>If a value is non-null, {@code isPresent()} will return {@code true} and {@code get()} will return the value.
 * <p>If a value is null, {@code isEmpty()} will return {@code true} and {@code orElse()} will return the given
 * default value.
 * <p>Additional methods are included to somewhat resemble functionality of {@link java.util.Optional}.
 *
 * @author <a href="https://klepto.dev/">Augustinas R.</a>
 * @since 0.1
 */
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class When<K, V> {

    private final K key;
    private final V result;

    /**
     * Creates a new when mapper for a given key with an empty result.
     *
     * @param key the key object
     * @param <K> the key type for compile-time type safety
     * @param <V> the value type for compile-time type safety, ({@link Object} until the first call of
     *            {@link When#map(Object, Object)}.
     * @return a new when mapper for a given key
     */
    public static <K, V> When<K, V> when(K key) {
        return new When<>(key, null);
    }

    /**
     * Creates a new mapping for key-value pair, if given key equals to key of this container, a new when container
     * will be created with given value as the result. Otherwise {@code this} is returned. Using polymorphic value
     * types should be avoided, due to how compile time type-inference works, each subsequent call of this method may
     * alter the result type when using polymorphic values. If you absolutely need to use polymorphic values you have to
     * make sure your last call of this method is done with the super type.
     *
     * @param key   the mapping key
     * @param value the mapping value
     * @param <T>   generic type to infer value type for future calls of this method
     * @return this or new when object if key matched the key of this container
     */
    @SuppressWarnings("unchecked")
    public <T extends V> When<K, T> map(K key, T value) {
        if (this.key.equals(key)) {
            return new When<>(key, value);
        }

        return (When<K, T>) this;
    }

    /**
     * Returns true if result value is present, otherwise false.
     *
     * @return true if result has a non-null value, otherwise false
     */
    public boolean isPresent() {
        return result != null;
    }

    /**
     * Returns true if result value is not present, otherwise false.
     *
     * @return true if result has a null value, otherwise false
     */
    public boolean isEmpty() {
        return !isPresent();
    }

    /**
     * Returns the result value (if key didn't match any mappings, value will be {@code null}).
     *
     * @return the result value
     */
    public V get() {
        return result;
    }

    /**
     * If a value is present, performs the given action with the value, otherwise does nothing.
     *
     * @param action the action to be performed, if a value is present
     */
    public void ifPresent(Consumer<? super V> action) {
        if (isPresent()) {
            action.accept(result);
        }
    }

    /**
     * If a value is present, returns the value, otherwise returns other.
     *
     * @param other the value to be returned, if no value is present (may be {@code null})
     * @return the value, if present, otherwise other
     */
    public V orElse(V other) {
        return isPresent() ? result : other;
    }

    /**
     * If a value is present, returns the value, otherwise returns the result produced by the supplying function.
     *
     * @param supplier the supplying function that produces a value to be returned
     * @return the value, if present, otherwise the result produced by the supplying function
     */
    public V orElseGet(Supplier<? extends V> supplier) {
        // we don't call orElse because we want supplier to be evaluated lazily
        return isPresent() ? result : supplier.get();
    }

    /**
     * If a value is present, returns the value, otherwise throws an throwable produced by the throwable supplying function.
     * @param throwableSupplier the supplying function that produces an throwable to be thrown
     * @param <X> type of the exception to be thrown
     * @return the value, if present
     * @throws X if no value is present
     */
    public <X extends Throwable> V orElseThrow(Supplier<? extends X> throwableSupplier) throws X {
        if (isEmpty()) {
            throw throwableSupplier.get();
        }
        return result;
    }

}
