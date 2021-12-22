using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnManager : MonoBehaviour
{
    public GameObject[] animalPrefabs;
    private float spawnRangeX = 20.0f;
    private float spawnPositionZ = 20.0f;
    void Start()
    {

    }

    void Update()
    {
        if (Input.GetKeyDown(KeyCode.S))
        {
            Vector3 spawnPosition = new Vector3(Random.Range(-spawnRangeX, spawnRangeX + 1), 0, spawnPositionZ);
            int randomAnimalIndex = Random.Range(0, animalPrefabs.Length);

            Instantiate(animalPrefabs[randomAnimalIndex], spawnPosition, animalPrefabs[randomAnimalIndex].transform.rotation);
        }
    }
}
