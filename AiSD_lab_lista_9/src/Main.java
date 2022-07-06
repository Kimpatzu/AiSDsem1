public class Main {
    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        myTree.add("12");
        myTree.add("3");
        myTree.add("2");
        myTree.add("*");
        myTree.add("6");
        myTree.add("+");
        myTree.add("+");
        myTree.traverseInOrder();

    }
}
