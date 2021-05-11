// May - 10

// Bunny is playing with binary strings.
// He wants to divide a binary string B into 3 parts, each part length is >= '1',
// when we combine the 3 parts will result the string B.
// eg. B is divided as d1, d2, d3. if we combine d1, d2 and d3 should result B.

// Your task is to find the number of ways to divide the Binary String B 
// into 3 parts, where each part should contain equal number of 1's.

// The answer may be too large, return it modulo 10^9 + 7.

// Input Format:
// -------------
// A string B, a binary string B.

// Output Format:
// --------------
// Print an integer, number of ways to break B.


// Sample Input-1:
// ---------------
// 01010010

// Sample Output-1:
// ----------------
// 6

// Explanation:
// ------------
// There are six ways to break S into 3 parts 
// where each part contain the equal number of  1's.
// 01 | 01 | 0010
// 01 | 010 | 010
// 01 | 0100 | 10
// 010 | 1 | 0010
// 010 | 10 | 010
// 010 | 100 | 10


// Sample Input-2:
// ---------------
// 010010

// Sample Output-2:
// ----------------
// 0



import java.util.*;

class BinaryStringDivision
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String bin=sc.next();
        int n=bin.length();
        int onesCount=0;
        for(int i=0;i<n;i++)
        {
            if(bin.charAt(i)=='1')
            {
                onesCount++;
            }
        }
        
        int mod=1000000007;
        if(onesCount%3==0)
        {
            if(onesCount==0)
            {
                int possibilities=(((n-1)*(n-2))/2)%mod;
                System.out.println(possibilities);
            }
            else
            {
                ArrayList<Integer> startGroup=new ArrayList<Integer>();
                ArrayList<Integer> endGroup=new ArrayList<Integer>();
                
                int countPerGroup=onesCount/3;
                int count=0;
                for(int i=0;i<n;i++)
                {
                    
                    if(bin.charAt(i)=='1')
                    {
                        if(count==0)
                        {
                            startGroup.add(i);
                        }
                        count++;
                        if(count==countPerGroup)
                        {
                            endGroup.add(i);
                            count=0;
                        }
                    }
                }
                
                int result=1;
                int grpLen=startGroup.size();
                int possibilities=0;
                int zeros=0;
                for(int i=0;i<grpLen-1;i++)
                {
                    zeros=startGroup.get(i+1)-endGroup.get(i)-1;
                    possibilities=zeros+1;
                    result=((result%mod)*(possibilities%mod))%mod;
                }
                
                System.out.println(result);
            }
            
        }
        else
        {
            System.out.println(0);
        }
    }
}