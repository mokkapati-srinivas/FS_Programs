// May - 31

// Sampoornesh Babu is working with Strings.
// He is trying to form a palindrome using two strings P and Q.
// The rules to form the palindrome are as follows:
// 	- Divide the strings P and Q into two parts, and length of P and Q are same.
// 	- Division of P and Q should be done at same index position.
// 	- After Division P -> P1 + P2 and Q -> Q1 + Q2, where + indicates concatenation.
// 	- Now, check whether P1 + Q2 or Q1 + P2 forms a palindrome or not.
// 	- if palindrome is formed print 'true', otherwise 'false'. 

// For Example: 'job' can be divided in the following ways:
// ""+"job", "j"+"ob",  "jo"+"b", "job"+"".

// Your task is to help Sampoornesh Babu to find whether palindrome can be 
// formed with the strings P and Q.

// Input Format:
// -------------
// Two space separated strings P and Q

// Output Format:
// --------------
// Print a boolean value, whether can you form a palindrome or not.


// Sample Input-1:
// ---------------
// mortal carrom

// Sample Output-1:
// ----------------
// true

// Explanation:
// ------------
// Divide P="mortal" and Q="carrom" at index 3 as follows:
//     P -> "mor" + "tal", P1 = "mor" and P2 = "tal"
//     Q -> "car" + "rom", Q1 = "car" and Q2 = "rom"

// P1 + Q2 = "morrom" is a palindrome,so print true.


// Sample Input-2:
// ---------------
// romans carrom

// Sample Output-2:
// ----------------
// false

import java.util.*;

class CheckPalindromeBySplittingStringsPandQ
{
    
    public static boolean checkMiddlePalindrome(String currStr, int l, int r)
    {
        while(l<r && currStr.charAt(l)==currStr.charAt(r))
        {
            l++;
            r--;
        }
        return l>=r;
    }
    
    public static boolean checkPalindrome(String p, String q, int n)
    {
        int l=0;
        int r=n-1;
        while(l<r && p.charAt(l)==q.charAt(r))
        {
            l++;
            r--;
        }
        
        return checkMiddlePalindrome(p,l,r) || checkMiddlePalindrome(q,l,r);
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String p=sc.next();
        String q=sc.next();
        int n=p.length();
        
        boolean result=(checkPalindrome(p,q,n) || checkPalindrome(q,p,n));
        System.out.println(result);
    }
}