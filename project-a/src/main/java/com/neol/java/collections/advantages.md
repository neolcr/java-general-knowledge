Limitations of an array:
1. arrays are fixed in size
2. Arrays con hold only homogeneous data elements (unless array of objects)
3. There is no ready-made api for arrays in java (there is in collections)


Collections
from best to worse

O(1) - Constant Time
O(log n) - Logarithmic Time
O(n) - Linear Time
O(n log n) - Linearithmic Time


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