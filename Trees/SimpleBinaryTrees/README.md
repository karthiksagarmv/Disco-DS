[BinaryTreeBalanceCheck](https://github.com/karthiksagarmv/Disco-DS/edit/master/Trees/SimpleBinaryTrees/BinaryTreeBalanceCheck.java)

Java Solution to check if given tree is balanced. The code computes the height in recursion call.

**Variants**: This code can be modified to compute the height of every node in its class in single traversal.

[BinaryTreeSymmetry](https://github.com/karthiksagarmv/Disco-DS/edit/master/Trees/SimpleBinaryTrees/BinaryTreeSymmetry.java)

Java Solution to check symmetry of given binary tree. A tree is symmetric if we split the tree into vertical half, the two parts are mirror images with respect to structure and data  

[Traversal / Vertical Order Type 1](https://github.com/karthiksagarmv/Disco-DS/blob/master/Trees/SimpleBinaryTrees/Traversals/VerticalOrderTraversal1.java)  
  
This is a O(n*w) solution, where w => width of given tree, it works by computing maximum and minumum horizontal width of tree and then print for each level.

[Traversal / Vertical Order Type 2](https://github.com/karthiksagarmv/Disco-DS/blob/master/Trees/SimpleBinaryTrees/Traversals/VerticalOrderTraversal2.java)

This solution uses Map to save entries of vertical order traversal corresponding to a horizontal distance.  
The code uses TreeMap to save the entries. Time complexity would be O(N*log(N))  
