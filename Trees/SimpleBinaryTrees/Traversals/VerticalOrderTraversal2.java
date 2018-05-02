import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

/*
 * 
 *  The idea is to maintain a TreeMap ( We need to maintain the sorted order of the keys )
 *  IF the order of printing does not matter, we can use HashMaps
 *  
 *  We create a (key, value) => (horizontal distance, vector or elements )
 *  We insert every element to appropriate horizontal distance bucket
 *  
 *  
 */

class Node {
	int data;
	Node left, right;
	
	public Node(int data) 
	{
		this.data = data;
		left = right = null;
	}
}

public class VerticalOrderTraversal2 {

	Node root;
	
	public void printVerticalOrder(Node root) {
		TreeMap<Integer, Vector<Integer>> orderMap = new TreeMap<>();
		printVerticalOrderHelper(root,0,orderMap);
		
		 for(Entry<Integer,Vector<Integer>> entry: orderMap.entrySet()) {
			 System.out.println(entry.getValue());
		 }
	}
	
	/*
	 * Why TreeMap?
	 * We need to maintain the order of the keys, to display from left to right
	 * 
	 * No order of keys required => HashMap
	 * Insertion order is to be maintained => LinkedHashMap
	 * Sorted order is required => TreeMap
	 */
	
	private void printVerticalOrderHelper(Node root, int curDist, TreeMap<Integer, Vector<Integer>> orderMap) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		
		Vector<Integer> curDistVector = orderMap.get(curDist);
		
		if(curDistVector == null) {
			curDistVector = new Vector<Integer>();
			orderMap.put(curDist, curDistVector);
		}
		
		curDistVector.add(root.data);
		printVerticalOrderHelper(root.left, curDist-1, orderMap);
		printVerticalOrderHelper(root.right, curDist+1, orderMap);
		
	}

	public static void main(String[] args) {
		 
		/*
	   	 *
	   	 *    1
		        /   \
		       2     3
		      / \   / \
		     4   5 6   7
		             \   \
		              8   9 
   	
       Let us construct the tree shown in above diagram 
       
       */
		VerticalOrderTraversal2 tree = new VerticalOrderTraversal2();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        tree.printVerticalOrder(tree.root);
    }
}
