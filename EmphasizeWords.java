// May - 13

// Problem Statement:

// Reena has to send the mails regularly.
// She used emphasize any word W based on a given set of words[].
// Two emphasize the words she used enclose them with <i> and </i> tag.
// The emphasize procedure of the sub-words of W is as follows:
	
// 	- If two sub-words are intersected with each other, 
// 	  enclose them with one <i></i> tag.
	
// 	- If two sub-words are enclosed with <i></i> tag and neighbours also,
// 	  then merge the sub-words as one and enclose with one <i> </i> tag.

// You will be given the word W, and set of words[] to emphasize.
// Your task is to help Reena to emphasize the word W.
// and print it.

// Input Format:
// -------------
// Line-1: A string W, the word.
// Line-2: space separated strings, set of words[].

// Output Format:
// --------------
// Print the string, the emphasized string.

// Sample Input-1:
// ---------------
// kmitngit123
// it 123

// Sample Output-1:
// ----------------
// km<i>it</i>ng<i>it123</i>


// Sample Input-2:
// ---------------
// qwertykeypad
// qwerty key pad

// Sample Output-2:
// ----------------
// <i>qwertykeypad</i>


import java.util.*;

class EmphasizeWords
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String w=sc.next();
        sc.nextLine();
        String words[]=sc.nextLine().split(" ");
        
        int n=w.length();
        boolean emphasize[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            for(String word: words)
            {
                int wordLen=word.length();
                if(w.startsWith(word,i))
                {
                    int start=i;
                    int end=i+wordLen-1;
                    for(int j=start;j<=end;j++)
                    {
                        emphasize[j]=true;
                    }
                }
            }
        }
        
        String result="";
        int left=0;
        boolean flag=false;
        for(int i=0;i<n;i++)
        {
            if(emphasize[i]==false)
            {
                result+=w.charAt(i);
                flag=false;
            }
            else
            {
                if(flag==false)
                {
                    left=i;
                    flag=true;
                }
                if(i+1==n || emphasize[i+1]==false)
                {
                    result+="<i>"+w.substring(left,i+1)+"</i>";
                }
            }
        }
        System.out.println(result);
    }
}
