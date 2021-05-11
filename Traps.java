// Problem Statement:


// Few people travelling in N*N grid land.
// and there are few traps set by local goons. Due to safety restrictions, 
// people has to maximize the distance between the traps near to them.

// You are given the current status of N*N grid containing values 0 and 1, 
// where 0 represents a person and 1 represents trap, 
// your task is to find a person's cell such that his/her distance to the 
// nearest trap cell is maximized, and return the distance.

// The distance used in this problem is the Manhattan distance: 
// the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1| .

// Input Format:
// -------------
// Line-1: An integer N, size of the square grid.
// Next N lines: N space separated integers, grid[][] either 0 or 1.

// Output Format:
// --------------
// An integer, maximum distance.


// Sample Input-1:
// ---------------
// 3
// 1 0 1
// 0 0 0
// 1 0 1

// Sample Output-1:
// ----------------
// 2

// Explanation: 
// ------------
// The person at (1, 1) is with distance 2 from all the traps.


// Sample Input-2:
// ---------------
// 3
// 1 0 0
// 0 0 0
// 1 0 0

// Sample Output-2:
// ----------------
// 3

// Explanation: 
// ------------
// The person at (1, 2) is with distance 3 from all the traps.

import java.util.*;

class Traps
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int grid[][]=new int[n][n];
        
        ArrayList<Integer> traps=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j]=sc.nextInt();
                if(grid[i][j]==1)
                    traps.add(i*n+j);
            }
        }
        
        int tlen=traps.size();
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    int closestTrap=Integer.MAX_VALUE;
                    for(int k=0;k<tlen;k++)
                    {
                        int row=traps.get(k)/n;
                        int col=traps.get(k)%n;
                        int dist=Math.abs(row-i)+Math.abs(col-j);
                        closestTrap=Math.min(dist,closestTrap);
                    }
                    maxi=Math.max(closestTrap,maxi);
                }
            }
        }
        System.out.println(maxi);
    }
}
