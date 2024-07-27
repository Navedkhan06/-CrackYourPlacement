class Solution {

    // Helper function to reverse a segment of k nodes
    public ListNode reverseKNodes(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        // Reverse the first k nodes in the segment
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            // Check if there are at least k nodes remaining
            ListNode start = prev.next;
            ListNode end = curr;
            int count = 0;

            // Move end pointer to the end of the current k-group
            while (end != null && count < k) {
                end = end.next;
                count++;
            }

            // If we have exactly k nodes, reverse the current k-group
            if (count == k) {
                ListNode nextSegmentStart = end; // Save the start of the next segment
                ListNode reversedSegmentStart = reverseKNodes(start, k); // Reverse the current k-group

                // Connect the reversed segment back into the list
                prev.next = reversedSegmentStart;
                start.next = nextSegmentStart;

                // Update prev and curr pointers for the next iteration
                prev = start;
                curr = nextSegmentStart;
            } else {
                // If there are fewer than k nodes remaining, break out of the loop
                break;
            }
        }

        return dummy.next; // Return the head of the modified list
    }
}