// A Kid is arranging a structure using building blocks, 
// by placing individual building-block adjacent to each other.

// A building-block is a vertical alignment of blocks.
		                            
// here one block each represents  as -

// The following structure made up of using building blocks

               






//             0  1   3   4   2   3    2   0   1   0   2

// Once the structure is completed, kid pour water(w) on it.

// You are given a list of integers, heights of each building-block in a row.
// Now your task How much amount of water can be stored by the structure.


// Input Format:
// -------------
// Space separated integers, heights of the blocks in the structure. 

// Output Format:
// --------------
// Print an integer, 


// Sample Input:
// -------------
// 0 1 3 4 2 3 2 0 1 0 2
    
// Sample Output:
// --------------
// 6
    
// Explanation:
// -----------
// In the above structure,  6 units of water (w represents the water in the structure)
// can be stored.


import java.util.*;

class TrappingRainWater
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String inp[]=sc.nextLine().split(" ");
        int n=inp.length;
        
        int block[]=new int[n];
        for(int i=0;i<n;i++)
        {
            block[i]=Integer.parseInt(inp[i]);
        }
        
        int leftmax[]=new int[n];
        int rightmax[]=new int[n];
        
        leftmax[0]=0;
        for(int i=1;i<n;i++)
        {
            leftmax[i]=Math.max(block[i-1],leftmax[i-1]);
        }
        
        rightmax[n-1]=0;
        for(int i=n-2;i>=0;i--)
        {
            rightmax[i]=Math.max(block[i+1],rightmax[i+1]);
        }
        
        // System.out.println(Arrays.toString(leftmax));
        // System.out.println(Arrays.toString(rightmax));
        
        int water=0;
        // left and right overflows
        for(int i=1;i<n-1;i++)
        {
            int highestwater=Math.min(leftmax[i],rightmax[i]);
            if(block[i]<highestwater)
                water+=highestwater-block[i];
        }
        
        System.out.println(water);
        
    }
}
