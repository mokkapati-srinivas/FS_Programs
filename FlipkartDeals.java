// Problem Statement:


// FLIPKART online grocery zone offering best prices, and combo offers on a variety
// of items. The store has N items which are been sold with a certian price per unit.

// There are also combo offers, and each combo offer consists of one or more 
// variety of items with a price tag. Each combo offer is represented in the form 
// of a list, the last number represents the amount you need to pay for this combo 
// offer, other values represents how many specific items you could get if you buy 
// this offer. 

// Customer can avail the combo offers as many times as they wanted.

// Now you are been given pricelist of N items, K number of combo offers, and 
// the number of items of each variety need to buy. 

// Now it's your turn to find the lowest price you have to pay for to buy exactly 
// certain items as given, where you could make optimal use of the combo offers.

// Input Format:
// -------------
// Line-1: Two integers N and K, number of varieties, and number of Combo offers 
// Line-2: N space seprated inteegrs, prices of N varieties.
// Next K lines: 'N+1' space separated inteegrs, number of items of each variety and
//               and last number is cost to buy all these variety of items.
// Last Line: N space separated integers, number of items of each variety to buy.

// Output Format:
// --------------
// Print an integer, lowest price to pay for items to buy.


// Sample Input-1:
// ---------------
// 2 2
// 3 6
// 3 1 12
// 2 3 17
// 6 6

// Sample Output-1:
// ----------------
// 40

// Explanation:
// ------------
// There are two variety of items, X and Y. Their prices are Rs.3 and Rs. 6 respectively.
// In combo offer-1, you can pay Rs.12 for 3X and 1Y
// In combo offer-2, you can pay Rs.17 for 2A and 3B.
// You need to buy 6A and 6B, so you may pay Rs.34 for 4X and 6Y (combo offer-2), 
// and Rs.6 for 2X. So Total of Rs.40


// Sample Input-2:
// ---------------
// 3 2
// 1 2 3
// 1 2 0 4
// 2 1 2 8
// 3 4 2

// Sample Output-2:
// ----------------
// 14

import java.util.*;
class FlipkartDeals
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++)
        {
            prices[i]=sc.nextInt();
        }
        int deals[][]=new int[k][n+1];
        for(int i=0;i<k;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                deals[i][j]=sc.nextInt();
            }
        }
        int requirement[]=new int[n];
        for(int i=0;i<n;i++)
        {
            requirement[i]=sc.nextInt();
        }
        
        Arrays.sort(deals,(a,b)->{
            int len=a.length;
            int suma=0;
            int sumb=0;
            for(int i=0;i<len-1;i++)
            {
                suma+=a[i];
                sumb+=b[i];
            }
            if(suma>sumb)
                return -1;
            else if(sumb>suma)
                return 1;
            else
            {
                if(a[len-1]>b[len-1])
                    return -1;
                else
                    return 1;
            }
        });
        
        // for(int i=0;i<k;i++)
        // {
        //     for(int j=0;j<n+1;j++)
        //     {
        //         System.out.print(deals[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int i=0;
        int flag=0;
        int items=0;
        int totalPrice=0;
        while(i<k)
        {
            flag=0;
            items=Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                if(requirement[j]<deals[i][j])
                {
                    flag=1;
                    break;
                }
                if(deals[i][j]!=0 && items>requirement[j]/deals[i][j])
                {
                    items=requirement[j]/deals[i][j];
                }
            }
            if(flag==0)
            {
                for(int j=0;j<n;j++)
                {
                    requirement[j]-=(items*deals[i][j]);
                }
                totalPrice+=(items*deals[i][n]);
            }
            i++;
        }
        
        for(i=0;i<n;i++)
        {
            if(requirement[i]!=0)
            {
                totalPrice+=(requirement[i]*prices[i]);
                requirement[i]=0;
            }
        }
        
        System.out.println(totalPrice);
    }
}

