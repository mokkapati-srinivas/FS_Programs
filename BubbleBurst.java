// Problem Statement:


// You are playing a shooting game.
// There are N bottles hanging to a rod, i-th bottle numbered bottle[i].

// If you shoot i-th bottle, you will get bottle[i-1]*bottle[i]*bottle[i+1] points.
// The more points you score, the more rewards you can win.

// Your task is to score the maximum points by shooting all the ballons wisely.

// Note: After you shoot bottle at i-th index, bottles at i-1 and i+1 positions
// become adjacent. if there is no existing 'i-1' or 'i+1' positions for selected bottle.
// you can assume that bottle[i-1] = bottle[i+1] = 1.

// Input Format:
// -------------
// N space separated integers bottles[].

// Output Format:
// --------------
// Print an integer, maximum points you can get.


// Sample Input:
// ---------------
// 3 1 5 8

// Sample Output:
// ----------------
// 167

// Explanation:
// ------------
// Given bottles = [3, 1, 5, 8] 
// position 	points
// --------------------
// 1				3*1*5
// 5				3*5*8
// 3				1*3*8
// 8				1*8*1
// --------------------
// Total = 167


// Sample Input:
// ---------------
// 2 1 3 5 4

// Sample Output:
// ----------------
// 102

// Explanation:
// ------------
// Given bottles = [2, 1, 3, 5, 4] 

// position 	points
// --------------------
// 5				3*5*4
// 1				2*1*3
// 3				2*3*4
// 2				1*2*4
// 4				1*4*1
// --------------------

import java.util.*;
class BubbleBurst
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String inp[]=sc.nextLine().split(" ");
        int n=inp.length;
        
        int bottles[]=new int[n+2];
        bottles[0]=1;
        bottles[n+1]=1;
        for(int i=1;i<=n;i++)
        {
            bottles[i]=Integer.parseInt(inp[i-1]);
        }
        
        int dp[][]=new int[n+2][n+2];
        int maxPoints=Integer.MIN_VALUE;
        for(int window=1;window<=n;window++)
        {
            for(int left=1;left<=n-window+1;left++)
            {
                int right=left+window-1;
                for(int i=left;i<=right;i++)
                {
                    dp[left][right]=Math.max(dp[left][right],dp[left][i-1]+(bottles[left-1]*bottles[i]*bottles[right+1])+dp[i+1][right]);
                }
                maxPoints=Math.max(maxPoints,dp[left][right]);
            }
        }
        System.out.println(maxPoints);
    }
}
