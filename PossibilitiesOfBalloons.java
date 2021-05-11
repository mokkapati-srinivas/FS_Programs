// Problems:

// You are decorating a side wall with balloons.
// You have an unlimited set of ballons of three different colors.

// The decoration should have N rows of 3 balloons each. 
// You have to make sure that no two adjacent balloons have the same colour.
// both vertically and horizontally.

// Return the number of ways you can decorate the wall,  
// the answer must be computed modulo 10^9 + 7

// Input Format:
// -------------
// An integer N

// Output Format:
// --------------
// Print an integer as outpur, number of ways to decorate.


// Sample Input-1:
// ---------------
// 1

// Sample Output-1:
// ----------------
// 12

// Explanation:
// ------------
// Suppose the colors are, B, G, R. Given N is 1
// RBR	BRB	GRB
// RBG	BRG	GRG
// RGR	BGR	GBR
// RGB	BGB	GBG


// Sample Input-2:
// ---------------
// 2

// Sample Output-2:
// ----------------
// 54


import java.util.*;
class PossibilitiesOfBalloons
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long mod=1000000007;
        
        long twoColors[]=new long[n];
        long threeColors[]=new long[n];
        twoColors[0]=6;
        threeColors[0]=6;
        for(int i=1;i<n;i++)
        {
            twoColors[i]=twoColors[i-1]*3+threeColors[i-1]*2;
            threeColors[i]=twoColors[i-1]*2+threeColors[i-1]*2;
        }
        
        System.out.println((twoColors[n-1]+threeColors[n-1])%mod);
    }
}

