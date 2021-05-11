// Problem Statement:


// Sridhar brought his latest Apple iPhone 12 pro. He started his conversation 
// with one of his friend on WhatsApp with list of words.

// Now it’s our task to find and return what are the most common words 
// in the list of words he used in sorted order based on occurrence from 
// largest to smallest. If any of words he used are having same occurrence 
// then consider the lexicographic order.

// You will be given a list of words, you need to print top P number of 
// most common used words as described in the statement. 

// Input Format:
// -------------
// Line-1: comma separated line of words, list of words.
// Line-2: An integer P, number of words to display. 

// Output Format:
// --------------
// Print P number of most common used words.


// Sample Input-1:
// ---------------
// ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are,case
// 3

// Sample Output-1:
// ----------------
// [are, case, egg]



// Sample Input-2:
// ---------------
// ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are
// 3

// Sample Output-2:
// ----------------
// [are, egg, case]

import java.util.*;

class Trie
{
    String word=null;
    int noTimes=0;
    Trie children[]=new Trie[26];
}

class KFrequentWords
{
    public static void insertToTrie(Trie root, String s)
    {
        Trie temp=root;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char curr=s.charAt(i);
            if(temp.children[curr-'a']==null)
                temp.children[curr-'a']=new Trie();
                
            temp=temp.children[curr-'a'];
        }
        
        temp.word=s;
        temp.noTimes+=1;
    }
    
    public static void addWordsToQueue(Trie curr, PriorityQueue<ArrayList<String>> queue)
    {
        if(curr==null)
            return;
        
        for(int i=0;i<26;i++)
        {
            if(curr.children[i]!=null)
            {
                if(curr.children[i].noTimes!=0)
                {
                    ArrayList<String> temp=new ArrayList<String>();
                    temp.add(curr.children[i].word);
                    temp.add(""+curr.children[i].noTimes);
                    queue.add(temp);
                }
                
                addWordsToQueue(curr.children[i],queue);
            }
        }
    }
    
    public static void getKFrequentWords(String words[], int p)
    {
        Trie root=new Trie();
        for(String word:words)
        {
            insertToTrie(root,word);
        }
        
        PriorityQueue<ArrayList<String>> queue=new PriorityQueue<ArrayList<String>>((a,b)->{
            int first=Integer.parseInt(a.get(1));
            int second=Integer.parseInt(b.get(1));
            if(second>first)
            {
                return 1;
            }
            else if(second<first)
            {
                return -1;
            }
            else
            {
                String f=a.get(0);
                String s=b.get(0);
                if(f.compareTo(s)<0)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
        });
        
        addWordsToQueue(root,queue);
        
        ArrayList<String> res=new ArrayList<String>();
        for(int i=0;i<p;i++)
        {
            res.add(queue.poll().get(0));
        }
        
        System.out.println(res);
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String words[]=sc.nextLine().split(",");
        int p=sc.nextInt();
        getKFrequentWords(words,p);
    }
}
