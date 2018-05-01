
/*
 * 	The algorithm ->
 *  1) Find the max horizontal distance of the given tree,
 *     i.e. Maximum leftSpan and rightSpan of the tree
 *  2) For each horizontal distance, call the printVerticalOrder Function
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


public class VerticalOrderTraversal1 
{

	public static Integer rightDistance = Integer.MIN_VALUE;
	public static Integer leftDistance = Integer.MAX_VALUE;
	
	Node root;
	
	public void verticalOrder(Node root) 
	{
		findMinMax(root,0);
		
		for(int line = leftDistance; line <= rightDistance; line++) {
			printVerticalOrderLine(root,line,0);
			System.out.println();
		}
	}	
	
	private void printVerticalOrderLine(Node root, int line,int curDist) {

		// TODO Auto-generated method stub
		if(root == null) 
			return;
		
		if(curDist == line)
			System.out.print(root.data + " ");
		
		printVerticalOrderLine(root.left, line, curDist-1);
		printVerticalOrderLine(root.right, line, curDist+1);
		
	}
	
	private void findMinMax(Node root,int dist) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		
		if(dist > rightDistance)
			rightDistance = dist;
		else if ( dist < leftDistance)
			leftDistance = dist;
		
		findMinMax(root.left,dist-1);
		findMinMax(root.right,dist+1);
			
	}
	
	  // Main function to test the traversal
    public static void main(String args[]) 
    {
    	VerticalOrderTraversal1 tree = new VerticalOrderTraversal1();
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
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);
  
        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root);
    }
}
