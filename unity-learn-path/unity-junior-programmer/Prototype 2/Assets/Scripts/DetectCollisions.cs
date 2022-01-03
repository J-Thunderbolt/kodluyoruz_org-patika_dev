using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DetectCollisions : MonoBehaviour
{
    private GameManager gameManager;

    void Awake()
    {
        gameManager = GameObject.Find("GameManager").GetComponent<GameManager>();
    }
    void Start()
    { }

    void Update()
    { }

    private void OnTriggerEnter(Collider other)
    {
        if (other.CompareTag("Player"))
        {
            Destroy(gameObject);
            gameManager.AddLife(-1);
        }
        else if (other.CompareTag("Projectile"))
        {
            gameObject.GetComponent<AnimalHunger>().FeedAnimal(1);
            Destroy(other.gameObject);
        }
    }
}
