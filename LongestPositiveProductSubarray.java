// Problem Statement:


// Ashok is given an array of integers nums.
// His task is to find the longest contiguous subsequence S, 
// the product of all the numbers in the subsequence should be positive.

// Return the length of longest contiguous subarray.

// Input Format:
// -------------
// Space separated integers nums[], list of numbers.

// Output Format:
// --------------
// Print the length of the longest contiguous subsequence


// Sample Input-1:
// ---------------
// 1 -1 2 -2

// Sample Output-1:
// ----------------
// 4


// Sample Input-2:
// ---------------
// -1 -2 -3 0 1

// Sample Output-2:
// ----------------
// 2

// Explanation:
// ------------
// 0 is considered as positive number.


// Sample Input-3:
// ---------------
// 1 2 3 4 -5 6  7 8

// Sample Output-3:
// ----------------
// 4

import java.util.*;
class LongestPositiveProductSubArray
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String inp[]=sc.nextLine().split(" ");
        int n=inp.length;
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=Integer.parseInt(inp[i]);
        }
        
        int firstNegativeInd=-1;
        int negative=0;
        int zeroInd=-1;
        int result=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                negative=0;
                firstNegativeInd=-1;
                zeroInd=i;
            }
            else if(nums[i]<0)
            {
                if(firstNegativeInd==-1)
                {
                    firstNegativeInd=i;
                }
                negative++;
            }
            
            if(negative%2==0)
            {
                result=Math.max(result,i-zeroInd);
            }
            else
            {
                result=Math.max(result,i-firstNegativeInd);
            }
        }
        
        System.out.println(result);
    }
}

