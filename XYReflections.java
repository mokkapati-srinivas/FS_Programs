// Problem Statement:


// Mr. Brahmi went for shopping at AMB mall after a tired evening and
// he planned to have fun. So he visited the gaming zone. Later he found 
// an interesting game there called "XY-Reflection". 

// This game has a display board and when Brahmi choose a number N, the board display 
// set of numbers from 1 to N, and Brahmi need to find out the count of numbers,
// whose XY-Reflection is a valid and a different number too.

// XY-Reflection of any number is formed as follows:
//     - rotate the number 180degrees.
//     - the digits [0, 1, 6, 8, 9] are valid after 180 degree rotation
      
// A number is said to be valid iff each digit of the rotated number is valid.
// and newly formed number should be diffrent too.

// Can you please help Mr. Brahmi to find the count of valid XY-Reflections.

// NOTE: The XY-Reflection number may be grater than the original number.

// Input Format:
// -------------
// An integer N, numbers from 1 to N will be displayed on board.

// Output Format:
// --------------
// Print an integer, count of valid XY-Reflections.


// Sample Input-1:
// ---------------
// 10

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// Valid XY-Reflections are as follows: 6-> 9, 9-> 6, 10->01



// Sample Input-2:
// ---------------
// 50

// Sample Output-2:
// ----------------
// 6

// Explanation:
// ------------
// Valid XY-Reflections are as follows: 6-> 9, 9-> 6, 10->01, 16-> 61, 18-> 81, 19-> 91

import java.util.*;
class XYReflections
{
    static int count=0;
    
    public static void generateNumAndCount(int len, int xy[], int n, String string, String reverse)
    {
        if(len==0)
        {
            if(Integer.parseInt(string)<=n && !string.equals(reverse))
            {
                count++;
            }
            return;
        }
        
        for(int i=0;i<5;i++)
        {
            if(xy[i]==0 && string.equals(""))
                continue;
                
            String tempstring=string+xy[i];
            String tempreverse=reverse;
            if(xy[i]==6)
                tempreverse="9"+tempreverse;
            else if(xy[i]==9)
                tempreverse="6"+tempreverse;
            else
                tempreverse=xy[i]+tempreverse;
                
            generateNumAndCount(len-1,xy,n,tempstring,tempreverse);
        }
        
        return;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int len=(""+n).length();
        int xy[]={0,1,6,8,9};
        for(int i=1;i<=len;i++)
        {
            generateNumAndCount(i,xy,n,"","");   
        }
        
        System.out.println(count);
    }
}
