import java.util.TreeMap;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

/*
 * 
 * The logic is to use the level order traversal 
 * and maintain a Queue of Pair ( Node, HorizontalDistance)
 * 
 * TreeMap is used assuming the order of printing is important as 
 * TreeMap maintains the keys in sorted order.
 */

class Node {
	int data;
	Node left, right;
	
	public Node(int data) 
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class VerticalOrderTraversal3 {
	
	class Pair{
		Node treeNode;
		int horizontalDistance;
		
		Pair(Node node,int dist){
			this.treeNode = node;
			this.horizontalDistance = dist;
		}
	}
	
	Node root;
	
	public void printVerticalOrder(Node root) {
		
		if(root == null) 
			return;
		
		TreeMap<Integer, Vector<Integer>> orderMap = new TreeMap<>();
		Queue<Pair> traversalQueue = new LinkedList<>();
		traversalQueue.add(new Pair(root,0));
		
		while(!traversalQueue.isEmpty()) {
			Pair current = traversalQueue.poll();
			int distance = current.horizontalDistance;
			
			Vector<Integer> currentDistanceList = orderMap.get(distance);
			if(currentDistanceList == null) {
				currentDistanceList = new Vector<Integer>();
				orderMap.put(distance, currentDistanceList);
			}
			
			currentDistanceList.add(current.treeNode.data);
						
			if(current.treeNode.left != null)
				traversalQueue.add(new Pair(current.treeNode.left, distance - 1));
			
			if(current.treeNode.right != null)
				traversalQueue.add(new Pair(current.treeNode.right, distance + 1));
		}
		
		for(Entry<Integer,Vector<Integer>> entry: orderMap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public static void main(String[] args) {
		 
		/*
	   	 *
	   	 *        1
		        /   \
		       2     3
		      / \   / \
		     4   5 6   7
		             \   \
		              8   9 
   	
       Let us construct the tree shown in above diagram 
       
       */
		VerticalOrderTraversal3 tree = new VerticalOrderTraversal3();
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
