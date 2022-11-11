import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    //main function written again to remove confusion

    public static void main(String[] args) {
//       /*
//        LinkedList list = new LinkedList();
//        list.insert(1);
//        list.insert(2);
//        list.insert(3);
//        list.insert(4);
//        list.insert(5);
//        list.insert(6);
//        list.insert(7);
//
//        Node head = new Node(6);
//        Node tail = head;
//
//        for (int i = 2 ; i < 7 ; i ++){
//            tail.next = new Node(7-i);
//            tail = tail.next;
//        }
//
//       // head = ReverseUptoK.kReverse(head, 3);
//        //head = ReverseUptoK.iterReverse(head);
//        //head = ReverseUptoK.reverse(head);
//        head = BubbleSortNode.bubbleSort(head);
//
//        while (head != null){
//            System.out.print(head.data+" ");
//            head = head.next;
//        }
//
//
//        //-------------------ArrayList-----------------------------//
//        ArrayList<Node<Integer>> node = new ArrayList<>();
//        Node<Integer> n1 = new Node<>(1);
//        Node<Integer> n2 = new Node<>(2);
//        Node<Integer> n3 = new Node<>(3);
//        Node<Integer> n4 = new Node<>(4);
//        Node<Integer> n5 = new Node<>(5);
//
//        node.add(n1);
//        node.add(n2);
//        node.add(n3);
//        node.add(n4);
//        node.add(n5);
//
//        for (int i = 0 ; i < 5; i ++){
//            System.out.println(node.get(i).data);
//        }
//
//        //--------------------------TreeNode---------------------------------//
//        TreeNode<String> dad = new TreeNode<>("papa");
//        TreeNode<String> son = new TreeNode<>("beta");
//        TreeNode<String> daughter = new TreeNode<>("beti");
//        //dad.children.add(son);
//        //dad.children.add(daughter);
//        //System.out.print(dad.data+" : ");
//        //System.out.print(dad.children.get(0).data+", ");
//        //System.out.print(dad.children.get(1).data);
//        //---------------------Queue----------------------------------------//
//        Queue<TreeNode<String>> q = new Queue<>(dad);
//        q.enqueue(son);
//        q.enqueue(daughter);
//        while (!q.isEmpty()){
//            System.out.println(q.front().data);
//            q.dequeue();
//        }
//
//        */
//        TreeNode<Integer> root = takeInput();
//
//        //printTree(root);
//        printPostOrder(root);
//
//             BinaryTreeHelper.BT();
//             PrabalExam.exam();
//        BinarySearchTree.helper();
//        String s = "AgReEmEnT";
//        charFrequency(s);
//        character(s);
//        HashMapHelper.helper();
//        Heaps.helper();

//    TrieTesting.runner();
//        new DynamicProgramming();
        new Graph();

    }



    public static TreeNode<Integer> takeInput() {
        Scanner s = new Scanner(System.in);

        System.out.println("Write the data for root Node: ");
        int data = s.nextInt();

        TreeNode<Integer> root = new TreeNode<>(data);
        Queue<TreeNode<Integer>> Q = new Queue<>();
        Q.enqueue(root);

        while (!Q.isEmpty()) {
            TreeNode<Integer> temp = Q.dequeue();
            System.out.println("No of children of node: " + temp.data);
            int n = s.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.println("Write the data for " + (i + 1) + " Node: of " + temp.data);
                data = s.nextInt();
                TreeNode<Integer> node = new TreeNode<>(data);
                temp.children.add(node);
                Q.enqueue(node);
            }
        }

        return root;
    }

    public static void printTree(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> Q = new Queue<>();
        Q.enqueue(root);

        while (!Q.isEmpty()) {
            TreeNode<Integer> temp = Q.dequeue();
            System.out.print(temp.data + " : ");
            int n = temp.children.size();
            for (int i = 0; i < n; i++) {
                System.out.print(temp.children.get(i).data + ", ");
                Q.enqueue(temp.children.get(i));
            }
            System.out.println();
        }

    }

    public static int countNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            count += countNodes(root.children.get(i));
        }

        return count;
    }

    public static int totalSum(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int count = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            count += totalSum(root.children.get(i));
        }

        return count;

    }

    public static void printPostOrder(TreeNode<Integer> root) {
        if (root == null) return;
        if (root.children.size() == 0) {
            System.out.println(root.data);
            return;
        }

        int n = root.children.size();

        for (int i = 0; i < n; i++) {
            printPostOrder(root.children.get(i));
        }
        System.out.println(root.data);
    }

    public static void charFrequency(String s) {
        int[] arr = new int[27];

        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i);
            if (temp >= 97) temp -= 'a';
            else temp -= 'A';
            arr[temp]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i);
            if (temp >= 97) temp -= 'a';
            else temp -= 'A';
            if (arr[temp] > 0){
                System.out.print(s.charAt(i) +""+ arr[temp]);
                arr[temp] = 0;
            }


        }
        System.out.println();
//        System.out.println("Nikhil ans: ");
    }

    public static void character(String str){
        int counter[] = new int[256];
        int i, len;
        len = str.length();
        for (i = 0; i < len; i++)
        {
            counter[(int) str.charAt(i)]++;
        }
        for (i = 0; i < 256; i++)
        {
            if (counter[i] != 0)
            {
                System.out.print((char) i + " --> " + counter[i]);
            }
        }
    }
}


