// Problem Statement:

// EA Sports, developed a video game.
// They designed a game in such a way that, there are L number of levels from 1 to L.
// There are D number of dependencies where each dependency[m] = [ Xm, Ym ], 
// represents a prerequisite relationship, that is, in order to play level-Ym,  
// you must have completed the level-Xm . 

// In one day you can complete any number of levels as long as you have completed 
// all the prerequisites levels in the game. 

// You cannont play a level-Ym which has some prerequisite level-Xm on same day.

// Write a method to return the minimum number of days to complete all the levels 
// in the game. If there is no way to complete all the levels, return -1.


// Input Format:
// -------------
// Line-1: An integer L, number of levels.
// Line-2: An integer D, number of dependencies.
// Next D lines: Two space separated integers, Xm and Ym.

// Output Format:
// --------------
// An integer, the minimum number of days to complete all the levels in the game.


// Sample Input-1:
// ---------------
// 3
// 2
// 1 3
// 2 3

// Sample Output-1:
// ----------------
// 2

// Explanation-1:
// --------------
// On the first day, levels 1 and 2 are completed. 
// On the second day, level 3 is completed.


// Sample Input-2:
// ---------------
// 3
// 3
// 1 2
// 2 3
// 3 1

// Sample Output-2:
// ----------------
// -1

// Explanation-2:
// -------------
// No level can be completed because they depend on each other.


import java.util.*;
public class EASportsCompleteGame {
    static int count=0;
    public static boolean kahnsAlgo(HashMap<Integer,TreeSet<Integer>> dep, int indegree[], int l)
    {
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<l;i++)
        {
            if(indegree[i]==0)
            {
                queue.add(i);
            }
        }
        int nodesprocessed=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            while(size-->0)
            {
                int curr=queue.poll();
                for(int neigh:dep.get(curr))
                {
                    indegree[neigh]--;
                    if(indegree[neigh]==0)
                        queue.add(neigh);
                }
                nodesprocessed++;
            }
            count++;
        }
        if(nodesprocessed!=l)
            return false;
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt();
        int d=sc.nextInt();
        int indegree[]=new int[l];
        HashMap<Integer,TreeSet<Integer>> dep=new HashMap<Integer,TreeSet<Integer>>();
        for(int i=0;i<l;i++)
        {
            dep.put(i,new TreeSet<Integer>());
        }
        for(int i=0;i<d;i++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            TreeSet<Integer> temp=dep.get(x-1);
            temp.add(y-1);
            dep.put(x-1,temp);
            indegree[y-1]++;
        }
        if(kahnsAlgo(dep,indegree,l))
        {
            System.out.println(count);
        }
        else
        {
            System.out.println(-1);
        }
    }    
}
