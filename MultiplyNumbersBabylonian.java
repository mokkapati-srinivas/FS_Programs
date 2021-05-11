// Problem Statement:

// Babylonians invented muliplication of numbers.

// You will be given two strings consist of digits only.
// You have to perform the multiplication of these two strings using 
// Babylonians approach, and return the result of multiplication of two strings.


// Input Format:
// -------------
// Two space separated strings, num1 and num2.

// Output Format:
// --------------
// Print the product of two strings num1 and num2.


// Sample Input-1:
// ---------------
// 5 4 

// Sample Output-1:
// ----------------
// 20


// Sample Input-2:
// ---------------
// 121 432 

// Sample Output-2:
// ----------------
// 52272

// Note:
// -----
// 	- Input should contain digits only, and should not contain leading 0's except 0.
// 	- Output will be in the range of integer only.
// 	- There will be no leading minus '-' symbol also.
// 	- Should not use built-in BigInteger library.
// 	- Should not convert the given strings into integers.


import java.util.*;

class MultiplyNumbersBabylonians
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String num1=sc.next();
        String num2=sc.next();
        int m=num1.length();
        int n=num2.length();
        
        int resultArr[]=new int[m+n];
        int n1=0,n2=0;
        int product=0,idx1=0,idx2=0;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                n1=num1.charAt(j)-'0';
                n2=num2.charAt(i)-'0';
                product=n1*n2;
                idx1=i+j;
                idx2=i+j+1;
                
                product=product+resultArr[idx2];
                resultArr[idx1]+=product/10;
                resultArr[idx2]=product%10;
            }
        }
        
        int i=0;
        for(i=0;i<m+n;i++)
        {
            if(resultArr[i]!=0)
            {
                break;
            }
        }
        if(i==m+n)
        {
            System.out.println(0);
        }
        else
        {
            String result="";
            for(int j=i;j<m+n;j++)
            {
                result+=resultArr[j];
            }
            System.out.println(result);
        }
    }
}
