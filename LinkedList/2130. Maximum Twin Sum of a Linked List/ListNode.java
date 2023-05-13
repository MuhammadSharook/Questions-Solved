// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 class Solution {
    public int pairSum(ListNode head) 
    {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        int maxSum = Integer.MIN_VALUE;
        while(head != slow)
        {
            int sum = prev.val + head.val;
            maxSum = Integer.max(maxSum,sum);
            head = head.next;
            prev = prev.next;
        }
        return maxSum;
    }
}