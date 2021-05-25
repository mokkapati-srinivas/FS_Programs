// May - 25

// The king 'Luther Martin' has a kingdom in the form of square land of size N*N,
// So, there are N*N square cells in the land.
// You can divide the cell into two halfs either diagonal or anti-diagonal.
// 	- The diagonal division of the cell indicates by L
// 	- The anti-diagonal division of the cell indicates by R.
// 	- '_' indicates no division of the cell.
	
// The king is given the following information:
// An intgeer N, and N strings, consist of three characters L, R, and '_' ,
// where each string length is N. The division may create new zones.

// Your task is to divide each cell according to the given information, and
// return the number of new zones formed after all the divisions made.

// NOTE: Refer hint for pictorial representation of R and L divisions.

// Input Format:
// -------------
// Line-1: An integer N, size of the land.
// Line-2: N comma separated strings, each string of length N.
// 		The string consist only these characers [R,L,_] 

// Output Format:
// --------------
// Print an integers, number of new zones formed.


// Sample Input-1:
// ---------------
// 4
// RLRL,LRLR,RLRL,LRLR

// Sample Output-1:
// ----------------
// 13

// Sample Input-2:
// ---------------
// 4
// RRLL,R__L,L__R,LLRR

// Sample Output-2:
// ----------------
// 9


// Sample Input-3:
// ---------------
// 4
// L_RR,_L_R,R_L_,RR_L

// Sample Output-3:
// ----------------
// 2


import java.util.*;

class KingdomWithDiagonalAntiDiagonalDivisions
{
    
    public static String find(String node, HashMap<String,String> root)
    {
        if(root.get(node).equals(node))
        {
            return node;
        }
        String currParent=find(root.get(node),root);
        root.put(node,currParent);
        return currParent;
    }
    
    public static void union(String node1, String node2, HashMap<String,String> root)
    {
        String parent1=find(node1,root);
        String parent2=find(node2,root);
        if(!parent1.equals(parent2))
        {
            root.put(parent1,parent2);
        }
    }
    
    public static int findUniqueZones(int n, char kingdom[][])
    {
        HashMap<String,String> root=new HashMap<String,String>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<4;k++)
                {
                    String node=i+" "+j+" "+k;
                    root.put(node,node);
                }
            }
        }
        
        
        String node0="";
        String node1="";
        String node2="";
        String node3="";
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                node0=i+" "+j+" "+0;
                node1=i+" "+j+" "+1;
                node2=i+" "+j+" "+2;
                node3=i+" "+j+" "+3;
                if(kingdom[i][j]=='D')
                {
                    union(node0,node3,root);
                    union(node1,node2,root);
                }
                else if(kingdom[i][j]=='A')
                {
                    union(node0,node1,root);
                    union(node2,node3,root);
                }
                else
                {
                    union(node0,node1,root);
                    union(node2,node3,root);
                    union(node1,node2,root);
                }
                
                if(i+1<n)
                {
                    node3=i+" "+j+" "+3;
                    node1=(i+1)+" "+j+" "+1;
                    union(node3,node1,root);
                }
                if(j+1<n)
                {
                    node2=i+" "+j+" "+2;
                    node0=i+" "+(j+1)+" "+0;
                    union(node2,node0,root);                    
                }
            }
        }
        
        int uniqueZones=0;
        for(String key:root.keySet())
        {
            String currRoot=find(key,root);
            if(currRoot.equals(key))
            {
                uniqueZones++;
            }
        }
        
        return uniqueZones;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String input[]=sc.next().split(",");
        
        char kingdom[][]=new char[n][n];
        for(int i=0;i<n;i++)
        {
            String inp=input[i];
            for(int j=0;j<n;j++)
            {
                char curr=inp.charAt(j);
                if(curr=='L')
                    kingdom[i][j]='D';
                else if(curr=='R')
                    kingdom[i][j]='A';
                else
                    kingdom[i][j]='_';
            }
        }
        
        int uniqueZones=findUniqueZones(n,kingdom);
        System.out.println(uniqueZones);
    }
}