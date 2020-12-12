package cr.ac.tec.BuildATree.TreesStructure.BTree;

public class Btree {

    public BNode root;

    /**
     * Constructor de árbol B
     */
    public Btree() {
        root = new BNode();
        root.isLeaf = true;
        root.numberOfNodes = 0;
        root.key[0] = -1;
    }

    /**
     *Método principal para insertar elementos
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

    /***
     * En caso de que aún no esté lleno una hoja, se inserta con este método.
     * @param node Nodo nuevo
     * @param value valor a insertar
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
     * Realiza un split a la hoja hija
     * @param parentNode hoja padre
     * @param childIndex hoja hija
     * @param newChild el nuevo dato a insertar
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
     * Imprime el árbol
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