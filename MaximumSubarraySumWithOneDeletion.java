// Vijay is playing with set of boxes, each box is printed a number on it.
// all the boxes placed in a row.

// You are given the numbers printed on the boxes in the row.
// Your task is to find the maximum sum of the numbers when one box is removed 
// from the sub-set of boxes, and the sub-set is selected as a contiguous set of 
// boxes from the row. 

// Note: The sub-set should not be empty after removal of a box.

// Input Format:
// -------------
// Single line of space separated integers, number on the boxes.

// Output Format:
// --------------
// Print an integer, Maximum sum of sub-set of boxes,
// after removal of a box.


// Sample Input-1:
// ---------------
// -2 -3 4 -1 -2 1 5 -3

// Sample Output-1:
// ----------------
// 9

// Sample Input-2:
// ---------------
// -2 -3 -4 -1 -2 1 5 -3 8

// Sample Output-2:
// ----------------
// 14

import java.util.*;

class MaximumSubarraySumWithOneDeletion
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String inp[]=sc.nextLine().split(" ");
        int n=inp.length;
        
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=Integer.parseInt(inp[i]);
        }
        
        int forward[]=new int[n];
        int backward[]=new int[n];
        forward[0]=arr[0];
        backward[n-1]=arr[n-1];
        
        for(int i=1;i<n;i++)
        {
            forward[i]=Math.max(arr[i],arr[i]+forward[i-1]);
        }
        for(int i=n-2;i>=0;i--)
        {
            backward[i]=Math.max(arr[i],arr[i]+backward[i+1]);
        }
        
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(i==0)
                ans=Math.max(ans,backward[1]);
            else if(i==n-1)
                ans=Math.max(ans,forward[n-2]);
            else
                ans=Math.max(ans,forward[i-1]+backward[i+1]);
        }
        
        System.out.println(ans);
    }
}
