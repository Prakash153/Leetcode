// 1.   store the current's next into temp. 
// 2.   link the current's next to previous. 
// 3.   replace previous with current. 
// 4.   store the current's next into current for iteration. 
     


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head ; 
        ListNode prev = null ; 
        while(curr != null){
            ListNode temp = curr.next; 
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
}
