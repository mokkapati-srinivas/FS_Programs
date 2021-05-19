// May - 19

// Chitti built a mini robot 'Tiny', which is used to transform
// the given string S into a target string T.

// Tiny is allowed to perform the given steps to transform S into T:
// 	- Add a letter to S at any place.
// 	- Remove any letter from S.
// 	- Substitute a letter in S with another letter.

// Your task is to write a program for Tiny to transform S into T
// in minimum number of steps. and return the count of steps.

// Input Format:
// -------------
// Two space separated strings S and T, consist of lowercase letters only.

// Output Format:
// --------------
// Print an integer, minimum number of steps required to transform S into T.


// Sample Input-1:
// ---------------
// energy synergy

// Sample Output-1:
// ----------------
// 2

// Explanation:
// -----------
// energy -> senergy (add 's')
// senergy -> synergy (substitute 'y' in place of 'e')


// Sample Input-2:
// ---------------
// treatment basement

// Sample Output-2:
// ----------------
// 5

// Explanation:
// -----------
// treatment -> tretment (remove 'a')
// tretment -> trement (remove 't')
// trement -> arement (substitute 'a' in place of 't')
// arement -> asement (substitute 's' in place of 'r')
// asement -> basement (add 'b')

import java.util.*;

class MinimumStepsToTransformString
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String source=sc.next();
        String target=sc.next();
        int slen=source.length();
        int tlen=target.length();
        
        int dp[][]=new int[slen+1][tlen+1];
        for(int i=0;i<=slen;i++)
        {
            dp[i][0]=i;
        }
        for(int j=0;j<=tlen;j++)
        {
            dp[0][j]=j;
        }
        for(int i=1;i<=slen;i++)
        {
            for(int j=1;j<=tlen;j++)
            {
                char schar=source.charAt(i-1);
                char tchar=target.charAt(j-1);
                if(schar==tchar)
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    int replace=dp[i-1][j-1]+1;
                    int insert=dp[i][j-1]+1;
                    int remove=dp[i-1][j]+1;
                    dp[i][j]=Math.min(replace,Math.min(insert,remove));
                }
            }
        }
        
        System.out.println(dp[slen][tlen]);
    }
}