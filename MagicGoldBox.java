// Problem Statement:


// A magic box with p rows and r columns is initially filled with silver.
// If we invoke a method 'addMagicOperation' which turns the silver at index (r, c)
// into gold. 

// Given N set of indices to work up on, find the number of gold-blocks which 
// are formed after each addMagicOperation. 

// A gold-block is a block of gold cells connected horizontally and vertically and 
// surrounded by silver. Consider all four edges of the magic box are surrounded by
// silver.

// Input Format:
// --------------
// Line-1: Three space separated integers p, r , and n (number of add Magic Operations)
// Next N lines: Two space separated integers, cell to perform addMagicOperation 

// Output Format:
// --------------
// Print a list of numbers, number of gold-blocks formed after each addMagicOperation


// Sample Input-1:
// -----------------
// 3 3 5
// 0 0
// 0 1
// 1 2
// 2 1
// 1 1

// Sample Output-1:
// -----------------
// [1, 1, 2, 3, 1]

// Explanation:
// -----------
// Initially, the magic box is filled with silver. 
// (Assume 0 represents silver and 1 represents gold).

// 0 0 0
// 0 0 0
// 0 0 0

// Operation #1: addMagicOperation(0, 0) turns the silver at cell[0][0] into gold.

// 1 0 0
// 0 0 0   Number of Gold-blocks = 1
// 0 0 0

// Operation #2: addMagicOperation(0, 1) turns the silver at cell[0][1] into gold.

// 1 1 0
// 0 0 0   Number of Gold-blocks = 1
// 0 0 0

// Operation #3: addMagicOperation(1, 2) turns the silver at cell[1][2] into gold.

// 1 1 0
// 0 0 1   Number of Gold-blocks = 2
// 0 0 0

// Operation #4: addMagicOperation(2, 1) turns the silver at cell[2][1] into gold.

// 1 1 0
// 0 0 1   Number of Gold-blocks = 3
// 0 1 0

// Operation #5: addMagicOperation(1, 1) turns the silver at cell[1][1] into gold.

// 1 1 0
// 0 1 1   Number of Gold-blocks = 1
// 0 1 0



// DFS Code:

// import java.util.*;
// class MagicBox
// {
//     public static void dfs(int mat[][], int p, int q, int x, int y)
//     {
//         if(x<0 || x>=p || y<0 || y>=q)
//             return;
            
//         if(mat[x][y]==2 || mat[x][y]==0)
//             return;
        
//         mat[x][y]=2;
        
//         int dirs[][]={{0,-1},{0,1},{-1,0},{1,0}};
        
//         for(int dir[]:dirs)
//         {
//             int a=x+dir[0];
//             int b=y+dir[1];
//             dfs(mat,p,q,a,b);
//         }
        
//         return;
//     }
    
//     public static void main(String args[])
//     {
//         Scanner sc=new Scanner(System.in);
//         int p=sc.nextInt();
//         int q=sc.nextInt();
//         int n=sc.nextInt();
        
//         int mat[][]=new int[p][q];
//         int temp[][]=new int[p][q];
        
//         ArrayList<Integer> res=new ArrayList<Integer>();
        
//         int count=0;
//         for(int i=0;i<n;i++)
//         {
//             int a=sc.nextInt();
//             int b=sc.nextInt();
//             mat[a][b]=1;
//             for(int j=0;j<p;j++)
//             {
//                 for(int k=0;k<q;k++)
//                 {
//                     temp[j][k]=mat[j][k];
//                 }
//             }
            
//             count=0;
//             for(int j=0;j<p;j++)
//             {
//                 for(int k=0;k<q;k++)
//                 {
//                     if(temp[j][k]==1)
//                     {
//                         dfs(temp,p,q,j,k);
//                         count++;
//                     }
//                 }
//             }
            
//             res.add(count);
//         }
        
//         System.out.println(res);
//     }
// }

// Union Find Solution
import java.util.*;
class MagicGoldBox
{
    public static int find(int[] parents, int currnode)
    {
        int finalparent=currnode;
        while(finalparent!=parents[finalparent])
        {
            finalparent=parents[finalparent];
        }
        // path compression
        while(currnode!=parents[currnode])
        {
            int currnodeparent=parents[currnode];
            parents[currnode]=finalparent;
            currnode=currnodeparent;
        }
        return finalparent; 
    }
    public static int union(int []parents, int[] size, int x, int y, int count)
    {
        int parentofx=find(parents,x);
        int parentofy=find(parents,y);
        // if parentofx==parentofy then we do nothing. We return
        if(parentofx==parentofy)
        {
            return count;
        }
        int big=0,small=0;
        if(size[parentofx]>size[parentofy])
        {
            big=parentofx;
            small=parentofy;
        }
        else
        {
            big=parentofy;
            small=parentofx;
        }
        parents[small]=big;
        size[big]=size[big]+size[small];
        
        count--;
        return count;
    }
    public static void main(String args[])
    {
        int count=0;
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int k=sc.nextInt();
        int parents[]=new int[m*n];
        int size[]=new int[m*n];
        Arrays.fill(parents,-1);
        Arrays.fill(size,1);
        int dirs[][]={{0,-1},{0,1},{1,0},{-1,0}};
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<k;i++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            int curr=x*n+y;
            if(parents[curr]!=-1)
            {
                continue;
            }
            parents[curr]=curr;
            
            count++;
            for(int[] dir:dirs)
            {
                int nx=x+dir[0];
                int ny=y+dir[1];
                int neigh=nx*n+ny;
                
                if(nx>=0 && nx<m && ny>=0 && ny<n && parents[neigh]!=-1)
                {
                    count = union(parents,size,curr,neigh,count);
                }
            }
            res.add(count);
        }
        System.out.println(res);
    }
}

