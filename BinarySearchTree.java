public class BinarySearchTree {
    BinaryTreeNode<Integer> root;
    int size = 0;

    public static void helper(){

        int[] arr = new int[]{1,2,3,4,5,6,7};



//        BinaryTreeNode<Integer> root = arrayToBST(arr, 0, arr.length-1);
        BinaryTreeNode<Integer> root = BinaryTreeHelper.takeInput();
        BinaryTreeHelper.printUsingQ(root);
        System.out.print("inOrder: "+" ");
        inOrder(root);
        System.out.println();
        System.out.print("preOrder: "+" ");
        preOrder(root);
//        System.out.println("Printing reverse InOrder of Binary Search Tree");
//        reverseInOrder(root);
//        System.out.println();
//        System.out.println("Height: "+height(root, 0       ));
//        System.out.println(isBST(root,-1));

    }

    //constructing a balance binary tree from array to BinarySearchTree using sorted array
    public static BinaryTreeNode<Integer> arrayToBST(int[] arr, int start, int end){
        if (arr.length == 0 || start > end) return null;

        int middle = (start + end)/2;
        int data = arr[middle];

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);

        int leftStart = start;
        int leftEnd = middle - 1;
        int rightStart = middle + 1;
        int rightEnd = end;

        root.left = arrayToBST(arr, leftStart, leftEnd);
        root.right = arrayToBST(arr, rightStart, rightEnd);

        return root;
    }

    public static void reverseInOrder(BinaryTreeNode<Integer> root){
        if (root == null) return;

        reverseInOrder(root.right);
        System.out.print(root.data+" ");
        reverseInOrder(root.left);
    }

    public static Node<Integer> BSTtoLinkedList(BinaryTreeNode<Integer> root, Node<Integer> head){
        if (root == null) return null;

        Node<Integer> ansOne = BSTtoLinkedList(root.right, head);
        head = new Node<>(root.data);
        head.next = ansOne;
        Node<Integer> ansTwo = BSTtoLinkedList(root.left,head);
        if (ansTwo != null) {
            ansTwo.next = head;
            return head;
        }

        return head;
    }

    public static int height (BinaryTreeNode<Integer> root, int tempHeight){
        if (root == null) return tempHeight-1;

        int ansOne = height(root.left, tempHeight + 1);
        int ansTwo = height(root.right, tempHeight +1);

        return (ansTwo > ansOne)? ansTwo : ansOne;
    }

    public static boolean isBST(BinaryTreeNode<Integer> root, int prev){
        if (root == null) return true;

        boolean oneAns = isBST(root.left, prev);
        if (prev != -1) {
            if (root.data < prev) {
                oneAns = false;
            }
        }
        prev = root.data;
        if (oneAns){
            oneAns = isBST(root.right, prev);
        }

        return oneAns;

    }

    public static void inOrder(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+", ");
        inOrder(root.right);
    }

    public static void postOrder(BinaryTreeNode<Integer> root){
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+", ");
    }

    public static void preOrder(BinaryTreeNode<Integer> root){
        if (root == null) return;

        System.out.print(root.data+", ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
