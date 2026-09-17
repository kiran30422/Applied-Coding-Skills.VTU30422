class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            // Save the next node
            ListNode next = current.next;

            // Reverse the link
            current.next = prev;

            // Move prev forward
            prev = current;

            // Move current forward
            current = next;
        }

        return prev;
    }
}
