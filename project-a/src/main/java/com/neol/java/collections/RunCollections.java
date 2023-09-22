package com.neol.java.collections;

import java.util.*;

public class RunCollections {
    public static void main(String...args){
        //Iterate-Collection-(List,Queue,Set)
        //Map

        // List -(ArrayList, LinkedList, Vector -(Stack))
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>(); // * see Deque
        List<Integer> vector = new Vector<>();
        Vector<Integer> stack = new Stack<>();

        //Queue -(PriorityQueue), Deque (ArrayDeque)
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Deque<Integer> dequeLinkedList = new LinkedList<>(); // * see List
        Deque<Integer> arrayDeque = new ArrayDeque<>();

        // Set
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        SortedSet<Integer> treeSet = new TreeSet<>();

        //--------------------------------------------------------------------------
        // Map
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHaspMap = new LinkedHashMap<>();
        Map<Integer, Integer> hashTable = new Hashtable<>();
        SortedMap<Integer, Integer> treeMap = new TreeMap<>();


    }
}
