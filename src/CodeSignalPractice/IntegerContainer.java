package CodeSignalPractice;

/**
 * `IntegerContainer` interface.
 */
public interface IntegerContainer {

    /**
     * Should add the specified integer `value` to the container
     * and return the number of integers in the container after the
     * addition.
     */
    default int add(int value) {
        // default implementation
        return 0;
    }

    /**
     * Should attempt to remove the specified integer `value` from
     * the container.
     * If the `value` is present in the container, remove it and
     * return `true`, otherwise, return `false`.
     */
    default boolean delete(int value) {
        // default implementation
        return false;
    }
}
