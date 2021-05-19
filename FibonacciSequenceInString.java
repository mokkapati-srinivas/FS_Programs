// May - 19

// Pramod is working on Strings consist of digits only. 
// He wants to findout, whether the given string can form Fibonacci sequence or not.

// A String can form a Fibonacci Sequence, if it contains at least three numbers,
// and numbers are in the following order:
// first, second, third  = first + second, fourth = third + second, .. so on.

// Return true, if the given string can form fibonacci sequence,
// otherwise, return false.

// Note: Numbers in the fibonacci sequence contains no leading 0's.
// for example, 2, 03,5 or 2,3,05 or 02,3,5 are not valid.

// Input Format:
// -------------
// A String consist of digits only

// Output Format:
// --------------
// Print a boolean value as result.


// Sample Input-1:
// ---------------
// 23581321

// Sample Output-1:
// ----------------
// true

// Explanation: 
// ------------
// Fibonacci Sequence is : 2, 3, 5, 8, 13, 21
// 2, 3, 2+3=5, 3+5=8, 5+8=13, 8+13=21.

// Sample Input-2:
// ---------------
// 199100199

// Sample Output-2:
// ----------------
// true

// Explanation: 
// ------------
// Fibonacci Sequence is : 1 99 100 199
// 1, 99, 1+99=100, 99+100=199.


import java.util.*;

class FibonacciSequenceInString
{
    
    public static boolean formString(int first, int second, String fibo)
    {
        String formed=first+""+second;
        int n=fibo.length();
        while(formed.length()<=n)
        {
            int third=first+second;
            formed=formed+third;
            if(formed.equals(fibo))
            {
                return true;
            }
            first=second;
            second=third;
        }
        
        return false;
    }
       
    public static boolean findFibo(String fibo)
    {
        int first=0;
        int second=0;
        boolean result=false;
        for(int i=0;i<=fibo.length()/2;i++)
        {
            first=first*10+(int)(fibo.charAt(i)-'0');
            second=0;
            for(int j=i+1;j<fibo.length();j++)
            {
                second=second*10+(int)(fibo.charAt(j)-'0');
                result=formString(first,second,fibo);
                if(result)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String fibo=sc.next();
        
        boolean result=findFibo(fibo);
        System.out.println(result);
    }
}