// June - 22

// Balbir singh is working with Binary Trees.
// The elements of the tree is given in the level order format.
// Balbir has a task to split the tree into two parts by removing only one edge
// in the tree in such way that the sum of elements in both the trees should be equal.

// You will be given the root of the binary tree.
// Your task is to help the Balbir singh to split the binary tree as specified.
// print true, if it is possible, otheriwse print false.

// Your task is to implement the class Solution:
// 	- public boolean checkEqualTree(BinaryTreeNode root):
// 	return the boolean value.
	
// NOTE: 
// Please do consider the node with data as '-1' as null in the given trees.

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 1 2 3 5 -1 -1 5

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 3 2 4 3 2 -1 7

// Sample Output-2:
// ----------------
// false

// NOTE: Look at hint for explanation.


import java.util.*;

/*
    //Structure of BinaryTreeNode for your reference.

    class BinaryTreeNode{
    	public int data; 
    	public BinaryTreeNode left, right; 
    	public BinaryTreeNode(int data){
    		this.data = data; 
    		left = null; 
    		right = null; 
    	}
    }
*/

class Solution {
    
    public int getSumOfAllTrees(BinaryTreeNode curr, ArrayList<Integer> sums)
    {
        if(curr==null || curr.data==-1)
        {
            return 0;
        }
        
        int leftSum=getSumOfAllTrees(curr.left,sums);
        int rightSum=getSumOfAllTrees(curr.right,sums);
        
        int currSum=curr.data+leftSum+rightSum;
        sums.add(currSum);
        
        return currSum;
        
    }
    
    public boolean checkEqualTree(BinaryTreeNode root) {
        // implement your code here.
        
        ArrayList<Integer> sums=new ArrayList<Integer>();
        int totalSum=getSumOfAllTrees(root,sums);
        int n=sums.size();
        // System.out.println(sums);
        
        for(int i=0;i<n;i++)
        {
            int firstPart=sums.get(i);
            int secondPart=totalSum-firstPart;
            if(firstPart==secondPart)
            {
                return true;
            }
        }
        
        return false;
    }
}
