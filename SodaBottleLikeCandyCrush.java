// Problem Statement:


// AMB mall to attract kids and to increase their economy they came to have 
// a separate Fun Zone. They opened a stall by name Soda Bears. We have an 
// LED display panel with different colours of Soda bears.

// You will be given a 2D integer panel representing the grid of a Soda bears, 
// we have different color-codes as positive integer in panel [p][q] of each 
// coloured soda bears. 
// If a cell in panel[p][q]=0, representing at position (p,q) is empty. 

// The given panel represents the state of game according to participants move. 
// Now it’s your aim to make panel to a stable state by merging Soda Bears 
// with certain conditions:

// 1. If three or more soda bears of the same colour are adjacent vertically or 
// horizontally, "merge" them all at the same time - these locations become empty.

// 2. After merging all Soda Bears simultaneously, if an empty space on the panel
// has soda bears on top of itself, then these bears will drop until they hit 
// another bear or bottom at the same time. 
// (No new soda bear will drop outside the top boundary.)

// 3. After the above steps, there may exist more bears that can be merged. 
// If so, you need to repeat the above steps.

// 4. If there does not exist more bears for merge (i.e. the panel is stable), 
// then return the current panel.

// Repeat the procedure for stable panel, then return the current panel state.

// Input Format:
// -------------
// Line-1: Two space separated integers, M and N size of panel
// Next M lines: N space separated integers, color codes of soda bears.

// Output Format:
// --------------
// Print the stable format of panel.


// Sample Input:
// --------------
// 8 4
// 11 5 13 5
// 12 13 5 13
// 1 2 3 4
// 11 2 3 4
// 2 2 2 5
// 13 13 3 4
// 14 13 13 14
// 12 12 11 13

// Sample Output:
// ----------------
// 0 0 0 5
// 11 0 0 13
// 12 0 0 4
// 1 0 0 4
// 11 0 13 5
// 13 0 5 4
// 14 5 13 14
// 12 12 11 13

import java.util.*;

class ColouredSoda
{
    
    public static boolean getHorizontal(int soda[][], int m, int n, TreeSet<Integer> indices)
    {
        boolean flag=false;
        for(int i=0;i<m;i++)
        {
            ArrayList<Integer> ind=new ArrayList<Integer>();
            int count=1;
            int prev=soda[i][0];
            ind.add(n*i);
            for(int j=1;j<n;j++)
            {
                if(soda[i][j]!=0 && soda[i][j]==prev)
                {
                    count++;
                    ind.add(n*i+j);
                }
                else
                {
                    if(count>=3)
                    {
                        flag=true;
                        for(int a:ind)
                        {
                            indices.add(a);
                        }
                    }
                    prev=soda[i][j];
                    ind.clear();
                    ind.add(n*i+j);
                    count=1;
                }
            }
            if(count>=3)
            {
                flag=true;
                for(int a:ind)
                {
                    indices.add(a);
                }
            }
            
        }
        return flag;
    }
    
    public static boolean getVertical(int soda[][], int m, int n, TreeSet<Integer> indices)
    {
        boolean flag=false;
        for(int j=0;j<n;j++)
        {
            ArrayList<Integer> ind=new ArrayList<Integer>();
            int count=1;
            int prev=soda[0][j];
            ind.add(j);
            for(int i=1;i<m;i++)
            {
                if(soda[i][j]!=0 && soda[i][j]==prev)
                {
                    count++;
                    ind.add(n*i+j);
                }
                else
                {
                    if(count>=3)
                    {
                        flag=true;
                        for(int a:ind)
                        {
                            indices.add(a);
                        }
                    }
                    prev=soda[i][j];
                    ind.clear();
                    ind.add(n*i+j);
                    count=1;
                }
            }
            if(count>=3)
            {
                flag=true;
                for(int a:ind)
                {
                    indices.add(a);
                }
            }
        }
        return flag;
    }
    
    public static void moveZeros(int soda[][], int m, int n, TreeSet<Integer> indices)
    {
        for(int ind:indices)
        {
            int row=ind/n;
            int col=ind%n;
            soda[row][col]=0;
        }
        
        for(int ind:indices)
        {
            int row=ind/n;
            int col=ind%n;
            
            while(row>0)
            {
                int temp=soda[row][col];
                soda[row][col]=soda[row-1][col];
                soda[row-1][col]=temp;
                row=row-1;
            }
        }
    }
    
    public static void getFinalSoda(int soda[][], int m, int n)
    {
        
        while(true)
        {
            TreeSet<Integer> indices=new TreeSet<Integer>();
            boolean horizontal=getHorizontal(soda,m,n,indices);
            boolean vertical=getVertical(soda,m,n,indices);
            // System.out.println(indices);
            if(indices.size()==0)
            {
                break;
            }
            else
            {
                moveZeros(soda,m,n,indices);                   
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(soda[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        
        int soda[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                soda[i][j]=sc.nextInt();
            }
        }
        
        getFinalSoda(soda,m,n);
    }
}

