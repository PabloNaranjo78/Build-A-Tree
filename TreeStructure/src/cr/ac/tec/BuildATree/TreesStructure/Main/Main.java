package cr.ac.tec.BuildATree.TreesStructure.Main;

import cr.ac.tec.BuildATree.TreesStructure.AVL.AVLTree;
import cr.ac.tec.BuildATree.TreesStructure.BST.BSTree;

public class Main {

    public static void main(String[] args) {
        AVLTree prueba = new AVLTree();
        prueba.insertNewElement(2);
        prueba.insertNewElement(3);
        prueba.insertNewElement(4);
        prueba.insertNewElement(5);
        prueba.insertNewElement(1);
        System.out.println(prueba.printAVLTree(prueba.root));
        prueba.insertNewElement(11);
        System.out.println(prueba.printAVLTree(prueba.root));

        BSTree prueba2 = new BSTree();

        prueba2.insertBSTree(2);
        prueba2.insertBSTree(3);
        prueba2.insertBSTree(1);
        prueba2.insertBSTree(4);
        System.out.println(prueba2.printBSTree(prueba2.getRoot()));

    }



}
