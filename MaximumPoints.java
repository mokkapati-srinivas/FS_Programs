// Problem Statement:


// Chinmay playing a game. Game has a display of N numbers in a row, nums[].
// Chinmay has to pick the numbers one after the other.

// Once Chinmay picks a number num[i], she will score num[i] points and 
// the number will be disappared on the board, simultaneously all the numbers having 
// the value 'num[i]+1' or 'num[i]-1' also disappears. 

// Chinmay has to select the numbers on the board, 
// such that no more numbers will be left over on the board.

// Chinmay wants to score maximum number of points.

// Initially chinmay has 0 points with her.
// Can you help Chinmay to score maximum number of points.

// Input Format:
// -------------
// Line-1 -> an integers N, number of numbers on the game board.
// Line-2 -> N space separated integers, numbers on the game board nums[].

// Output Format:
// --------------
// Print an integer as result, maximum score she can get.

// Sample Input-1:
// ---------------
// 3
// 4 5 3

// Sample Output-1:
// ----------------
// 8

// Explanation: 
// ------------
// Delete 5 to earn 5 points, consequently 4 is also deleted.
// Then, delete 3 to earn 3 points.
// Totally 8 is the score.


// Sample Input-2:
// ---------------
// 6
// 4 4 5 5 5 6

// Sample Output-2:
// ----------------
// 15

// Explanation: 
// -------------
// Delete 5 to earn 5 points, deleting both 4's and the 6.
// Then, delete 5 again to earn 5 points, and 5 again to earn 5 points.
// Totally 15 is the score.

import java.util.*;
class MaximumPoints
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
            max=Math.max(max,nums[i]);
        }
        
        int numsCount[]=new int[max+1];
        for(int i=0;i<n;i++)
        {
            numsCount[nums[i]]++;
        }
        int dp[]=new int[max+1];
        if(numsCount[1]!=0)
        {
            dp[1]=(numsCount[1]*1);
        }
        for(int i=2;i<max+1;i++)
        {
            dp[i]=Math.max(dp[i-2]+(i*numsCount[i]),dp[i-1]);
        }
        
        System.out.println(dp[max]);
    }
}

