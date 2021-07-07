// Problem Statement:

// Nagireddy is working with a list of integers list[], all are positive integers.
// Nagireddy is defined a pair[p,q] as reserved pair, 
// iff the pair[p,q] follows the below rules:
// 	- In the pair, [p,q] : p and q are indices, and 0 <= p < q < N.
// 	- Sum of list[p] and reverse(list[q]) and Sum of list[q] and reverse(list[p]) 
// 	  shoud be equal.

// Your task is to help Mr Nagireddy, to find and count the number of reserved pairs 
// in the given list of integers, list[].


// Input Format:
// -------------
// Line-1: An integer N, size of the list.
// Line-2: N space seperated integers, elements of the list.

// Output Format:
// --------------
// Print an integer, number of reserved pairs.


// Sample Input-1:
// ---------------
// 5
// 91 78 23 89 27

// Sample Output-1:
// ----------------
// 3
// 87+23=110 23+87=110

// Explanation:
// ------------
// The pairs are: [78, 23], [23, 89] and [78, 89]
// Pair-1: 78+32 => 87 + 23 => equals 110
// Pair-2: 89+32 => 98 + 23 => equals 121
// Pair-3: 78+98 => 87 + 89 => equals 176


// Sample Input-2:
// ---------------
// 5
// 22 10 36 29 7

// Sample Output-2:
// ----------------
// 1

// Explanation:
// ------------
// The pair is [22, 7]


import java.util.*;

class ReversedPairs
{
    public static int reverseNum(int num)
    {
        int rev=0;
        while(num>0)
        {
            rev=rev*10+(num%10);
            num=num/10;
        }
        
        return rev;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        
        int revNums[]=new int[n];
        for(int i=0;i<n;i++)
        {
            revNums[i]=reverseNum(nums[i]);
        }
        
        int pairCount=0;
        HashMap<Integer,Integer> frequency=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            int currDiff=nums[i]-revNums[i];
            if(frequency.get(currDiff)==null)
            {
                frequency.put(currDiff,1);
            }
            else
            {
                int count=frequency.get(currDiff);
                frequency.put(currDiff,count+1);
            }
        }
        
        for(int key: frequency.keySet())
        {
            int count=frequency.get(key);
            if(count!=1)
            {
                pairCount+=(count*(count-1))/2;
            }
        }
        System.out.println(pairCount);
    }
}
