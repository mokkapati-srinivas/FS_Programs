// May - 24

// There is a fresh veggies farm on top of a hill,
// The farmer has built a 3-colored steps to reach his farm on top of the hill.
// There are 3-lanes from ground to the hill top, i.e., each color will represent a lane.
// There are N steps, and step-0 is the ground, and step-n is the top of the hill.

// There is a rabbit in search of fresh veggies to eat, and knows about the farm 
// on top of the hill. The rabbit starts to climb the steps in the middle lane 
// from step-0, one after the other. There are few gates arranged on each lane and 
// the gates are locked. If the rabbit found a gate on the next step, it has to move 
// to the adjacent lane of the same step, and if the adjacent lane also has a gate 
// on same step, the rabbit can jump over the gate to reach the lane which is not 
// adjacent. There will be at most one gate on each step.

// The rabbit cannot jump over the gate on the next step.

// You will be given positions of the gates as gates[] array of size N+1,
// Your task is to find out the minimum number of jump overs, 
// the rabbit needs to reach step-n the top of the hill in any lane starting from middle lane to step-0. 

// NOTE:
// 	- gates[a]=b means there is a gate in lane-b, on step-a.
// 	- gates[3]=2 means there is a gate in lane-2, on step-3.
// 	- gates[2]=0 means there is no gate on step-2.
// 	- there are no gates on step-0 and step-n.
	
// Input Format:
// -------------
// Line-1: An integer N, number of steps built.
// Line-2: N+1 space separated integers, gates[i] is between [0-3]

// Output Format:
// --------------
// Print an integer, minimum number of jump overs.


// Sample Input-1:
// ---------------
// 5
// 0 2 1 3 3 0

// Sample Output-1:
// ----------------
// 2


// Sample Input-2:
// ---------------
// 5
// 0 3 1 1 3 0

// Sample Output-2:
// ----------------
// 0


import java.util.*;

class RabbitClimbing
{
    
    public static int getMinimumJumps(int n, int obstacles[], int dp[][], int currStep, int currLane)
    {
        if(currStep==n-1)
        {
            return 0;
        }
        
        if(dp[currStep][currLane]!=0)
        {
            return dp[currStep][currLane];
        }
        
        int result=Integer.MAX_VALUE;
        for(int i=1;i<=3;i++)
        {
            if(obstacles[currStep]!=i && obstacles[currStep+1]!=i)
            {
                if(i==currLane)
                {
                    result=Math.min(result,getMinimumJumps(n,obstacles,dp,currStep+1,i));
                }
                else
                {
                    result=Math.min(result,1+getMinimumJumps(n,obstacles,dp,currStep+1,i));
                }
            }
        }
        
        dp[currStep][currLane]=result;
        
        return dp[currStep][currLane];
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int obstacles[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            obstacles[i]=sc.nextInt();
        }
        
        int dp[][]=new int[n+1][4];
        int result=getMinimumJumps(n+1,obstacles,dp,0,2);
        System.out.println(result);
    }
}