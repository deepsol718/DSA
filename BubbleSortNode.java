public class BubbleSortNode {
    public static Node<Integer> bubbleSort(Node<Integer> head){
        if (head == null || head.next == null) return head;

        Node<Integer> small = head.next;
        Node<Integer> prev = head;

        while (small != null){
            if (small.data < head.data){
                prev.next = head;
                Node<Integer> next = small.next;
                small.next = head.next;
                head.next = next;
                Node<Integer> temp = small;
                small = head; //changing back the value of head and small
                head = temp;
            }
            prev = small;
            small = small.next;
        }

        Node<Integer> ans = bubbleSort(head.next);
        head.next = ans;
        return head;
    }
}
