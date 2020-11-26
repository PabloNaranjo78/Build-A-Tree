package cr.ac.tec.BuildATree.TreesStructure.AVL;

public class AVLNode {
    int num;
    int bFactor;
    AVLNode leftChildren;
    AVLNode rightChildren;

    public AVLNode(int num){
        this.bFactor = 0;
        this.num = num;
        this.leftChildren = null;
        this.rightChildren = null;
    }
}
