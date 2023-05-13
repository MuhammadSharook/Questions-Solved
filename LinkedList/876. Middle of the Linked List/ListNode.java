
//  * Definition for singly-linked list.
 public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    private int size(ListNode head)
    {
        int count = 0;
        ListNode curr = head;
        while(curr != null)
        {
            curr = curr.next;
            count++;
        }
        return count;
    }
    public ListNode middleNode(ListNode head) 
    {
        int len = size(head)/2;

        ListNode curr = head;
        while(len-- > 0)
        {
            curr = curr.next;
        }
        return curr;
    }
}