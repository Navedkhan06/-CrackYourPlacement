class Solution {
    private ListNode temp;
    private boolean stop;
    public void reorderList(ListNode head) {
        temp = head;
        stop = false;
        reorder(head);
    }

    private void reorder (ListNode node) {
        if(node == null)
            return;
        //call recursively util we reach the end
        reorder(node.next);

        //if we have found the stop signal, we should not process anymore.
        if(stop)
            return;

        
        if(node == temp || node == temp.next) {
            //if we are in the middle of the list, we must stop and break the cycle
            node.next = null;
            stop = true;
        }
        else {
            //we merge the two node
            ListNode next = temp.next;
            temp.next = node;
            temp = temp.next;
            temp.next = next;
            temp = temp.next;
        }
    }
}