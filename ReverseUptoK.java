public class ReverseUptoK {
    public static Node kReverse(Node head, int k){
        if (k == 0 || k == 1 || head == null || head.next == null){
            return head;
        }

        int count = k;

        Node tail = head;
        Node next = null;

        //count > 1 is taken because the pointer is already on node 1 (hope u will understand)
        while (count > 1 && tail != null ){
            count--;
            tail = tail.next;
        }
        if (tail != null){
            next = tail.next;
            tail.next = null;
        }
        tail = reverse(head);

        Node ans = kReverse(next, k);
        head.next = ans;
        return tail;
    }

    public static Node iterReverse(Node head){
        if (head == null) return head;

        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static Node reverse(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node ans = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return ans;
    }
}
