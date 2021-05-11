// Problem Statement:


// Zee Telugu started a world champion’s game show for the kids between 8-12 years.
// The main moto of this game is to check the IQ level of the kids in few concepts related to
// Mathematics.

// Pillai has participated in this competition, where he was given few variety of chocolate bags, each 
// variety has a unque price per chocolate. Now he was asked to find all possible ways to sell the chocolates
// with given amount T.

// Your task is to help Pillai, to find all the possible ways of selling the variety of chacolates for a given amount, and print the count.

// Input Format:
// -------------
// Line-1: Two space separated integers N and T, N varieties, T is amount.
// Line-2: N space separated integers, price of each variety of chocolate.

// Output Format:
// --------------
// Print an integer, number of possible ways.


// Sample Input-1:
// ---------------
// 3 10
// 2 3 5

// Sample Output-1:
// ----------------
// 4


// Sample Input-2:
// ---------------
// 2 8
// 2 5

// Sample Output-2:
// ----------------
// 1

import java.util.*;
class PossibleWaysChocolateDistribution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int choc[]=new int[n];
        for(int i=0;i<n;i++)
        {
            choc[i]=sc.nextInt();
        }
        
        int dp[]=new int[t+1];
        for(int i=0;i<n;i++)
        {
            for(int j=choc[i];j<=t;j++)
            {
                if(j==choc[i])
                {
                    dp[j]+=1;
                }
                else
                {
                    dp[j]=dp[j]+dp[j-choc[i]];
                }
            }
        }
        
        System.out.println(dp[t]);
    }
}

