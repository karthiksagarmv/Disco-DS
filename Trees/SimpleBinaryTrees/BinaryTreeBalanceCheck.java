/*
 * 	Node of the tree which contains data, left Node and right Node
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

/*
 * This is utility class to store the height of the tree
 */
class Height
{
	int height;

	public Height() {
		height = 0;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}


/*
 * This is the public exposed class which 
 * contains root node and creates the tree
 */
public class BinaryTreeBalanceCheck 
{
	Node root;
	
	/*
	 * 1) If tree is empty => BALANCED
	 * 2) If difference between left and right subtree is < 2 => BALANCED
	 * 
	 * We are calculating the current tree height at every step and using it in recursion 
	 * call back to eliminate calculating height at each node.
	 */
	
	boolean isTreeBalanced(Node root, Height curHeight) {
		
		if(root == null) {
			curHeight.setHeight(0);
			return true;
		}
		
		boolean leftBalanced = false, rightBalanced = false;
		Height leftHeight = new Height();
		Height rightHeight = new Height(); 
		
		leftBalanced = isTreeBalanced(root.left,leftHeight);
		rightBalanced = isTreeBalanced(root.right,rightHeight);
		
		curHeight.setHeight(Math.max(leftHeight.getHeight(), rightHeight.getHeight()) + 1);
		
		if(Math.abs(leftHeight.height - rightHeight.height) >=2 )
			return false;
		
		return leftBalanced & rightBalanced;
	}
	
	public static void main(String args[])
    {
        Height height = new Height();
 
        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        BinaryTreeBalanceCheck tree = new BinaryTreeBalanceCheck();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.right.right = new Node(8);
        tree.root.left.left.left = new Node(7);
 
        if (tree.isTreeBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
	
}
