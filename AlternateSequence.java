// Problem Statement:


// In a theatre, there are N people stand in a line for tickets, 
// male represented with 1 and female represented with 0.

// Theater management decides to issue the tickets in such a way that
// if one ticket issued to a male, next ticket should be issued to a female only, 
// and vice versa.

// In order to follow it, they planned to make few alterations in the line itself, 
// so that no two adjacent persons have same gender.
 
// You are given a binary string S, represents intial order of the people in the line.
// In one alteration, you can replace one female '0' with a  male '1' or vice versa.

// Your task to find and print the minimum number of alterations needed 
// to make the line to follow alternate gender sequence.

// Input Format:
// -------------
// A binary String, S.

// Output Format:
// --------------
// Print an integer, minimum number of alterations.


// Sample Input-1:
// ---------------
// 1001

// Sample Output-1:
// ----------------
// 2


// Sample Input-2:
// ---------------
// 101101

// Sample Output-2:
// ----------------
// 3

import java.util.*;
class AlternateSequence
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        char flag='1';
        int res1=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!=flag)
            {
                res1++;
            }
            if(flag=='1')
            {
                flag='0';
            }
            else
            {
                flag='1';
            }
        }
        flag='0';
        int res2=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!=flag)
            {
                res2++;
            }
            if(flag=='1')
            {
                flag='0';
            }
            else
            {
                flag='1';
            }
        }
        
        System.out.println(Math.min(res1,res2));
    }
}

