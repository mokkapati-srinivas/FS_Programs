// Problem Statement:

// Sukumar is a math teacher. He has 1*N matrix, filled with positive numbers.
// He has given a task to his students. They have to form G number of groups
// using the numbers of the matrix, you can use each number only once.
// And the sum of the numbers in each group should be equal.
// The groups may contain one or more elements.

// Your task is to help the students, to check whether is it possible to make G groups
// from the numbers of the given matrix.
// If possible, print true. Otherwise, print false.


// Input Format:
// -------------
// Line-1: Two space separated integers, N and G
// Line-2: N space separated integers, list[]

// Output Format:
// --------------
// Print a boolean result.


// Sample Input-1:
// ---------------
// 7 4
// 3 2 5 1 8 6 7

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 6 3
// 3 2 5 1 6 5

// Sample Output-2:
// ----------------
// flase


import java.util.*;

class FormGSubsetsWithSameSum
{
    
    public static boolean findGSubsetsWithSameSum(int nums[], int n, int reqSum, int visited[], int g, int currSum, int currInd)
    {
        if(g==0)
        {
            return true;
        }
        
        if(currSum==reqSum)
        {
            return findGSubsetsWithSameSum(nums,n,reqSum,visited,g-1,0,0);
        }
        
        for(int i=currInd;i<n;i++)
        {
            if(visited[i]==0 && currSum+nums[i]<=reqSum)
            {
                visited[i]=1;
                if(findGSubsetsWithSameSum(nums,n,reqSum,visited,g,currSum+nums[i],i+1))
                {
                    return true;
                }
                visited[i]=0;
            }
        }
        
        return false;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int g=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        
        int total=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            total+=nums[i];
            maxi=Math.max(maxi,nums[i]);
        }
        if(total%g!=0 || maxi>(total/g))
        {
            System.out.println(false);
        }
        else
        {
            int reqSum=total/g;
            int visited[]=new int[n];
            boolean result=findGSubsetsWithSameSum(nums,n,reqSum,visited,g,0,0);
            System.out.println(result);
        }
    }
}
