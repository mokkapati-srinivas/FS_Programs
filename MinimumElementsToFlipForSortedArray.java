// Problem Statement:


// Suryakantam is a sweets seller, famous for motichoor laddus.
// Sanath Nagar Sathi is a foodie, so he bought a set of laddu packets from Suryakantam.
// No two laddu packets have same number of laddus.
// Sathi has placed all the laddu packets in a row.

// You are given initial arrangement of laddu packets, 
// Sanath Nagar Sathi wants to arrange all the laddu packets in ascending order.
// Few laddu packets are already in sorted order at beginning and/or 
// end of the arranement.

// Your task is to help Sanath Nagar Sathi to find out the minimum number of packets need 
// to be sorted in a sequence to make overall arrangement of packets in ascending order.


// Input Format:
// -------------
// Line-1: An integer N , number of laddu packets.
// Line-2: N space separated integers, number of laddus in each packet.

// Output Format:
// --------------
// Print an integer, length of the subset of the arrangement.


// Sample Input-1:
// ---------------
// 10
// 5 6 16 11 8 13 15 18 19 20

// Sample Output-1:
// ----------------
// 5


// Sample Input-2:
// ---------------
// 6
// 5 6 8 13 15 18 

// Sample Output-2:
// ----------------
// 0

import java.util.*;
class SanathNagarSathi
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int unsorted[]=new int[n];
        int sorted[]=new int[n];
        for(int i=0;i<n;i++)
        {
            unsorted[i]=sc.nextInt();
            sorted[i]=unsorted[i];
        }
        Arrays.sort(sorted);
        int start=n,end=-1;
        for(int i=0;i<n;i++)
        {
            if(sorted[i]!=unsorted[i])
            {
                start=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            if(sorted[i]!=unsorted[i])
            {
                end=i;
                break;
            }
        }
        if(start<=end)
        {
            System.out.println((end-start+1));
        }
        else
        {
            System.out.println(0);
        }
    }
}

