using System.Collections;
using System.Collections.Generic;
using UnityEngine;


public class AVL_Ci : MonoBehaviour 
{
    private LevelManager gameLevelManager;
    public int coinValue;
    
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
            gameLevelManager.AddCoins(coinValue);
            //Destroy(gameObject);
            gameLevelManager.RespawnTavl();
        }
        if(other.tag == "FallDetector"){
            gameLevelManager.RespawnTavl();
        }
    } 
}
