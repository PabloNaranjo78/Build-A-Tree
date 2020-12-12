package cr.ac.tec.BuildATree.TreesStructure.Printer;

class Node<T extends Comparable<?>> {
    Node<T> left, right, parent;
    T data;

    public Node() {

    }

    public Node(T data) {
        this.data = data;
    }
}
