using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManager : MonoBehaviour
{
    private int score;
    private int lives = 3;
    void Start()
    {

    }

    void Update()
    {

    }

    public void AddLife(int value)
    {
        lives += value;

        if (lives <= 0)
        {
            Debug.Log("Game Over!..");
            lives = 0;
        }

        Debug.Log("Lives: " + lives);
    }

    public void AddScore(int value)
    {
        score += value;

        Debug.Log("Score: " + score);
    }
}
