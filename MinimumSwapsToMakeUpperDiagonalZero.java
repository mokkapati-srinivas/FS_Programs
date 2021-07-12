// Problem Statement:


// You are given a square box with square cubes in it.
// Each cube of size 1*1*1, and colored with either white or blue.
// white cube represented by 1 and blue cube represented by 0.

// In one operation, You can choose any two adjacent horizontal lines of the box and 
// swap them. The box is said to be diagonal box, if all the square cubes 
// above the main diagonal are blue colored.

// Your task is to find the the minimum number of operations needed to arrange the box 
// as diagonal box , if it is not possible to arrange return  -1.

// The main diagonal of a box is the diagonal that starts at cube (0, 0) and
// ends at cube (n-1, n-1) .

// Input Format:
// -------------
// Line-1: An integer, N size of the box.
// Next N lines: N space separated integers, colors of the cubes in the box.

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 3
// 0 1 0
// 1 0 1
// 1 0 0

// Sample Output-1:
// ----------------
// 2


// Sample Input-2:
// ---------------
// 4
// 1 1 0 0
// 1 0 1 0
// 0 1 0 0
// 1 0 1 0

// Sample Output-2:
// ----------------
// -1


import java.util.*;

class MinimumSwapsToMakeUpperDiagonalZero
{
    
    public static int swapBetween(int zeros[], int i, int j)
    {
        int count=0;
        for(int ind=j;ind>i;ind--)
        {
            int temp=zeros[ind-1];
            zeros[ind-1]=zeros[ind];
            zeros[ind]=temp;
            count++;
        }
        
        return count;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int matrix[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=sc.nextInt();
            }
        }
        
        int zeros[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=n-1;j>=0;j--)
            {
                if(matrix[i][j]==0)
                {
                    count++;
                }
                else
                {
                    break;
                }
            }
            zeros[i]=count;
        }
        
        boolean isPossible=true;
        int minSwaps=0;
        mainFor: for(int i=0;i<n;i++)
        {
            int curr=zeros[i];
            int req=n-1-i;
            if(curr<req)
            {
                int swapInd=n;
                for(int j=i+1;j<n;j++)
                {
                    if(zeros[j]>=req)
                    {
                        swapInd=j;
                        break;
                    }
                }
                if(swapInd<n)
                {
                    minSwaps+=swapBetween(zeros,i,swapInd);
                }
                else
                {
                    isPossible=false;
                    break mainFor;
                }
            }
        }
        
        // System.out.println(minSwaps);
        if(isPossible)
            System.out.println(minSwaps);
        else
            System.out.println(-1);
    }
}
