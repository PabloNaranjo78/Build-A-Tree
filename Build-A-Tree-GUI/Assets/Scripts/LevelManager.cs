using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class LevelManager : MonoBehaviour
{

    public float respawnDelay;
    public PlayerControler gamePlayer;
    public CoinScript gameCoin;
    public int coins;
    public Text coinText;


    // Start is called before the first frame update
    void Start()
    {
        gamePlayer = FindObjectOfType<PlayerControler> ();
        gameCoin = FindObjectOfType<CoinScript> ();
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
        gameCoin.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        gameCoin.transform.position = gamePlayer.respawnPoint;
        gameCoin.gameObject.SetActive (true);
    }


//Coin Counter
    public void AddCoins(int numberOfCoins) {
        coins += numberOfCoins;
        coinText.text = "Score: " + coins;
    }
}
