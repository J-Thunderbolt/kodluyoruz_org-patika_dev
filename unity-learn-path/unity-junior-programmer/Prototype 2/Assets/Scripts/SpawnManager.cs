using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpawnManager : MonoBehaviour
{
    public GameObject[] animalPrefabs;
    private float spawnRangeX = 18.0f;
    private float spawnPositionZ = 20.0f;
    private float startDelay = 2.0f;
    private float spawnInterval = 2.0f;
    void Start()
    {
        InvokeRepeating("SpawnRandomAnimal", startDelay, spawnInterval);
    }

    void Update()
    {
    }

    void SpawnRandomAnimal()
    {
        Vector3 spawnPosition = new Vector3(Random.Range(-spawnRangeX, spawnRangeX + 1), 0, spawnPositionZ);
        int randomAnimalIndex = Random.Range(0, animalPrefabs.Length);

        Instantiate(animalPrefabs[randomAnimalIndex], spawnPosition, animalPrefabs[randomAnimalIndex].transform.rotation);
    }
}
