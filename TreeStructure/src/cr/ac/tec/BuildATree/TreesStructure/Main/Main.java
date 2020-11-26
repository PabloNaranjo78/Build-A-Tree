package cr.ac.tec.BuildATree.TreesStructure.Main;

import cr.ac.tec.BuildATree.TreesStructure.AVL.AVLTree;

public class Main {

    public static void main(String[] args) {
        AVLTree prueba = new AVLTree();
        prueba.insertNewElement(2);
        prueba.insertNewElement(3);
        prueba.insertNewElement(4);
        prueba.insertNewElement(5);
        prueba.insertNewElement(1);
        prueba.printTree(prueba.root);
    }
}
