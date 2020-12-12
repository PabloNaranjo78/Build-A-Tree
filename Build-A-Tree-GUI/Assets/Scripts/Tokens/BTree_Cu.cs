using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class BTree_Cu : MonoBehaviour 
{
    private LevelManager gameLevelManager;
    public int coinValue;
    public Text Btree;
    Server server = new Server();
    System.Random random = new System.Random();
    
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
 
            gameLevelManager.RespawnTbtree();
            int num = random.Next(1,12);
            if (num <= 9)
            {
            Btree.text = server.Conectar("B" + "0" + num);
            }
            else
             {
            Btree.text = server.Conectar("B" + num);
             }
        }
        if(other.tag == "FallDetector"){
            gameLevelManager.RespawnTbtree();
        }
    } 
}
