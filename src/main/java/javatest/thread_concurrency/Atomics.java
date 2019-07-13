package javatest.thread_concurrency;

import java.util.concurrent.atomic.AtomicReference;

/**
 * The java.util.concurrent.atomic package contains a set of classes that support atomic compound actions on a single value in a lock-free
 * manner similar to volatile.<br/>
 * Using AtomicXXX classes, it is possible to implement an atomic check-then-act operation:
 * 
 * @author darekar
 */
class CheckThenAct {

    private final AtomicReference<String> value =
        new AtomicReference<>();

    void initialize() {
        if (value.compareAndSet(null, "value")) {
            System.out.println("Initialized only once.");
        }
    }
}
