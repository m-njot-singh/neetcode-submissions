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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        int carry =0;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + carry;
            int rem = sum;
            carry =0;
            if(sum>9){
                rem = sum%10;
                carry = sum/10;
            }
            ListNode dummy=new ListNode(rem);
            temp.next = dummy;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        
        while(l1!= null){
            int sum = l1.val + carry;
            int rem = sum;
            carry =0;
            if(sum>9){
                rem = sum%10;
                carry = sum/10;
            }
            ListNode dummy=new ListNode(rem);
            temp.next = dummy;
            temp= temp.next;
            l1 = l1.next;
        }

        while(l2!=null){
            int sum = l2.val + carry;
            int rem = sum;
            carry =0;
            if(sum>9){
                rem = sum%10;
                carry = sum/10;
            }
            ListNode dummy=new ListNode(rem);
            temp.next = dummy;
            temp = temp.next;
            l2 = l2.next;
        }
        if(carry!=0){
            ListNode dummy = new ListNode(carry);
            temp.next = dummy;
            temp = temp.next;
        }
        return ans.next;
    }
}
