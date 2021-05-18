// May - 13

// Problem Statement:

// Cardano is a famous mathematician. working on numbers.
// Given a number N, which is the product of all the digits of a number.
// You need to find such smallest number S.

// Your task is to help Mr Cardano to find smallest number S, 
// where the product of all the digits of S should be equal to N.
// If it is not possible to create S with in range of integer, print 0.


// Input Format:
// -------------
// An integer N

// Output Format:
// --------------
// Print an integer, smallest number S.


// Sample Input-1:
// ---------------
// 36

// Sample Output-1:
// ----------------
// 49


// Sample Input-2:
// ---------------
// 147

// Sample Output-2:
// ----------------
// 377


// Sample Input-3:
// ---------------
// 22

// Sample Output-3:
// ----------------
// 0


import java.util.*;

class DigitsToMultiplyToN
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        boolean flag=false;
        String result="";
        while(n>1)
        {
            flag=false;
            int i=9;
            for(i=9;i>=2;i--)
            {
                if(n%i==0)
                {
                    flag=true;
                    break;
                }
            }
            
            if(flag==false)
            {
                result="0";
                break;
            }
            else
            {
                result=i+result;
                n=n/i;
            }
        }
        System.out.println(result);
    }
}
