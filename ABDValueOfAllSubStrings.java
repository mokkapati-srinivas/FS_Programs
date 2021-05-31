// May - 31

// Sumanth has an idea to calculate the ABD value of a string.
// An ABD value is defined as the absolute diffrence between
// the most occurance count of a charcter and the least occurance count 
// of another character in the given string.

// Sumanth is given a string S,
// He wants to find out, the sum of ABD values of all the substrings of S,
// where ABD > 0.

// Your task is to help Sumanth to find total ABD value of substrings of S.

// Input Format:
// -------------
// A String S

// Output Format:
// --------------
// Print an integer, sum of ABD of all the strings of S


// Sample Input-1:
// ---------------
// abbcc

// Sample Output-1:
// ----------------
// 5

// Explanation: 
// ------------
// The substrings with non-zero ABD are as follows:
// Substring and ABD value -> "abb"-1,"abbc"-1,"abbcc"-1,"bbc"-1,"bcc"-1
// The total sum of ABD is, 5


// Sample Input-2:
// ---------------
// abcbabc

// Sample Output-2:
// ----------------
// 15

// Explanation: 
// ------------
// The substrings with non-zero ABD are as follows:
// substring and ABD value -> "abcb"-1,"abcba"-1,"abcbab"-2,"abcbabc"-1,"bcbabc"-2
// "bcbab"-2, "bcba"-1, "bcb"-1, "cbab"-1,"cbabc"-1,"bab"-1, "babc"-1.
// The total sum of ABD is, 15

import java.util.*;

class ABDValueOfAllSubStrings
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        
        int result=0;
        for(int i=0;i<n;i++)
        {
            HashMap<Character,Integer> frequency=new HashMap<Character,Integer>();
            for(int j=i;j<n;j++)
            {
                int count=frequency.getOrDefault(s.charAt(j),0);
                frequency.put(s.charAt(j),count+1);
                int maxFreq=Integer.MIN_VALUE;
                int minFreq=Integer.MAX_VALUE;
                for(char key: frequency.keySet())
                {
                    maxFreq=Math.max(maxFreq,frequency.get(key));
                    minFreq=Math.min(minFreq,frequency.get(key));
                }
                result+=maxFreq-minFreq;
            }
        }
        
        System.out.println(result);
    }
}