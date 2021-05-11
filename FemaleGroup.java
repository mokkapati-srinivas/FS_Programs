// Problem Statement:


// Few people standing in row, where male candidates are represented with 0 and 
// Female with 1. We are given any random number ‘R’ such that ‘R’ values of males
// need to be replaced with female at certain positions in such a way that we can
// form longest female continuous group given in a row.

// Your task is to help to form the longest female continuous group 
// in the row and print the length of it.

// Input Format:
// -------------
// Line-1: Two integers N and R, number of people and R.
// Line-2: N space separated integers, [0, 1] only.

// Output Format:
// --------------
// Print the length of longest female group.

// Sample Input-1:
// ---------------
// 10 3
// 1 0 1 1 1 0 0 0 1 0

// Sample Output-1:
// ----------------
// 7

// Sample Input-2:
// ---------------
// 14 2
// 1 1 1 1 0 0 1 1 1 1 1 0 1 1 0

// Sample Output-2:
// ----------------
// 11

import java.util.*;

class FemaleGroup
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int k=r;
        int j=0;
        int maxlen=Integer.MIN_VALUE;
        int i=0;
        for(i=0;i<n;i++)
        {
            // System.out.println(maxlen);
            if(arr[i]==0)
            {
                k--;
            }
            if(k==-1)
            {
                maxlen=Math.max(maxlen,i-j);
                while(arr[j]==1)
                {
                    j++;
                }
                j+=1;
                k+=1;
            }
        }
        if(arr[n-1]==1)
            maxlen=Math.max(maxlen,i-j);
        
        System.out.println(maxlen);
        
    }
}

