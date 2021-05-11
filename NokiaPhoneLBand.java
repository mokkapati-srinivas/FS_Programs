// Problem Statement:

// Given a nokia phone,with the following dialpad.
// 		1 2 3
// 		4 5 6
// 		7 8 9
// 		* 0 #
// And You are given an L band to dial the number,  
// Using the L band you can dial the number as follows, 
// You can start with any digit,
// 	if you are at digit 1, next digit you can choose {6,8}
// 	if you are at digit 2, next digit you can choose {7,9}
// 	if you are at digit 3, next digit you can choose {4,8}
// 	and so on..

// Now your task is to find how many distinct numbers of length N you can dial.

// Note: Numbers should contain only digits, {* , #} -> not allowed.
// Answer should be modulo 1000000007.

// Input Format:
// -----------------
// An integer N, length of numbers
 
// Output Format:
// ------------------
// Print an integer, number of distinct numbers you can dial.


// Sample Input-1:
// ---------------
// 1

// Sample Output-1:
// ----------------
// 10

// Explanation:
// -------------
// To dial a number of length 1, you can dial all digits.


// Sample Input-2:
// ---------------
// 2

// Sample Output-2:
// ----------------
// 20

// Explanation:
// ------------
// To dial a number of length 2, the possible numbers are
// {04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94}

// Sample Input-3:
// ---------------
// 5

// Sample Output-3:
// ----------------
// 240


import java.util.*;

class NokiaPhoneLBand
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        if(n==1)
        {
            System.out.println(10);
        }
        else
        {
            long prev[]=new long[10];
            long curr[]=new long[10];
            long mod=1000000007;
            for(int i=0;i<=9;i++)
            {
                prev[i]=1;
            }
            for(int i=1;i<n;i++)
            {
                curr[0]=(prev[4]%mod+prev[6]%mod)%mod;
                curr[1]=(prev[6]%mod+prev[8]%mod)%mod;
                curr[2]=(prev[7]%mod+prev[9]%mod)%mod;
                curr[3]=(prev[4]%mod+prev[8]%mod)%mod;
                curr[4]=(prev[0]%mod+prev[3]%mod+prev[9]%mod)%mod;
                curr[5]=0;
                curr[6]=(prev[0]%mod+prev[1]%mod+prev[7]%mod)%mod;
                curr[7]=(prev[2]%mod+prev[6]%mod)%mod;
                curr[8]=(prev[1]%mod+prev[3]%mod)%mod;
                curr[9]=(prev[2]%mod+prev[4]%mod)%mod;
                for(int j=0;j<=9;j++)
                {
                    prev[j]=curr[j];
                }
            }
            
            long result=0;
            for(int i=0;i<=9;i++)
            {
                result=(result%mod+prev[i]%mod)%mod;
            }
            System.out.println(result);
        }
    }
}
