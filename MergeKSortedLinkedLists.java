// Problem Statement:

// In South Central Railways, There are N Railway Tracks,
// Each Railway track passing through a set of stations, each station indicated 
// with positive integer.

// You are given K railway-tracks information, with the stations number list of 
// each track in ascending order.

// Your task is to return the merged list of station numbers of all tracks together


// NOTE: Your task is to implement mergeKTracks() given in Solution Class.

//     Method Signature:
//     -----------------
//         public ListNode mergeKTracks(ListNode[] tracks)

// Input Format:
// -------------
// Line-1: AN integer K, number of railway tracks
// Next K lines: space separated of integrs, numbers of stations in each track.

// Output Format:
// --------------
// Print the list of merged station numbers of all tracks.


// Sample Input-1:
// ---------------
// 3
// 1 2 3 4
// 2 4 8
// 2 3 7 11

// Sample Output-1:
// ----------------
// 1 2 2 2 3 3 4 4 7 8 11



// Sample Input-2:
// ---------------
// 3
// 1 3 8 10
// 2 5 8 9
// 3 5 6 8 10

// Sample Output-2:
// ----------------
// 1 2 3 3 5 5 6 8 8 8 9 10 10


Solution:

import java.util.*;
/*
Singly Linked List
class ListNode{
    // Members of the class are:
    int val;    // station number
    ListNode next;  // next station
}

*/

class MergeKSortedLinkedLists {
    // Implement mergeKLists method	
	public ListNode mergeKTracks(ListNode[] tracks) {
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>((a,b)->a.val-b.val);
        
        int k=tracks.length;
        for(int i=0;i<k;i++)
        {
            queue.add(tracks[i]);
        }
        
        ListNode head=null,tail=null;
        while(!queue.isEmpty())
        {
            ListNode curr=queue.poll();
            if(head==null)
            {
                head=curr;
                tail=curr;
            }
            else
            {
                tail.next=curr;
                tail=curr;
            }
            if(curr.next!=null)
            {
                queue.add(curr.next);
            }
        }
        
        return head;
	}
}	
