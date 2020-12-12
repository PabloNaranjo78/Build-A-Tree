package cr.ac.tec.BuildATree.TreesStructure.BST;

public class BSNode {

    int num;
    BSNode leftChildren,rightChildren;

    /**
     * Nodo de árbol binario
     * @param num
     */
    public BSNode (int num){
        this.num = num;
        this.leftChildren = null;
        this.rightChildren = null;
    }
}
