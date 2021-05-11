// April - 28

// Sampoornesh Babu is learning arithmatics.
// His teacher given him a task to find the minimum number of operations
// required to convert a given integer I to 1.

// Sampoornesh is allowed to perform the following operations:
// 	- If I is even, convert I with I/2 .
// 	- In I is odd, convert I with either I+1 or I-1.

// Now it's your task to help Sampoornesh Babu to find and print
// the minimum number of operations required.

// Input Format:
// -------------
// An integer I.

// Output Format:
// --------------
// Print an integer, the minimum number of operations required.


// Sample Input-1:
// ---------------
// 10

// Sample Output-1:
// ----------------
// 4

// Explanation:
// ------------
// 10 -> 5 -> 4-> 2 -> 1.


// Sample Input-2:
// ---------------
// 15

// Sample Output-2:
// ----------------
// 5

// Explanation:
// ------------
// 15 -> 16 -> 8 -> 4 -> 2 -> 1.

import java.util.*;

class ConvertNumberToOne
{
    
    public static int convertToOne(int n, HashMap<Integer,Integer> steps)
    {
        if(steps.get(n)!=null)
        {
            return steps.get(n);   
        }
        
        if(n==1)
        {
            steps.put(1,0);
            return 0;
        }
        
        if(n%2==0)
        {
            int c=1+convertToOne(n/2,steps);
            steps.put(n,c);
            return c;
        }
        else
        {
            int c1=1+convertToOne(n-1,steps);
            int c2=1+convertToOne(n+1,steps);
            int c=Math.min(c1,c2);
            steps.put(n,c);
            return c;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        HashMap<Integer,Integer> steps=new HashMap<Integer,Integer>();
        int result=convertToOne(n,steps);
        System.out.println(result);
    }
}