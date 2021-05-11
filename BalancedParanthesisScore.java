// May - 05

// Subodh is interested in playing with Strings,
// For a given String 'S', Subodh applies some rules to find the value of 'S'.
// The rules are as follows:
// 	- If it is a balanced [] has value 1
// 	- XY has value X + Y , where X and Y are balanced [] strings.
// 	- [Z] has score 2 * Z , where Z is a balanced parentheses string.
	
// Find out the value of given String and print it.

// Note: All the given strings are balanced

// Input Format:
// ----------------
// A String contains only '[', ']'


// Output Format:
// ------------------
// Print an integer as result.


// Sample Input-1:
// -------------------
// []

// Sample Output-1:
// ---------------------
// 1

// Sample Input-2:
// -------------------
// [[]]

// Sample Output-2:
// ---------------------
// 2

// Sample Input-3:
// -------------------
// [[][[]]]

// Sample Output-3:
// ---------------------
// 6


import java.util.*;

class BalancedParanthesisScore
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        char paranthesis[]=sc.next().toCharArray();
        int n=paranthesis.length;
        
        Stack<Integer> levelScores=new Stack<Integer>();
        int score=0;
        for(int i=0;i<n;i++)
        {
            if(paranthesis[i]=='[')
            {
                levelScores.push(score);
                score=0;
            }
            else
            {
                score=levelScores.pop()+Math.max(2*score,1);
            }
        }
        
        System.out.println(score);
    }
}