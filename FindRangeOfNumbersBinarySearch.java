// May - 11

// Problem Statement:

// There is a road in a hill area, the road is flat in some places and slope 
// in some places (only upwards). There are N lamp posts are fixed on one side 
// of the road. The lights on the lamp posts are arranged in horizontal line, 
// for making this arrangement, the lamp post are made with different heights.

// You will be given the heights of the lamp posts from top of the hill to 
// the bottom of the hill. And you will be given an height H, your task is to find 
// the starting and ending position of the lamp posts with height H. 
// If there is no such lamp post with height H, return [-1, -1].

// Complete your code with O(log n) runtime complexity.

// Input Format:
// -------------
// Line-1 -> Two space separated integers N and H, number of lamp posts and height H.
// Line-2 -> N space separated integers, heights of the lamp posts.

// Output Format:
// --------------
// Print two integers set, starting and ending positions of the lamp posts with height H.


// Sample Input-1:
// ---------------
// 10 5
// 2 3 3 5 5 5 8 9 9 9

// Sample Output-1:
// ----------------
// [3, 5]


// Sample Input-2:
// ---------------
// 10 6
// 2 3 3 5 5 5 8 9 9 9

// Sample Output-2:
// ----------------
// [-1, -1]



import java.util.*;

class FindRangeOfNumberBinarySearch
{
    
    public static int binarySearchLeftMost(int n, int heights[], int h)
    {
        int low=0;
        int high=n-1;
        int leftIndex=-1;
        int mid=0;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(heights[mid]==h)
            {
                leftIndex=mid;
                high=mid-1;
            }
            else if(heights[mid]>h)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        
        return leftIndex;
    }
    
    public static int binarySearchRightMost(int n, int heights[], int h)
    {
        int low=0;
        int high=n-1;
        int rightIndex=-1;
        int mid=0;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(heights[mid]==h)
            {
                rightIndex=mid;
                low=mid+1;
            }
            else if(heights[mid]>h)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        
        return rightIndex;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int h=sc.nextInt();
        int heights[]=new int[n];
        for(int i=0;i<n;i++)
        {
            heights[i]=sc.nextInt();
        }
        
        ArrayList<Integer> range=new ArrayList<Integer>();    
        int leftIndex=binarySearchLeftMost(n,heights,h);
        int rightIndex=binarySearchRightMost(n,heights,h);
        range.add(leftIndex);
        range.add(rightIndex);
        System.out.println(range);
        
    }
}