// Problem Statement:


// Gumadi Baleshwar Rao purchased two boxes (Box1,Box2) of unique weights 
// of gold coins, where first box weights are subset of second box gold weights.

// Now design a method for Gumadi Baleshwar Rao to find all the next largest weights 
// of Box1 gold coins in the corresponding locations of box2 , 
// if doesn’t exist return -1.

// The Next largest Weight is Weight ‘W’ in Box1 is the first largest weight 
// to its right side weight in Box2.

// NOTE: Unique weights means, no two coins will have same weight.

// Input Format:
// -------------
// Line-1: space separated integers, weihts of gold coins in the first box.
// Line-2: space separated integers, weihts of gold coins in the second box.

// Output Format:
// --------------
// Print a list of integers, next largest weights

// Sample Input-1:
// ---------------
// 4 3 2
// 1 3 4 2

// Sample Output-1:
// ----------------
// [-1, 4, -1]


// Sample Input-2:
// ---------------
// 5 6 3 4
// 1 5 3 7 8 6 4 2

// Sample Output-2:
// ----------------
// [7, -1, 7, -1]

import java.util.*;

class NextGreaterElement
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String inp1[]=sc.nextLine().split(" ");
        int n1=inp1.length;
        int box1[]=new int[n1];
        int i=0;
        for(String s:inp1)
        {
            box1[i++]=Integer.parseInt(s);
        }
        String inp2[]=sc.nextLine().split(" ");
        int n2=inp2.length;
        int box2[]=new int[n2];
        i=0;
        HashMap<Integer,Integer> nge=new HashMap<Integer,Integer>();
        for(String s:inp2)
        {
            box2[i]=Integer.parseInt(s);
            nge.put(box2[i],-1);
            i++;
        }
        Stack<Integer> stack=new Stack<Integer>();
        stack.add(0);
        for(i=1;i<n2;i++)
        {
            int top=stack.peek();
            if(box2[i]<=box2[top])
            {
                stack.add(i);
            }
            else
            {
                while(!stack.isEmpty() && box2[stack.peek()]<box2[i])
                {
                    top=stack.pop();
                    nge.put(box2[top],box2[i]);
                }
                stack.add(i);
            }
        }
        
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(i=0;i<n1;i++)
        {
            res.add(nge.get(box1[i]));
        }
        
        System.out.println(res);
    }
}
