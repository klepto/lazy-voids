package dev.klepto.lazyvoids;

import one.util.streamex.StreamEx;

import java.util.*;
import java.util.stream.Stream;

/**
 * Delegate methods to {@link StreamEx} in-order to enable descriptive static imports. Imagine using vanilla stream API.
 *
 * @author <a href="https://klepto.dev/">Augustinas R.</a>
 * @since 0.1
 */
public final class Streams {

    /**
     * @see StreamEx#empty()
     */
    public static <T> StreamEx<T> stream() {
        return StreamEx.empty();
    }

    /**
     * @see StreamEx#of(Object)
     */
    public static <T> StreamEx<T> stream(T element) {
        return StreamEx.of(element);
    }

    /**
     * @see StreamEx#of(Object[])
     */
    public static <T> StreamEx<T> stream(T... elements) {
        return StreamEx.of(elements);
    }

    /**
     * @see StreamEx#of(Iterator)
     */
    public static <T> StreamEx<T> stream(Iterator<? extends T> iterator) {
        return StreamEx.of(iterator);
    }

    /**
     * @see StreamEx#of(Spliterator) 
     */
    public static <T> StreamEx<T> stream(Spliterator<? extends T> spliterator) {
        return StreamEx.of(spliterator);
    }

    /**
     * @see StreamEx#of(Spliterator) 
     */
    public static <T> StreamEx<T> stream(Iterable<T> iterable) {
        return stream(iterable.spliterator());
    }

    /**
     * @see StreamEx#of(Collection) 
     */
    public static <T> StreamEx<T> stream(Collection<T> collection) {
        return StreamEx.of(collection);
    }

    /**
     * @see StreamEx#of(Enumeration) 
     */
    public static <T> Stream<T> stream(Enumeration<? extends T> enumeration) {
        return StreamEx.of(enumeration);
    }

    /**
     * @see StreamEx#ofReversed(Object[]) 
     */
    public static <T> StreamEx<T> reverseStream(T... elements) {
        return StreamEx.ofReversed(elements);
    }

    /**
     * @see StreamEx#ofReversed(List) 
     */
    public static <T> StreamEx<T> reverseStream(List<T> list) {
        return StreamEx.ofReversed(list);
    }

    /**
     * @see StreamEx#ofKeys(Map) 
     */
    public static <T> StreamEx<T> keyStream(Map<T, ?> map) {
        return StreamEx.ofKeys(map);
    }

    /**
     * @see StreamEx#ofValues(Map)
     */
    public static <T> StreamEx<T> valueStream(Map<?, T> map) {
        return StreamEx.ofValues(map);
    }

}
