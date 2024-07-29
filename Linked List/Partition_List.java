class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode curr, prev, insertionNode = null, preHead = new ListNode(-1, head);
            
        for (curr = head, prev = preHead; curr != null; prev = curr, curr = curr.next) {
      
            // initialize the insertion node with the first node greater than or equals to x
            if (curr.val >= x && insertionNode == null) {
                insertionNode = prev;
                continue;
            }

             if (curr.val < x) {
                // no node greater than or equals to X was found
                // so we don't need to do anything
                if (insertionNode == null) {
                    continue;
                }

                // move current node to be after insertion node
                prev.next = curr.next;
                curr.next = insertionNode.next;
                insertionNode.next = curr;

                // make current node the new insertion node
                insertionNode = curr;
            }
        }

        return preHead.next;
        
    }
}