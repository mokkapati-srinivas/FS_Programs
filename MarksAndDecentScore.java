// Problem Statement:

// In a class of N students, each student has secured different marks in final exams, 
// and different levels of decency, The students are numbered from 0,1,2,.. N-1.

// The class teacher defines, compMarks[i] = [p,q], indiactes Student-p secured 
// more marks than Student-q. This information is provided based on valid observations only.
// And, decentScore[p] = d, indicates Student-p has decency level- d.

// Your task is to find and return the result[] as follows:
// 	- result[p] = q, where Student-q has the least level of decency
// 	  [i.e., the student-q with the smallest value of decentScore[q] ]
// 	  among all the students who scores maximum or equal in exams >= Student-p.


// Input Format:
// -------------
// Line-1: An integer N, number of students.
// Next 'N-1' lines: Two space separated integers p and q, compMarks[i] = [p, q] 
// Last Line: N space separated integers, decentScore[].

// Output Format:
// --------------
// Print N space separated integers as result


// Sample Input-1:
// ---------------
// 6
// 1 3
// 2 4
// 3 5
// 0 3
// 3 4
// 4 2 6 8 3 1

// Sample Output-1:
// ----------------
// 0 1 2 1 1 5

// Explanation:
// ------------
// result[3] = 1.
// Student-1 has secured more marks than Student-3,
// Student-0 has secured more marks than Student-3.
// Among [1, 0], the only Student who has least decentScore is Student-1.

// result[4] = 1.
// Student-1 has secured more marks than Student-3, who secured more marks than 3.
// Student-2 has secured more marks than Student-4.
// Among [1,2,3], the only Student who has least decentScore is Student-1.

// You can follow the same for rest of the students also.


import java.util.*;

class MarksAndDecentScore
{
    static int minDecentScoreNode=0;
    public static void findMoreMarksUtil(HashMap<Integer,ArrayList<Integer>> moreMarks, int n, int decentScore[], int i, int curr, int visited[])
    {
        visited[curr]=1;
        if(decentScore[curr]<decentScore[minDecentScoreNode])
        {
            minDecentScoreNode=curr;
        }
        
        for(int neigh: moreMarks.get(curr))
        {
            if(visited[neigh]==0)
            {
                findMoreMarksUtil(moreMarks,n,decentScore,i,neigh,visited);
            }
        }
    }
    
    public static int[] findMoreMarks(HashMap<Integer,ArrayList<Integer>> moreMarks, int n, int decentScore[])
    {
        int result[]=new int[n];
        for(int i=0;i<n;i++)
        {
            result[i]=i;
        }
        
        for(int i=0;i<n;i++)
        {
            int visited[]=new int[n];
            minDecentScoreNode=i;
            findMoreMarksUtil(moreMarks,n,decentScore,i,i,visited);
            result[i]=minDecentScoreNode;
        }
        
        return result;
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<Integer,ArrayList<Integer>> moreMarks=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
            moreMarks.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<n-1;i++)
        {
            int p=sc.nextInt();
            int q=sc.nextInt();
            moreMarks.get(q).add(p);
        }
        int decentScore[]=new int[n];
        for(int i=0;i<n;i++)
        {
            decentScore[i]=sc.nextInt();
        }
        
        int result[]=findMoreMarks(moreMarks,n,decentScore);
        for(int i=0;i<n;i++)
        {
            System.out.print(result[i]+" ");
        }
    }
}

