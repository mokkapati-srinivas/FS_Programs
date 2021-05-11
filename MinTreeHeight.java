// Problem Statement:


// Thomas constructing a Tree of N nodes, nodes labelled as 0, 1, 2, .. ,n-1.
// He is given a list of N-1 edges[], where edge[i]=[v1, v2], is an undirected edge
// between v1 and v2.

// He can construct the tree by selecting any node as root node.
// You task is to find out the trees with the smallest height, among all the trees.

// Print the root nodes of all the smallest height trees in ascending order.

// NOTE: A Tree,is a connected graph without simple cycles.

// Input Format:
// -------------
// Line-1: An integer N, number of nodes.
// Next N-1 lines: Two integers, represent an edge.

// Output Format:
// --------------
// Print the list of root nodes of Smallest Height Trees.
// In ascending order

// Sample Input-1:
// ---------------
// 4
// 0 1
// 2 1
// 1 3

// Sample Output-1:
// ----------------
// [1]

// Explanation:
// -------------

// Tree Combinations are.

// 	   0					     1			
// 	   |					   / | \
// 	   1					  0  2  3
// 	 /  \
// 	2    3
	
// 	   2					  	   3			
// 	   |					   	   |
// 	   1					   	   1
// 	 /  \					 	 /   \
// 	0    3 			    			0     2



// Sample Input-2:
// ---------------
// 6
// 3 0
// 1 3
// 3 2
// 4 3
// 5 4

// Sample Output-2:
// ----------------
// [3, 4]

import java.util.*;

class MinTreeHeight
{
    public int height;
    MinTreeHeight()
    {
        this.height=0;
    }
    public void DFS(int v,int count, HashMap<Integer,ArrayList<Integer>> adj, int[] visited)
    {
        int flag=0;
        visited[v]=1;
        for(int u:adj.get(v))
        {
            if(visited[u]==0)
            {
                flag=1;
                visited[u]=1;
                DFS(u,count+1,adj,visited);
            }
        }
        
        if(flag==0)
        {
            height=Math.max(height,count);
        }
        
        return;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
            adj.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<n-1;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            ArrayList<Integer> temp1=adj.get(a);
            temp1.add(b);
            ArrayList<Integer> temp2=adj.get(b);
            temp2.add(a);
            adj.put(a,temp1);
            adj.put(b,temp2);
        }
        
        // System.out.println(adj);
        int visited[]=new int[n];
        ArrayList<Integer> nodesheight=new ArrayList<Integer>();
        MinTreeHeight mh;
        int minheight=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            Arrays.fill(visited,0);
            mh=new MinTreeHeight();
            mh.DFS(i,0,adj,visited);
            nodesheight.add(mh.height);
            minheight=Math.min(minheight,mh.height);
        }
        
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            if(nodesheight.get(i)==minheight)
                res.add(i);
        }
        
        System.out.println(res);
    }
}
