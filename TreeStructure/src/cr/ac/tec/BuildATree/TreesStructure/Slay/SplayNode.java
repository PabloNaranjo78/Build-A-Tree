package cr.ac.tec.BuildATree.TreesStructure.Slay;

public class SplayNode {

    int num;
    SplayNode leftChildren;
    SplayNode rightChildren;
    SplayNode parent;

    public SplayNode(int num){
        this.num = num;
        this.leftChildren = null;
        this.rightChildren = null;
        this.parent = null;
    }
}
