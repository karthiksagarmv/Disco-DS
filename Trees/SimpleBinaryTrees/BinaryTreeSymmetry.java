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
 * Logic-
 * 		1) If tree is empty it is symmetric
 * 		2) If both left and right are not empty, we branch out to two paths
 * 				Ensure data is same
 * 				Ensure it is symmetric by going left in one path and right in another path
 */

public class BinaryTreeSymmetry {

	Node root;

	boolean isTreeSymmetric(Node root) 
	{
		return (root == null)  || isTreeSymmetricHelper(root.left,root.right);
	}
	
	boolean isTreeSymmetricHelper(Node left, Node right) {
		
		// If we find empty nodes in both paths, it is symmetric
		if(left == null && right == null) {
			return true;
		}
		
		// When both paths are not empty, check current data in both paths and recur for symmetry
		if(left != null && right != null) {
			return (left.data == right.data) && isTreeSymmetricHelper(left.left, right.right)
					&& isTreeSymmetricHelper(left.right, right.left);
		}
		
		System.out.println("Returning False" + left.data + " " + right.data);
		// If we find empty node in one path and non empty in another, it is asymmetric
		return false;
	}

	public static void main(String args[])
    {
 
        /* Constructed binary tree is
                   1
                 /   \
                2      2
                 \    /
                  5  5
            
       */
        BinaryTreeSymmetry tree = new BinaryTreeSymmetry();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        
 
        if (tree.isTreeSymmetric(tree.root))
            System.out.println("Tree is Symmetric");
        else
            System.out.println("Tree is not Symmetric");
    }
}
