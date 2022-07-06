import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

public class RBTree<T> {
    private class Node{
        private T key;
        private int value;
        private ArrayList<Integer> showlist = new ArrayList<>();
        private Node parent;
        private Node left;
        private Node right;
        private int color;//1-red 0-black

        public Node(T key, int value) {
            this.key=key;
            this.value=value;
            this.color=1;
            showlist.add(value);
        }
        public Node() {
            this.left=null;
            this.right=null;
            this.color=0;
        }
    }
    private Comparator<T> comparator;
    private Node root;
    private Node NULL;

    public RBTree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.NULL=new Node();
        this.root=NULL;
    }
    private int numberOfLeaves=0;
    private int numberOfBlackLeaves=0;
    public String percentOfBlackLeaves(){
        numberOfLeaves=0;
        numberOfBlackLeaves=0;
        percentOfBlackLeaves(root);
        return (double)numberOfBlackLeaves/numberOfLeaves*100+"%";
    }
    private void percentOfBlackLeaves(Node node){
        if(node!=NULL) {
            percentOfBlackLeaves(node.left);
            if (node.left == NULL && node.right == NULL) {
                numberOfLeaves++;
                if (node.color == 0)
                    numberOfBlackLeaves++;
            }
            percentOfBlackLeaves(node.right);
        }

    }
    private void rbTransplant(Node u, Node v){
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left){
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }
    public T remove(T key){
        Node del=searchRB(key);
        if(del==NULL){
            return null;
        }
        else{
            Node y,x;
            y = del;
            int yOriginalColor = y.color;
            if (del.left == NULL) {
                x = del.right;
                rbTransplant(del, del.right);
            } else if (del.right == NULL) {
                x = del.left;
                rbTransplant(del, del.left);
            } else {
                y = TreeMinimum(del.right);
                yOriginalColor = y.color;
                x = y.right;
                if (y.parent == del) {
                    x.parent = y;
                } else {
                    rbTransplant(y, y.right);
                    y.right = del.right;
                    y.right.parent = y;
                }

                rbTransplant(del, y);
                y.left = del.left;
                y.left.parent = y;
                y.color = del.color;
            }
            if (yOriginalColor == 0){
                RBdeleteFixup(x);
            }
            return y.key;
        }
    }
    private void RBdeleteFixup(Node x){
        while(x!=root && x.color==0){
            if(x==x.parent.left) {
                Node s= x.parent.right;
                if(s.color==1) {
                    s.color = 0;
                    x.parent.color = 1;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }
                if(s.left.color==0 && s.right.color==0){
                    s.color=1;
                    x=x.parent;
                }
                else {
                    if (s.right.color == 0) {
                        s.left.color = 0;
                        s.color = 1;
                        rightRotate(s);
                        s = x.parent.right;
                    }
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.right.color = 0;
                    leftRotate(x.parent);
                    x = root;
                }
            }
            else{
                Node s= x.parent.left;
                if(s.color==1) {
                    s.color = 0;
                    x.parent.color = 1;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }
                if(s.left.color==0 && s.right.color==0){
                    s.color=1;
                    x=x.parent;
                }
                else {
                    if (s.left.color == 0) {
                        s.right.color = 0;
                        s.color = 1;
                        leftRotate(s);
                        s = x.parent.left;
                    }
                    s.color = x.parent.color;
                    x.parent.color = 0;
                    s.left.color = 0;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color=0;
    }
    private Node TreeSuccessor(Node node){
        if(node.right !=NULL)
            return TreeMinimum(node);
        Node Ynode=node.parent;
        while(Ynode!=NULL && node==Ynode.right){
            node=Ynode;
            Ynode=Ynode.parent;
        }
        return Ynode;
    }
    public String search(T key){
        Node node =searchRB(key);
        return node==NULL?"Element doesn't exist": "" + node.value;
    }

    private Node searchRB(T key){
        Node node=root;
        int cmp=0;
        if(root==null)
            return node;
        while(node!=NULL &&  (cmp=comparator.compare(key, node.key))!=0)
            node=cmp<0? node.left:node.right;
        return node;
    }
    private Node TreeMinimum(Node node){
        while (node.left!=NULL){
            node=node.left;
        }
        return node;
    }
    public void insert(T key, int value){
        Node node=new Node(key,value);
        node.parent=null;
        node.left=NULL;
        node.right=NULL;

        Node y = null;
        Node x = this.root;
        boolean alredyis = false;
        while (x != NULL && !alredyis) {
            y = x;
            if (comparator.compare(node.key, x.key)==0){
                x.showlist.add(value);
                alredyis=true;
            } if (comparator.compare(node.key, x.key)<0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (comparator.compare(node.key, y.key)<0) {
            y.left = node;
        } else if (comparator.compare(node.key, y.key)>0){
            y.right = node;
        }

        if (node.parent == null){
            node.color = 0;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        RBinsert(node);
    }

    private void RBinsert(Node x) {
        Node y;
        while (x.parent.color == 1) {
            if (x.parent == x.parent.parent.right) {
                y = x.parent.parent.left;
                if (y.color == 1) {
                    y.color = 0;
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.left) {
                        x = x.parent;
                        rightRotate(x);
                    }
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    leftRotate(x.parent.parent);
                }
            }
            else{
                y = x.parent.parent.right;
                if (y.color == 1) {
                    y.color = 0;
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    x = x.parent.parent;
                } else {
                    if (x == x.parent.right) {
                        x = x.parent;
                        leftRotate(x);
                    }
                    x.parent.color = 0;
                    x.parent.parent.color = 1;
                    rightRotate(x.parent.parent);
                }
            }
            if(x==root)
                break;

        }
        root.color=0;
    }
    public String traverseInOrder(Node node){
        String output = "";
        String previous = "";
        if (node != null){
            output += traverseInOrder(node.left);
            if (node.key != null){
                output += node.key + " ";
                for (int i=0; i<node.showlist.size(); i++){
                    output += ", " + node.showlist.get(i);
                }
                output += "\n";
            }
            output += traverseInOrder(node.right);
        }
        return output;
    }

    public String traverseInOrder(){
        return traverseInOrder(root);
    }

    private void leftRotate(Node x){
        Node y=x.right;
        x.right=y.left;
        if(y.left!=NULL)
            y.left.parent=x;
        y.parent=x.parent;
        if(x.parent==null)
            this.root=y;
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
            this.root=y;
        else if(x==x.parent.right)
            x.parent.right=y;
        else
            x.parent.left=y;
        y.right=x;
        x.parent=y;
    }
}
