class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode current = head;
        ListNode prevGroupEnd = null;

        while (current != null) {

            // Find the end of the current group
            ListNode groupEnd = current;

            for (int i = 1; i < k; i++) {
                groupEnd = groupEnd.next;

                // Fewer than k nodes remain
                if (groupEnd == null) {
                    return head;
                }
            }

            // Save the node after the group
            ListNode nextGroup = groupEnd.next;

            // Reverse the current group
            ListNode prev = nextGroup;
            ListNode node = current;

            while (node != nextGroup) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            // Connect previous group to reversed group
            if (prevGroupEnd == null) {
                head = groupEnd;
            } else {
                prevGroupEnd.next = groupEnd;
            }

            // Current is now the end of the reversed group
            prevGroupEnd = current;

            // Move to next group
            current = nextGroup;
        }

        return head;
    }
}
