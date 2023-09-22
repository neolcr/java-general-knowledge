package com.neol.java.collections;

import java.util.*;

public class RunCollections {
    public static void main(String...args){
        //Iterate-Collection-(List,Queue,Set)
        //Map

        // List -(ArrayList, LinkedList, Vector -(Stack))
        List<Integer> arrayList = new ArrayList<>();
            // good at add/remove at the end and random access
            // bad at add/remove at the beginning/middle
        List<Integer> linkedList = new LinkedList<>(); // * see Deque
            // good at add/remove at any position
            // bad at random access
            // Can be either LIFO or FIFO
        List<Integer> vector = new Vector<>();
            // Like arraylist but thread safe (synchronized)
        Vector<Integer> stack = new Stack<>();
            // Lifo

        //Queue -(PriorityQueue), Deque (ArrayDeque)
        Queue<Integer> priorityQueue = new PriorityQueue<>(); // FIFO
            // Fast o(1) for retrieva using priority that can be customized
            // Slower o(log(n)) for adding/removing
        Deque<Integer> dequeLinkedList = new LinkedList<>(); // * see List
            // Can be either LIFO or FIFO
            // Slower than ArrayDeque
        Deque<Integer> arrayDeque = new ArrayDeque<>();
            //Default deque option, faster than LinkedList

        // Set
        Set<Integer> hashSet = new HashSet<>();
            //DEFAULT option: fast at adding, removing or finding element
            // NO traversal order, random scattered by hash function
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
            // IT HAS all the good things as HashSet but also TRAVERSAL ORDER as inserted
            // It is an extension of HashSet
        SortedSet<Integer> treeSet = new TreeSet<>();
            // It is slower than HastSet/LinkedHasSet in adding, removing or finding O(log(n))
            // Red-Black Tree structure: automatic sorting
            // It is used when needs to be sortedd and order needs to be preserved while adding/removing elements
            // EnumSet is the same but for using enums


        //--------------------------------------------------------------------------
        // Map
        Map<Integer, Integer> hashMap = new HashMap<>();
            //DEFAULT option: fast at adding, removing or finding element
            // NO traversal order, random scattered by hash function
            // Allows null values either keys or values
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
            // IT HAS all the good things as HashMap but also TRAVERSAL ORDER as inserted
            // It is an extension of HashMap
        Map<Integer, Integer> hashTable = new Hashtable<>();
            //Hashtable is like HashMap but synchronized, worse performance
            //Also does NOT ALLOW null key or values -> NullPointerException
        SortedMap<Integer, Integer> treeMap = new TreeMap<>();
            // It is slower than HashMap/LinkedHashMap in adding, removing or finding O(log(n))
            // Red-Black Tree structure: automatic sorting
            // It is used when needs to be sorted and order needs to be preserved while adding/removing elements
            // EnumMap is the same but for using enums

        //testStack((Stack<Integer>)stack);
        //testPriorityQueue((PriorityQueue<Integer>) priorityQueue);
        //testArrayDeque((ArrayDeque<Integer>) arrayDeque);
//        testTreeSet((TreeSet<Integer>) treeSet);
        //testTreeMap((TreeMap<Integer, Integer>) treeMap);
        treeHashSet((HashSet<Integer>) hashSet);


    }

    private static void treeHashSet(HashSet<Integer> hashSet) {
        for(int i = 0 ; i < 100; i++){
            hashSet.add(null);
        }

        for (Integer integer : hashSet) {
            System.out.println(integer);
        }


    }

    private static void testTreeMap(TreeMap<Integer, Integer> treeMap) {
        treeMap.put(54,100);
        treeMap.put(110,19);
        treeMap.put(-3, 9);
        treeMap.put(330,12);
        treeMap.put(0,1);
        treeMap.put(10,10);
        treeMap.put(-93, 1);

        System.out.println(treeMap);
    }

    // Very good at automatically sorting
    private static void testTreeSet(TreeSet<Integer> treeSet) {
        treeSet.add(4);
        treeSet.add(1);
        treeSet.add(47);
        treeSet.add(34);
        treeSet.add(48);
        treeSet.add(24);
        treeSet.add(-4);
        System.out.println(treeSet);
        System.out.println(treeSet.remove(1));
        System.out.println(treeSet);
    }

    // Faster than LinKedList, can work as LIFO or FIFO
    private static void testArrayDeque(ArrayDeque<Integer> arrayDeque) {
        //Lifo
        arrayDeque.push(0);
        arrayDeque.push(1);
        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque.pop());


        //Fifo
        arrayDeque.offer(0);
        arrayDeque.offer(1);
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque.poll());

        // can use addFirst/Last / offerFirst/Last removeFirst/Last

    }

    // QUEUE IS FIFO (Fist In Fist Out)
    // offer is safe add, false instead of exception if bounded queue
    // poll is safe remove, null instead of exception if empty queue
    // peek is like poll but does not even remove the item, just retrieves it
    private static void testPriorityQueue(PriorityQueue<Integer> priorityQueue) {
        priorityQueue.add(0);
        priorityQueue.add(1);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.peek());

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.offer(1);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());


    }

    // STACK IS LIFO (Last In First Out)
    private static void testStack(Stack<Integer> stack) {
        stack.add(0); // not idiomatic
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}
