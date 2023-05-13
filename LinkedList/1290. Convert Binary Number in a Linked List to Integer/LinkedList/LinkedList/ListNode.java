
//  * Definition for singly-linked list.
 public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public int getDecimalValue(ListNode head) 
    {
        ListNode rev = reverse(head);
        ListNode temp = rev;
        int num = 0;
        int p = 0;
        while(temp != null)
        {
            if(temp.val == 1)
            {
                num = num + (int)(Math.pow(2,p));
            }
            p++;
            temp = temp.next;
        }
        return num;
    }
}