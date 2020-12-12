using System.IO;
using System.Diagnostics;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class LevelManager : MonoBehaviour
{

    public float respawnDelay;
    public PlayerControler gamePlayer;
    public CoinScript gameCoin;

    private TreeManager tree;

    public ForcePushScript gamePUforcepush;
    public AirJumpScript gamePUairjump;
    public ShieldScript gamePUshield;

    public AVL_Ci gameTavl;
    public BST_R gameTbst;
    public BTree_Cu gameTbtree;
    public Splay_T gameTsplay;

    public int coins;
    public Text coinText;

    private int rndC;
    private int rnd1;
    private int rnd2;
    private int rnd3;




    // Start is called before the first frame update
    void Start()
    {
        gamePlayer = FindObjectOfType<PlayerControler> ();
        gameCoin = FindObjectOfType<CoinScript> ();

        gamePUforcepush = FindObjectOfType<ForcePushScript> ();
        gamePUairjump = FindObjectOfType<AirJumpScript> ();
        gamePUshield = FindObjectOfType<ShieldScript> ();

        gameTavl = FindObjectOfType<AVL_Ci> ();
        gameTbst = FindObjectOfType<BST_R> ();
        gameTbtree = FindObjectOfType<BTree_Cu> ();
        gameTsplay = FindObjectOfType<Splay_T> ();

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

    //Respawn Power ups
    public void RespawnPUfp() {
        StartCoroutine("RespawnCoroutinePUfp");
    }
    public void RespawnPUaj() {
        StartCoroutine("RespawnCoroutinePUaj");
    }
    public void RespawnPUs() {
        StartCoroutine("RespawnCoroutinePUs");
    }

    // Respawn Tokens
    public void RespawnTavl() {
        StartCoroutine("RespawnCoroutineTavl");
    }
    public void RespawnTbst() {
        StartCoroutine("RespawnCoroutineTbst");
    }
    public void RespawnTbtree() {
        StartCoroutine("RespawnCoroutineTbtree");
    }
    public void RespawnTsplay() {   
        StartCoroutine("RespawnCoroutineTsplay");
    }

    //Respawn Coroutines
    public IEnumerator RespawnCoroutineP() {
        gamePlayer.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        gamePlayer.transform.position = gamePlayer.respawnPoint;
        gamePlayer.gameObject.SetActive (true);
    }

    public IEnumerator RespawnCoroutineC() {
        rndC = Random.Range(-30,31);
        gameCoin.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        gameCoin.transform.position = new Vector3(rndC,23,0);
        gameCoin.gameObject.SetActive (true);
    }

    //PU Coroutines
    public IEnumerator RespawnCoroutinePUfp() {
        rnd1 = Random.Range(-30,31);
        gamePUforcepush.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        gamePUforcepush.transform.position = new Vector3(rnd1,23,0);
        gamePUforcepush.gameObject.SetActive (true);
    }
    public IEnumerator RespawnCoroutinePUaj() {
        rnd2 = Random.Range(-30,31);
        gamePUairjump.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        gamePUairjump.transform.position = new Vector3(rnd2,23,0);
        gamePUairjump.gameObject.SetActive (true);
    }
    public IEnumerator RespawnCoroutinePUs() {
        rnd3 = Random.Range(-30,31);
        gamePUshield.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        gamePUshield.transform.position = new Vector3(rnd3,23,0);
        gamePUshield.gameObject.SetActive (true);
    }

    //Tokens coroutines
    public IEnumerator RespawnCoroutineTavl() {
        rndC = Random.Range(-30,31);
        gameTavl.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        gameTavl.transform.position = new Vector3(rndC,23,0);
        gameTavl.gameObject.SetActive (true);
    }
    public IEnumerator RespawnCoroutineTbst() {
        rnd1 = Random.Range(-30,31);
        gameTbst.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        gameTbst.transform.position = new Vector3(rnd1,23,0);
        gameTbst.gameObject.SetActive (true);
    }
    public IEnumerator RespawnCoroutineTbtree() {
        rnd2 = Random.Range(-30,31);
        gameTbtree.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        gameTbtree.transform.position = new Vector3(rnd2,23,0);
        gameTbtree.gameObject.SetActive (true);
    }
    public IEnumerator RespawnCoroutineTsplay() {
        rnd3 = Random.Range(-30,31);
        gameTsplay.gameObject.SetActive (false);
        yield return new WaitForSeconds (respawnDelay);
        gameTsplay.transform.position = new Vector3(rnd3,23,0);
        gameTsplay.gameObject.SetActive (true);
    }

    //Coin Counter
    public void AddCoins(int numberOfCoins) {
        coins += numberOfCoins;
        coinText.text = "Score: " + coins;
    }
}
