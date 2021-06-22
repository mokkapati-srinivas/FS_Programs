// June - 22

// In a school, there are N students in a class numbered from 1,2,3..N.
// During the play time in school, drill master wants to split them into 
// two teams based on their interest.

// If the pair of students want to play opposite each other, drill master should 
// put them in different teams, e.g. pair[i] = (A,B), it is not allowed to 
// put A and B in same team.
 
// You need to find out wether is it possible to put everyone into two teams or not
// return true if it is possible, otherwise false.

// Input Format:
// ----------------
// Line-1 -> Two Integers, N and P, number of students N, number of pairs P.
// Next P lines -> Two integers, one pair[i], where 'i' is from 0 to P-1

// Output Format:
// ------------------
// Print a boolean result.


// Sample Input-1:
// -------------------
// 5 4
// 1 2
// 1 3
// 2 4
// 3 5

// Sample Output-1:
// ---------------------
// true

// Explanation: 
// ----------------
// team1 [1,4,5], team2 [2,3]


// Sample Input-2:
// -------------------
// 5 5
// 1 2
// 2 3
// 3 4
// 4 5
// 1 5

// Sample Output-2:
// ---------------------
// false


import java.util.*;

class DivideIntoTwoTeams
{
    
    public static boolean isSafe(int color, int curr, HashMap<Integer,ArrayList<Integer>> adj, int colors[])
    {
        for(int neigh: adj.get(curr))
        {
            if(colors[neigh]==color)
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isPossibleToSplit(int curr, int n, HashMap<Integer,ArrayList<Integer>> adj, int colors[])
    {
        if(curr==n+1)
        {
            return true;
        }
        
        for(int c=1;c<=2;c++)
        {
            if(isSafe(c,curr,adj,colors))
            {
                colors[curr]=c;
                boolean next=isPossibleToSplit(curr+1,n,adj,colors);
                if(next==true)
                {
                    return true;
                }
                colors[curr]=0;
            }
        }
        
        return false;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=1;i<=n;i++)
        {
            adj.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<p;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        int colors[]=new int[n+1];
        boolean result=isPossibleToSplit(1,n,adj,colors);
        System.out.println(result);
    }
}