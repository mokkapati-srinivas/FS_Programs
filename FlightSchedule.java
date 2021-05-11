// Gopal would like to go on Tour, and planned a schedule.
// Airport authority has created a new way of issuing tickets.
// Gopal purchased a set of airline tickets, 
// each ticket contains the 'departure from' and 'arrival to'.

// Redesign the Gopal's tour schedule in an order.
// Gopal intially must begin his tour from BZA.
// Hence the tour schedule's start point should begin with BZA. 

// You are given a list of flight tickets which Gopal has purchased.
// Your task is to find out and return the tour schedule that has the least lexical order.
// Gopal must use all the tickets once and only once.

// Note:
// ------
// If there are multiple valid schedules, you should return the schedule 
// that has the smallest lexical order when read as a single string. 
// For example, the schedule ["BZA", "LGA"] has a smaller lexical order than ["BZA", "LGB"].

// All airports are represented by three capital letters.
// You may assume all tickets form at least one valid schedule.

// Input Format:
// -------------
// Single Line of tickets separated by comma, and each ticket separated by space, 
// Gopal's flight tickets.

// Output Format:
// --------------
// Print the schedule, which is smallest lexical order of tour schedule.


// Sample Input-1:
// ----------------
// DEL HYD,BZA DEL,BLR MAA,HYD BLR

// Sample Output-1:
// --------------------
// [BZA, DEL, HYD, BLR, MAA]


// Sample Input-2:
// ------------------
// BZA BLR,BZA CCU,BLR CCU,CCU BZA,CCU BLR

// Sample Output-2:
// ------------------
// [BZA, BLR, CCU, BZA, CCU, BLR]


import java.util.*;
class FlightSchedule
{
    public static boolean isVisited(HashMap<String,Integer> visited)
    {
        for(String key:visited.keySet())
        {
            if(visited.get(key)==0)
                return false;
        }
        return true;
    }
    public static boolean dfs(HashMap<String,TreeSet<String>> adj, HashMap<String,Integer> visited, String node, ArrayList<String> res)
    {
        
        res.add(node);
        if(adj.get(node)!=null)
        {
            for(String neigh:adj.get(node))
            {
                String nn=node+" "+neigh;
                if(visited.get(nn)==0)
                {
                    visited.put(nn,1);
                    if(dfs(adj,visited,neigh,res))
                        return true;
                    visited.put(nn,0);
                }
            }
        }
        if(isVisited(visited))
        {
            return true;
        }
        
        res.remove(res.size()-1);
        return false;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String inp[]=sc.nextLine().split(",");
        int n=inp.length;
        
        HashMap<String,TreeSet<String>> adj=new HashMap<String,TreeSet<String>>();
        for(String pair:inp)
        {
            String cities[]=pair.split(" ");
            if(adj.get(cities[0])==null)
            {
                adj.put(cities[0],new TreeSet<String>());
            }
            TreeSet<String> temp=adj.get(cities[0]);
            temp.add(cities[1]);
            adj.put(cities[0],temp);
        }
        HashMap<String,Integer> visited=new HashMap<String,Integer>();
        for(int i=0;i<n;i++)
        {
            visited.put(inp[i],0);
        }
        ArrayList<String> res=new ArrayList<String>();
        if(dfs(adj,visited,"BZA",res))
        {
            System.out.println(res);
        }
        else
        {
            System.out.println("[]");
        }
    }
}
