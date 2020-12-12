package cr.ac.tec.BuildATree.TreesStructure.AVL;

import cr.ac.tec.BuildATree.TreesStructure.BST.BSNode;

public class AVLTree {

    public AVLNode root;

    /***
     * Constructor de Arbol AVL
     */
    public AVLTree(){
        this.root = null;
    }

    private int getBFactor(AVLNode node){
        if (node == null){
            return -1;
        }
        else{
            return node.bFactor;
        }
    }

    //Rotaciones

    /***
     * Realiza rotación hacia la izquierada
     * @param node el nodo al que se quiere rotar
     * @return retorna el nodo rotado
     */
    private AVLNode leftRotation(AVLNode node){
        AVLNode temp = node.leftChildren;
        node.leftChildren = temp.rightChildren;
        temp.rightChildren = node;
        node.bFactor = Math.max(getBFactor(node.leftChildren),getBFactor(node.rightChildren))+1;
        temp.bFactor = Math.max(getBFactor(temp.leftChildren),getBFactor(temp.rightChildren))+1;
        return temp;
    }

    private AVLNode rightRotation(AVLNode node){
        AVLNode temp = node.rightChildren;
        node.rightChildren = temp.leftChildren;
        temp.leftChildren = node;
        node.bFactor = Math.max(getBFactor(node.leftChildren),getBFactor(node.rightChildren))+1;
        temp.bFactor = Math.max(getBFactor(temp.leftChildren),getBFactor(temp.rightChildren))+1;
        return temp;
    }

    private AVLNode doubleLeftRotation(AVLNode node){
        AVLNode temp;
        node.leftChildren = rightRotation(node.leftChildren);
        temp = leftRotation(node);
        return temp;
    }

    private AVLNode doubleRightRotation(AVLNode node){
        AVLNode temp;
        node.rightChildren = leftRotation(node.rightChildren);
        temp = rightRotation(node);
        return temp;
    }

    //Insertar

    /***
     * Busca un lugar en donde insertar el elemento
     * @param newNode nodo nuevo
     * @param nextNode el nodo auxiliar para ir realizando las rotaciones
     * @return
     */
    private AVLNode insertAVL(AVLNode newNode, AVLNode nextNode){
        AVLNode newParent = nextNode;
        if (newNode.num < nextNode.num){
            if (nextNode.leftChildren == null){
                nextNode.leftChildren = newNode;
            }
            else{
                nextNode.leftChildren = insertAVL(newNode,nextNode.leftChildren);
                if (((getBFactor(nextNode.leftChildren))-(getBFactor(nextNode.rightChildren)))==2){
                    if(newNode.num< nextNode.leftChildren.num){
                        newParent = leftRotation(nextNode);
                    }
                    else{
                        newParent = doubleLeftRotation(nextNode);

                    }
                }
            }
        }
        else if (newNode.num > nextNode.num){
            if (nextNode.rightChildren == null){
                nextNode.rightChildren = newNode;
            } else {
                nextNode.rightChildren = insertAVL(newNode,nextNode.rightChildren);
                if(((getBFactor(nextNode.rightChildren))-(getBFactor(nextNode.leftChildren)))==2){
                    if(newNode.num> nextNode.num){
                        newParent = rightRotation(nextNode);
                    }
                    else{
                        newParent = doubleRightRotation(nextNode);
                    }
                }
            }
        }
        else {
            System.out.println("ya está en el árbol");
        }

        /////////
        if((nextNode.leftChildren==null)&&(nextNode.rightChildren!=null)){
            nextNode.bFactor = nextNode.rightChildren.bFactor+1;
        }
        else if ((nextNode.rightChildren == null)&&(nextNode.leftChildren!=null)){
            nextNode.bFactor = nextNode.leftChildren.bFactor+1;
        }
        else{
            nextNode.bFactor = Math.max(getBFactor(nextNode.leftChildren),getBFactor(nextNode.rightChildren))+1;
        }
        return newParent;
    }

    /***
     * Inserta un dato, en caso de que el nodo sea nuevo, lo pone en la raiz
     * @param data
     */
    public void insertNewElement(int data){
        AVLNode newNode = new AVLNode(data);

        if (root==null){
            root = newNode;
        }
        else{
            root = insertAVL(newNode,root);
        }

    }

    /***
     * método para imprimir
     * @return llama al método recursivo que imprime y retorna un string
     */
    public String print(){
        return printAVLTree(root);
    }

    private String printAVLTree(AVLNode node){
        if(node!=null){
            return ""+node.num+"("+printAVLTree(node.leftChildren)+"/"+printAVLTree(node.rightChildren)+")";
        }
        else{
            return "*";
        }
    }
}
