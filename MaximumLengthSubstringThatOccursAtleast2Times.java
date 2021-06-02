// June - 02

// Charlie Brown is working with strings,
// He is a given a string S. He wants to find out the maximum substring 'MaxSub'.

// MaxSub is a substring which appears atleast twice in S with Maximum length. 

// Your task is to help Charlie Brown to find the Maximum Substring MaxSub,
// and print the length of MaxSub. If there is MaxSub, return 0.

// Input Format:
// -------------
// A string S.

// Output Format:
// --------------
// Print an integer, length of MaxSub


// Sample Input-1:
// ---------------
// babababba

// Sample Output-1:
// ----------------
// 5

// Explanation: 
// ------------
// The Maximum substring is 'babab' , which occurs 2 times.


// Sample Input-2:
// ---------------
// abbbbba

// Sample Output-2:
// ----------------
// 4

// Explanation: 
// ------------
// The Maximum substring is 'bbbb' , which occurs 2 times.


// Sample Input-3:
// ---------------
// vignesh

// Sample Output-3:
// ----------------
// 0


import java.util.*;

class MaximumLengthSubstringThatOccursAtleast2Times
{
    public static int power(int d, int exp)
    {
        if(exp==0)
        {
            return 1;
        }
        
        int midPower=power(d,exp/2);
        if(exp%2==0)
        {
            return midPower*midPower;
        }
        else
        {
            return d*midPower*midPower;
        }
    }
    
    public static boolean rabinKarp(String s, int n, int m, int powD, int d)
    {
        HashMap<Long,ArrayList<Integer>> hashCodeIndices=new HashMap<Long,ArrayList<Integer>>();
        
        long hash=0;
        for(int i=0;i<m;i++)
        {
            hash=hash*d+((int)s.charAt(i)-97);
        }
        hashCodeIndices.put(hash, new ArrayList<Integer>());
        hashCodeIndices.get(hash).add(m-1);
        
        int firstCharIndex=0;
        for(int i=m;i<n;i++)
        {
            int currHashChar=(int)s.charAt(i)-97;
            hash=(hash-(((int)s.charAt(firstCharIndex)-97)*powD))*d+currHashChar;
            firstCharIndex++;
            if(hashCodeIndices.get(hash)!=null)
            {
                ArrayList<Integer> indices=hashCodeIndices.get(hash);
                String currSubString=s.substring(firstCharIndex,i+1);
                for(int end: indices)
                {
                    int start=end-(m-1);
                    String hashSubString=s.substring(start,end+1);
                    if(hashSubString.equals(currSubString))
                    {
                        return true;
                    }
                }
                
                hashCodeIndices.get(hash).add(i);
            }
            else
            {
                hashCodeIndices.put(hash,new ArrayList<Integer>());
                hashCodeIndices.get(hash).add(i);
            }
        }
        
        return false;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        
        int start=0;
        int end=n;
        int mid=0;
        int maxLen=0;
        int d=2;
        while(start<=end)
        {
            mid=(start+end)/2;
            int powD=power(d,mid-1);
            if(rabinKarp(s,n,mid,powD,d))
            {
                maxLen=mid;
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        System.out.println(maxLen);
    }
}