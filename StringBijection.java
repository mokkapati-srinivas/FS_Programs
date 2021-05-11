// Problem Statement:


// Given two strings S1 and S2, find if S2 can match S1 or not.

// A match that is both one-to-one (an injection) and onto (a surjection), 
// i.e. a function which relates each letter in string S1 to a separate and 
// distinct non-empty substring in S2, where each non-empty substring in S2 
// also has a corresponding letter in S1.

// Return true,if S2 can match S1.
// Otherwise false.

// Input Format:
// -------------
// Line-1 -> Two strings S1 and S2

// Output Format:
// --------------
// Print a boolean value as result.


// Sample Input-1:
// ---------------
// abab kmitngitkmitngit

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// aaaa kmjckmjckmjckmjc

// Sample Output-2:
// ----------------
// true

// Sample Input-3:
// ---------------
// aabb xyzabcxyzabc

// Sample Output-3:
// ----------------
// false

import java.util.*;
class StringBijection
{
    static HashMap<Character,String> map=new HashMap<Character,String>();
    public static boolean bijectionMatch(String s1, String s2, int s1Ind, int s2Ind)
    {
        if(s1Ind==s1.length() && s2Ind==s2.length())
        {
            return true;
        }
        if(s1Ind==s1.length() || s2Ind==s2.length())
        {
            return false;
        }
        
        char curr=s1.charAt(s1Ind);
        if(map.get(curr)!=null)
        {
            String str=map.get(curr);
            if(s2Ind+str.length()>s2.length() || !s2.substring(s2Ind,s2Ind+str.length()).equals(str))
            {
                return false;
            }
            else
            {
                return bijectionMatch(s1,s2,s1Ind+1,s2Ind+str.length());
            }
        }
        else
        {
            for(int i=s2Ind;i<s2.length();i++)
            {
                map.put(curr,s2.substring(s2Ind,i+1));
                if(bijectionMatch(s1,s2,s1Ind+1,i+1))
                {
                    return true;
                }
            }
            map.remove(curr);
        }
        
        return false;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        
        boolean result=bijectionMatch(s1,s2,0,0);
        System.out.println(result);
    }
}

