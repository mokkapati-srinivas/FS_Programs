// Problem Statement:

// Naresh is working on expression of words.
// If you give him an expression like, [p,q,r]s[t,u],
// Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
// Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

// Naresh will be given an expression as a string EXP, like the above format.
// He needs to return all words that can be formed in like mentioned above, 
// Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

// NOTE: 
// Expression consist of lowercase alphabets, comma, and square brackets only.

// Input Format:
// -------------
// A string EXP, expression.

// Output Format:
// --------------
// Print list of words, formed from the expression.


// Sample Input-1:
// ---------------
// [b]c[e,g]k

// Sample Output-1:
// ----------------
// [bcek, bcgk]


// Sample Input-2:
// ---------------
// [a,b][c,d]

// Sample Output-2:
// ----------------
// [ac, ad, bc, bd]


// Sample Input-3:
// ---------------
// [xyz]a[b,c]

// Sample Output-3:
// ----------------
// [xyzab, xyzac]

import java.util.*;

class WordsFromExpression
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String exp=sc.next();
        int n=exp.length();
        
        ArrayList<ArrayList<String>> input=new ArrayList<ArrayList<String>>();
        ArrayList<String> curr=new ArrayList<String>();
        HashMap<String,String> adjacency=new HashMap<String,String>();
        int i=0,j=0;
        while(i<n)
        {
            char c=exp.charAt(i);
            if(c=='[')
            {
                curr=new ArrayList<String>();
                String temp="";
                j=i+1;
                while(j<n)
                {
                    if(exp.charAt(j)==']')
                    {
                        break;
                    }
                    temp+=exp.charAt(j);
                    j++;
                }
                i=j;
                
                String tempArr[]=temp.split(",");
                for(String s:tempArr)
                {
                    curr.add(s);
                }
            }
            else if(c==']')
            {
                curr=new ArrayList<String>();
                i++;
            }
            else
            {
                j=i;
                while(j<n)
                {
                    if(exp.charAt(j)=='[')
                    {
                        break;
                    }
                    j++;
                }
                String temp=exp.substring(i,j);
                i=j;
                curr.add(temp);
            }
            
            if(curr.size()!=0)
            {
                input.add(curr);
            }
        }
        
        int inputSize=input.size();
        TreeSet<String> result=new TreeSet<String>();
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> initial=input.get(0);
        for(String s:initial)
        {
            queue.add(s);
        }
        int index=1;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int a=0;a<size;a++)
            {
                String str=queue.poll();
                if(index==inputSize)
                {
                    result.add(str);
                    continue;
                }
                for(String s:input.get(index))
                {
                    queue.offer((str+s));
                }
            }
            index++;
        }
        
        System.out.println(result);
    }
}
