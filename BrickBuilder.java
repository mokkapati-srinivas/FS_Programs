// Problem Statement:


// Google created a new mobile app for kids below 12 years with naming 
// convention as Bricks Builder game .The main idea behind the Bricks Builder 
// is to construct a tall tower with all types of available bricks in Brick Builder 
// game set. The game set has certain conditions while constructing the tower.

// Each bricks are having different proportions where nth brick may have 
// height h(i), width w(i) and depth d(i) (real integers). When we place a brick
// on top of another brick the proportions of the bottom base is greater than the
// top brick. The brick has property for rotations can have any side functions as its base.

// Create a method to return maximum height of Brick Builder.
// Following are the key points to note in the problem statement:
// 1) A brick can be placed on top of another brick only if both width and depth 
// of the top placed brick are smaller than width and depth of the lower brick 
// respectively.

// 2) We can rotate bricks such that width is smaller than depth. For example, 
// if there is a brick with dimensions {1x2x3} where 1 is height, 2×3 is base, 
// then there can be three possibilities,{1x2x3},{2x1x3}and{3x1x2}.

// 3) We can use multiple instances of bricks. What it means is, 
// we can have two different rotations of a brick as part of our 
// maximum height of Brick Builder.


// Input Format:
// -------------
// Line-1: An integers N, number of bricks in the set. 
// Next N lines: 3 space separated integers, height, width, depth of each brick.

// Output Format:
// --------------
// Print an integer, maximum height of Bricks Builder game.


// Sample Input:
// --------------
// 3
// 4 6 7
// 1 2 3
// 4 5 6
// 10 12 32

// Sample Output:
// --------------
// 60

// Explanation:
// -------------
// Following are all rotations of the bricks in decreasing order of base area.
// 10 x 12 x 32 
// 12 x 10 x 32
// 32 x 10 x 12
// 4 x 6 x 7
// 4 x 5 x 6
// 6 x 4 x 7
// 5 x 4 x 6
// 7 x 4 x 6
// 6 x 4 x 5
// 1 x 2 x 3
// 2 x 1 x 3
// 3 x 1 x 2

// The height 60 is obtained by bricks 
// {3, 1, 2}
// {1, 2, 3} 
// {6, 4, 5}
// {4, 5, 6} 
// {4, 6, 7}
// {32, 10, 12} 
// {10, 12, 32}

import java.util.*;

class BrickBuilder
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<ArrayList<Integer>> bricks=new PriorityQueue<ArrayList<Integer>>((a,b)->{
            int area=b.get(1)*b.get(2)-a.get(1)*a.get(2);
            return area;
        });
        
        for(int i=0;i<n;i++)
        {
            int h=sc.nextInt();
            int b=sc.nextInt();
            int d=sc.nextInt();
            ArrayList<Integer> temp1=new ArrayList<Integer>();
            temp1.add(h);
            temp1.add(Math.max(b,d));
            temp1.add(Math.min(b,d));
            bricks.add(temp1);
            ArrayList<Integer> temp2=new ArrayList<Integer>();
            temp2.add(b);
            temp2.add(Math.max(h,d));
            temp2.add(Math.min(h,d));
            bricks.add(temp2);
            ArrayList<Integer> temp3=new ArrayList<Integer>();
            temp3.add(d);
            temp3.add(Math.max(h,b));
            temp3.add(Math.min(h,b));
            bricks.add(temp3);
        }
        
        ArrayList<ArrayList<Integer>> bricks2=new ArrayList<ArrayList<Integer>>();

        while(!bricks.isEmpty())
        {
            bricks2.add(bricks.poll());
        }
        
        int dp[]=new int[3*n];
        for(int i=0;i<3*n;i++)
        {
            dp[i]=bricks2.get(i).get(0);
        }
        
        int res=dp[0];
        for(int i=1;i<3*n;i++)
        {
            int ib=bricks2.get(i).get(1);
            int id=bricks2.get(i).get(2);
            int max=0;
            for(int j=0;j<i;j++)
            {
                int jb=bricks2.get(j).get(1);
                int jd=bricks2.get(j).get(2);
                if(jb>ib && jd>id)
                {
                    max=Math.max(max,dp[j]+dp[i]);
                }
            }
            dp[i]=Math.max(max,dp[i]);
            res=Math.max(res,dp[i]);
        }
        
        System.out.println(res);
    }
}

