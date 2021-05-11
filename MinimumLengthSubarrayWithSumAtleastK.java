// Problem Statement:

// There is a game builder with a display board, it was designed in such a way that 
// It will show a set of random numbers in a row on top of display and in the
// bottom of the diaplay shows a random sum S. 

// A player need to select the numbers from display, such a way that it accepts only
// smallest non-empty linear set of numbers and thier sum should be atleast S.

// Your task is to help the player to find the length of the smallest 
// non empty linear set from the display, with sum at least S. 

// If we don’t have such non empty linear set, then print -1.

// NOTE: Numbers on the diplay are both +ve and -ve.

// Input Format:
// -------------
// Line-1: Two integers, N and S.
// Line-2: N space separated integers, numbers diaplyed on the display.

// Output Format:
// --------------
// Print an integer, Length of non-empty smallest linear set.


// Sample Input-1:
// ---------------
// 8 6
// 2 -5 4 -1 3 -2 4 -3

// Sample Output-1:
// ----------------
// 3


// Sample Input-1:
// ---------------
// 4 3
// -1 2 -1 2

// Sample Output-1:
// ----------------
// 3


import java.util.*;
class MinimumSubarrayWithSumAtleastK
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int prefix[]=new int[n+1];
        prefix[0]=0;
        for(int i=1;i<n+1;i++)
        {
            prefix[i]=arr[i-1]+prefix[i-1];
        }
        int minlen=Integer.MAX_VALUE;
        Deque<Integer> queue=new ArrayDeque<Integer>();
        for(int i=0;i<n+1;i++)
        {
            while(!queue.isEmpty() && prefix[i]-prefix[queue.getFirst()]>=k)
            {
                minlen=Math.min(minlen,i-queue.getFirst());
                queue.removeFirst();
            }
            while(!queue.isEmpty() && prefix[i]<prefix[queue.getLast()])
            {
                queue.removeLast();
            }
            queue.add(i);
        }
        if(minlen!=Integer.MAX_VALUE)
            System.out.println(minlen);
        else
            System.out.println(-1);
    }
}
