// Problem Statement:

// A Frog is on Land at position-0 and trying to reach the lake at position-P.
// There are N traps on the land given as Traps[], where Traps[i] is the position
// of a trap.

// The frog can jump from it's current position to F steps forward (to right) or 
// B steps backward (to left). Te frog cannot to consecutive backward jumps.
// The frog should avoid to jump on the position trap[i], where trap[i] is +ve integer.
// The frog cannot jump if the position value < 0, but can jump beyond the Lake position.


// Your task is to find the minimum number of jumps needed by the frog to reach 
// the lake. If it is possible to reach the lake return no.of jumps, 
// Otherwise return -1.

// Input Format:
// -------------
// Line-1: Four space separated integers, N, F, B, P.
// Line-2: N space separated integers, Traps[].

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 5 4 9 7
// 11 5 14 16 6

// Sample Output-1:
// ----------------
// 5

// Explanation:
// ------------
// 3 forward jumps starts from, 0 to 4, 4 to 8, 8 to 12
// 1 backward jump from,12 to 3.
// 1 forward jump from, 3 to 7.


// Sample Input-2:
// ---------------
// 6 3 5 13
// 2 5 16 11 19 23

// Sample Output-2:
// ----------------
// 7


// Sample Input-3:
// ---------------
// 6 3 5 13
// 2 7 15 18 17 23

// Sample Output-3:
// ----------------
// -1


import java.util.*;

class FrogAndTraps
{
    public static int findNoOfSteps(HashSet<Integer> traps, int f, int b, int p)
    {
        LinkedList<ArrayList<Integer>> queue=new LinkedList<>();
        ArrayList<Integer> initial=new ArrayList<Integer>();
        // In each in queue it contains current position, either can go backward
        // can go backward - 1, cannot go backward - 0 and minimumSteps till that step
        initial.add(0);
        initial.add(1);
        initial.add(0);
        queue.add(initial);
        
        HashSet<Integer> visited=new HashSet<Integer>(traps);
        
        while(!queue.isEmpty())
        {
            // System.out.println(queue);
            ArrayList<Integer> front=queue.poll();
            int currPos=front.get(0);
            int canGoBackward=front.get(1);
            int minSteps=front.get(2);
            
            if(currPos==p)
            {
                return minSteps;
            }
            
            if(visited.contains(currPos))
            {
                continue;
            }
            visited.add(currPos);
            
            int forward=currPos+f;
            int backward=currPos-b;
            
            if(canGoBackward==1 && backward>=0 && !visited.contains(backward))
            {
                ArrayList<Integer> curr=new ArrayList<Integer>();
                curr.add(backward);
                curr.add(0);
                curr.add(minSteps+1);
                queue.add(curr);
            }
            
            if(forward<10000 && !visited.contains(forward))
            {
                ArrayList<Integer> curr=new ArrayList<Integer>();
                curr.add(forward);
                curr.add(1);
                curr.add(minSteps+1);
                queue.add(curr);
            }
        }
        
        return -1;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int f=sc.nextInt();
        int b=sc.nextInt();
        int p=sc.nextInt();
        HashSet<Integer> traps=new HashSet<Integer>();
        for(int i=0;i<n;i++)
        {
            traps.add(sc.nextInt());
        }
        
        int result=findNoOfSteps(traps,f,b,p);
        System.out.println(result);
    }
}
