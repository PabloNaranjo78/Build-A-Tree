using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class BST_R : MonoBehaviour 
{
    private LevelManager gameLevelManager;
    public int coinValue;
    Server server = new Server();
    System.Random random = new System.Random();
    public Text BSTtext;
    
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
        if (other.tag == "Player"){

            gameLevelManager.RespawnTbst();
            int num = random.Next(1,15);
            if (num <= 9)
            {
            BSTtext.text = server.Conectar("S" + "0" + num);
            }
            else
             {
            BSTtext.text = server.Conectar("S" + num);
             }
            
            }if (other.tag == "FallDetector"){
            gameLevelManager.RespawnTbst();
        }

        }
    } 

