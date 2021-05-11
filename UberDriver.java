// Problem Statement:


// UBER driver has a vehicle, daily he used go in only one direction.
// Capacity of the vehicle is S (no of seats except driver seat), 

// Given a list of N bookings, booking[i]= [ num_customers, pickup, drop ].
// booking indicates, number of customers to pick up, and pick up, droping points.

// Initially the vehicle is empty.

// Return true if and only if it is possible to pick up and drop off all customers 
// of all bookings.

// Input Format:
// -------------
// Line-1 -> Two integers N and S, number of bookings and number of seats in the vehicle.
// Next N Lines -> three space separated integers, num_customers, pickup point, 
//                 dropping point

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 2 5
// 2 1 5
// 3 3 7

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 2 4
// 2 1 5
// 3 3 7

// Sample Output-2:
// ----------------
// false


// Sample Input-3:
// ---------------
// 3 11
// 3 2 7
// 3 7 9
// 8 3 9

// Sample Output-3:
// ----------------
// true


import java.util.*;
class UberDriver
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int passengers[][]=new int[n][3];
        int minTime=Integer.MAX_VALUE;
        int maxTime=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<3;j++)
            {
                passengers[i][j]=sc.nextInt();
            }
            minTime=Math.min(minTime,passengers[i][1]);
            maxTime=Math.max(maxTime,passengers[i][2]);
        }
        
        int rushAtGivenTime[]=new int[maxTime+1];
        for(int i=0;i<n;i++)
        {
            for(int j=passengers[i][1];j<passengers[i][2];j++)
            {
                rushAtGivenTime[j]+=passengers[i][0];
            }
        }
        
        int flag=0;
        for(int i=minTime;i<=maxTime;i++)
        {
            if(rushAtGivenTime[i]>s)
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
    }
}

