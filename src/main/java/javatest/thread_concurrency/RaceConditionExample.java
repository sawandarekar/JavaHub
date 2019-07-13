package javatest.thread_concurrency;

/**
 * A race condition occurs when more than one thread is performing a series of actions on shared resources, and several possible outcomes
 * can exist based on the order of the actions from each thread.
 * 
 * @author darekar
 */
public class RaceConditionExample<T> {

    private volatile T value;

    T get() {
        if (value == null) {
            value = initialize();
        }
        return value;
    }

    private T initialize() {
        return null;
    }
}
