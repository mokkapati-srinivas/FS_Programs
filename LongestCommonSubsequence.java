
// Problem Statement:


// Vihaan is given a pair of words likely word1 and word2, 
// he is asked to create a method which returns the numbers of characters in a word 
// formed from long lasting frequent posteriority.

// Posteriority is the word formed from the original word with few characters removed
// without modifying the corresponding order of the left over characters.

// Find the longest common posteriority of two words.
// Return 0 if no common posteriority.

// Input Format:
// -------------
// Two space separated strings S1, S2.

// Output Format:
// --------------
// Print an integer, the length of longest common prosperity.


// Sample Input-1:
// ---------------
// abcde ace

// Sample Output-1:
// ----------------
// 3


// Sample Input-2:
// ---------------
// acd bef

// Sample Output-2:
// ----------------
// 0


import java.util.*;
class LongestCommonSubsequence
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String word1=sc.next();
        String word2=sc.next();
        
        int l1=word1.length();
        int l2=word2.length();
        int dp[][]=new int[l1+1][l2+1];
        
        for(int i=0;i<l1+1;i++)
        {
            dp[i][0]=0;
        }
        for(int j=0;j<l2+1;j++)
        {
            dp[0][j]=0;
        }
        
        for(int i=1;i<l1+1;i++)
        {
            for(int j=1;j<l2+1;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        System.out.println(dp[l1][l2]);
    }
}

