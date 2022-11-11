public class LinkedList {
    Node<Integer> head;

    public void push (int element){
        Node new_node = new Node(element);

        if (head == null){
            head = new_node;
        }
        else {
            Node last = head;

            while (last.next != null){
                last = last.next;
            }

            last.next = new_node;
        }
    }

    public void print(){
        Node node = head;

        while (node != null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    public Node<Integer> reverse (Node<Integer> head){
        if (head == null || head.next == null) return head;

        Node<Integer> ans = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return ans;
    }


}
