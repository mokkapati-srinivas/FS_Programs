// May - 24

// Manoj is given a box full of balls with several colors, 
// each colored ball is uniquely identified by a number.

// All the balls are arranged in a line randomly.
// He is given the arrangement as an array of numbers, colored balls.
// He has to form the subarray of size S from left to right, and 
// find the number of diffferent colors in each subarray.

// Your task is to help Manoj to find the number of different colored balls 
// in each subarray and print them as an array.

// Input Format:
// -------------
// Line-1: Two integers N and S, number of balls, size of subarray.
// Line-2: N space separated integers, colors of the balls in the line.

// Output Format:
// --------------
// Print an array of integers.


// Sample Input-1:
// ---------------
// 7 3
// 2 3 4 3 3 2 4

// Sample Output-1:
// ----------------
// [3, 2, 2, 2, 3]


// Sample Input-2:
// ---------------
// 8 4
// 1 2 2 2 2 3 4 5

// Sample Output-2:
// ----------------
// [2, 1, 2, 3, 4]


import java.util.*;

class NumberOfUniqueElementsInEachSubArrayOfSizeS
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int balls[]=new int[n];
        for(int i=0;i<n;i++)
        {
            balls[i]=sc.nextInt();
        }
        
        HashMap<Integer,Integer> frequency=new HashMap<Integer,Integer>();
        int distinctBalls=0;
        for(int i=0;i<s;i++)
        {
            if(frequency.get(balls[i])==null)
            {
                frequency.put(balls[i],1);
                distinctBalls++;
            }
            else
            {
                int currCount=frequency.get(balls[i]);
                frequency.put(balls[i],currCount+1);
            }
        }
        
        ArrayList<Integer> result=new ArrayList<Integer>();
        result.add(distinctBalls);
        
        int right=s;
        int prevLeft=0;
        while(right<n)
        {
            if(frequency.get(balls[prevLeft])==1)
            {
                distinctBalls--;
                frequency.remove(balls[prevLeft]);
            }
            else
            {
                int currCount=frequency.get(balls[prevLeft]);
                frequency.put(balls[prevLeft],currCount-1);
            }
            
            if(frequency.get(balls[right])==null)
            {
                frequency.put(balls[right],1);
                distinctBalls++;
            }
            else
            {
                int currCount=frequency.get(balls[right]);
                frequency.put(balls[right],currCount+1);
            }
            result.add(distinctBalls);
            
            right++;
            prevLeft++;
        }
        
        System.out.println(result);
    }
}