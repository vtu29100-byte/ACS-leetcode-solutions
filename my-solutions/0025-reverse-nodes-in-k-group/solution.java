class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // Check whether k nodes are available
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Less than k nodes -> keep them unchanged
        if (count < k) {
            return head;
        }

        // Reverse k nodes
        curr = head;
        ListNode prev = null;

        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // head is now the last node of this group
        head.next = reverseKGroup(curr, k);

        return prev;
    }
}
