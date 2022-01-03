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
    private float sideSpawnMinZ = 3.0f;
    private float sideSpawnMaxZ = 15.0f;
    private float sideSpawnX = 20.0f;
    void Start()
    {
        InvokeRepeating("SpawnRandomAnimalTop", startDelay, spawnInterval);
        InvokeRepeating("SpawnRandomAnimalLeft", startDelay, spawnInterval * 1.5f);
        InvokeRepeating("SpawnRandomAnimalRight", startDelay, spawnInterval * 2);
    }

    void Update()
    {
    }

    void SpawnRandomAnimalTop()
    {
        int randomAnimalIndex = Random.Range(0, animalPrefabs.Length);
        Vector3 spawnPosition = new Vector3(Random.Range(-spawnRangeX, spawnRangeX + 1), 0, spawnPositionZ);

        Instantiate(animalPrefabs[randomAnimalIndex], spawnPosition, animalPrefabs[randomAnimalIndex].transform.rotation);
    }

    void SpawnRandomAnimalLeft()
    {
        int randomAnimalIndex = Random.Range(0, animalPrefabs.Length);
        Vector3 spawnPosition = new Vector3(-sideSpawnX, 0, Random.Range(sideSpawnMinZ, sideSpawnMaxZ + 1));
        Vector3 rotation = new Vector3(0, 90, 0);

        Instantiate(animalPrefabs[randomAnimalIndex], spawnPosition, Quaternion.Euler(rotation));
    }

    void SpawnRandomAnimalRight()
    {
        int randomAnimalIndex = Random.Range(0, animalPrefabs.Length);
        Vector3 spawnPosition = new Vector3(sideSpawnX, 0, Random.Range(sideSpawnMinZ, sideSpawnMaxZ + 1));
        Vector3 rotation = new Vector3(0, -90, 0);

        Instantiate(animalPrefabs[randomAnimalIndex], spawnPosition, Quaternion.Euler(rotation));
    }
}
