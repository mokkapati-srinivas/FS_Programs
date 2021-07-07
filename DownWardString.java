// Problem Statement:

// Shravan Kumar is working with numeric strings, consist of digits from [0-9] only.
// Shravan has to check whether the given numeric string is a downward string or not.

// A string is said to be a downward string, if the string follows the below rules:
// 	- Divide the string S into two or more substrins, 
// 	  like sub[0],sub[1], sub[2],..,sub[n-1]. Iif you append all the substrings 
// 	  should result in S,sub[0]+sub[1]+ sub[2]+..+sub[n-1] = S
	  
// 	- The numeric values of the substrings should be in decreasing order.
// 	  i.e., sub[0] > sub[1] > .. > sub[n-1].
// 	- The difference between each consecutive pair should be 1 only.
// 	  i.e., sub[0]-sub[1] = sub[1]-sub[2] = .. = sub[n-2]-sub[n-1] = 1.

// Your task is to help Mr Shravan Kumar, 
// to check the given numeric string is downward string or not. 
// If yes, print "true", Otherwise print "false".

// Input Format:
// -------------
// A String, numeric word.

// Output Format:
// --------------
// Print a boolean result.


// Sample Input-1:
// ---------------
// 004567

// Sample Output-1:
// ----------------
// false

// Explanation:
// ------------
// Numeric Word can be divided as follows: "004","5","6","7"
// Given word is not a downward string. 


// Sample Input-2:
// ---------------
// 1201100010

// Sample Output-2:
// ----------------
// true

// Explanation:
// ------------
// Numeric Word can be divided as follows: "12","011","00010"
// The numeric value of substrings are: 12, 11, 10


// Sample Input-3:
// ---------------
// 5040301

// Sample Output-3:
// ----------------
// false

// Explanation:
// ------------
// Numeric Word can be divided as follows: "5","04","03","01"
// The numeric value of substrings are: 5,4,3,1
// Rule-1 and Rule-2 are followed but Rule-3 is not followed.



// Sample Input-4:
// ---------------
// 99999998

// Sample Output-4:
// ----------------
// true

// Explanation:
// ------------
// Numeric Word can be divided as follows: "9999","9998".


import java.util.*;
import java.math.BigInteger;

class DownWardString
{
    
    public static boolean findRemaining(String word, int n, BigInteger lastNum, int currInd)
    {
        if(currInd==n)
        {
            return true;
        }
        
        for(int i=currInd;i<n;i++)
        {
            BigInteger currNum=new BigInteger(word.substring(currInd,i+1));
            if(lastNum.equals(currNum.add(BigInteger.ONE)))
            {
                if(findRemaining(word,n,currNum,i+1))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean findIfPossible(String word)
    {
        int n=word.length();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                BigInteger num1=new BigInteger(word.substring(0,i+1));
                BigInteger num2=new BigInteger(word.substring(i+1,j+1));
                if(num1.equals(num2.add(BigInteger.ONE)))
                {
                    if(findRemaining(word,n,num2,j+1))
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String word=sc.next();
        
        boolean possible=findIfPossible(word);
        System.out.print(possible);
    }
}
