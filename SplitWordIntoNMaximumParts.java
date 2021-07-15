// Problem Statement:

// Mr Parandhamayya working with words.
// He is given a word W, you need to divide the word into N non-empty parts, 
// such that all the newly formed words should be distinct, and 
// if you append all those words should form original word W.

// Your task is to help Mr Parandhamayya to divide the word into N parts,
// such that, the value of N should be maximized, and print N.

// Input Format:
// -------------
// Line-1: A string W, a word.

// Output Format:
// --------------
// Print an integer result, the value of N.


// Sample Input-1:
// ---------------
// banana

// Sample Output-1:
// ----------------
// 4

// Explanation: 
// ------------
// One way to divide the word is "b","a","n","ana".
// If you divide it like "b","a","n","an","a".The word "a" will be repeated.
// So it is not allowed to divide like the second way.


// Sample Input-2:
// ---------------
// mississippi

// Sample Output-2:
// ----------------
// 7

// Explanation: 
// ------------
// One of the way to divide the word is "m","i","s","si","ssi","p","pi".

// NOTE: Subsequences are not allowed.


import java.util.*;

class SplitWordIntoNMaximumParts
{
    public static boolean isPossibleToDivideUtil(String word, int n, int reqDiv, HashSet<String> visited, int currDiv, int currInd)
    {
        if(currDiv>=reqDiv)
        {
            return true;
        }
        
        String curr="";
        for(int i=currInd;i<n;i++)
        {
            curr+=word.charAt(i);
            if(!visited.contains(curr))
            {
                visited.add(curr);
                boolean next=isPossibleToDivideUtil(word,n,reqDiv,visited,currDiv+1,i+1);
                if(next)
                {
                    return true;
                }
                visited.remove(curr);
            }
        }
        
        return false;
    }
    
    public static boolean isPossibleToDivide(String word, int n, int reqDiv)
    {
        HashSet<String> visited=new HashSet<String>();
        
        if(isPossibleToDivideUtil(word,n,reqDiv,visited,0,0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String word=sc.next();
        int n=word.length();
        
        int low=1;
        int high=n;
        int maxDivisions=1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(isPossibleToDivide(word,n,mid))
            {
                maxDivisions=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        System.out.println(maxDivisions);
    }
}
