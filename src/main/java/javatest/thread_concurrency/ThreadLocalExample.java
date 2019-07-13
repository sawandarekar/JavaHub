package javatest.thread_concurrency;

import java.util.UUID;

/**
 * One way to contain data within a thread and make locking unnecessary is to use ThreadLocal storage. Conceptually, ThreadLocal acts as if
 * there is a variable with its own version in every Thread. ThreadLocals are commonly used for stashing per-Thread values like the "current
 * transaction" or other resources. Also, they are used to maintain per-thread counters, statistics, or ID generators.
 * 
 * @author darekar
 */
public class ThreadLocalExample {

}

class TransactionExecutor extends Thread {

    @Override
    public void run() {

    }
}

class TransactionManager {

    private final ThreadLocal<Transaction> currentTransaction = ThreadLocal.withInitial(TransactionImpl::new);

    Transaction currentTransaction() {
        Transaction current = currentTransaction.get();
        if (current == null) {
            current = new TransactionImpl();
            currentTransaction.set(current);
        }
        return current;
    }
}

interface Transaction {

    UUID getTranscationID();
}

class TransactionImpl implements Transaction {

    UUID tranId = UUID.randomUUID();

    @Override
    public UUID getTranscationID() {
        return tranId;
    }
}
