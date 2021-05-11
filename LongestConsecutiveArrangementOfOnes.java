// Apr - 29

// A merchant has two types of idols, gold and silver.
// He has arranged the idols in the form of m*n grid, 
// 	- the gold idols are represented as 1's 
// 	- the silver idols are represented as 0's.

// Your task is to find the longest consecutive arrangement of gold idols, 
// The arranement can be either horizontal, vertical, diagonal or antidiagonal, 
// but not the combination of these.


// Input Format:
// -------------
// Line-1: Two space separated integers m and n, grid size.
// Next m lines : n space separated integers, arrangement of idols.

// Output Format:
// --------------
// Print an integer, longest arranement of gold idols.


// Sample Input:
// ---------------
// 4 5
// 1 0 1 1 1
// 0 1 0 1 0
// 1 0 1 0 1
// 1 1 0 1 1

// Sample Output:
// ----------------
// 4


import java.util.*;

class LongestConsecutiveArrangementOfOnes
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int idols[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                idols[i][j]=sc.nextInt();
            }
        }
        
        int horizontal[][]=new int[m][n];
        int vertical[][]=new int[m][n];
        int diagonal[][]=new int[m][n];
        int antiDiagonal[][]=new int[m][n];
        horizontal[0][0]=vertical[0][0]=diagonal[0][0]=antiDiagonal[0][0]=idols[0][0];
        int maxIdols=idols[0][0];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(idols[i][j]==1)
                {
                    horizontal[i][j]=vertical[i][j]=diagonal[i][j]=antiDiagonal[i][j]=1;
                    if(j-1>=0)
                    {
                        horizontal[i][j]=horizontal[i][j-1]+1;
                        maxIdols=Math.max(maxIdols,horizontal[i][j]);
                    }
                    if(i-1>=0)
                    {
                        vertical[i][j]=vertical[i-1][j]+1;
                        maxIdols=Math.max(maxIdols,vertical[i][j]);
                    }
                    if(i-1>=0 && j-1>=0)
                    {
                        diagonal[i][j]=diagonal[i-1][j-1]+1;
                        maxIdols=Math.max(maxIdols,diagonal[i][j]);
                    }
                    if(i-1>=0 && j+1<n)
                    {
                        antiDiagonal[i][j]=antiDiagonal[i-1][j+1]+1;
                        maxIdols=Math.max(maxIdols,antiDiagonal[i][j]);
                    }
                }
                else
                {
                    horizontal[i][j]=vertical[i][j]=diagonal[i][j]=antiDiagonal[i][j]=0;
                }
            }
        }
        
        System.out.println(maxIdols);
    }
}