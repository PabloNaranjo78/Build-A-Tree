package cr.ac.tec.BuildATree.TreesStructure.Printer;/*
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



