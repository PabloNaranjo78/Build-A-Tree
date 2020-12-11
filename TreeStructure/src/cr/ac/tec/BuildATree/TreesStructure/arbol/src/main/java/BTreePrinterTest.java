/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.text.html.HTML;

public class BTreePrinterTest { 
    
    public static Node<String> imprimi2(String input)
    {  
        input = input.trim();
        Node<String> root = new Node<String>(Character.toString(input.charAt(0)));
        
        Node<String> actual = root;  
        Integer length = input.length();  
        
        for (int i = 1; i < length; i++) {   
            
            Character actualCaracter = input.charAt(i);
            
            switch (actualCaracter)
            {
                case  '(':
                    Node<String> nodoIzquierdo = new Node<String>();
                    nodoIzquierdo.parent = actual;
                    actual.left = nodoIzquierdo;
                    actual = actual.left;
                    break;
                case  ')':
                    actual = actual.parent;
                    break;
                case  '/': 
                    Node<String> nodoDerecho = new Node<String>();
                    actual = actual.parent; 
                    nodoDerecho.parent = actual;
                    actual.right = nodoDerecho;
                    actual = actual.right;
                    break;
                default:
                    if (actual.data == null) {
                        actual.data = Character.toString(input.charAt(i));
                    }
                    else
                    {
                        actual.data = actual.data + Character.toString(input.charAt(i));
                    }
                    break;
            }
            
        }
        
        return root;
    } 

    public static void main(String[] args) {  
        String string = BTreePrinter.printString(imprimi2("3(2(1(*/*)/*)/5(4(*/*)/11(*/*)))"));
        System.out.println(string);
    }
}

class Node<T extends Comparable<?>> {
    Node<T> left, right, parent;
    T data;
    
    public Node() {
        
    }

    public Node(T data) {
        this.data = data;
    }
}

class BTreePrinter { 
    
    public static <T extends Comparable<?>> String printString(Node<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        return stringNodeInternal(Collections.singletonList(root), 1, maxLevel, "");
    } 

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    } 
    
    private static <T extends Comparable<?>> String stringNodeInternal(List<Node<T>> nodes, int level, int maxLevel, String result) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return result; 
        
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        result += BTreePrinter.addWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                result += node.data;
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                result += " ";
            }

            result += BTreePrinter.addWhitespaces(betweenSpaces);
        }
        
        result += System.lineSeparator(); 

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                result += BTreePrinter.addWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    result += BTreePrinter.addWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    result += "/";
                else
                    result += BTreePrinter.addWhitespaces(1);

                result += BTreePrinter.addWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    result += "\\";
                else
                    result += BTreePrinter.addWhitespaces(1);

                result += BTreePrinter.addWhitespaces(endgeLines + endgeLines - i);
            }

            result += System.lineSeparator(); 
        }

        
        return stringNodeInternal(newNodes, level + 1, maxLevel, result);
    }

    private static String addWhitespaces(int count) {
        String result = "";
        for (int i = 0; i < count; i++)
            result += " "; 
        
        return result;
    }

}