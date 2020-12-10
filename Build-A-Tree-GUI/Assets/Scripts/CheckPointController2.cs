using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CheckPointController2 : MonoBehaviour
{
    public Sprite redH;
    public Sprite greenH;
    private SpriteRenderer checkPointSpriteRenderer;
    public bool chackpointReached;
    public Vector3 respawnPoint2;
    // Start is called before the first frame update
    void Start()
    {
        checkPointSpriteRenderer = GetComponent<SpriteRenderer> ();
        respawnPoint2 = transform.position; 
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    void OnTriggerEnter2D(Collider2D other) {
        if(other.tag == "Player") {
            checkPointSpriteRenderer.sprite = greenH;
            chackpointReached = true;

        }
    }
}
