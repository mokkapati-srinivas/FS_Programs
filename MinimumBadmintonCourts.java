// Problem Statement:

// KMIT hosting a Keshav Memorial Badminton League. 
// They planned to conduct N number of games. Each game begin and ends in perticular time slot.

// You are given an array of time slots of the N games, consisting of
// begin and end times (b1,e1),(b2,e2),... (b < e ).
// Your task is to determine minimum number of badminton courts required 
// to conduct all the games smoothly.

// NOTE: If a game begins at time 'a' ends at time 'b', 
// another game can start at 'b'.

// Input Format:
// -------------
// Line-1: An integer N, number of games.
// Next N lines: Two space separated integers, begin and end time of each game.

// Output Format:
// --------------
// Print an integer, minimum number of badminton courts required.


// Sample Input-1:
// ---------------
// 3
// 0 30
// 5 10
// 15 20

// Sample Output-1:
// ----------------
// 2

// Sample Input-2:
// ---------------
// 3
// 0 10
// 15 25
// 25 35

// Sample Output-2:
// ----------------
// 1

import java.util.*;
class MinimumBadmintonCourts
{
    
    public static int partition(int arr[], int start, int end)
    {
        int pindex=start;
        int pivot=arr[end];
        int temp=0;
        for(int i=start;i<end;i++)
        {
            if(arr[i]<=pivot)
            {
                temp=arr[i];
                arr[i]=arr[pindex];
                arr[pindex]=temp;
                pindex++;
            }
        }
        
        temp=arr[end];
        arr[end]=arr[pindex];
        arr[pindex]=temp;
        
        return pindex;
    }
    
    public static void quickSort(int arr[],int start, int end)
    {
        if(start<end)
        {
            int pindex=partition(arr,start,end);
            quickSort(arr,start,pindex-1);
            quickSort(arr,pindex+1,end);
        }
        else
        {
            return;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int start[]=new int[n];
        int end[]=new int[n];
        for(int i=0;i<n;i++)
        {
            start[i]=sc.nextInt();
            end[i]=sc.nextInt();
        }
        
        quickSort(start,0,n-1);
        quickSort(end,0,n-1);
        
        int minCourts=0;
        int maxEndTimeInSpecificCourt=0;
        for(int i=0;i<n;i++)
        {
            if(start[i]<end[maxEndTimeInSpecificCourt])
            {
                minCourts++;
            }
            else
            {
                maxEndTimeInSpecificCourt++;
            }
        }
        
        System.out.println(minCourts);
    }
}

