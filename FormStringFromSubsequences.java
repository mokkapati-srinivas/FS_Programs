// Problem Statement:


// Kiran is playing with strings and its subsequences.
// A subsequence can be formed from a string by deleting some characters 
// (may be string itself)

// Kiran has given two strings S and T, 
// your task to form T by concatenating the subsequences of S  

// Return the minimum number of subsequences required to form T.
// If the task is impossible, return -1 .

// Input Format:
// -------------
// Line-1 -> Two strings S and T

// Output Format:
// --------------
// Print an integer as result.


// Sample Input-1:
// ---------------
// abc abcbc

// Sample Output-1:
// ----------------
// 2

// Explanation: 
// ------------
// T = "abcbc" can be formed by "abc" and "bc",
// which are subsequences of S = "abc".


// Sample Input-2:
// ---------------
// abc acdbc

// Sample Output-2:
// ----------------
// -1

// Explanation: 
// ------------
// string T cannot be constructed from the
// subsequences of string S due to the character "d" in string T.


import java.util.*;
class FormStringFromSubsequences
{
    
    public static int findStrictlyGreaterElement(ArrayList<Integer> list,int element)
    {
        int start=0;
        int end=list.size()-1;
        int mid=0;
        int ans=-1;
        while(start<=end)
        {
            mid=(start+end)/2;
            if(list.get(mid)<=element)
            {
                start=mid+1;
            }
            else
            {
                ans=mid;
                end=mid-1;
            }
        }
        
        return ans;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        int slen=s.length();
        int tlen=t.length();
        
        HashMap<Character,ArrayList<Integer>> indices=new HashMap<Character,ArrayList<Integer>>();
        char curr=' ';
        for(int i=0;i<slen;i++)
        {
            curr=s.charAt(i);
            if(indices.get(curr)==null)
            {
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.add(i);
                indices.put(curr,temp);
            }
            else
            {
                ArrayList<Integer> temp=indices.get(curr);
                temp.add(i);
                indices.put(curr,temp);
            }
        }
        
        int prevInd=-1;
        int currInd=0;
        int i=0;
        int flag=0;
        int index=0;
        int minimumSubsequences=1;
        while(i<tlen)
        {
            curr=t.charAt(i);
            if(indices.get(curr)==null)
            {
                flag=1;
                break;
            }
            else
            {
                index=findStrictlyGreaterElement(indices.get(curr),prevInd);
                if(index!=-1)
                {
                    currInd=indices.get(curr).get(index);
                    prevInd=currInd;
                    i++;
                }
                else
                {
                    minimumSubsequences++;
                    prevInd=-1;
                }
            }
        }
        
        if(flag==0)
        {
            System.out.println(minimumSubsequences);
        }
        else
        {
            System.out.println(-1);
        }
    }
}
