import java.util.ArrayList;

public class HufffmanTree {
    class Node{
        int weight;
        int symbol;
        Node left;
        Node right;
        Node (int nodeSymbol, int nodeWeight){
            weight = nodeWeight;
            symbol = nodeSymbol;
        }
        Node (int nodeSymbol, int nodeWeight, Node leftNode, Node rightNode){
            weight = nodeWeight;
            symbol = nodeSymbol;
            left = leftNode;
            right = rightNode;
        }
        Node (Node node){
            weight = node.getWeight();
            symbol = node.getSymbol();
            left = node.getLeft();
            right = node.getRight();
        }

        public int getWeight() {
            return weight;
        }

        public int getSymbol() {
            return symbol;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    private Node _root;

    public HufffmanTree(int symbol, int weight){
        _root = new Node(symbol,weight);
        _root.symbol = symbol;
        _root.weight = weight;
    }
    public HufffmanTree(HufffmanTree hT1, HufffmanTree hT2){
        _root = new Node(0,hT1.getRootWeight() + hT2.getRootWeight());
        _root.left = hT1._root;
        _root.right = hT2._root;
    }
    public String getCode(){
        return getCode(_root, "");
    }
    public String getCode(Node node, String s){
        String output = "";
        if (node.left == null && node.right ==null && node.symbol!=0){
            output += (char)node.symbol + " ("+ node.symbol+ "): " + s + "\n" ;

        }
        if (node.left!=null){
           output += getCode(node.left, s + "0");
        }
        if (node.right!=null){
            output += getCode(node.right, s+ "1");
        }
        return output;
    }

    public int getRootWeight(){
        return _root.weight;
    }

    public String decodeString(String codedString){
        String decodedString = "";
        char[] cdStringCharArr = codedString.toCharArray();
        Node currentNode = new Node(_root);
        for(int i = 0; i<cdStringCharArr.length; i++){
            if(cdStringCharArr[i]=='0'){
                if(currentNode.left!=null){
                    currentNode = currentNode.getLeft();
                } else {
                    decodedString += "" + (char)currentNode.getSymbol();
                    currentNode = new Node(_root);
                    i--;
                }
            } else if(cdStringCharArr[i]=='1'){
                if(currentNode.right!=null){
                    currentNode = currentNode.getRight();
                } else {
                    decodedString += "" + (char)currentNode.getSymbol();
                    currentNode = new Node(_root);
                    i--;
                }
            }
        }
        return  decodedString + (char)currentNode.getSymbol();
    }

}
