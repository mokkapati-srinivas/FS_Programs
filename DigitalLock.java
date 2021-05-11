// Problem Statement:


// A device is secured with a digital lock, 
// The digital lock is made up of a 3*3 grid like below:
// | 1 | 2 | 3 |
// | 4 | 5 | 6 |
// | 7 | 8 | 9 |

// The lock is secured by creating pattern using the above grid.
// A valid pattern as formed as follows:

// Rules for a valid pattern:
// 	- Each pattern must connect at least m keys and at most n keys.
// 	- All the keys must be distinct.
// 	- If the line connecting two consecutive keys in the pattern passes through 
// 	  any other keys, the other keys must have already the part of the pattern. 
// 	  No jumps through a key which is not part of the pattern is allowed.
// 	- The order of keys used matters.
 
// You will be given two integers m and n, where 1 ≤ m ≤ n ≤ 9, 
// Your task is to count the total number of patterns of the device lock, 
// which consist of minimum of m keys and maximum n keys. 

// Examples of valid and invalid patterns:
// 	Invalid move: 4 - 1 - 3 - 6
// 	Line 1 - 3 passes through key 2 which had not been part of the pattern.

// 	Invalid move: 4 - 1 - 9 - 2
// 	Line 1 - 9 passes through key 5 which had not been part of the pattern.

// 	Valid move: 2 - 4 - 1 - 3 - 6
// 	Line 1 - 3 is valid because it passes through key 2, which had been part 
// 	of the pattern

// 	Valid move: 6 - 5 - 4 - 1 - 9 - 2
// 	Line 1 - 9 is valid because it passes through key 5, which had been part 
// 	of the pattern

// Input Format:
// -------------
// Two space separated integers M and N.

// Output Format:
// --------------
// Print an integer, number of valid patterns formed using the grid.


// Sample Input-1:
// ---------------
// 1 1

// Sample Output-1:
// ----------------
// 9


// Sample Input-2:
// ---------------
// 1 2

// Sample Output-2:
// ----------------
// 65

import java.util.*;

class DigitalLock
{
    
    public static int noOfPatterns(int m, int n)
    {
        int possible[][]=new int[10][10];
        possible[1][3]=possible[3][1]=2;
        possible[1][7]=possible[7][1]=4;
        possible[1][9]=possible[9][1]=5;
        possible[2][8]=possible[8][2]=5;
        possible[3][7]=possible[7][3]=5;
        possible[3][9]=possible[9][3]=6;
        possible[4][6]=possible[6][4]=5;
        possible[7][9]=possible[9][7]=8;
        
        boolean visited[]=new boolean[10];
        
        int result=0;
        result+=4*DFS(1,1,0,m,n,possible,visited);
        result+=4*DFS(2,1,0,m,n,possible,visited);
        result+=DFS(5,1,0,m,n,possible,visited);
        
        return result;
    }
    
    public static int DFS(int curr,int length, int count, int m, int n, int possible[][], boolean visited[])
    {
        if(length>=m)
        {
            count++;
        }
        
        visited[curr]=true;
        for(int next=1;next<=9;next++)
        {
            if(length+1<=n)
            {
                int jump=possible[curr][next];
                if(visited[next]==false && (jump==0 || visited[jump]==true))
                {
                    count=DFS(next,length+1,count,m,n,possible,visited);
                }
            }
        }
        visited[curr]=false;
        
        return count;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        
        int result=noOfPatterns(m,n);
        System.out.println(result);
    }
}
