using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class LevelManager : MonoBehaviour
{

    public float respawnDelay;
    public PlayerControler gamePlayer;
    public CoinScript gameCoin;
    public CheckPointController1 gameCP1;
    public CheckPointController2 gameCP2;
    public CheckPointController3 gameCP3;
    public CheckPointController4 gameCP4;
    public CheckPointController5 gameCP5;
    public int coins;
    public Text coinText;
    private int spawnPosition;


    // Start is called before the first frame update
    void Start()
    {
        gamePlayer = FindObjectOfType<PlayerControler> ();
        gameCoin = FindObjectOfType<CoinScript> ();
        gameCP1 = FindObjectOfType<CheckPointController1> ();
        gameCP2 = FindObjectOfType<CheckPointController2> ();
        gameCP3 = FindObjectOfType<CheckPointController3> ();
        gameCP4 = FindObjectOfType<CheckPointController4> ();
        gameCP5 = FindObjectOfType<CheckPointController5> ();
        coinText.text = "Score: " + coins;
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    public void RespawnP() {
        StartCoroutine("RespawnCoroutineP");
    }

    public void RespawnC() {
        StartCoroutine("RespawnCoroutineC");
    }

    public IEnumerator RespawnCoroutineP() {
        gamePlayer.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        gamePlayer.transform.position = gamePlayer.respawnPoint;
        gamePlayer.gameObject.SetActive (true);
    }

    public IEnumerator RespawnCoroutineC() {
        Debug.Log("Yep");
        spawnPosition = Random.Range(1,5);
        Debug.Log(spawnPosition);
        gameCoin.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        //gameCoin.transform.position = gamePlayer.respawnPoint;
        /*
        if (spawnPosition == 1) {
            gameCoin.transform.position = gameCP1.respawnPoint1;
        }
        if (spawnPosition == 2) {
            gameCoin.transform.position = gameCP2.respawnPoint2;
        }
        if (spawnPosition == 3) {
            gameCoin.transform.position = gameCP3.respawnPoint3;
        }
        if (spawnPosition == 4) {
            gameCoin.transform.position = gameCP4.respawnPoint4;
        }
        if (spawnPosition == 5) {
            gameCoin.transform.position = gameCP5.respawnPoint5;
        }
        */
        gameCoin.gameObject.SetActive (true);
        //spawnPosition = Random.Range(1,6);
    }


//Coin Counter
    public void AddCoins(int numberOfCoins) {
        coins += numberOfCoins;
        coinText.text = "Score: " + coins;
    }
}
