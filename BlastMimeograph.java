// Murali playing a mobile game, Blast the letters.

// In the game he is given a word W and value R.
// Murali has to perform the blasting operation as follows:
// 	- He has to blast the mimeograph M of length R in W, 
// 	  a mimeograph is a string such that each letter in it should be same.
// 	- After blasting the mimeograph, the rest of the string on 
// 	  its left side and right side, concatenated together.

// Murali has to perform the blasting operation repeatedly, 
// until no more mimeograph M found.

// Your task is to return the final string after all the blast operations have been done.

// Input Format:
// -------------
// Line-1: A string and an integer, W and R.

// Output Format:
// --------------
// Print a string, the final string after all the blast operations have been done.


// Sample Input-1:
// --------------- 
// ababbaaab 3

// Sample Output-1:
// ----------------
// aba

// Sample Input-2:
// --------------- 
// caaabbbaacdddd 2

// Sample Output-2:
// ----------------
// cabc


import java.util.*;
class BlastMimeograph
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String w=sc.next();
        int r=sc.nextInt();
        if(r==0)
        {
            System.out.println(w);
        }
        else if(r==1)
        {
            System.out.println("");
        }
        else
        {
            int n=w.length();
            
            Stack<Character> mime=new Stack<Character>();
            for(int i=0;i<n;i++)
            {
                char curr=w.charAt(i);
                if(mime.isEmpty())
                {
                    mime.push(curr);
                    prev=curr;
                    prevcount=1;
                }
                else
                {
                    mime.push(curr);
                    if(curr==prev)
                    {
                        prevcount++;
                        if(prevcount==r)
                        {
                            while(prevcount-->0)
                            {
                                mime.pop();
                            }
                            prevcount=0;
                            if(!mime.isEmpty())
                            {
                                prev=mime.peek();
                                while(!mime.isEmpty() && mime.peek()==prev)
                                {
                                    mime.pop();
                                    prevcount++;
                                }
                                for(int j=0;j<prevcount;j++)
                                {
                                    mime.push(prev);
                                }
                            }
                        }
                    }
                    else if(curr!=prev)
                    {
                        prev=curr;
                        prevcount=1;
                    }
                }
            }
            
            String res="";
            for(int i=0;i<mime.size();i++)
            {
                res+=mime.get(i);
            }
            
            System.out.println(res);
        }
    }
}
