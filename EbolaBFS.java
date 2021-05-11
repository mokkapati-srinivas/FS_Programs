// A dangerous virus "ebola" is spreading across african countries.
// Few people stand in a form of p*q grid, some positions in the grid are empty.

// The grid is represented with three values 0,1, 2.
// Where
// 	- 0 indicates an empty position,
// 	- 1 indiactes a healthy person , or
// 	- 2 indiactes an infected person.
	
// Every minute, any healthy person who is 4-directionally adjacent to an infected 
// person becomes infected.

// Your task is to find out the minimum amount of time in minutes that the virus 
// takes to spread among all the people in that grid.

// If this is impossible, return -1.

// NOTE:
// 4-directions are Up, Down, Left, Right.

// Input Format:
// -------------
// Line-1: Two integers P and Q, size of the grid.
// Next P lines: contains Q space separated integers, either 0, 1, or 2.

// Output Format:
// --------------
// An integer, the minimum amount of time in minutes


// Sample Input-1:
// ---------------
// 3 3
// 2 1 1
// 1 1 0
// 0 1 1

// Sample Output-1:
// ----------------
// 4

// Explanation-1:
// --------------
// There is an infected person at position (0, 0).
// In the first minute: people in (0, 1) and (1, 0) positions are infected.
// In the second minute: people in (0, 2) and (1, 1) positions are infected.
// In the third minute: person in (1, 2) position is infected.
// In the fourth minute: person in (2, 2) position is infected.


// Sample Input-2:
// ---------------
// 3 3
// 2 1 1
// 0 1 1
// 1 0 1

// Sample Output-2:
// ----------------
// -1

// Explanation-2:
// --------------
// The healthy person in the bottom left corner (row 2, column 0) is never infected, 
// because infection only happens 4-directionally.

// Sample Input-3:
// ---------------
// 1 2
// 0 2

// Sample Output-3:
// ----------------
// 0

// Explanation-3: 
// -------------
// Since there is already no healthy person at minute 0, the answer is just 0.

import java.util.*;
class EbolaBFS
{
    
    public static int BFS(int mat[][], int p, int q, Queue<Integer> start)
    {
        int i,j;
        int noOfMin=0;
        boolean flag=false;
        Queue<Integer> queue=start;
        int size=queue.size();
        while(!queue.isEmpty())
        {
            flag=false;
            size=queue.size();
            while(size-->0)
            {
                int front=queue.poll();
                i=front/q;
                j=front%q;
                if(i-1>=0 && mat[i-1][j]==1)
                {
                    mat[i-1][j]=2;
                    queue.add((q*(i-1)+j));
                    flag=true;
                }
                if(i+1<p && mat[i+1][j]==1)
                {
                    mat[i+1][j]=2;
                    queue.add((q*(i+1)+j));
                    flag=true;
                }
                if(j-1>=0 && mat[i][j-1]==1)
                {
                    mat[i][j-1]=2;
                    queue.add((q*i+j-1));
                    flag=true;
                }
                if(j+1<q && mat[i][j+1]==1)
                {
                    mat[i][j+1]=2;
                    queue.add((q*i+j+1));
                    flag=true;
                }
            }
            if(flag==true)
            {
                noOfMin++;
            }
        }
        
        for(i=0;i<p;i++)
        {
            for(j=0;j<q;j++)
            {
                if(mat[i][j]==1)
                {
                    return -1;
                }
            }
        }
        
        return noOfMin;
        
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int q=sc.nextInt();
        int mat[][]=new int[p][q];
        Queue<Integer> start=new LinkedList<Integer>();
        for(int i=0;i<p;i++)
        {
            for(int j=0;j<q;j++)
            {
                mat[i][j]=sc.nextInt();
                if(mat[i][j]==2)
                {
                    start.add(i*q+j);
                }
            }
        }
        
        int res=BFS(mat,p,q,start);
        System.out.println(res);
        
    }
}

