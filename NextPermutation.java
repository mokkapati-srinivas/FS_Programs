// Problem Statement:

// You are given a list of digits( 0 to 9) digits[].
// A number is formed using the given order of the list.
// for example: given list is [1,3,2], then number is 132.

// Find the next biggest number in the lexographic order using 
// the same list of digits, by using the each digit in the list only once,
// and print the digit list of such biggest number.

// If such biggest number is not possible, 
// print the smallest lexographic order of the digits.

// Input Format:
// -------------
// Line-1 : An integer N, number of digits.
// Line-2 : N space separated integers, list of digits.

// Output Format:
// --------------
// Print an integer list.


// Sample Input-1:
// ---------------
// 4
// 1 2 4 3

// Sample Output-1:
// ----------------
// [1, 3, 2, 4]


// Sample Input-2:
// ---------------
// 4
// 4 3 2 1

// Sample Output-2:
// ----------------
// [1, 2, 3, 4]

import java.util.*;
class NextPermutation
{
    
    public static void swap(int digits[], int i, int j)
    {
        int temp=digits[i];
        digits[i]=digits[j];
        digits[j]=temp;
    }
    
    public static void reverse(int digits[], int i, int j)
    {
        while(i<j)
        {
            swap(digits,i,j);
            i++;
            j--;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int digits[]=new int[n];
        for(int i=0;i<n;i++)
        {
            digits[i]=sc.nextInt();
        }
        
        int i=n-2;
        while(i>=0 && digits[i]>=digits[i+1])
        {
            i--;
        }
        if(i>=0)
        {
            int j=n-1;
            while(j>=0 && digits[j]<=digits[i])
            {
                j--;
            }
            swap(digits,i,j);
        }
        reverse(digits,i+1,n-1);
        
        System.out.println(Arrays.toString(digits));
        
    }
}

