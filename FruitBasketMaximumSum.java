// Problem Statement:


// Given a bunch of baskets in a row, each basket contains few fruits in it.
// You can select K number of baskets, one after other.
// The selection of basket is either from beginning or from the end the row.

// Return the maximum number of fruits you have after K baskets collected.

// Input Format:
// -------------
// Line-1 -> Two integers N and K, N is no of baskets and K is the basket 
// count you can pick.
// Line-2 -> N space separated integers fruits[], fruits in each basket.

// Output Format:
// --------------
// Print an integer, Maximum num of fruits you can collect.


// Sample Input-1:
// ---------------
// 7 3
// 1 2 3 4 5 6 1

// Sample Output-1:
// ----------------
// 12


// Sample Input-2:
// ---------------
// 5 3
// 2 2 2 2 2

// Sample Output-2:
// ----------------
// 6


// Sample Input-3:
// ---------------
// 8 3
// 1 79 80 1 1 1 200 1

// Sample Output-3:
// ----------------
// 202

import java.util.*;

class FruitBasketMaximumSum
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int baskets[]=new int[n];
        for(int i=0;i<n;i++)
        {
            baskets[i]=sc.nextInt();
        }
        
        int fruitPrefix[]=new int[n];
        fruitPrefix[0]=baskets[0];
        for(int i=1;i<n;i++)
        {
            fruitPrefix[i]=fruitPrefix[i-1]+baskets[i];
        }
        int subArrayLen=n-k;
        int minimumFruitSubArray=Integer.MAX_VALUE;
        int subArraySum=0;
        for(int i=subArrayLen-1;i<n;i++)
        {
            int j=i-(subArrayLen-1);
            if(j==0)
            {
                subArraySum=fruitPrefix[i];
            }
            else
            {
                subArraySum=fruitPrefix[i]-fruitPrefix[j-1];
            }
            minimumFruitSubArray=Math.min(minimumFruitSubArray,subArraySum);
        }
        
        int maxFruits=fruitPrefix[n-1]-minimumFruitSubArray;
        System.out.println(maxFruits);
    }
}

