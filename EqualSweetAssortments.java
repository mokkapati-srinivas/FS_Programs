// Problem Statement:

// Mr. Ayyangar is a Sweet Seller, packed N boxes of assorted sweets with 
// different weights. The weights are given as an array WoB[] [0-indexed]. 
// He got 4 orders from Ajay, Vijay, Ramesh and Suresh.
// And each of them ordered equal amounts of assorted sweets.

// Now Mr. Ayyangar, cannot open the boxes as they are already packed.
// He has to divide the N boxes into 4 sets as follows:
// (0, p-1),  (p+1,q-1), (q+1, r-1), (r+1,N-1), in such a way that, 
// total weight of each set should be equal. Each set indicates index values.

// Now your task is to help Mr Ayyangar, to divide the N boxes of assorted sweets 
// as mentioned above. If it is possible to form the sets with equal weights, 
// print "true". Otherwise, print "false".


// Input Format:
// -------------
// Line-1: An integer, N number of boxes.
// Line-2: N space separated integers, WoB[].

// Output Format:
// --------------
// Print a boolean result.


// Sample Input-1:
// ---------------
// 10
// 3 3 4 1 5 4 2 4 5 6

// Sample Output-1:
// ----------------
// true

// Explanation:
// ------------
// p=2, q=5, r=8
// Totalweights of set-1 (0,1) : WoB[0] + WoB[1] = 6
// Totalweights of set-2 (3,4) : WoB[3] + WoB[4] = 6
// Totalweights of set-3 (6,7) : WoB[6] + WoB[7] = 6
// Totalweights of set-4 (9) : WoB[9] = 6
// So, it is possible to divide the N boxes.

// Sample Input-2:
// ---------------
// 10
// 2 6 1 7 2 7 8 7 7 1

// Sample Output-2:
// ----------------
// false


import java.util.*;

class EqualSweetAssortments
{
    public static boolean isPossible(int n, int wob[])
    {
        int prefixSum[]=new int[n+1];
        int sum=0;
        for(int i=1;i<=n;i++)
        {
            sum+=wob[i-1];
            prefixSum[i]=sum;
        }
        
        for(int p=1;p<n;p++)
        {
            int pSum=prefixSum[p];
            
            int q=p+1;
            boolean qFlag=false;
            int qSum=0;
            while(q<n)
            {
                qSum+=wob[q];
                q++;
                if(qSum==pSum)
                {
                    qFlag=true;
                    break;
                }
            }
            
            int r=q+1;
            boolean rFlag=false;
            int rSum=0;
            while(r<n)
            {
                rSum+=wob[r];
                r++;
                if(rSum==pSum)
                {
                    rFlag=true;
                    break;
                }
            }
            
            int s=r+1;
            boolean sFlag=false;
            int sSum=0;
            while(s<n)
            {
                sSum+=wob[s];
                s++;
            }
            if(sSum==pSum)
            {
                sFlag=true;
            }
            
            if(qFlag && rFlag && sFlag)
            {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int wob[]=new int[n];
        for(int i=0;i<n;i++)
        {
            wob[i]=sc.nextInt();
        }
        
        boolean result=isPossible(n,wob);
        System.out.println(result);
    }
}

