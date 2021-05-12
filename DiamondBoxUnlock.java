//  May - 12

// Kohinoor diamond is robbed by Hrithik,
// He kept the diamond in a suitcase, the suitcase has a lock with 4 circular wheels, 
// and each wheel consist of 0-9 digits in the order 0,1,2,3,4,5,6,7,8,9 only.
// You can rotate a wheel from 0 to 9 or 9 to 0.

// As the diamond is most valuable, the lock has some traps,
// if anybody try to unlock the suitcase and reached any one of the traps,
// the suitcase will be blasted. And you will be dead.

// Initially, the suitcase lock is set to 0000.
// and you will be given the unlock key, your task to find and print
// the minimum number of rotations required to unlock the suitcase.
// If it is not possible to unlock the suitcase without blasting, print -1.

// NOTE:
// In one rotation you can choose any one wheel and 
// rotate to its next or previous digit.


// Input Format:
// -------------
// Line-1: space separated strings, each string of length 4 and contains only digits [0-9]
// Line-2: A string, key to unlock.

// Output Format:
// --------------
// Print an integer, the minimum number of rotations required to unlock.


// Sample Input-1:
// ---------------
// 0302 0202 0203 2323 3003
// 0303 

// Sample Output-1:
// ----------------
// 8

// Explanation:
// ------------
// To unlock the suitcase the valid rotations are as follows:
// 0000 > 1000 > 1100 > 1200 > 1201 > 1202 > 0202 > 0302 > 0303.


// Sample Input-2:
// ---------------
// 6656 6676 6766 6566 5666 7666 6665 6667
// 6666 

// Sample Output-2:
// ----------------
// -1

// Explanation:
// ------------
// You can't unlock the suitcase.


import java.util.*;

class DiamondBoxUnlock
{
    
    public static boolean isPossible(String curr, String traps[], HashSet<String> visited)
    {
        for(String trap:traps)
        {
            if(trap.equals(curr))
            {
                return false;
            }
        }
        
        if(visited.contains(curr))
        {
            return false;
        }
        
        return true;
    }
    
    public static int unlockBox(String start, String end, String traps[])
    {
        for(String trap:traps)
        {
            if(trap.equals(start))
            {
                return -1;
            }
        }
        
        HashSet<String> visited=new HashSet<String>();
        Queue<String> queue=new LinkedList<String>();
        queue.add(start);
        visited.add(start);
        int result=0;
        boolean flag=false;
        parent: while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int s=0;s<size;s++)
            {
                String poll=queue.poll();
                if(poll.equals(end))
                {
                    flag=true;
                    break parent;
                }
                for(int i=0;i<4;i++)
                {
                    int num=poll.charAt(i)-'0';
                    String up=poll.substring(0,i)+((num+1)%10)+poll.substring(i+1,4);
                    if(isPossible(up,traps,visited))
                    {
                        visited.add(up);
                        queue.offer(up);
                    }
                    String down=poll.substring(0,i)+((10+num-1)%10)+poll.substring(i+1,4);
                    if(isPossible(down,traps,visited))
                    {
                        visited.add(down);
                        queue.offer(down);
                    }
                }
            }
            result++;
        }
        
        if(flag==true)
        {
            return result;
        }
        else
        {
            return -1;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String traps[]=sc.nextLine().split(" ");
        String end=sc.next();
        
        int result=unlockBox("0000",end,traps);
        System.out.println(result);
    }
}