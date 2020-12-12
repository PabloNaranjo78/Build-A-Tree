using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;   


public class Splay_T : MonoBehaviour 
{
    private LevelManager gameLevelManager;
    public int coinValue;
    public Text SplayText;
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
  
            //Destroy(gameObject);
            gameLevelManager.RespawnTsplay();
            int num = random.Next(1,15);
            if (num <= 9)
            {
            SplayText.text = server.Conectar("P" + "0" + num);
            }
            else
             {
            SplayText.text = server.Conectar("P" + num);
             }
        }
        if(other.tag == "FallDetector"){
            gameLevelManager.RespawnTsplay();
        }
    } 
}
