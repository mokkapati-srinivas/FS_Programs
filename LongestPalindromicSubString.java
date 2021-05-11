// Problem Statement:

// Mr. James professor of at Illinois state university, as a part of assignment he created a
// problem statement related to strings.
// He gave a String S, and asked them to design a method to 
// return the longest substring in S, which is a palindrome.

// NOTE: Alphabets are case sensitive
// "Aa" is not considered a palindrome here.

// Input Format:
// -------------
// A string S, consist of lowercase/uppercase letters or/and digits

// Output Format:
// --------------
// Print a string, longest palindrome substring.


// Sample Input-1:
// ---------------
// abbbabbcbbacdb

// Sample Output-1:
// ----------------
// abbcbba


// Sample Input-2:
// ---------------
// thedivideriswide

// Sample Output-2:
// ----------------
// edivide

import java.util.*;
class LongestPalindromicSubString
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        int maxi=0;
        int maxj=0;
        
        dp[n-1][n-1]=true;
        for(int i=0;i<n-1;i++)
        {
            dp[i][i]=true;
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1]=true;
                maxi=i;
                maxj=i+1;
            }
            else
                dp[i][i+1]=false;
        }
        
        int row=0,col=0;
        for(int j=2;j<n;j++)
        {
            row=0;
            col=j;
            while(row<n && col<n)
            {
                if(s.charAt(row)==s.charAt(col))
                {
                    dp[row][col]=dp[row+1][col-1];
                    if(dp[row][col]==true)
                    {
                        maxi=row;
                        maxj=col;
                    }
                }
                else
                {
                    dp[row][col]=false;
                }
                row++;
                col++;
            }
        }
        
        System.out.println(s.substring(maxi,maxj+1));
    }
}

