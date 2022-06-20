# Given the head of a linked list, remove the nth node from the end of the list and return its head.

idea: To solve this problem in one pass and O(1) EXTRA space the idea is to implement two pointer approach in which we maintain a gap of 'n' betweent the two pointers
slow and fast byh giving a headstart to fast pointer. 

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next; // if n == length of the list 
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
