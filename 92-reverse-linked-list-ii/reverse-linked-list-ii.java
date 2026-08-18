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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        List<Integer> values = new ArrayList<>();
        for (int i = 1; i <= right; i++) {
            if (i >= left) {
                values.add(curr.val);
            }
            curr = curr.next;
        }
        Collections.reverse(values);
        curr = head;
        for (int i = 1; i <= right; i++) {
            if (i >= left) {
                curr.val = values.remove(0);
            }
            curr = curr.next;
        }
        return head;
    }
}
