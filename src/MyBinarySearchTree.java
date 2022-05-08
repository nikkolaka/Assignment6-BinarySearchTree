public class MyBinarySearchTree <Type extends Comparable<Type>>{
    private Node root;
    private int size;
    public long comparisons;

    public void add (Type item){
        if(root == null){
            root = new Node();
            root.item = item;
        } else if(root.item.compareTo(item) < 0){
            comparisons++;
            root.left = add(item, root.left);
        } else{
            root.right = add(item, root.right);
        }
    }
    private Node add (Type item, Node subTree){
        if(subTree == null){
            size++;
            subTree = new Node();
            subTree.item = item;
            return subTree;
        } else if(subTree.item.compareTo(item) < 0){
            comparisons++;
            subTree.left = add(item, subTree.left);
        } else{
            subTree.right = add(item, subTree.right);
        }
        return subTree;
    }

    public void remove (Type item){

    }
 /*   private Node remove (Type item, Node subtree){

    }

    public Type find (Type item){

    }
    private Type find (Type item, Node subTree){
        
    }

    public int height(){

    }

    public int size(){

    }

    public boolean isEmpty(){

    }*/

    private void updateHeight(Node node){
        if(node.left.height >= node.right.height){
            node.height = node.left.height + 1;
        } else{
            node.height = node.right.height + 1;
        }
    }

    public String toString(){
    StringBuilder str = new StringBuilder();
    if(root == null){
        return  "";
    }
    str.append(root);

    if(root.left != null){
        str.insert(0,"[ "+toStringHelp(root.left)) ;
    }
    if(root.right != null){
        str.append(toStringHelp(root.right)).append("]");
    }
    return str.toString();



    }
    private StringBuilder toStringHelp(Node subTree){
        StringBuilder str = new StringBuilder();
        if(subTree.left != null){
            str.append(toStringHelp(subTree.left).append(", ").append(subTree));
        }
        if(subTree.right != null){
            str.append(subTree).append(subTree.right).append(", ");
        }
        return str;

    }

    class Node{
        Type item;
        Node left;
        Node right;
        int height = 0;

        public String toString(){
            return item.toString() + ":H"+height;
        }

    }

}
