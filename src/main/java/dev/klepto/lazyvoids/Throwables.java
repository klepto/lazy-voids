package dev.klepto.lazyvoids;

import dev.klepto.lazyvoids.Functions.ThrowableSupplier;
import dev.klepto.lazyvoids.Functions.ThrowableRunnable;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

/**
 * Throwable utilities that will make any self-respecting developer angry.
 *
 * @author <a href="https://klepto.dev/">Augustinas R.</a>
 * @since 0.1
 */
public class Throwables {

    /**
     * Runs given a runnable and converts any thrown throwables to runtime exception in-oder to avoid explicit
     * try-catch block.
     *
     * @param runnable the runnable
     * @throws RuntimeThrowable if any exception was thrown during runnable execution
     */
    public static void runtimeThrows(ThrowableRunnable runnable) {
        runtimeThrows(() -> {
            runnable.run();
            return null;
        });
    }

    /**
     * Gets a value from given a supplier and converts any thrown throwables to runtime exception in-oder to avoid
     * explicit try-catch block.
     *
     * @param supplier the supplier
     * @return result of the supplier
     * @throws RuntimeThrowable if any exception was thrown while getting result of the supplier
     */
    public static <T> T runtimeThrows(ThrowableSupplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Throwable throwable) {
            throw new RuntimeThrowable(throwable);
        }
    }

    /**
     * Delegate container that converts any throwable into a runtime exception to avoid explicit exception
     * catching. Delegates majority of the methods to the underlying throwable in-order to mimic it's behavior and
     * return a clean stack trace that doesn't include this container.
     */
    @RequiredArgsConstructor
    private static class RuntimeThrowable extends RuntimeException {

        @Delegate(excludes = Excludes.class)
        private final Throwable throwable;

        private static interface Excludes {
            void addSuppressed(Throwable t);
            Throwable[] getSuppressed();
        }

    }

}
