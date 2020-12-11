package cr.ac.tec.BuildATree.TreesStructure.BTree;

public class BNode {

    public int numberOfNodes;
    public int key[];
    public BNode children[];
    public boolean isLeaf;

    public BNode() {
        key = new int[3];
        children = new BNode[4];
        isLeaf = true;
    }
}
