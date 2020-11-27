package cr.ac.tec.BuildATree.TreesStructure.AVL;

import cr.ac.tec.BuildATree.TreesStructure.BST.BSNode;

public class AVLTree {

    public AVLNode root;

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

    //Insertar simple

    public void insertNewElement(int data){
        AVLNode newNode = new AVLNode(data);

        if (root==null){
            root = newNode;
        }
        else{
            root = insertAVL(newNode,root);
        }

    }

    public String printAVLTree(AVLNode node){
        if(node!=null){
            //    printTree(node.leftChildren);
            //  System.out.println(node.num+",");
            //printTree(node.rightChildren);
            return ""+node.num+"("+printAVLTree(node.leftChildren)+"/"+printAVLTree(node.rightChildren)+")";
        }
        else{
            return "";
        }


}
}
