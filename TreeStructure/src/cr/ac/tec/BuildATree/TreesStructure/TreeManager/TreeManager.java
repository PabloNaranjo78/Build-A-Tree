package cr.ac.tec.BuildATree.TreesStructure.TreeManager;

import cr.ac.tec.BuildATree.TreesStructure.AVL.AVLTree;
import cr.ac.tec.BuildATree.TreesStructure.BST.BSTree;
import cr.ac.tec.BuildATree.TreesStructure.BTree.Btree;
import cr.ac.tec.BuildATree.TreesStructure.Printer.BTreePrinter;
import cr.ac.tec.BuildATree.TreesStructure.Slay.SplayTree;

import static cr.ac.tec.BuildATree.TreesStructure.Printer.BTreePrinterTest.imprimi2;

public class TreeManager {

    Btree player1Btree = new Btree();
    AVLTree player1AVLTree = new AVLTree();
    BSTree player1BSTree = new BSTree();
    SplayTree player1SplayTree = new SplayTree();

    /***
     * Revisa la entrada del servidor para verificar que acción tomar, B es para árbol B, A para AVL,
     * S para el BST, P para el Splay y R para reiniciar los árboles
     * @param data el string con la información del socket
     * @return retorna el resultado de agregar un dato a un árbol
     */
    public String checkEvent(String data){
        try{
        String type = data.substring(0,1);
        System.out.println(data);
        System.out.println(type.equals("B"));
        System.out.println(type);
        int num = Integer.parseInt(data.substring(1,3));
        if (type.equals("B")){
            player1Btree.insert(num);
            return player1Btree.print();
        }else if (type.equals("A")){
            player1AVLTree.insertNewElement(num);
            return BTreePrinter.printString(imprimi2(player1AVLTree.print()));
        } else if (type.equals("S")){
            player1BSTree.insertBSTree(num);
            return BTreePrinter.printString(imprimi2(player1BSTree.print()));
        }else if (type.equals("P")){
            player1SplayTree.insertSplayTree(num);
            return BTreePrinter.printString(imprimi2(player1SplayTree.print()));
        }else if (type.equals("R")){
            this.player1Btree = new Btree();
            this.player1AVLTree = new AVLTree();
            this.player1BSTree = new BSTree();
            this.player1SplayTree = new SplayTree();
            return "-_-";
        }
        else{
            return "Error";
        }
    } catch (NumberFormatException e) {
            e.printStackTrace();
        }return "Error";
    }
}




