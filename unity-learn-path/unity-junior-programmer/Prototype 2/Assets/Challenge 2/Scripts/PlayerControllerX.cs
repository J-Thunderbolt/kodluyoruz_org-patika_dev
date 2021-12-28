using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerControllerX : MonoBehaviour
{
    public GameObject dogPrefab;
    private float inputDelay = 0.75f;
    private float timer;

    void Update()
    {
        timer += Time.deltaTime;
        if (timer >= inputDelay)
        {

            if (Input.GetKeyDown(KeyCode.Space))
            {
                Instantiate(dogPrefab, transform.position, dogPrefab.transform.rotation);
                timer = 0f;
            }
        }
    }
}
