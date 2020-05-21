package dev.klepto.lazyvoids;

import lombok.val;

import java.util.Collection;
import java.util.List;

/**
 * Utilities for generating a pseudo-random number. Implementation is backed up by {@link Math#random()} which delegates
 * to global pseudo-random number generator of the current JVM. As majority of other utilities in this library, this
 * should never be used in real-world applications (unless you are a god c0dar).
 *
 * @see Math#random()
 * @see java.util.Random
 * @see java.security.SecureRandom
 * @author <a href="https://klepto.dev/">Augustinas R.</a>
 * @since 0.1
 */
public final class Random {

    /**
     * Returns a {@code double} value with a positive sign, greater than or equal to {@code 0.0} and less than {@code
     * 1.0}. Returned values are chosen pseudo-randomly with (approximately) uniform distribution from that range.
     *
     * @return a pseudorandom {@code double} greater than or equal to {@code 0.0} and less than {@code 1.0}.
     * @see Math#random()
     */
    public static double random() {
        return Math.random();
    }

    /**
     * Returns a {@code double} value with a positive sign, greater
     * than or equal to {@code 0.0} and less than given bound.
     *
     * @param bound the upper bound for pseudorandom double (exclusive)
     * @return a pseudorandom {@code double} greater than or equal to {@code 0.0} and less than given bound
     */
    public static double random(double bound) {
        return random() * bound;
    }

    /**
     * Returns a {@code long} value with a positive sign, greater
     * than or equal to {@code 0.0} and less than given bound.
     *
     * @param bound the upper bound for pseudorandom long (exclusive)
     * @return a pseudorandom {@code long} greater than or equal to {@code 0.0} and less than given bound
     */
    public static long random(long bound) {
        return (long) (random() * bound);
    }

    /**
     * Returns a {@code long} value with a positive sign, greater
     * than or equal to {@code 0.0} and less than given bound.
     *
     * @param lowerBound the lower bound for pseudorandom long (inclusive)
     * @param upperBound the upper bound for pseudorandom long (exclusive)
     * @return a pseudorandom {@code long} greater than or equal to {@code 0.0} and less than given bound
     */
    public static long random(long lowerBound, long upperBound) {
        return lowerBound + random(upperBound - lowerBound);
    }

    /**
     * Returns a {@code long} value with a positive sign, greater
     * than or equal to {@code 0.0} and less or equal to given bound.
     *
     * @param lowerBound the lower bound for pseudorandom long (inclusive)
     * @param upperBound the upper bound for pseudorandom long (inclusive)
     * @return a pseudorandom {@code long} greater than or equal to {@code 0.0} and less or equal to given bound
     */
    public static long randomInclusive(long lowerBound, long upperBound) {
        return random(lowerBound, upperBound + 1);
    }

    /**
     * Returns an {@code int} value with a positive sign, greater
     * than or equal to {@code 0.0} and less than given bound.
     *
     * @param bound the upper bound for pseudorandom int (exclusive)
     * @return a pseudorandom {@code int} greater than or equal to {@code 0.0} and less than given bound
     */
    public static int random(int bound) {
        return (int) random((long) bound);
    }

    /**
     * Returns an {@code int} value with a positive sign, greater
     * than or equal to {@code 0.0} and less or equal to given bound.
     *
     * @param lowerBound the lower bound for pseudorandom int (inclusive)
     * @param upperBound the upper bound for pseudorandom int (exclusive)
     * @return a pseudorandom {@code int} greater than or equal to {@code 0.0} and less or equal to given bound
     */
    public static int random(int lowerBound, int upperBound) {
        return (int) random((long) lowerBound, upperBound);
    }

    /**
     * Returns a {@code int} value with a positive sign, greater
     * than or equal to {@code 0.0} and less or equal to given bound.
     *
     * @param lowerBound the lower bound for pseudorandom int (inclusive)
     * @param upperBound the upper bound for pseudorandom int (inclusive)
     * @return a pseudorandom {@code int} greater than or equal to {@code 0.0} and less or equal to given bound
     */
    public static int randomInclusive(int lowerBound, int upperBound) {
        return random(lowerBound, upperBound + 1);
    }

    /**
     * Generates a pseudo-random number using {@code chance} as the upper bound and returns true if the number is equal
     * to {@code 0}.
     *
     * @param chance the upper bound for the roll (exclusive)
     * @return true if rolled number is equal to {@code 0}, otherwise false
     */
    public static boolean roll(long chance) {
        return random(chance) == 0;
    }

    /**
     * Returns a random element in a given collection using a generated pseudo-random number.
     *
     * @param collection the collection
     * @return a random element within the collection
     * @throws IndexOutOfBoundsException if collection is empty
     */
    public static <T> T randomElement(Collection<T> collection) {
        val skip = random(collection.size());
        return collection.stream()
                .skip(skip)
                .findFirst()
                .orElseThrow(IndexOutOfBoundsException::new);
    }

    /**
     * Returns a random element in a given list using a generated pseudo-random number.
     *
     * @param list the list
     * @return a random element within the list
     * @throws IndexOutOfBoundsException if list is empty
     */
    public static <T> T randomElement(List<T> list) {
        return list.get(random(list.size()));
    }

    /**
     * Returns a random element in a given array using a generated pseudo-random number.
     *
     * @param array the array
     * @return a random element within the array
     * @throws ArrayIndexOutOfBoundsException if array is empty
     */
    public static <T> T randomElement(T... array) {
        return array[random(array.length)];
    }

}
