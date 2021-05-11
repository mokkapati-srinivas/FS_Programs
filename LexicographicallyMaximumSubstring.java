// Problem Statement:


// For this challenge, a substring is defined as any contiuous group of one or more 
// characters of a string. For example, the unique substrings of "baca" are [b, ba, 
// bac, baca, a, ac, aca, c ,ca] . The list in alphabetical order is [a, ac, aca, b, 
// ba, bac, baca, c, ca]. in this case, the maximum substrin, alphabetically, is 'ca'.

// Given a string s, determine its maximum substring.

// Your task is to design a function, that return the maximum substring of s.

// NOTE:
// String s contains only lowercase alphabets.

// Input Format:
// -------------
// A string, s

// Output Format:
// --------------
// print a string, maximum substring.


// Sample Input-1:
// ---------------
// baca

// Sample Output-1:
// ----------------
// ca


// Sample Input-2:
// ---------------
// banana

// Sample Output-2:
// ----------------
// nana


import java.util.*;
class MaximumSubString
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        
        char maxi='a';
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char curr=s.charAt(i);
            if(curr>maxi)
            {
                maxi=curr;
            }
        }
        
        String result="A";
        String temp="";
        for(int i=n-1;i>=0;i--)
        {
            char curr=s.charAt(i);
            temp=curr+temp;
            if(curr==maxi)
            {
                if(result.compareTo(temp)<0)
                {
                    result=temp;
                }
            }
        }
        
        System.out.println(result);
    }
}

