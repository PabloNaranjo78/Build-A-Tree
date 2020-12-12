package cr.ac.tec.BuildATree.TreesStructure.BTree;

public class Btree {

    public BNode root;
    Btree() {
        // new root
        root = new BNode();
        // assign the root node to be a isLeaf
        root.isLeaf = true;
        root.numberOfNodes = 0;
        // initial the key value in the root to -1 (null)
        root.key[0] = -1;
    }

    /**
     * The Insert Method:
     * This method insert a key k into a B Tree.
     * The insert method takes one argument
     * The run time of the Insert Method is O(t log n)
     *
     * @param k is the key that will be inserted into the node in the B Tree
     */
    public void insert(int k)
    {
        BNode r = root;
        if (r.numberOfNodes == 3) {
            BNode s = new BNode();
            root = s;
            s.numberOfNodes = 0;
            s.isLeaf = false;
            s.children[0] = r;
            splitChild(s, 1, r);

            insertNonfull(s, k);
        }else {
            insertNonfull(r, k);
        }
    }

    /**
     * The Insert in none full node Method:
     * This method insert a key k into a node that is already full.
     * The insert method takes two arguments: Node x, and integer k as a value
     * The run time of the Insert in None Full Node algorithm is: O(t log n).
     *
     *
     * @param node that the value will be inserted in.
     * @param value the value to be inserted
     */
    public void insertNonfull(BNode node, int value) {
        int i = node.numberOfNodes;
        if (node.isLeaf) {
            while (i >= 1 && value < node.key[i - 1]) {
                node.key[i] = node.key[i - 1];
                i--;
            }
            node.key[i] = value;
            node.numberOfNodes++;
        } else {
            while (i >= 1 && value < node.key[i - 1]) {
                i--;
            }
            i++;
            if (node.children[i - 1].numberOfNodes == 3) {
                splitChild(node, i, node.children[i - 1]);
                if (value > node.key[i - 1]) {
                    i++;
                }
            }
            insertNonfull(node.children[i - 1], value);
        }
    }

    /**
     * The Split Child Method
     * It takes three arguments: Node x, int i, Node y
     * The Basic idea of split child is: if we want to insert a key value into a node we should
     * check if the node is not full ( node can have at most 2*t-1 keys). If it is full, then we must
     * split the node into two node.
     * The Run Time of splitChild algorithm is: O(t), where t is a constant
     * Node y: is x’s i th child.
     *
     * @param parentNode the Parent Node
     * @param childIndex The index of the element
     * @param newChild
     */
    private void splitChild(BNode parentNode, int childIndex, BNode newChild) {
        BNode z = new BNode();
        z.isLeaf = newChild.isLeaf;
        z.numberOfNodes = 1;
        z.key[0] = newChild.key[2];

        if (!newChild.isLeaf) {
            z.children[1] = newChild.children[3];
            z.children[0] = newChild.children[2];
        }
        newChild.numberOfNodes = 1;

        // Here we insert node z as a child of node x
        for (int j = parentNode.numberOfNodes + 1; j >= childIndex + 1; j--) {
            parentNode.children[j] = parentNode.children[j - 1];
            parentNode.key[j - 1] = parentNode.key[j - 2];
        }
        parentNode.children[childIndex] = z;
        parentNode.key[childIndex - 1] = newChild.key[1];
        parentNode.numberOfNodes++;
    }

    /**
     * To print the B-Tree
     */
    public String print() {
        return printAux(root);
    }

    private String printAux(BNode node) {
        String result ="";
        if (node == null) {
            System.out.println("Null");
        } else {
            for (int i = 0; i < node.numberOfNodes; i++) {
                if(node.key[i] > 0)
                    result+="-"+node.key[i];
                if (!node.isLeaf)
                {
                    result+="("+printAux(node.children[i])+")";
                }
            }
            if (!node.isLeaf){
                result+="("+printAux(node.children[node.numberOfNodes])+")";
            }
        }
        return result;
    }

}