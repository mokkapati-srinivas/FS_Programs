// Problem Statement:

// There are pair of words namely W1 and W2 with a limited of word range, 
// Create a method to return a true value if W2 contains the anagram of W1. 
// In additional, one of the anagram of first word is the substring of the second word.

// Your task is to implement the Solution class, and implement a method in it, 
// 	- public boolean checkPalindromeSubstring(String w1, String w2){}.

// Input Format:
// -------------
// Two space separated words w1 and w2, consist of lowercase letters only.

// Output Format:
// --------------
// Print a boolean value, if W2 contains the anagram of W1 or not.


// Sample Input-1:
// ---------------
// abbcbb abbbabbcb

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// abbcbbc abbbabbcb

// Sample Output-2:
// ----------------
// false

import java.util.*;
class Solution
{
    
    public int computeHash(int ht,int currchar, int firstcharofht)
    {
        return ht-firstcharofht+currchar;
    }
    
    public boolean checkSubstring(String w1,String w2)
    {
        int alphatext[]=new int[26];
        int alphapat[]=new int[26];
        Arrays.fill(alphatext,0);
        Arrays.fill(alphapat,0);
        int lt=w2.length();
        int lp=w1.length();
        if(lt>=lp)
        {
            int hp=0;
            for(int i=0;i<lp;i++)
            {
                hp+=((int)w1.charAt(i))-96;
            }
            int ht=0;
            for(int i=0;i<lp-1;i++)
            {
                ht+=((int)w2.charAt(i))-96;
            }
            // System.out.println(ht);
            int firstcharofht=0;
            int currchar=0;
            int flag=0;
            int i=lp-1;
            while(i<lt)
            {
                flag=0;
                currchar=((int)w2.charAt(i))-96;
                // System.out.println(currchar);
                // System.out.println(firstcharofht);
                ht=computeHash(ht,currchar,firstcharofht);
                // System.out.println(ht);
                if(ht==hp)
                {
                    for(int j=i-lp+1;j<=i;j++)
                    {
                        alphatext[(int)w2.charAt(j)-97]++;
                        alphapat[(int)w1.charAt(j-i+lp-1)-97]++;
                    }
                    for(int j=0;j<26;j++)
                    {
                        if(alphatext[j]!=alphapat[j])
                        {    
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0){
                        return true;
                    }
                }
                firstcharofht=((int)w2.charAt(i-lp+1))-96;
                Arrays.fill(alphatext,0);
                Arrays.fill(alphapat,0);
                i++;
            }
            return false;
        }
        else
        {
            return false;
        }
    }
}

