// Problem Statement:

// Kiran is given a string S, and an integer N.
// Kiran wants to find the longest substring which has following properties:
// 	- the substring of S should be maximum in length, and 
// 	- should contains atmost N distint characters in it.
	
// Can you help Kiran to find the longest substring 'ls' with above properties,
// and return the length of the substring 'ls'.

// Input Format:
// -------------
// Line-1: A string S
// Line-2: An integer N, number of distinct characters.

// Output Format:
// --------------
// Print an integer, lenth of longest substring with atmost N distinct characters.


// Sample Input-1:
// ---------------
// philippines
// 3

// Sample Output-1:
// ----------------
// 6

// Sample Input-2:
// ---------------
// abaccdbcca
// 2

// Sample Output-2:
// ----------------
// 3

import java.util.*;

class LongestSubstringWithAtmostKChars
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int len=s.length();
        int n=sc.nextInt();
        
        int i=0;
        int j=0;
        int frequency[]=new int[26];
        int characters=0;
        int ls=Integer.MIN_VALUE;
        while(i<len)
        {
            int curr=(int)s.charAt(i)-97;
            if(frequency[curr]==0)
            {
                characters++;
            }
            frequency[curr]++;
            while(j<i && characters>n)
            {
                int charj=(int)s.charAt(j)-97;
                if(frequency[charj]==1)
                {
                    frequency[charj]=0;
                    characters--;
                    j++;
                    break;
                }
                else
                {
                    frequency[charj]--;
                    j++;
                }
            }
            ls=Math.max(ls,i-j+1);
            i++;
        }
        System.out.println(ls);
    }
}
