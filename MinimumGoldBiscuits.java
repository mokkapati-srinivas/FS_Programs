// M.P.Ahammed the founder of Malbar Gold and Diamonds merchant, announced an offer
// that they will charge the minimum amount to make all the gold-biscuits into one.

// Sharvan a gold supplier has different weighed gold-biscuits with him.
// He wants to utilize the offer.

// The processing charge to make two biscuits into one is calculated as follows:
// 	- To make two biscuits of weights A and B into one biscuit, 
// 	you have to pay the amount 'A + B'. 

// Your task is to help M.P.Ahammed to keep his promise and 
// to charge the minimum amount to make Mr. Shravan's gold-biscuits 
// into one gold-biscuit.

// Input Format:
// -------------
// Single line of space separated integers, number on the boxes.

// Output Format:
// --------------
// Print an integer, minimum amount to be paid by Mr Shravan.



// Sample Input-1:
// ---------------
// 4 3 6

// Sample Output-1:
// ----------------
// 45


// Sample Input-2:
// ---------------
// 5 2 4 3 6

// Sample Output-2:
// ----------------
// 45


import java.util.*;
class MinimumGoldBiscuits
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String inp[]=sc.nextLine().split(" ");
        int n=inp.length;
        
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
        for(int i=0;i<n;i++)
        {
            queue.add(Integer.parseInt(inp[i]));
        }
        
        int res=0;
        while(queue.size()>1)
        {
            int a=queue.poll();
            int b=queue.poll();
            int temp=a+b;
            res+=temp;
            queue.add(temp);
        }
        
        System.out.println(res);
    }
}
