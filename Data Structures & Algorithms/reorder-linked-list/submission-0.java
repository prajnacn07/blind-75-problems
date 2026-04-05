/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode sec = slow.next; // mid
        ListNode prev = slow.next = null;
        while (sec != null){
            ListNode temp = sec.next;
            sec.next = prev;
            prev = sec;
            sec = temp;
        }

        ListNode first = head;
        sec = prev;
        while(sec != null){
            ListNode temp1 = first.next;
            ListNode temp2 = sec.next;

            first.next = sec;
            sec.next = temp1;
            first = temp1;
            sec = temp2;
        }
        
    }
}
