// Problem Statement:


// In Hyderabad after a long pandemic gap, 
// the Telangana Youth festival Is Organized at HITEX.

// In HITEX, there are a lot of programs planned. During the festival in order
// to maintain the rules of Pandemic, they put a constraint that one person 
// can only attend any one of the programs per day according to planned days.

// Now it’s your turn to implement the "Solution" class in such a way that you need 
// to return the maximum number of programs you can attend according to given rules.

// Explanation:
// ------------
// You have a list of programs ‘p’ and days ’d’, where you can attend only one
// program on one day.

// Programs [p] = [first day, last day], p is the program's first day and the last day.


// Input Format:
// -------------
// Line-1: An integer N, number of programs.
// Line-2: N comma separated pairs, each pair(f_day, l_day) is separated by space.

// Output Format:
// --------------
// An integer, the maximum number of programs you can attend.


// Sample Input-1:
// ---------------
// 4
// 1 2,2 4,2 3,2 2

// Sample Output-1:
// ----------------
// 4


// Sample Input-2:
// ---------------
// 6
// 1 5,2 3,2 4,2 2,3 4,3 5

// Sample Output-2:
// ----------------
// 5

class SegmentTreeApplication_AttendPrograms {
    
    class SegmentTreeNode {
        
        int start, end;
        SegmentTreeNode left, right;
        int val;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            val = 0;
        }
    }
    
    SegmentTreeNode root;
    public int maxPrograms(int[][] events) {
        if (events == null || events.length == 0)
            return 0;
        
        Arrays.sort(events, (a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int lastDay = events[events.length-1][1];
        int firstDay = Integer.MAX_VALUE;
        for (int i = 0; i < events.length; i++) {
            firstDay = Math.min(firstDay, events[i][0]);
        }
        
        root = buildSegmentTree(firstDay, lastDay);
        
        int count = 0;
        for (int[] event: events) {
            int availableSlot = query(root, event[0], event[1]);
            if (availableSlot != Integer.MAX_VALUE) {
                count++;
                update(root, availableSlot);
            }
            
        }
        return count;
    }
    
    private SegmentTreeNode buildSegmentTree(int start, int end) {
        if (start > end)
            return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        node.val = start;
        if (start != end) {
            int mid = start + (end - start)/2;
            node.left = buildSegmentTree(start, mid);
            node.right = buildSegmentTree(mid+1, end);
            
        }
        return node;
    }
    
    private void update(SegmentTreeNode curr, int availableSlot) {
        if (curr.start == curr.end) {
            curr.val = Integer.MAX_VALUE;
        }
        else {
            int mid = curr.start + (curr.end - curr.start)/2;
            
            if (mid >= availableSlot) {
                update(curr.left, availableSlot);
            }
            else {
                update(curr.right, availableSlot);
            }
            curr.val = Math.min(curr.left.val, curr.right.val);
        }
    }
    private int query(SegmentTreeNode curr, int start, int end) {
        if(start>end)
            return Integer.MAX_VALUE;
        
        if (curr.start == start && curr.end == end) {
            return curr.val;
        }
        
        int mid = curr.start + (curr.end - curr.start)/2;
        
        return Math.min(query(curr.left, start, mid), query(curr.right, mid+1, end));
    }  
}
