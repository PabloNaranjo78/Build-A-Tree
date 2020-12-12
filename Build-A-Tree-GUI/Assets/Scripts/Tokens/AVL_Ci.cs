using System.Security.Cryptography;
using System;
using System.Diagnostics;
using System.IO;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using System;
using System.Net;


public class AVL_Ci : MonoBehaviour 
{
    private LevelManager gameLevelManager;
    public int coinValue;
    public Text AVLText;
    System.Random random = new System.Random();
    Server server = new Server();


    
    // Start is called before the first frame update
    void Start()
    {
        
        gameLevelManager = FindObjectOfType<LevelManager> ();
 
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    // Si Player toca la moneda
    void OnTriggerEnter2D(Collider2D other)
    {
        if (other.gameObject.tag == "Player"){

            gameLevelManager.RespawnTavl();
            int num = random.Next(1,11);
            if (num <= 9)
            {
            AVLText.text = server.Conectar("A" + "0" + num);
            }
            else
             {
            AVLText.text = server.Conectar("A" + num);
             }
            
            }
        if(other.gameObject.tag == "FallDetector"){
            gameLevelManager.RespawnTavl();
            
        }
    
    } 
}
