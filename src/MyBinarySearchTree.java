public class MyBinarySearchTree <Type extends Comparable<Type>>{
    private Node root;
    private int size;
    public long comparisons = 0;

    public void add (Type item){
        if(root == null){
            size++;
            root = new Node();
            root.item = item;
        } else if(root.item.compareTo(item) > 0){
            root.left = add(item, root.left);
            updateHeight(root);
        } else{
            root.right = add(item, root.right);
            updateHeight(root);
        }
    }
    private Node add (Type item, Node subTree){
        if(subTree == null){
            size++;
            subTree = new Node();
            subTree.item = item;

            return subTree;
        } else if(subTree.item.compareTo(item) > 0){
            subTree.left = add(item, subTree.left);
            updateHeight(subTree);
        } else{
            subTree.right = add(item, subTree.right);
            updateHeight(subTree);
        }
        return subTree;
    }

    public Type find (Type item){
        return find(item, root);

    }

    private Type find (Type item, Node subTree){
        comparisons++;
        if(subTree == null){

            return null;
        }
        if(item.compareTo(subTree.item) < 0){
            return find(item, subTree.left);

        } else if(item.compareTo(subTree.item) > 0){
            return find(item, subTree.right);

        }else if(item.compareTo(subTree.item) == 0){


            return subTree.item;
        }

        return subTree.item;

    }

    public void remove (Type item){
        if(root != null){
            remove(item, root);
        }
    }
    private Node remove (Type item, Node subTree){

        if(subTree == null){
            return null;
        }
        if(item.compareTo(root.item) == 0 && root.left == null && root.right == null){
            root = null;
        }
        if(item.compareTo(subTree.item) < 0){
            subTree.left = remove(item, subTree.left);
/*            updateHeight(subTree);*/
        } else if(item.compareTo(subTree.item) > 0){
            subTree.right = remove(item, subTree.right);
/*            updateHeight(subTree);*/
        } else if(item.compareTo(subTree.item) == 0){

            if(subTree.left == null){
                size--;
                return subTree.right;
            } else if(subTree.right == null){
                size--;
                return subTree.left;
            }

            Node min = minReturn(subTree.right);

            subTree.item = min.item;

            subTree.right = remove(subTree.item, subTree.right);
        }

        updateHeight(subTree);
        return subTree;
    }

    private Node minReturn(Node subTree){
        while(subTree.left != null){
            subTree = subTree.left;
        }
        return subTree;
    }


    public int height(){
        if(root != null)return root.height;

        return -1;

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    private int height(Node node){
        if(node == null){
            return -1;
        } else{
            return node.height;
        }
    }

    private void updateHeight(Node node){
        node.height = Math.max(height(node.left), height(node.right)) + 1;
/*        if(node.left != null && node.right != null){
            if(node.left.height >= node.right.height){
                node.height = node.left.height + 1;
            } else{
                node.height = node.right.height + 1;
            }
        } else if(node.left != null){
            node.height = node.left.height + 1;
        } else if (node.right != null){
            node.height = node.right.height + 1;
        }*/

    }

    public String toString(){
        if(root == null){
            return "[]";
        }
        return "["+toString(root).substring(2)+"]";
    }
    private String toString(Node subTree){
        if(subTree == null){
            return "";
        } else{
            return toString(subTree.left)+", "+subTree+toString(subTree.right);
        }
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
