// Problem Statement:

// There are N bags containing gold boxes. In each bag, gold boxes are with certain weights that are
// arranged according to weights from smallest to largest arranged strictly ,create a method in such a way
// that we need to return the least weight of gold box which is common in all the given bags.
// If we don’t have any least common weight of gold box in any bag then return -1.

// Input Format:
// -------------
// Line-1: Two integers B and N, number of bags and number of goldboxes in each Bag.
// Next B lines: N space separated integers, weights of GoldBoxes.

// Output Format:
// --------------
// Print the least weight of gold box, if found
// Print -1, if not found.


// Sample Input:
// ---------------
// 5 5
// 1 2 3 4 5
// 2 3 6 7 9
// 1 2 3 5 8
// 1 3 4 6 8 
// 2 3 5 7 8

// Sample Output:
// ----------------
// 3


import java.util.*;

class GoldBagsBinarySearch
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int b=sc.nextInt();
        int n=sc.nextInt();
        
        int gb[][]=new int[b][n];
        for(int i=0;i<b;i++)
        {
            for(int j=0;j<n;j++)
            {
                gb[i][j]=sc.nextInt();
            }
        }
        
        int count=0;
        for(int ele:gb[0])
        {
            count=0;
            for(int i=0;i<b;i++)
            {
                int ind=Arrays.binarySearch(gb[i],ele);
                if(ind>=0)
                {
                    count++;
                }
            }
            if(count==b)
            {
                System.out.println(ele);
                break;
            }
        }
        if(count!=b)
        {
            System.out.println(-1);
        }
    }
}

