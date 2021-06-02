// June - 02

// Shaggy Rogers is working with numbers.
// He is given a number N, 
// He wants to replace all occurrences of a digit in the number N,
// with another digit between [0-9]. May be with same number too.

// But there should not be any leading zeros in the number after the replacement,
// Or the number should not become zero.

// Rogers can perform the replacement of the occurrences of the digit in N for two 
// times, He will generate two new numbers P and Q, such that the value of |P-Q| 
// should be Maximum.

// Your task is to help Shaggy Roers to find the maximum difference of P and Q possible.


// Input Format:
// -------------
// An integer N, the number

// Output Format:
// --------------
// Print an integer, the maximum difference of P and Q


// Sample Input-1:
// ---------------
// 123

// Sample Output-1:
// ----------------
// 820

// Explanation:
// ------------
// Replacement-1: replace 1 with 9 you will get P as 923
// Replacement-2: replace 2 with 0 you will get Q as 103
// So Max difference is 820.


// Sample Input-2:
// ---------------
// 4254

// Sample Output-2:
// ----------------
// 8008

// Explanation:
// ------------
// Replacement-1: replace 4 with 9 you will get P as 9259
// Replacement-2: replace 4 with 1 you will get Q as 1259
// So Max difference is 8008.


import java.util.*;

class GenerateMaximumAndMinimumNumbers
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String n=sc.next();
        char num[]=n.toCharArray();
        int len=n.length();
        
        HashMap<Integer,ArrayList<Integer>> indices=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<len;i++)
        {
            int curr=num[i]-'0';
            if(indices.get(curr)==null)
            {
                indices.put(curr,new ArrayList<Integer>());
            }
            indices.get(curr).add(i);
        }
        
        int max=Integer.parseInt(n);
        int min=Integer.parseInt(n);
        boolean maxFlag=false;
        boolean minFlag=false;
        for(int i=0;i<len;i++)
        {
            if(maxFlag && minFlag)
            {
                break;
            }
            
            int curr=num[i]-'0';
            if(maxFlag==false && curr<9)
            {
                for(int ind: indices.get(curr))
                {
                    num[ind]='9';
                }
                max=0;
                for(int j=0;j<len;j++)
                {
                    max=max*10+(int)(num[j]-'0');
                }
                for(int ind: indices.get(curr))
                {
                    num[ind]=(char)(curr+'0');
                }
                maxFlag=true;
            }
            if(minFlag==false)
            {
                if(i==0 && curr>1)
                {
                    for(int ind: indices.get(curr))
                    {
                        num[ind]='1';
                    }
                    min=0;
                    for(int j=0;j<len;j++)
                    {
                        min=min*10+(int)(num[j]-'0');
                    }
                    for(int ind: indices.get(curr))
                    {
                        num[ind]=(char)(curr+'0');
                    }
                    minFlag=true;
                }
                else if(i>0 && curr>0 && !indices.get(curr).contains(0))
                {
                    for(int ind: indices.get(curr))
                    {
                        num[ind]='0';
                    }
                    min=0;
                    for(int j=0;j<len;j++)
                    {
                        min=min*10+(int)(num[j]-'0');
                    }
                    for(int ind: indices.get(curr))
                    {
                        num[ind]=(char)(curr+'0');
                    }
                    minFlag=true;
                }
            }
        }
        System.out.println((max-min));
    }
}