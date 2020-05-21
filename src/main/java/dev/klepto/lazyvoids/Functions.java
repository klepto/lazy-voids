package dev.klepto.lazyvoids;

import java.util.function.Function;

/**
 * Voids & bools for functional API.
 *
 * @author <a href="https://klepto.dev/">Augustinas R.</a>
 * @since 0.1
 */
public final class Functions {

    /**
     * Returns a function that always returns it's input. More descriptive alternative to {@link Function#identity()}.
     * Intended to be used as a static import to improve readability of functional chains.
     *
     * @param <T> the type of the input and output objects to the function
     * @return a function that always returns its input argument
     */
    public static <T> Function<T, T> self() {
        return t -> t;
    }

    /**
     * Alternative to {@link Runnable} with Throwable in the method signature. Intended for usage in functional API
     * where exception catching cannot be avoided.
     */
    @FunctionalInterface
    public interface ThrowableRunnable {

        /**
         * Actions implementation of this runnable.
         *
         * @throws Throwable any throwable thrown while executing this runnable
         */
        void run() throws Throwable;
    }

    /**
     * Alternative to {@link java.util.function.Supplier} with Throwable in the method signature. Intended for usage in
     * functional API where exception catching cannot be avoided.
     */
    @FunctionalInterface
    public interface ThrowableSupplier<T> {

        /**
         * Gets a result of this supplier.
         *
         * @return result of this supplier
         * @throws Throwable any throwable thrown while getting result of this supplier
         */
        T get() throws Throwable;
    }

}
