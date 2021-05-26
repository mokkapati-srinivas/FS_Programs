// May - 26

// Prashanth Varma is working on integer sets.
// He is given an Zero-Set ZS of length N, the set conatins only 0's.
// Also he is provided with a set of M triplets[], where triplet[i] = [start, end, val].
// The triplet contains the following values: start means starting index, 
// end menas last index, and val means value to be added.

// Prashanth has to perform M operations as follows:
// 	- He need to read three values from the triplet[i], where 0<= i < M.
// 	- He needs to add the value of 'val' to all the elements in ZS,
// 	  between start and end indices, both are inclusive.
	
// Your task is to help Prashanth Varma, to perform M operations on ZS
// and return the final ZeroSet ZS.

// NOTE:
// Can you solve the problem in O(n+k) time complexity?

// Input Format:
// -------------
// Line-1: Two space separated integers N and M, size of ZS and number of triplets.
// Next M lines: Three space separated integers, the triplets [start, end, val]

// Output Format:
// --------------
// Print the final ZS, after performing M operations.


// Sample Input:
// -------------
// 5 3
// 1 3 2
// 2 4 3
// 0 2 -2

// Sample Output:
// --------------
// [-2,0,3,5,3]


// Explanation:
// ------------
// Initial state of the ZeroSet is: [0,0,0,0,0]
// 	- After applying operation [1,3,2] => [0,2,2,2,0]
// 	- After applying operation [2,4,3] => [0,2,5,5,3]
// 	- After applying operation [0,2,-2] => [-2,0,3,5,3]


import java.util.*;

class AddBetweenIndicesToZeros
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int steps[][]=new int[m][3];
        for(int i=0;i<m;i++)
        {
            steps[i][0]=sc.nextInt();
            steps[i][1]=sc.nextInt();
            steps[i][2]=sc.nextInt();
        }
        
        int bumps[]=new int[n];
        for(int i=0;i<m;i++)
        {
            int left=steps[i][0];
            int right=steps[i][1];
            int val=steps[i][2];
            bumps[left]+=val;
            if(right+1<n)
            {
                bumps[right+1]-=val;
            }
        }
        
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=bumps[i];
            bumps[i]=sum;
        }
        
        System.out.println(Arrays.toString(bumps));
    }
}
