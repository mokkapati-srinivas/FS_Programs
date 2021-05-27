// May - 27

// Bharath is given a set of integers arr[] of length N.
// He planned split arr[] into four subsets.

// He also defined a rule set to split the set arr[] as follows:
// 	- select three indices p, q, r, where p < q < r.
// 	- split the arr[] as four subsets: sub(0, p-1), sub(p+1, q-1) sub(q+1, r-1), sub(r+1, N-1)
// 	- the sum of elements in each subset should be equal .
// 	  i.e., subsum(0, p-1) = subsum(p+1, q-1) = subsum(q+1, r-1) = subsum(r+1, N-1)

// Your task is to help Bharath to split the set arr[] with the above rules,
// If you are able to satisfy all the rules , return true. Otherwise, false.


// Input Format:
// -------------
// Line-1 -> An integer N, number of array elements
// Line-2 -> N space separated integers, elements of the array.

// Output Format:
// --------------
// Print an boolean result.


// Sample Input-1:
// ---------------
// 10
// 2 6 1 7 2 7 8 7 7 0

// Sample Output-1:
// ----------------
// false


// Sample Input-2:
// ---------------
// 10
// 3 3 4 1 5 4 2 4 5 6

// Sample Output-2:
// ----------------
// true

// Explanation:
// --------------
// p = 2, q = 5, r = 8.
// subsum(0, i - 1) = subsum(0, 1) = 6
// subsum(i + 1, j - 1) = subsum(3, 4) = 6
// subsum(j + 1, k - 1) = subsum(6, 7) = 6
// subsum(k + 1, n - 1) = subsum(9) = 6


import java.util.*;

class SplitArrayInto4PartsWithEqualSum
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        
        int prefixSum[]=new int[n+1];
        int sum=0;
        for(int i=0;i<n+1;i++)
        {
            prefixSum[i]=sum;
            if(i!=n)
                sum+=arr[i];
        }
        
        boolean result=false;
        for(int p=0;p<n-2;p++)
        {
            int pDiff=prefixSum[p];
            
            int q=p+1;
            boolean pFlag=false;
            while(q<n-1)
            {
                if(prefixSum[q]-prefixSum[p+1]==pDiff)
                {
                    pFlag=true;
                    break;
                }
                q++;
            }
            
            int r=q+1;
            boolean qFlag=false;
            while(r<n)
            {
                if(prefixSum[r]-prefixSum[q+1]==pDiff)
                {
                    qFlag=true;
                    break;
                }
                r++;
            }
            
            boolean rFlag=false;
            if(r+1<n && prefixSum[n]-prefixSum[r+1]==pDiff)
            {
                rFlag=true;
            }
            
            if(pFlag && qFlag && rFlag)
            {
                result=true;
                break;
            }
        }
        System.out.println(result);
    }
}