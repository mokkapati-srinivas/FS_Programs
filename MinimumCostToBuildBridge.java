// Problem Statement:

// Pandavas and Kauravas are ruling two different kingdoms sepertaed by river.
// If you connect both the kingdoms they will be in Square shaped land.
// Land occupied by the kingdoms, indiacted with 1's and the river, indiacted with 0's.

// Now, Pandavas and Kauravas decided to build a bridge on the river for easy 
// connectivity. As the cost of building a bridge will be high, they have decided 
// to reduce the length of the bridge. You are allowed to build the bridge on 
// the river cells, connected by 4 directions only (up, down,left,right).

// Your task is to help the Kings, to minimize the occupation of river cells, 
// to build the bridge with minimum cost. And return the count of river cells occupied.

// Input Format:
// -------------
// Line-1: An integer N, size of the land.
// Next N lines: N space separated integers, either 0 or 1. 

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 4
// 1 1 1 0
// 1 0 0 0
// 1 0 0 1
// 0 0 1 1

// Sample Output-1:
// ----------------
// 2


// Sample Input-2:
// ---------------
// 5
// 1 1 0 0 0
// 1 1 0 0 0
// 0 0 0 0 1
// 0 0 0 1 1
// 0 0 1 1 1

// Sample Output-2:
// ----------------
// 3


import java.util.*;

class MinimumCostToBuildBridge
{
    public static void markKingdom(int kingdom[][], int n, int whatToKeep, int i, int j)
    {
        kingdom[i][j]=whatToKeep;
        
        if(i-1>=0 && kingdom[i-1][j]==1)
        {
            markKingdom(kingdom,n,whatToKeep,i-1,j);
        }
        if(i+1<n && kingdom[i+1][j]==1)
        {
            markKingdom(kingdom,n,whatToKeep,i+1,j);
        }
        if(j-1>=0 && kingdom[i][j-1]==1)
        {
            markKingdom(kingdom,n,whatToKeep,i,j-1);
        }
        if(j+1<n && kingdom[i][j+1]==1)
        {
            markKingdom(kingdom,n,whatToKeep,i,j+1);
        }
    }
    
    public static int getMinimumBridgeDistance(int kingdom[][], int n)
    {
        int whatToKeep=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(kingdom[i][j]==1)
                {
                    whatToKeep++;
                    // HashSet<Integer> visited=new HashSet<Integer>();
                    markKingdom(kingdom,n,whatToKeep,i,j);
                }
            }
        }
        
        Queue<Integer> queue=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<Integer>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(kingdom[i][j]==2)
                {
                    queue.add(i*n+j);
                    visited.add(i*n+j);
                }
            }
        }
        
        int bridgeDistance=0;
        mainWhile: while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                int curr=queue.poll();
                int currI=curr/n;
                int currJ=curr%n;
                if(kingdom[currI][currJ]==3)
                {
                    break mainWhile;
                }
                
                if(currI-1>=0 && !visited.contains((currI-1)*n+currJ))
                {
                    visited.add((currI-1)*n+currJ);
                    queue.add((currI-1)*n+currJ);
                }
                if(currI+1<n && !visited.contains((currI+1)*n+currJ))
                {
                    visited.add((currI+1)*n+currJ);
                    queue.add((currI+1)*n+currJ);
                }
                if(currJ-1>=0 && !visited.contains(currI*n+currJ-1))
                {
                    visited.add(currI*n+currJ-1);
                    queue.add(currI*n+currJ-1);
                }
                if(currJ+1<n && !visited.contains(currI*n+currJ+1))
                {
                    visited.add(currI*n+currJ+1);
                    queue.add(currI*n+currJ+1);
                }
            }
            bridgeDistance++;
        }
        
        // Return distance-1 because the source is inclusive of bridge length
        // So we have to remove it
        return bridgeDistance-1;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int kingdom[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                kingdom[i][j]=sc.nextInt();
            }
        }
        
        int minBridgeDistance=getMinimumBridgeDistance(kingdom,n);
        System.out.println(minBridgeDistance);
        
    }
}
