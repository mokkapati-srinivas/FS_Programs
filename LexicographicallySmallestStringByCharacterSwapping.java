// Problem Statement:

// Krishna is working on strings, He is trying to modify the string 
// which has to be first in lexicographic order.
// You can modify the string using following operations:
// 	- Interchange the characters at the given pair of indices.
// 	- You can perform the interchange of the pair any number of times.
// 	- You will be given I number of pairs

// Example: 
// --------
// If pair is ->[i,j], you can interchange the characters at i-th and j-th indices
// with each other.

// Krishna is given a String S, an integer I and I pairs of indices.
// Can you help Krishna to find the string that can be formed 
// after performing interchange operations, which has to be first in the
// lexicographical order.

// Note: String contains only lowercase letters.


// Input Format:
// -------------
// Line-1: A string S
// Line-2: An integer I, number of interchanges.
// Next I lines: Two space separated integers, interchange pair.

// Output Format:
// --------------
// A string, lexicographic smallest string after the interchanges


// Sample Input-1:
// ---------------
// cba
// 2
// 0 1
// 1 2

// Sample Output-1:
// ----------------
// abc

// Explanation: 
// -------------
// Interchange s[0] and s[1], s = "bca"
// Interchange s[1] and s[2], s = "bac"
// Interchange s[0] and s[1], s = "abc"


// Sample Input-2:
// ---------------
// dcab
// 2
// 0 3
// 1 2

// Sample Output-2:
// ----------------
// bacd

// Explaination: 
// -------------
// Interchange s[0] and s[3], s = "bcad"
// Interchange s[1] and s[2], s = "bacd"


// Sample Input-3:
// ---------------
// dcab
// 3
// 0 3
// 1 2
// 0 2

// Sample Output-3:
// ----------------
// abcd

// Explaination: 
// -------------
// Interchange s[0] and s[3], s = "bcad"
// Interchange s[0] and s[2], s = "acbd"
// Interchange s[1] and s[2], s = "abcd"


import java.util.*;

class LexicographicallySmallestStringByCharacterSwapping
{
    public static int findRoot(int root[], int node)
    {
        if(root[node]==node)
        {
            return node;
        }
        int r=findRoot(root,root[node]);
        root[node]=r;
        return r;
    }

    public static void union(int root[], int node1, int node2)
    {
        int node1Root=findRoot(root,node1);
        int node2Root=findRoot(root,node2);
        if(node1Root!=node2Root)
        {
            root[node1Root]=node2Root;
        }
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int len=s.length();
        int n=sc.nextInt();
        int root[]=new int[len];
        for(int i=0;i<len;i++)
        {
            root[i]=i;
        }
        for(int i=0;i<n;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            union(root,a,b);
        }

        HashMap<Integer,PriorityQueue<Character>> unions=new HashMap<Integer,PriorityQueue<Character>>();
        for(int i=0;i<len;i++)
        {
            int topRoot=findRoot(root,i);
            root[i]=topRoot;
            if(unions.get(topRoot)==null)
            {
                unions.put(topRoot,new PriorityQueue<Character>());
            }
            unions.get(topRoot).add(s.charAt(i));
        }

        String result="";
        for(int i=0;i<len;i++)
        {
            result+=unions.get(root[i]).poll();
        }
        System.out.println(result);

    }
}
