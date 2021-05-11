// Problem Statement:


// In a Maths class, the math teacher given a task to her students, 
// She is given an unlimit set of candles, the candles are in the form of digits 
// from [0-9]. The task is, students have to form the natural numbers from M to N, 
// (where M < N) using the candles given to them. The students have to find and 
// return the number of digit-D shaped candles used to form the natural numbers
// between M and N, where M and N are inclusive.

// You will be given three integers D, M, and N.
// Your task is to help the students to find the number of digit-D shaped candles used.

// Input Format:
// -------------
// Three space separated integers, D, M, and N

// Output Format:
// --------------
// Print an integer, the number of times digit-D shaped candles used.


// Sample Input-1:
// ---------------
// 2 15 25

// Sample Output-1:
// ----------------
// 7

// Explanation:
// ------------
// Numbers contains digit-2 in them are 20,21,22,23,24,25. So total of 7.

// Sample Input-2:
// ---------------
// 3 21 39

// Sample Output-2:
// ----------------
// 12

import java.util.*;

class NumberOfOccurrencesOfDigit
{
    
    public static int findDigitCountUptoNumber(int num, int d)
    {
        int count=0;
        for(int pow10=1;pow10<=num;pow10=pow10*10)
        {
            int divisor=pow10*10;
            int quotient=num/divisor;
            int countUptoNearestPow10=quotient*pow10;
            int remainder=num%divisor;
            
            count+=countUptoNearestPow10;
            count+=Math.min(pow10,Math.max(0,(remainder+1-(d*pow10))));
            if(d==0)
            {
                count-=pow10;
            }
        }
        
        return count;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int d=sc.nextInt();
        int m=sc.nextInt();
        int n=sc.nextInt();
        
        int countn=findDigitCountUptoNumber(n,d);
        int countm=findDigitCountUptoNumber(m-1,d);
        int result=countn-countm;
        System.out.println(result);
    }
}

