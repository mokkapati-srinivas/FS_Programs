// Problem Statement:

// At university of Chicago a Computer Science programing faculty as a part of 
// teaching passion, in order to make newly joined students more enthusiastic 
// in learning the subject he will be giving a problem at the first day of semester.
// The student who tops they will be awarded with cash prize. In regard to this 
// he asked the students to work on concept related to strings, he gave a task to
// read a word and find the count of all the turn of phrases of the word, and 
// the phrases should be distinct.

// Now it’s time for you to create a method which satisfies the above program.
// A turn of phrases of a word is obtained by deleting 
// any number of characters (possibly zero) from the front of the word and
// any number of characters (possibly zero) from the back of the word.

// Input Format:
// -------------
// A single string, the word.

// Output Format:
// --------------
// Print an integer, number of distinct phrases possible.


// Sample Input-1:
// ---------------
// aabbaba

// Sample Output-1:
// ----------------
// 21

// Explanation:
// -------------
// The turn of phrases of the word, which are distinct as follows:
// a, b, aa, bb, ab, ba, aab, abb, bab, bba, aba, aabb, abba, bbab, baba, 
// aabba, abbab, bbaba, aabbab, abbaba, aabbaba


// Sample Input-2:
// ---------------
// kmithyd

// Sample Output-2:
// ----------------
// 28


import java.util.*;
class Trie
{
    Trie children[]=new Trie[26];
}
class SubstringTries
{
    static int count=0;
    public static void constructTrie(Trie root, String s)
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
    }
    public static void DFSOnTrie(Trie root)
    {
        if(root==null)
            return;
        for(int i=0;i<26;i++)
        {
            if(root.children[i]!=null)
            {
                count++;
                // System.out.println((char)(i+97));
                DFSOnTrie(root.children[i]);
            }
        }
    }
    public static void getUniqueSubstrings(String s)
    {
        Trie root=new Trie();
        String temp="";
        for(int i=s.length()-1;i>=0;i--)
        {
            temp=""+s.charAt(i)+temp;
            // System.out.println(temp);
            constructTrie(root, temp);
        }
        DFSOnTrie(root);
        System.out.println(count);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        getUniqueSubstrings(s);
    }
}
