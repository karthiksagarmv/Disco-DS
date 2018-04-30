public class RunningMedian {

    /*
        What is median?
              Middle element in sorted array.
              
        Brute force -> 
              Maintain the sorted list and find middle one, it takes O(n*n)
              
        Logic =>
              We will maintain two heaps
              We will create two heaps, max heap for left part of list and min heap for right part of list.
    */
    
    
    public static PriorityQueue<Integer> leftHeap = new PriorityQueue(new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return b.compareTo(a);
        }
    });
    public static PriorityQueue<Integer> rightHeap = new PriorityQueue();
    
    
    /*
        Insert first element into left
        For every other element insert to left bucket if it is less than Maximum in left bucket or else to Right
    */
    
    public static void insertElement(int number){
        if(leftHeap.size() == 0 || leftHeap.peek() > number)
            leftHeap.add(number);
        else
            rightHeap.add(number);
    }
    
    /*
        Take the element from the bigger heap and put it into smaller heap
    */
    
    public static void balanceHeaps(PriorityQueue<Integer> leftHeap, PriorityQueue<Integer> rightHeap)
    {
        PriorityQueue<Integer> smallerHeap = (leftHeap.size() < rightHeap.size() ? leftHeap : rightHeap);
        PriorityQueue<Integer> biggerHeap = (rightHeap.size() > leftHeap.size()? rightHeap: leftHeap);
            
        if(biggerHeap.size() - smallerHeap.size() >=2)
        {
            smallerHeap.add(biggerHeap.poll());
        }
    }
    
    /*
        If size of both heaps are equal
            take average,
        else 
            return heap of bigger size peek()
    */
    
    public static double getMedian()
    {
        PriorityQueue<Integer> smallerHeap = (leftHeap.size() < rightHeap.size() ? leftHeap : rightHeap);
        PriorityQueue<Integer> biggerHeap = (rightHeap.size() > leftHeap.size()? rightHeap: leftHeap);

        if(smallerHeap.size() == biggerHeap.size())
        {
             return (double)((smallerHeap.peek() + biggerHeap.peek())/2.0);
        }
        
        return biggerHeap.peek();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            insertElement(a[a_i]);
            balanceHeaps(leftHeap,rightHeap);
            System.out.println(getMedian());
        }
    }
}
