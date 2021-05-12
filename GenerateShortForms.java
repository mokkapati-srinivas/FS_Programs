// May - 12

// Now a days, everyone is used type the words using short-forms,
// A short-form can be created by replacing non-intersected substrings 
// with their respective lengths.

// e.g., elite can be written as follows:
//     - e3e (by replacing lut with 3), 
//     - el2e (by replacing it with 2), 
//     - 3t1 (by replacing eli and e with 3 and 1).
// etc.


// You will be given a word.
// Your task is to find all possible short-fomrs of the given word, 
// and print them as a list of lexicographic order.


// Input Format:
// -------------
// A string W, the word.

// Output Format:
// --------------
// Print the list of possible short-forms of W in lexographic order. 


// Sample Input-1:
// ---------------
// kmit

// Sample Output-1:
// ----------------
// [4, 3t, 2i1, 2it, 1m2, 1m1t, 1mi1, 1mit, k3, k2t, k1i1, k1it, km2, km1t, kmi1, kmit]


// Sample Input-2:
// ---------------
// cse

// Sample Output-2:
// ----------------
// [3, 2e, 1s1, 1se, c2, c1e, cs1, cse]


import java.util.*;

class GenerateShortForms
{
    static TreeSet<String> result=new TreeSet<String>();
    
    public static void findShortForms(String w, int index)
    {
        int n=w.length();
        String word="";
        int count=0;
        for(int i=0;i<n;i++)
        {
            char curr=w.charAt(i);
            if(curr=='*')
            {
                count++;
            }
            else
            {    
                if(count!=0)
                {
                    word+=count;
                    count=0;
                }
                word+=curr;
            }
        }
        if(count!=0)
        {
            word+=count;
        }
        result.add(word);
        
        for(int i=index;i<n;i++)
        {
            String next=w.substring(0,i)+"*"+w.substring(i+1,n);
            findShortForms(next,i+1);
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String w=sc.next();
        
        findShortForms(w,0);
        System.out.println(result);
    }
}