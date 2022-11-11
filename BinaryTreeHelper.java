import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
//import java.util.Queue;

public class BinaryTreeHelper {
    public static void BT(){
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInput() ;
        printAllKthNodes(root,6,1);
//        printUsingQ(root);
//        System.out.println("PreOrder: ");
//        preOrder(root);
//        System.out.println();
//        System.out.println("PostOrder: ");
//        postOrder(root);
//        System.out.println();
//        System.out.println("inOrder: ");
//        inOrder(root);
//
//        int[] preOrder = new int[]{4, 2, 1, 3, 6, 5, 7};
//        int[] inOrder = new int[]{1, 2, 3, 4, 5, 6, 7};
//        int[] postOrder = new int[]{1, 3, 2, 5, 7, 6, 4};
//        BinaryTreeNode<Integer> node = buildTree(preOrder, inOrder);
//        BinaryTreeNode<Integer> node = makeTree(inOrder, postOrder);
//        System.out.println("make tree ko print krne wale h");
//        printUsingQ(node);
    }
    public static BinaryTreeNode<Integer> getData(Scanner s){
        int rootData;
        System.out.println("Enter data ");
        rootData = s.nextInt();
        if (rootData == -1) return null;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(rootData);
        node.left = getData(s);
        node.right = getData(s);
        return node;
    }

    public static void print(BinaryTreeNode<Integer> root){
        if (root == null) return;

        String toBePrinted = root.data + ": ";

        if (root.left != null){
            toBePrinted += "L: " + root.left.data + ",";
        }
        if (root.right != null){
            toBePrinted += "R: " + root.right.data;
        }
        System.out.println(toBePrinted);
        print(root.left);
        print(root.right);
    }

    public static void printUsingQ(BinaryTreeNode<Integer> root){
        if (root == null){
            System.out.println("tree empty ho chuka h");
            return;
        };

        Queue<BinaryTreeNode<Integer>>  Q = new Queue<>();
        Q.enqueue(root);

        while (!Q.isEmpty()){
            BinaryTreeNode<Integer> temp = Q.dequeue();
            String s = temp.data + ": ";
            if (temp.left != null) {
                s += temp.left.data +", ";
                Q.enqueue(temp.left);
            }
            else{
                s += " ";
            }
            if (temp.right != null) {
                s += temp.right.data +", ";
                Q.enqueue(temp.right);
            }
            System.out.println(s);
        }
    }

    public static BinaryTreeNode<Integer> takeInput(){
        Scanner s = new Scanner(System.in);

        System.out.println("Write data for the root node ");
        int data  = s.nextInt();

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);

        Queue<BinaryTreeNode<Integer>> Q = new Queue<>();
        Q.enqueue(root);

        while (!Q.isEmpty()){
            BinaryTreeNode<Integer> temp = Q.dequeue();
            System.out.println("Left of "+temp.data);
            data = s.nextInt();
            if (data != -1){
                temp.left = new BinaryTreeNode<>(data);
                Q.enqueue(temp.left);
            }
            System.out.println("Right of "+temp.data);
            data = s.nextInt();
            if (data != -1){
                temp.right = new BinaryTreeNode<>(data);
                Q.enqueue(temp.right);
            }
        }

        return root;
    }

    public static void preOrder(BinaryTreeNode<Integer> root){
        if (root == null) return;

        System.out.print(root.data+", ");
        preOrder(root.left);
        preOrder(root.right);
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

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder){
        return buildTree(preOrder, inOrder,0, preOrder.length-1, 0, inOrder.length -1 );
    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd){
        if (inStart > inEnd) return null;

        int data = preOrder[preStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);

        int index = -1;


        for (int i = inStart; i<= inEnd ; i++){
            if (data == inOrder[i]){
                index = i;
                break;
            }
        }
        if (index == -1) return null;

        int leftInStart = inStart;
        int leftInEnd = index - 1;
        int leftPreStart = preStart + 1;
        int leftPreEnd  = leftInEnd  - leftInStart + leftPreStart;
        int rightInStart = index + 1;
        int rightInEnd = inEnd;
        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = preEnd ;


        root.left =  buildTree(preOrder, inOrder, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
        root.right =  buildTree(preOrder, inOrder, rightPreStart, rightPreEnd, rightInStart, rightInEnd);

        return root;

    }

    public static int sumOfDepth (BinaryTreeNode<Integer> root, int depth){
        if (root == null) return 0;

        int sum = sumOfDepth(root.left, depth + 1) + sumOfDepth(root.right, depth + 1);
        if (root != null ) sum += depth;

        return sum;

    }

    public static BinaryTreeNode<Integer> makeTree (int[] inOrder, int[] postOrder){
        int n = postOrder.length;
        for (int i = 0; i < n/2; i++){
            int temp = postOrder[i];
            postOrder[i] = postOrder[n-1-i];
            postOrder[n-i-1] = temp;
        }
//
//        for (int i = 0; i < n; i++){
//            System.out.println("reverse array : "+postOrder[i]+" ");
//        }

        return makeTree(inOrder, postOrder, 0, n-1, 0, n-1);
    }

    public static BinaryTreeNode<Integer> makeTree(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd){
        if (inStart > inEnd){
            return null;
        }
        int data = postOrder[postStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        System.out.println("root ka data: " + root.data);

        int index = -1;

        for (int i = inStart; i <= inEnd; i++){
            if (inOrder[i] == root.data){
                index = i;
                break;
            }
        }

        if (index == -1) return null;

        int leftInStart = inStart;
        int leftInEnd = index - 1;
        int rightInStart = index + 1;
        int rightInEnd = inEnd;
        int rightPostStart = postStart + 1;
        int rightPostEnd = rightPostStart + (rightInEnd - rightInStart);
        int leftPostStart = rightPostEnd + 1;
        int leftPostEnd = postEnd;



        root.right = makeTree(inOrder, postOrder, rightInStart, rightInEnd, rightPostStart, rightPostEnd);
        root.left = makeTree(inOrder, postOrder, leftInStart, leftInEnd, leftPostStart, leftPostEnd);

        return root;
    }

    public static void printKthElement(BinaryTreeNode<Integer> root, int k){
        if (root == null) return;

        if (k == 0){
            System.out.println(root.data);
            return;
        }
        printKthElement(root.left, k-1);
        printKthElement(root.right, k-1);

    }

    public static void printAllKthNodes(BinaryTreeNode<Integer> root, int element, int k){
        if (root == null) return;
        Queue<BinaryTreeNode<Integer>> Q = path(root, element);
        BinaryTreeNode<Integer> tempOne = Q.dequeue();
        printKthElement(tempOne,k);
        while(!Q.isEmpty() && k > 0){
            k--;
            BinaryTreeNode<Integer> tempTwo = Q.dequeue();
            if (k == 0){
                printKthElement(tempTwo, 0);
            }
            else if (tempTwo.left == tempOne && k > 0){
                printKthElement(tempTwo.right, k-1);
            }
            else{
                printKthElement(tempTwo.right,k-1);
            }
            tempOne = tempTwo;
        }

    }

    public static Queue<BinaryTreeNode<Integer>> path(BinaryTreeNode<Integer> root, int element){
      if (root == null) return null;

      if (root.data == element){
          Queue<BinaryTreeNode<Integer>> Q = new Queue<>();
          Q.enqueue(root);
          return Q;
      }

      Queue<BinaryTreeNode<Integer>> ans = path(root.left, element);
      if (ans == null) ans = path(root.right, element);

      if (ans != null) ans.enqueue(root);
      return ans;
    }
}
