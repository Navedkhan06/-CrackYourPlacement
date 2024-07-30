class Solution {
    public Node flatten(Node head) {
        flat(head);
        return head;
    }
    
    public Node flat(Node head){
        Node curr = head;
        Node last = head;
        while(curr!=null){
            if(curr.child!=null){
                //if we encounter child we will try to flatten that child and return its tail
                Node midTail = flat(curr.child);

                //if current node next is not null we need to connect it with curr next
                Node next = curr.next;
                if(next!=null){
                    midTail.next = next;
                    next.prev = midTail;   
                }

                //there we are connecting mid node's first node with curr node next pointer
                curr.next = curr.child;
                curr.child.prev = curr;

                //we make sure all child nodes should be null;
                curr.child = null;

                //there, we are giving curr pointer to midTail which is the end of child linked list
                curr = midTail;
            }
            //we used last pointer to get the last node of child
            last = curr;
            curr = curr.next;
        }
        return last;
    }
}