[Running Median](https://github.com/karthiksagarmv/Disco-DS/new/master/Heaps/RunningMedian.java)

Key Learnings
    
**PriorityQueues** 

    boolean add(E element): This method inserts the specified element into this priority queue.  
    public remove(): This method removes a single instance of the specified element from this queue, if it is present  
    public poll(): This method retrieves and removes the head of this queue, or returns null if this queue is empty.  
    public peek(): This method retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.  
    iterator(): Returns an iterator over the elements in this queue.  
    boolean contains(Object o): This method returns true if this queue contains the specified element

**ComparatorInterface**  

    Example for Max Heap  
    compareTo Returns 0 if equal, positive if first is greater and negative if second is greater
    PriorityQueue priorityQueue = new PriorityQueue(new Comparator<Integer>(){  
         public int compare(Integer a, Integer b){
              return b.compareTo(a);
         }
    }
