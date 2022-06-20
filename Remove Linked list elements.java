Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:

1->2->6->3->4->6->5->null
  remove 6 : 
1->2->3->4->5
  
  code : 
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next; 
        }
        ListNode curr = head ; 
        while(curr !=  null && curr.next != null){
            if(curr.next.val == val){
                curr.next= curr.next.next;
            }else{
                curr=curr.next;
            }
        }
        return head;
    }
}
