class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // Find lengths of both linked lists
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        
        // Equalize the lengths by padding the shorter list with zeros
        if (len1 < len2) {
            head1 = padList(head1, len2 - len1);
        } else if (len2 < len1) {
            head2 = padList(head2, len1 - len2);
        }
        
        // Perform the subtraction
        BigInteger num1 = linkedListToBigInteger(head1);
        BigInteger num2 = linkedListToBigInteger(head2);
        BigInteger result = num1.subtract(num2).abs();
        
        // Convert the result back to a linked list
        return bigIntegerToLinkedList(result);
    }

    // Helper method to find the length of the linked list
    private int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // Pad the linked list with leading zeros to make it of the given length
    private Node padList(Node head, int padding) {
        Node dummy = new Node(0);
        Node current = dummy;
        for (int i = 0; i < padding; i++) {
            current.next = new Node(0);
            current = current.next;
        }
        current.next = head;
        return dummy.next;
    }

    // Convert a linked list to a BigInteger
    private BigInteger linkedListToBigInteger(Node head) {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
        }
        return new BigInteger(sb.toString());
    }

    // Convert a BigInteger to a linked list
    private Node bigIntegerToLinkedList(BigInteger bigInt) {
        String str = bigInt.toString();
        Node head = new Node(Character.getNumericValue(str.charAt(0)));
        Node current = head;
        for (int i = 1; i < str.length(); i++) {
            current.next = new Node(Character.getNumericValue(str.charAt(i)));
            current = current.next;
        }
        return head;
    }
}
