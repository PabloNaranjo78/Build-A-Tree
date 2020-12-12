using System.Net.Mime;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using System;
using System.Net;

public class TreeManager : MonoBehaviour
{


    public Text BSTtext;
    public Text SplayText;
    public Text AVLText;
    public Text Btree;
    Server server = new Server();
    void Start()
    {
     
    }
    public void addBtree(int num)
    {
        if (num <= 9)
        {
            Btree.text = server.Conectar("B" + "0" + num);
        }
        else
        {
            Btree.text = server.Conectar("B" + num);
        }
    }
    public void addBST(int num)
    {
        if (num <= 9)
        {
            Btree.text = server.Conectar("S" + "0" + num);
        }
        else
        {
            Btree.text = server.Conectar("S" + num);
        }
    }
    public void addSplayTree(int num)
    {
        if (num <= 9)
        {
            Btree.text = server.Conectar("P" + "0" + num);
        }
        else
        {
            Btree.text = server.Conectar("P" + num);
        }
    }
    public void addAVLTree(int num)
    {
        if (num <= 9)
        {
            Btree.text = server.Conectar("A" + "0" + num);
        }
        else
        {
            Btree.text = server.Conectar("A" + num);
        }
    }

}
