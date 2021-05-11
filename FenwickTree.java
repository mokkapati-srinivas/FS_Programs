// Problem Statement:

// Malika taught a new fun time program practice for Engineering Students.
// As a part of this she has given set of numbers, and asked the students 
// to find the sum of numbers between indices S1 and S2 (S1<=S2), inclusive.

// Now it’s your task to implement the Solution class:
// 	- public Solution(int[] nums) : Initializes the object with the integer array nums .
// 	- public long sum(int S1, int S2): Returns the sum of the subarray nums[S1, S2] 
// 	(i.e., nums[S1] + nums[S1 + 1], ..., nums[S2] ).


// Input Format:
// -------------
// Line-1: An integer n, size of the array nums[] (set of numbers).
// 		where 1 <= n <= 22000
// Line-2: Two integers S1 and S2, index positions 
// 		where 0 <= S1 <= S2 < n

// Output Format:
// --------------
// An integer, sum of integers between indices(s1, s2).


// Sample Input-1:
// ---------------
// 8
// 2 6

// Sample Output-1:
// ----------------
// 2864403

// NOTE: 
// ----
// First 8 values of the input are: 
// 115053, 59099, 681359, 526248, 123844, 612168, 920784, 591204

class Solution{
    static int arr[];
    static int n;
    static long fenwick[];
    public Solution(int nums[])
    {
        arr=nums;
        n=arr.length;
        fenwick=new long[n+1];
        for(int i=0;i<n;i++)
        {
            this.update(i+1,arr[i]);
        }
    }
    
    public static long query(int idx)
    {
        long sum=0;
        while(idx>0)
        {
            sum+=fenwick[idx];
            idx=idx-Integer.lowestOneBit(idx);
        }
        
        return sum;
    }
    
    public static void update(int idx,int delta)
    {
        while(idx<=n+1)
        {
            fenwick[idx]+=delta;
            idx=idx+Integer.lowestOneBit(idx);
        }
    }
    
    public long sum(int s1,int s2)
    {
        
        long res=query(s2+1)-query(s1);
        
        return res;
    }
    
}