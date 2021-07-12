// Problem Statement:


// Gnanesh Varma is working in a laddus factory.
// There are N number of boxes placed in a row, and the boxes are numbered 
// from 0,1,2,...,N-1. And you will be asked to find the number fo laddus in 
// the box at a given position 'I', in such a way that, the sum of all the laddus 
// in all the boxes should be less than 'Total'.

// Gnanesh Varma has to fill the laddus in the boxes in the row 
// with the following conditions:
// 	- box[k] is a contains the laddus in the rane of [0, N-1].
// 	- The diffrence of laddus between two consecutive boxes is
// 	diff(box[k] - box[k+1]) <= 1 where k is in range of [0, N-1]. 
// 	- Number of laddus in box[I], should be maximized.

// Your task is to help Mr Gnanesh Varma, to maximize the number of laddus in Box-I.
// and return the count of laddus in Box-I.

// Input Format:
// -------------
// Three space separated integers, N, I, Total.

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 5 2 10

// Sample Output-1:
// ----------------
// 3

// Explanation: 
// ------------
// box[] = {1,2,3,2,2} is one such arrangement that follows all the conditions.
// another arrangement can be : {1,2,3,2,1}
// So, the maximum number of laddus in Box-2 is 3.

// Sample Input-2:
// ---------------
// 6 4 14

// Sample Output-2:
// ----------------
// 4


import java.util.*;

class MaximumLaddusAtAnIndex
{
    
    public static boolean isPossible(long laddusAtIndex, long n, long index, long totalLaddus)
    {
        long sum=laddusAtIndex;
        
        long temp=laddusAtIndex;
        for(long i=index+1;i<n;i++)
        {
            if(temp!=1)
            {
                temp=temp-1;
            }
            sum+=temp;
        }
        
        temp=laddusAtIndex;
        for(long i=index-1;i>=0;i--)
        {
            if(temp!=1)
            {
                temp=temp-1;
            }
            sum+=temp;
        }
        
        if(sum<=totalLaddus)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long index=sc.nextLong();
        long totalLaddus=sc.nextLong();
        
        long left=0;
        long right=totalLaddus;
        long result=0;
        while(left<=right)
        {
            long mid=(left+right)/2;
            if(isPossible(mid,n,index,totalLaddus))
            {
                result=mid;
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        System.out.println(right);
    }
}

