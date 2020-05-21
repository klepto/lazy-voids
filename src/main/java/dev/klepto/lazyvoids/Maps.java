package dev.klepto.lazyvoids;

import com.google.common.collect.ImmutableMap;
import lombok.val;
import net.jodah.typetools.TypeResolver;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static dev.klepto.lazyvoids.Functions.self;

/**
 * Utilities for creating small immutable maps in a non-verbose manner. Not very performance efficient, might wanna
 * buy more CPU cores if you are serious about using this.
 *
 * @author <a href="https://klepto.dev/">Augustinas R.</a>
 * @since 0.1
 */
public final class Maps {

    /**
     * Creates an immutable map from given enumeration method reference, using the method reference as key and
     * enumeration entry itself as the value.
     *
     * @param keyFunction the key function of enumeration
     * @param <K>         the generic key type
     * @param <V>         the generic value type
     * @return an immutable map that maps given method reference result to enumeration entries
     */
    @SuppressWarnings("unchecked")
    public static <K, V extends Enum<V>> Map<K, V> enumEntryMap(Function<V, K> keyFunction) {
        val typeArgs = TypeResolver.resolveRawArguments(Function.class, keyFunction.getClass());
        val enumType = (Class<V>) typeArgs[0];
        return ImmutableMap.copyOf(Arrays.stream(enumType.getEnumConstants())
                .collect(Collectors.toMap(keyFunction, self())));
    }

    /**
     * Very unsafely populates an immutable map. Prone to {@see ClassCastException} and {@see ArrayOutOfBounds}
     * exceptions. Internal usage only.
     *
     * @param keysAndValues the array containing key and value pairs
     * @param <K>           the key type inference
     * @param <V>           the value type inference
     * @return a new immutable map containing all given key and value pairs
     */
    @SuppressWarnings("unchecked")
    private static <K, V> Map<K, V> unsafeMap(Object... keysAndValues) {
        val builder = ImmutableMap.builder();
        for (int i = 0; i < keysAndValues.length; i += 2) {
            builder.put(keysAndValues[i], keysAndValues[i + 1]);
        }
        return (Map<K, V>) builder.build();
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key, V value) {
        return unsafeMap(key, value);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2) {
        return unsafeMap(key1, value1, key2, value2);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3) {
        return unsafeMap(key1, value1, key2, value2, key3, value3);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9, K key10, V value10) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9, key10, value10);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9, K key10, V value10,
                                       K key11, V value11) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9, key10, value10, key11, value11);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9, K key10, V value10,
                                       K key11, V value11, K key12, V value12) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9, key10, value10, key11, value11, key12, value12);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9, K key10, V value10,
                                       K key11, V value11, K key12, V value12, K key13, V value13) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9, key10, value10, key11, value11, key12, value12, key13, value13);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9, K key10, V value10,
                                       K key11, V value11, K key12, V value12, K key13, V value13, K key14, V value14) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9, key10, value10, key11, value11, key12, value12, key13, value13, key14,
                value14);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9, K key10, V value10,
                                       K key11, V value11, K key12, V value12, K key13, V value13, K key14, V value14
            , K key15, V value15) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9, key10, value10, key11, value11, key12, value12, key13, value13, key14,
                value14, key15, value15);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9, K key10, V value10,
                                       K key11, V value11, K key12, V value12, K key13, V value13, K key14, V value14
            , K key15, V value15, K key16, V value16) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9, key10, value10, key11, value11, key12, value12, key13, value13, key14,
                value14, key15, value15, key16, value16);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9, K key10, V value10,
                                       K key11, V value11, K key12, V value12, K key13, V value13, K key14, V value14
            , K key15, V value15, K key16, V value16, K key17, V value17) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9, key10, value10, key11, value11, key12, value12, key13, value13, key14,
                value14, key15, value15, key16, value16, key17, value17);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9, K key10, V value10,
                                       K key11, V value11, K key12, V value12, K key13, V value13, K key14, V value14
            , K key15, V value15, K key16, V value16, K key17, V value17, K key18, V value18) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9, key10, value10, key11, value11, key12, value12, key13, value13, key14,
                value14, key15, value15, key16, value16, key17, value17, key18, value18);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9, K key10, V value10,
                                       K key11, V value11, K key12, V value12, K key13, V value13, K key14, V value14
            , K key15, V value15, K key16, V value16, K key17, V value17, K key18, V value18, K key19, V value19) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9, key10, value10, key11, value11, key12, value12, key13, value13, key14,
                value14, key15, value15, key16, value16, key17, value17, key18, value18, key19, value19);
    }

    /**
     * Creates an immutable map with given key-value pairs.
     *
     * @return a new immutable map containing all given key and value pairs
     */
    public static <K, V> Map<K, V> map(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4, K key5
            , V value5, K key6, V value6, K key7, V value7, K key8, V value8, K key9, V value9, K key10, V value10,
                                       K key11, V value11, K key12, V value12, K key13, V value13, K key14, V value14
            , K key15, V value15, K key16, V value16, K key17, V value17, K key18, V value18, K key19, V value19,
                                       K key20, V value20) {
        return unsafeMap(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5, key6, value6, key7,
                value7,
                key8, value8, key9, value9, key10, value10, key11, value11, key12, value12, key13, value13, key14,
                value14, key15, value15, key16, value16, key17, value17, key18, value18, key19, value19, key20,
                value20);
    }

}
