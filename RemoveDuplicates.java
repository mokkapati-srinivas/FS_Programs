// Problem Statement:



// Pramod is working on words. He used to remove all the duplicate letters from a
// word.

// Pramod is given a word W. His task to remove all theduplicated letters from W,
// in such a way that the resulatant word R, contains no duplicate letters and all
// distinct letters from W should be there in R.and R should appear first in the 
// dictionary order. 

// Input Format:
// -------------
// A String, the word W.

// Output Format:
// --------------
// Print a String, resulatant word R.


// Sample Input-1:
// ---------------
// cbadccb

// Sample Output-1:
// ----------------
// adcb

// Sample Input-2:
// ---------------
// silicosis

// Sample Output-2:
// ----------------
// ilcos


Code:


import java.util.*;

class RemoveDuplicates
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String w=sc.nextLine();
        int n=w.length();
        
        HashMap<Character,Integer> index=new HashMap<Character,Integer>();
        for(int i=0;i<n;i++)
        {
            char curr=w.charAt(i);
            index.put(curr,i);
        }
        
        Stack<Character> stack=new Stack<Character>();
        HashMap<Character,Boolean> isPresent=new HashMap<Character,Boolean>();
        for(int i=0;i<n;i++)
        {
            isPresent.put(w.charAt(i),false);
        }
        for(int i=0;i<n;i++)
        {
            char curr=w.charAt(i);
            if(stack.isEmpty())
            {
                stack.push(curr);
                isPresent.put(curr,true);
            }
            else
            {
                if(!isPresent.get(curr))
                {
                    while(!stack.isEmpty() && stack.peek()>curr && index.get(stack.peek())>i)
                    {
                        char top=stack.pop();
                        isPresent.put(top,false);
                    }
                    if(!isPresent.get(curr))
                    {
                        stack.push(curr);
                        isPresent.put(curr,true);
                    }
                }
            }
        }
        
        String result="";
        while(!stack.isEmpty())
        {
            char top=stack.pop();
            result=top+result;
        }
        System.out.println(result);
    }
}

