public class MyTree{
    class Node{
        String value;
        Node left;
        Node right;
        Node (String obj){
            value = obj;
        }
        Node (String obj, Node leftNode, Node rightNode){
            value  = obj;
            left = leftNode;
            right = rightNode;
        }
    }
    private Node _root;
    public MyTree(){
        _root = null;
    }

    public void add(String value){
        add(_root,value);
    }

    private void add(Node node, String value){
        if(value == "+" || value == "-" || value == "*" || value == "/" || value =="%"){
            if (node.value == null){
                if (node.right == null){
                    add(node.right, value);
                } else {
                    node.value = value;
                }
            }
        } else {
            if (node == null){
                node = new Node(null);
                node.left = new Node(value);
            }
            if (node.left == null){
                node.left = new Node(value);
            } if (node.right == null){
                node.right = new Node(value);
            } if (node.value == "+" || node.value == "-" || node.value == "*" || node.value == "/" || node.value =="%"){
                Node newRoot = new Node(null);
                newRoot.left = new Node(node.value);
                newRoot.left.left = node.left;
                newRoot.left.right = node.right;
                newRoot.right = new Node(value);
                node = newRoot;
            } if (node.value == null){
                add(node.right , value);
            }
        }
    }

    public String traverseInOrder(){
       return traverseInOrder(_root);
    }

    public String traverseInOrder(Node node){
        String output = "";
        if (node != null){
            output += traverseInOrder(node.left);
            output += node.value;
            output += traverseInOrder(node.right);
        }
        return output;
    }

    public String traversePostOrder(Node node){
        String output = "";
        if (node != null){
            output += traversePostOrder(node.left);
            output += traversePostOrder(node.right);
            output += node.value;
        }
        return output;
    }
}
