package cr.ac.tec.BuildATree.TreesStructure.BST;

import cr.ac.tec.BuildATree.TreesStructure.AVL.AVLNode;

public class BSTree {



    BSNode root;

    public BSTree(){
        root=null;
    }

    public BSNode getRoot() {
        return root;
    }

    //Insertar

    public void insertBSTree(int num){
        BSNode newNode = new BSNode(num);
        if(root == null){
            root = newNode;
        }
        else{
            BSNode aux = root;
            BSNode parent;
            while(true){
                parent = aux;
                if(num< aux.num){
                    aux = aux.leftChildren;
                    if (aux == null){
                        parent.leftChildren = newNode;
                        return;
                    }
                } else if (num > aux.num) {
                    aux = aux.rightChildren;
                    if (aux==null){
                        parent.rightChildren = newNode;
                        return;
                    }
                } else{
                    System.out.println("Dato"+" *"+num+"* "+"repetido");
                    return;
                }
            }
        }
    }

    public String print (){
        return printBSTree(root);
    }

    public String printBSTree(BSNode node){
        if(node!=null){
            return ""+node.num+"( "+printBSTree(node.leftChildren)+"/"+printBSTree(node.rightChildren)+" )";
        }
        else{
            return "*";
        }
    }

}
