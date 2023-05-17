public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 != null)
        {
            sum = carry;
            if(l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }
            ans.next = new ListNode(sum % 10);
            ans = ans.next;
            carry = sum / 10;
        }
        if(carry == 1)
        {
            ans.next = new ListNode(1);
            ans = ans.next;
        }
        return (dummy.next);
    }
}