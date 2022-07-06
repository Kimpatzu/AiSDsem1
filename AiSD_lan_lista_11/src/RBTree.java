import java.util.Comparator;

public class RBTree {
    private class Node{
        private String key;
        private int value;
        private Node parent;
        private Node left;
        private Node right;
        private int color;      //1-red 0-black

        public Node(String key) {
            this.key=key;
            this.value=1;
            this.color=1;
        }
        public Node() {
            this.left=null;
            this.right=null;
            this.color=0;
        }
    }

    private Comparator comparator;
    private Node _root;
    private Node NULL;

    public RBTree(Comparator comparator) {
        this.comparator = comparator;
        this.NULL=new Node();
        this._root=NULL;
    }

    private void leftRotate(Node x){
        Node y=x.right;
        x.right=y.left;
        if(y.left!=NULL)
            y.left.parent=x;
        y.parent=x.parent;
        if(x.parent==null)
            this._root=y;
        else if(x==x.parent.left)
            x.parent.left=y;
        else
            x.parent.right=y;
        y.left=x;
        x.parent=y;
    }

    private void rightRotate(Node x){
        Node y=x.left;
        x.left=y.right;
        if(y.right!=NULL)
            y.right.parent=x;
        y.parent=x.parent;
        if(x.parent==null)
            this._root=y;
        else if(x==x.parent.right)
            x.parent.right=y;
        else
            x.parent.left=y;
        y.right=x;
        x.parent=y;
    }

    private void TreeInsert(Node root, Node z){
        Node y = null;
        Node x = root;
        while (x!=null){
            y = x;
            if (z.key.compareTo(x.key) < 0){
                x = x.left;
            } else if (z.key.compareTo(x.key) > 0){
                x = x.right;
            } else {
                x.value++;
            }
        }
        z.parent = y;
        if (y == null){
            root = z;
        } else if (z.key.compareTo(y.key)<0){
            y.left = z;
        } else {
            y.right = z;
        }
    }

    public void RBInsert(Node root, Node x){        //0 = black, 1 = red
        TreeInsert(root,x);
        x.color = 1;
        while (x!= root && x.parent.color == 1){
            if (x.parent == x.parent.parent.left){
                Node y = x.parent.parent.right;
                if(y.color == 1){
                    x.parent.color = 0;
                    y.color = 0;
                    x.parent.parent.color = 1;
                    x = x.parent.parent;
                } else {
                    if (x ==x.parent.right){
                        x = x.parent;
                        leftRotate(x);
                    }
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    rightRotate(x.parent.parent);
                }
            } else {
                Node y = x.parent.parent.right;
                if(y.color == 1){
                    x.parent.color = 0;
                    y.color = 0;
                    x.parent.parent.color = 1;
                    x = x.parent.parent;
                } else {
                    if (x ==x.parent.right){
                        x = x.parent;
                        rightRotate(x);
                    }
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    leftRotate(x.parent.parent);
                }
            }
        }
        root.color = 0;
    }

    private Node searchRB(String key){
        Node node=_root;
        int cmp=0;
        if(_root==null)
            return node;
        while(node!=NULL &&  (cmp=key.compareTo(node.key))!=0)
            node=cmp<0? node.left:node.right;
        return node;
    }

    public String successor(String elem){
        Node succNode=successorNode(_root, elem);
        return succNode==null?null:succNode.key;}
    private Node successorNode(Node node, String elem) {
        if(node==null) return null;
        int cmp=(elem.compareTo(node.key));
        if(cmp==0){
            if(node.right!=null)
                return getMin(node.right);
            else return null;
        } else if(cmp<0){
            Node retNode=successorNode(node.left, elem);
            return retNode==null?node:retNode;
        } else { // cmp>0
            return successorNode(node.right, elem);
        }
    }

    public String getMin(){
        if(_root==null) return null;
        Node node=getMin(_root);
        return node.key;
    }

    private Node getMin(Node node) {
        assert(node!=null);
        while(node.left!=null)
            node=node.left;
        return node;
    }



    public void RBDelete(Node z){
        Node y;
       if(z.left == NULL ||z.right == NULL){
           y = z;
       } else {
           y = successorNode(z, z.key);
       }
       Node x;
       if(y.left != NULL){
           x = y.left;
       } else {
           x = y.right;
       }
       x.parent = y.parent;
       if(y.parent == NULL){
           NULL._root
       }
    }
}
