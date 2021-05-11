// Problem Statement:

// Aravind went to a forest, he stuck inside the forest and He is blind.
// The forest is given as a square grid. The forest grid is filled with trees and empty cells.
// He can move upwards, downwadrs, left and right, but he cannot stop until he touches the tree.
// Once he touches a tree, ha can choose the next direction to move.
// Intially Aravind is at poistion A, and he is trying to reach a safe-point at position S.

// You will be given the forest grid filled with 1's and 0's, 1 means tree and 0 means empty cell.
// And initial position of Aravind, safe-point S.

// Your task is to find the minimum distance travelled by Aravind to reach the safe-point
// If he cannot stop at the safe-point, return -1.

// You may assume that the borders of the forest are all trees.

// Input Format:
// -------------
// Line-1: An integer N, size of the grid.
// Next N lines: N space separated integers
// Next line:  two space separated integers, initial position of Aravind
// Next line:  two space separated integers, position of safe-point.

// Output Format:
// --------------
// Print an integer, minimum distance travelled by Aravind to reah safe-point.


// Sample Input-1:
// ---------------
// 5
// 0 1 0 0 0
// 0 0 0 0 0
// 0 0 0 1 0
// 1 1 0 0 1
// 0 0 0 0 0
// 2 4
// 4 0

// Sample Output-1:
// ----------------
// 10

// Explanation:
// ------------
// For Picture look at hint.
// The minimum path is : up -> left -> down -> left.

// Sample Input-2:
// ---------------
// 5
// 0 1 0 0 0
// 0 0 0 0 0
// 0 0 0 1 0
// 1 1 0 0 1
// 0 0 0 0 0
// 0 3
// 3 3

// Sample Output-2:
// ----------------
// -1

// Explanation: 
// ------------
// Aravind cannot stop at safe-point.


import java.util.*;

class MinimumDistanceToSafePoint
{
    
    static int result=Integer.MAX_VALUE;
    static Stack<String> visited=new Stack<String>();
    
    public static int getUp(int grid[][], int n, int starti, int startj)
    {
        int i=starti;
        while(i-1>=0 && grid[i-1][startj]==0)
        {
            i--;
        }
        
        return i;
    }
    
    public static int getDown(int grid[][], int n, int starti, int startj)
    {
        int i=starti;
        while(i+1<n && grid[i+1][startj]==0)
        {
            i++;
        }
        
        return i;
    }
    
    public static int getLeft(int grid[][], int n, int starti, int startj)
    {
        int j=startj;
        while(j-1>=0 && grid[starti][j-1]==0)
        {
            j--;
        }
        
        return j;
    }
    
    public static int getRight(int grid[][], int n, int starti, int startj)
    {
        int j=startj;
        while(j+1<n && grid[starti][j+1]==0)
        {
            j++;
        }
        
        return j;
    }
    
    public static void getPath(int grid[][], int n, int steps, int starti, int startj, int safei, int safej)
    {
        if(starti==safei && startj==safej)
        {
            result=Math.min(result,steps);
            return;
        }
        
        visited.push((starti+" "+startj));
        
        int left=getLeft(grid,n,starti,startj);
        int right=getRight(grid,n,starti,startj);
        int up=getUp(grid,n,starti,startj);
        int down=getDown(grid,n,starti,startj);
        
        if(up!=starti && !visited.contains((up+" "+startj)))
        {
            getPath(grid,n,(steps+starti-up),up,startj,safei,safej);
        }
        if(down!=starti && !visited.contains((down+" "+startj)))
        {
            getPath(grid,n,(steps+down-starti),down,startj,safei,safej);
        }
        if(left!=startj && !visited.contains((starti+" "+left)))
        {
            getPath(grid,n,(steps+startj-left),starti,left,safei,safej);
        }
        if(right!=startj && !visited.contains((starti+" "+right)))
        {
            getPath(grid,n,(steps+right-startj),starti,right,safei,safej);
        }
        
        visited.pop();
        
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int grid[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j]=sc.nextInt();
            }
        }
        int starti=sc.nextInt();
        int startj=sc.nextInt();
        int safei=sc.nextInt();
        int safej=sc.nextInt();
        
        getPath(grid,n,0,starti,startj,safei,safej);
        
        if(result!=Integer.MAX_VALUE)
        {
            System.out.println(result);
        }
        else
        {
            System.out.println(-1);
        }
    }
}
