// Problem Statement:


// Given a flat surface of m*n size, each position contains either empty '0', 
// a Iron ball 'B' or Metal Block 'M' (The Metal block is an anti magnetic block), 
// Your task is to find the maximum Iron Balls you can attarct by using a Magnet.

// The Magnet attarcts all the iron balls in the same row and column from their 
// positions until the Metal Block. since the Metal block is an anti magnetic block.

// Note: You can only put the magnet at an empty position.


// Input Format:
// -------------
// Line-1 -> Two Integers, M and N, size of the grid
// Next M Lines -> N space separated characters, allowed characters '0', 'B', 'M'


// Output Format:
// --------------
// Print an integer, maximum Iron Balls you can attarct by using a Magnet


// Sample Input-1:
// ---------------
// 3 4
// 0 B 0 0 
// B 0 M B
// 0 B 0 0

// Sample Output:
// --------------
// 3 

// Explanation: 
// ------------
// For the given grid,

// 0 B 0 0 
// B 0 M B
// 0 B 0 0

// Placing a Magnet at (1,1) attacts 3 iron balls.

import java.util.*;

class MagneticBlocks
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        char surface[][]=new char[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                surface[i][j]=sc.next().charAt(0);
            }
        }
        
        int totalIronBlocks[][]=new int[m][n];
        int count=0;
        for(int i=0;i<m;i++)
        {
            count=0;
            for(int j=0;j<n;j++)
            {
                if(surface[i][j]=='B')
                    count++;
                else if(surface[i][j]=='M')
                    count=0;
                else
                    totalIronBlocks[i][j]+=count;
            }
            count=0;
            for(int j=n-1;j>=0;j--)
            {
                if(surface[i][j]=='B')
                    count++;
                else if(surface[i][j]=='M')
                    count=0;
                else
                    totalIronBlocks[i][j]+=count;
            }
        }
        for(int j=0;j<n;j++)
        {
            count=0;
            for(int i=0;i<m;i++)
            {
                if(surface[i][j]=='B')
                    count++;
                else if(surface[i][j]=='M')
                    count=0;
                else
                    totalIronBlocks[i][j]+=count;
            }
            count=0;
            for(int i=m-1;i>=0;i--)
            {
                if(surface[i][j]=='B')
                    count++;
                else if(surface[i][j]=='M')
                    count=0;
                else
                    totalIronBlocks[i][j]+=count;
            }
        }
        
        int maxIron=Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(surface[i][j]=='0')
                {
                    maxIron=Math.max(maxIron,totalIronBlocks[i][j]);
                }
            }
        }
        
        System.out.println(maxIron);
    }
}

