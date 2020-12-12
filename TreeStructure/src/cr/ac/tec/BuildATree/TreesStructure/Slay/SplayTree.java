package cr.ac.tec.BuildATree.TreesStructure.Slay;

import cr.ac.tec.BuildATree.TreesStructure.BST.BSNode;

public class SplayTree {

    public SplayNode root;

    public SplayTree(){
        root = null;
    }

    public void insertSplayTree(int num){
        SplayNode temp = this.root;
        SplayNode parent = null;

        while(temp != null){

            parent = temp;
             if (temp.num < num){
                 System.out.println(temp.num+"<"+num);
                 temp = temp.leftChildren;
             }else if (temp.num > num){
                 System.out.println(temp.num+">"+num);
                 temp = temp.rightChildren;
             } else {
                 System.out.println("ya está en el árbol");
                 return;
             }
        }

        temp = new SplayNode(num);
        temp.parent = parent;

        if(parent == null){
            this.root = temp;
        }
        else if (parent.num > temp.num){
            parent.rightChildren = temp;
        }else{
            parent.leftChildren = temp;
        }

        splay(temp);
    }

    private void leftRotation (SplayNode node){
        SplayNode temp = node.rightChildren;
        if (temp != null){
            node.rightChildren = temp.leftChildren;

            if (temp.leftChildren != null){
                temp.leftChildren.parent = node;

            }
            temp.parent = node.parent;
        }
        if (node.parent == null){
            this.root = temp;
        } else if (node == node.parent.leftChildren){
            node.parent.leftChildren = temp;
        } else {
            node.parent.rightChildren = temp;
        }

        if (temp != null){
            temp.leftChildren = node;
        }

        node.parent = temp;
    }
    private void rightRotation (SplayNode node){
        SplayNode temp = node.leftChildren;
        if (temp != null){
            node.leftChildren = temp.rightChildren;

            if (temp.rightChildren != null){
                temp.rightChildren.parent = node;

            }
            temp.parent = node.parent;
        }
        if (node.parent == null){
            this.root = temp;
        } else if (node == node.parent.leftChildren){
            node.parent.leftChildren = temp;
        } else {
            node.parent.rightChildren = temp;
        }

        if (temp != null){
            temp.rightChildren = node;
        }

        node.parent = temp;
    }

    private void splay(SplayNode node){
        while(node.parent != null){
            //zig

            if (node.parent.parent == null){
                if(node.parent.leftChildren == node){
                    rightRotation(node.parent);
                } else {
                    leftRotation(node.parent);
                }
            }
            //zig zag
            else if(node.parent.leftChildren == node && node.parent.parent.leftChildren == node.parent){
                rightRotation(node.parent.parent);
                rightRotation(node.parent);
            }
            else if (node.parent.rightChildren == node && node.parent.parent.rightChildren == node.parent){
                leftRotation(node.parent.parent);
                leftRotation(node.parent);
            }

            //zig-zag

            else if (node.parent.leftChildren == node && node.parent.parent.rightChildren == node.parent){
                rightRotation(node.parent);
                leftRotation(node.parent);
            } else{
                leftRotation(node.parent);
                rightRotation(node.parent);
            }
        }
    }
    public String printSplayTree(SplayNode node){
        if(node!=null){
            return ""+node.num+"("+printSplayTree(node.rightChildren)+ "/"+ printSplayTree(node.leftChildren)+")";
        }
        else{
            return "*";
        }
    }
}
