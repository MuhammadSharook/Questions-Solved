
// Definition for singly-linked list.

import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) 
    {
        // ArrayList<Integer> l = new ArrayList<>();
        // for(int i = 0; i < lists.length; i++)
        // {
        //     while(lists[i] != null)
        //     {
        //         l.add(lists[i].val);

        //         lists[i] = lists[i].next;
        //     }
        // }

        // Collections.sort(l);
        // ListNode head = new ListNode();
        // ListNode ans = head;
        // for(int i = 0; i < l.size(); i++)
        // {
        //     head.next = new ListNode(l.get(i));
        //     head = head.next;
        // }
        // return ans.next;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode t, ListNode o) ->
        {
            return t.val - o.val;
        });

        for(ListNode l : lists)
        {
            if(l != null)
                pq.add(l);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(pq.size() > 0)
        {
            ListNode top = pq.remove();

            curr.next = top;
            curr = curr.next;

            if(top.next != null)
            {
                pq.add(top.next);
            }
        }
        return dummy.next;
    }
}