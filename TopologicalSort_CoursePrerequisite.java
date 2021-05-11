// A graduate at University of China (UoC) has to follow certain rules. The rules are as follows:

// UoC offering K subjects, the subjects are indexed from 0 to K-1.
// Some subjets have to follow the conditions, like condition[i]= [Xi, Yi] which specifies you must
// take the subject Yi before the subject Xi.

// You are given total number of subjects and a list of the condition pairs.
// Return the ordering of subjects that a graduate should take to finish all subjects.
// 	- the result set should follow the given order of conditions.
// 	- If it is impossible to complete all subjects, return an empty set.

// Input Format:
// -------------
// Line-1: An integer K, number of subjects.
// Line-2: An integer C, number of conditions.
// Next C lines: Two space separated integers, Xi and Yi.

// Output Format:
// --------------
// Return a list of integers, the ordering of subjects that a graduate should take to finish all subjects


// Sample Input-1:
// ---------------
// 4
// 3
// 1 2
// 3 0
// 0 1

// Sample Output-1:
// ----------------
// [2, 1, 0, 3]

// Explanation-1:
// --------------
// There are a total of 4 courses to take. 
// Subject 1  should be taken after you finished subject 2.
// Subject 3  should be taken after you finished subject 0.
// Subject 0  should be taken after you finished subject 1.
// So the correct subject order is [2, 1, 0, 3].

// Sample Input-2:
// ---------------
// 5
// 5
// 0 1
// 1 2
// 2 3
// 3 4
// 4 0

// Sample Output-2:
// ----------------
// []

// Explanation-2:
// -------------
// No subject can be completed because they depend on each other.


// DFS Code:
// import java.util.*;
// class TopologicalSort
// {
//     static int UNVISITED=0;
//     static int EXPLORING=1;
//     static int DONE=2;
//     public static boolean dfs(int visited[], int node, HashMap<Integer,ArrayList<Integer>> adj, Stack<Integer> stack)
//     {
//         if(visited[node]==EXPLORING)
//         {
//             return true;
//         }
//         if(visited[node]==DONE)
//         {
//             return false;
//         }
//         visited[node]=EXPLORING;
//         for(int neigh:adj.get(node))
//         {
//             if(dfs(visited,neigh,adj,stack))
//             {
//                 return true;
//             }
//         }
//         visited[node]=DONE;
//         stack.push(node);
//         return false;
//     }
//     public static boolean hasCycle(int visited[], int k, HashMap<Integer,ArrayList<Integer>> adj, Stack<Integer> stack)
//     {
//         for(int i=0;i<k;i++)
//         {
//             if(visited[i]==UNVISITED && dfs(visited,i,adj,stack))
//             {
//                 return true;
//             }
//         }
//         return false;
//     }
//     public static void main(String args[])
//     {
//         Scanner sc=new Scanner(System.in);
//         int k=sc.nextInt();
//         int c=sc.nextInt();
//         HashMap<Integer,ArrayList<Integer>> adj=new HashMap<Integer,ArrayList<Integer>>();
//         for(int i=0;i<k;i++)
//         {
//             adj.put(i,new ArrayList<Integer>());
//         }
//         for(int i=0;i<c;i++)
//         {
//             int x=sc.nextInt();
//             int y=sc.nextInt();
//             // y is the prerequisite of x
//             ArrayList<Integer> temp=adj.get(y);
//             temp.add(x);
//             adj.put(y,temp);
//         }
//         int visited[]=new int[k];
//         Stack<Integer> stack=new Stack<Integer>();
//         ArrayList<Integer> res=new ArrayList<Integer>();
//         if(hasCycle(visited,k,adj,stack))
//         {
//             System.out.println(res);
//         }
//         else
//         {
//             while(!stack.isEmpty())
//             {
//                 res.add(stack.pop());
//             }
//             System.out.println(res);
//         }
//     }
// }


import java.util.*;
public class TopologicalSort_CoursePrerequisite {
    
    public static boolean kahnsAlgo(int indegree[], HashMap<Integer,TreeSet<Integer>> adj, ArrayList<Integer> res, int k)
    {
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<k;i++)
        {
            if(indegree[i]==0)
                queue.add(i);
        }
        int count=0;
        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            for(int neigh:adj.get(curr))
            {
                indegree[neigh]--;
                if(indegree[neigh]==0)
                    queue.add(neigh);
            }
            res.add(curr);
            count++;
        }
        if(count!=k)
            return false;
        return true;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int c=sc.nextInt();
        HashMap<Integer,TreeSet<Integer>> adj=new HashMap<Integer,TreeSet<Integer>>();
        for(int i=0;i<k;i++)
        {
            adj.put(i,new TreeSet<Integer>());
        }
        int indegree[]=new int[k];
        for(int i=0;i<c;i++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            // y is the prerequisite of x
            TreeSet<Integer> temp=adj.get(y);
            temp.add(x);
            adj.put(y,temp);
            indegree[x]++;
        }
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(kahnsAlgo(indegree, adj, res, k))
        {
            System.out.println(res);
        }
        else
        {
            System.out.println("[]");
        }

    }
}
