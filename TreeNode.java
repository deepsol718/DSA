public class TreeNode <T>{
    public T data;
    public ArrayLists<TreeNode<T>> children;

    public TreeNode(T data){
        this.data = data;
        children = new ArrayLists<>();
    }
}
