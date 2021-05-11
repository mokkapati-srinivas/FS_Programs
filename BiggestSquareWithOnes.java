// Problem Statement:

// The decoration on the wall, made up of led bulbs. When the bulbs turned on, 
// the bulbs emit either bule color light or white color light. 
// The leds bulbs decorated in the form of a grid of size m*n. 
// And when you turned on the bulbs, the bulbs are emiting the light 
// in blue color (1) and white color (0).

// You are given the current state of the decorated wall of size M*N,
// Your task is to find the biggest square can be formed using blue colored bulbs,
// and return its area.

// Input Format:
// -------------
// Line-1: Two space separated integers, M and N size of the decoration grid.
// Next M lines: N space separated integers ( either 0 or 1 only).

// Output Format:
// --------------
// Print an integer, area of the biggest square grid of blue colored bulbs.


// Sample Input:
// -------------
// 5 6
// 1 0 0 1 0 1
// 0 1 1 1 1 1
// 1 1 1 1 0 1
// 0 1 1 1 0 1
// 1 0 1 0 1 1 

// Sample Output:
// --------------
// 9


import java.util.*;

class BiggestSquareWithOnes
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int grid[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j]=sc.nextInt();
            }
        }
        
        int dp[][]=new int[m][n];
        int maxSize=0;
        for(int i=0;i<m;i++)
        {
            dp[i][n-1]=grid[i][n-1];
            maxSize=Math.max(maxSize,dp[i][n-1]);
        }
        for(int j=0;j<n;j++)
        {
            dp[m-1][j]=grid[m-1][j];
            maxSize=Math.max(maxSize,dp[m-1][j]);
        }
        for(int i=m-2;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {
                if(grid[i][j]==1)
                {
                    dp[i][j]=1+Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1]);
                }
                else
                {
                    dp[i][j]=0;
                }
                maxSize=Math.max(maxSize,dp[i][j]);
            }
        }
        
        int maxNumberOfElements=maxSize*maxSize;
        System.out.println(maxNumberOfElements);
    }
}
