using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class AnimalHunger : MonoBehaviour
{
    public Slider hungerSlider;
    public int amountToBeFed;
    private GameManager gameManager;
    private int currentFedAmount = 0;
    void Start()
    {
        hungerSlider.value = currentFedAmount;
        hungerSlider.maxValue = amountToBeFed;
        hungerSlider.fillRect.gameObject.SetActive(false);

        gameManager = GameObject.Find("GameManager").GetComponent<GameManager>();
    }

    void Update()
    {

    }

    public void FeedAnimal(int amount)
    {
        currentFedAmount += amount;
        hungerSlider.fillRect.gameObject.SetActive(true);
        hungerSlider.value = currentFedAmount;

        if (currentFedAmount >= amountToBeFed)
        {
            gameManager.AddScore(amountToBeFed);
            Destroy(gameObject, 0.1f);
        }
    }
}
