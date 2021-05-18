// May - 18

// Amith decided go on a holiday trip. 
// Given a map of N holiday spots numbered 0,1,2,.. N-1, map shows the connecting routes
// between the holiday sopts, the routes are bidirectional, and
// the connecting routes are indicates as routes[i] = [from , to , distance ]. 
// He can travel only a certian distance D.

// Your task is to find the holiday spot H with the smallest number of holiday spots
// that are reachable from H and whose distance is at most D, 

// If there are multiple holiday spots, return H with the greatest number.


// Input Format:
// -------------
// Line-1 : Three integers, N number of holiday spots, R is the number of connecting 
//         routes and D is the distance can travel.
// Next R lines : Three space separated integers, from , to and distance.

// Output Format:
// --------------
// Print an integer, holiday spot.


// Sample Input-1:
// ---------------
// 4 4 4
// 0 1 3
// 1 2 1
// 1 3 4
// 2 3 1

// Sample Output-1:
// ----------------
// 3


// Explanation:
// ------------
// Distance can travel= 4,

// From			Reachable sopts
// -------------------------------------
// Holiday-spot 0 -> [Holiday-spot 1, Holiday-spot 2] 
// Holiday-spot 1 -> [Holiday-spot 0, Holiday-spot 2, Holiday-spot 3] 
// Holiday-spot 2 -> [Holiday-spot 0, Holiday-spot 1, Holiday-spot 3] 
// Holiday-spot 3 -> [Holiday-spot 1, Holiday-spot 2] 

// Holiday-spots 0 and 3 have 2 reachable Holiday-spots at a distance = 4, 
// but we have to return Holiday-spot 3 since it has the greatest number.


// Sample Input-2:
// ---------------
// 5 6 2
// 0 1 2
// 0 4 8
// 1 2 3
// 1 4 2
// 2 3 1
// 3 4 1

// Sample Output-2:
// ----------------
// 0

// Explanation:
// ------------
// Distance can travel= 2,

// From			Reachable sopts
// -------------------------------------
// Holiday-spot 0 -> [Holiday-spot 1] 
// Holiday-spot 1 -> [Holiday-spot 0, Holiday-spot 4] 
// Holiday-spot 2 -> [Holiday-spot 3, Holiday-spot 4] 
// Holiday-spot 3 -> [Holiday-spot 2, Holiday-spot 4]
// Holiday-spot 4 -> [Holiday-spot 1, Holiday-spot 2, Holiday-spot 3]

// Holiday-spots 0 has 1 reachable Holiday-spot at a distance = 2, 


import java.util.*;

class HolidaySpotsTravel
{
    
    public static void findValidSpots(int from, int to, HashMap<Integer,ArrayList<Integer>> spots, HashMap<String,Integer> distance, HashMap<Integer,TreeSet<Integer>> validSpots, Stack<Integer> visited, int currDist, int targetDist)
    {
        visited.push(to);
        if(currDist!=0)
        {
            validSpots.get(from).add(to);
        }
        
        ArrayList<Integer> neighbours=spots.get(to);
        for(int neigh:neighbours)
        {
            int dist=distance.get(to+" "+neigh);
            if(!visited.contains(neigh) && currDist+dist<=targetDist)
            {
                findValidSpots(from,neigh,spots,distance,validSpots,visited,currDist+dist,targetDist);
            }
        }
        
        visited.pop();
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        int d=sc.nextInt();
        
        HashMap<Integer,ArrayList<Integer>> spots=new HashMap<Integer,ArrayList<Integer>>();
        HashMap<String,Integer> distance=new HashMap<String,Integer>();
        for(int i=0;i<n;i++)
        {
            spots.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<r;i++)
        {
            int from=sc.nextInt();
            int to=sc.nextInt();
            int dist=sc.nextInt();
            spots.get(from).add(to);
            distance.put(from+" "+to,dist);
            spots.get(to).add(from);
            distance.put(to+" "+from,dist);
        }
        
        HashMap<Integer,TreeSet<Integer>> validSpots=new HashMap<Integer,TreeSet<Integer>>();
        for(int i=0;i<n;i++)
        {
            validSpots.put(i,new TreeSet<Integer>());
            Stack<Integer> visited=new Stack<Integer>();
            findValidSpots(i,i,spots,distance,validSpots,visited,0,d);
        }
        
        int minSize=Integer.MAX_VALUE;
        int result=0;
        for(int i=0;i<n;i++)
        {
            int size=validSpots.get(i).size();
            if(size!=0 && size<=minSize)
            {
                minSize=size;
                result=i;
            }
        }
        System.out.println(result);
        
    }
}