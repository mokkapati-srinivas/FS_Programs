// Problem Statement:

// A group of K friends visited a bakery. There are N items available in the menu 
// and the price of N items is given as an array, price[], where price[i] is 
// the cost of i-th item. The bakery follows a strange rule, the prices of items 
// may shuffle at any point of time, and every order should contain consecutive items 
// from the menu.

// The friends group, placed K orders, where order[]=[from, to], 
// so the bill amount of the order[i] is the sum of prices of items, 
// price[from] + price[from+1] + ... + price[to-1] + price[to].

// The bakery owner wants to maximize the profit, by shuffling the prices of the items 
// before preparing the bills. He can shuffle the prices only once in a day.

// Your task is to help the bakery owner to maximize the overall bill amount 
// for K orders placed byy the friends group and print the total bill amount.


// Input Format:
// -------------
// Line-1: Two integers, N and K.
// Line-2: N space separated integers, price[].
// Next K lines: Two space separated integers, from and to values of each order.

// Output Format:
// --------------
// Print an integer result, maximized bill amount of all the K orders.


// Sample Input-1:
// ---------------
// 5 2
// 6 3 8 2 9
// 0 2
// 1 3

// Sample Output-1:
// ----------------
// 43

// Explanation:
// ------------
// One of the possible shuffled prices are : [3,8,9,6,2]
// Bill of order-1 is: price[0] + price[1] + price[2] = 3 + 8 + 9 = 20
// Bill of order-2 is: price[1] + price[2] + price[3] = 8 + 9 + 6 = 23 
// Total bill amount is : 43

// Sample Input-2:
// ---------------
// 7 3
// 7 2 5 4 3 1 8
// 1 4
// 0 2
// 3 5

// Sample Output-2:
// ----------------
// 53

// Explanation:
// ------------
// One of the possible shuffled prices are : [3,4,5,7,8,2,1]
// Bill of order-1 is: price[1] + price[2] + price[3] + price[4]= 4 + 5 + 7 + 8 = 24
// Bill of order-2 is: price[0] + price[1] + price[2] = 3 + 4 + 5 = 12
// Bill of order-2 is: price[3] + price[4] + price[5] = 7 + 8 + 2 = 17
// Total bill amount is : 53


import java.util.*;

class MaximizeProfitByShufflingOnce
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int price[]=new int[n];
        for(int i=0;i<n;i++)
        {
            price[i]=sc.nextInt();
        }
        int orders[][]=new int[k][2];
        for(int i=0;i<k;i++)
        {
            orders[i][0]=sc.nextInt();
            orders[i][1]=sc.nextInt();
        }
        
        int count[]=new int[n];
        for(int i=0;i<k;i++)
        {
            int left=orders[i][0];
            int right=orders[i][1];
            for(int j=left;j<=right;j++)
            {
                count[j]++;
            }
        }
        
        int totalProfit=0;
        Arrays.sort(price);
        Arrays.sort(count);
        for(int i=n-1;i>=0;i--)
        {
            if(count[i]==0)
            {
                break;
            }
            else
            {
                totalProfit+=(price[i]*count[i]);
            }
        }
        System.out.println(totalProfit);
    }
}

