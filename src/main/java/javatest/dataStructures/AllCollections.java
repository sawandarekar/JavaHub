package javatest.dataStructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TransferQueue;

public class AllCollections {
    public static void main(String... args) {
        Collection<?>[] col = {};
        Set<?>[] sets = {
            new CopyOnWriteArraySet<>(), // thread safe
            new HashSet<>(),
            new LinkedHashSet<>()
        };
        SortedSet<?>[] sortedSets = {};
        NavigableSet<?>[] navigableSets = {
            new TreeSet<>(),
            new ConcurrentSkipListSet<>() // thread safe
        };
        List<?>[] lists = {
            new Vector<>(),
            new ArrayList<>(),
            new LinkedList<>(),
            new CopyOnWriteArrayList<>(),// thread safe
        };

        Queue<?>[] queues = {
            new ConcurrentLinkedQueue<>(), // thread safe
            new PriorityQueue<>()
        };
        BlockingQueue<?>[] blockingQueues = {
            new ArrayBlockingQueue<>(10), // thread safe
            new LinkedBlockingQueue<>(), // thread safe
            new DelayQueue<>(), // thread safe
            new PriorityBlockingQueue<>(), // thread safe
            new SynchronousQueue<>(), // thread safe
        };
        TransferQueue<?>[] transferQueues = {
            new LinkedTransferQueue<>() // thread safe
        };
        Deque<?>[] deques = {
            new ConcurrentLinkedDeque<>(), // thread safe
            new ArrayDeque<>(),
            new LinkedList<>()
        };
        BlockingDeque<?>[] blockingDeques = {
            new LinkedBlockingDeque<>() // thread safe
        };

        Map<?, ?>[] maps = {
            new HashMap<>(),
            new Hashtable<>(),// thread safe
            new IdentityHashMap<>(),
            new WeakHashMap<>(),
            new LinkedHashMap<>(),
        };
        SortedMap<?, ?>[] sortedMaps = {};
        NavigableMap<?, ?>[] navigableMaps = {
            new TreeMap<>(),
            new ConcurrentSkipListMap<>()// thread safe
        };
        ConcurrentMap<?, ?>[] concurrentMaps = {
            new ConcurrentHashMap<>(),// thread safe
            new ConcurrentSkipListMap<>()// thread safe
        };

    }
}
