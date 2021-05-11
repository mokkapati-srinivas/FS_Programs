// In a birthday party, there are N guests attended the party.
// All of them formed in a circle, each o fthe guest numbered from 1 to N.

// But we have dinner tokens for only N-1 guests.
// and you are given an integer S.

// The distibution of tokens as follows:
// 	1- Intially you visit guest-1.
// 	2- Visit to the next S guests in the circle in clockwise direction including 
// 	visited guest, you may visit some guests more than once.
// 	3- The last guest you visit will get the token and moves out of the circle.
// 	4- You have to repeat the process from step-2, until all the tokens over.
	
// At the only one guest will be leftout without a token.

// You are given the number of guests, N , and an integer S , 
// Your task is to find the guest number who haven't recieved the token.

// Input Format:
// -------------
// Two integers N and S, number of guests N and value of S.

// Output Format:
// --------------
// Print an integer, Guest number remained at the end without a token.


// Sample Input-1:
// ---------------
// 5 3

// Sample Output-1:
// ----------------
// 4

// For the explanation look at Hint.

// Sample Input-2:
// ---------------
// 6 2

// Sample Output-2:
// ----------------
// 5


import java.util.*;

class CircleGuests
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        
        ArrayList<Integer> guests=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            guests.add(i+1);
        }
        int start=0;
        int size=n;
        for(int i=0;i<n-1;i++)
        {
            int remove=(start+s-1)%size;
            guests.remove(remove);
            start=remove;
            size--;
        }
        
        System.out.println(guests.get(0));
    }
}