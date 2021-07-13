// Problem Statement:

// There are N students stands in a row, where girls indicated with 0's 
// and boys indicated with 1's. The teacher ask them to stand alternatively 
// based on thier gender. [i.e., No two students with same gender stands side by side]

// You are allowed to perform these operations to arrange them to sit alternatively:
// 	Op-1: Move the first student in the row to the end of the row. 
// 	Op-2: Choose any one position in the row, replace with the student 
// 	      with another student with opposite enter. 
// 	      [i.e., replace a boy with girl or a girl with boy]

// You will be given the initial sitting of students as a binary string. 
// Your task is to find and return the minimum number of Op-2 operations required 
// to make them to sit alternatively according to their gender.


// Input Format:
// -------------
// A binary string B.

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 1100100

// Sample Output-1:
// ----------------
// 2

// Explanation:
// ------------
// Perform Op-1 operation 3 times: The sitting will be 0100110
// Perform Op-2 operation at 4th and 5th positions in the row
// Finally, sitting is 0101010


// Sample Input-2:
// ---------------
// 11011

// Sample Output-2:
// ----------------
// 1


import java.util.*;

class MinimumNoOfBitsToFlipToGetAlternateSequence
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String b=sc.next();
        int n=b.length();
        b=b+b;
        
        int min1=0;
        int min2=0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<2*n;i++)
        {
            int curr=b.charAt(i)-'0';
            if(i%2!=curr)
            {
                min1++;
            }
            else
            {
                min2++;
            }
            
            if(i>=n)
            {
                int last=b.charAt(i-n)-'0';
                if((i-n)%2!=last)
                {
                    min1--;
                }
                else
                {
                    min2--;
                }
                result=Math.min(result,Math.min(min1,min2));
            }
        }
        System.out.println(result);
    }
}
